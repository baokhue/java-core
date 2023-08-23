package mobilephone_management.controller;

import mobilephone_management.service.impl.AbroadServiceImpl;
import mobilephone_management.service.impl.BrandServiceImpl;
import mobilephone_management.service.util.NotFoundProductException;

import java.util.Scanner;

public class MobilePhoneManagement {
    public static void displayMenu() throws NotFoundProductException {
        Scanner scanner = new Scanner(System.in);
        int select = 0;
        do {
            System.out.println("---Managing Mobile phone Programme---");
            System.out.println("Choose a feature by number (to continue): ");
            System.out.println("1. Add new.");
            System.out.println("2. Delete.");
            System.out.println("3. Display Mobile phones list.");
            System.out.println("4. Search.");
            System.out.println("5. Exit.");

            System.out.println("Please choose a feature: ");
            select = Integer.parseInt(scanner.nextLine());

            switch (select){
                case 1: //Add
                    System.out.println("---Adding new Mobile phone.---");
                    System.out.println("Choose type of Mobile phone you want to add.");
                    System.out.println("1. Brand Mobile phone.");
                    System.out.println("2. Abroad Mobile phone.");

                    System.out.println("Input a number: ");
                    select = Integer.parseInt(scanner.nextLine());
                    switch (select) {
                        case 1: //Saving
                            BrandServiceImpl brandService = new BrandServiceImpl();
                            brandService.addBrand();
                            break;
                        case 2: //Debit
                            AbroadServiceImpl abroadService = new AbroadServiceImpl();
                            abroadService.addAbroad();
                            break;
                    }
                    break;
                case 2: //Delete
                    BrandServiceImpl brandService = new BrandServiceImpl();
                    brandService.removeBrand();

                    AbroadServiceImpl abroadService = new AbroadServiceImpl();
                    abroadService.removeAbroad();
                    break;
                case 3: //Display
                    BrandServiceImpl brandService1 = new BrandServiceImpl();
                    brandService1.displayBrandList();

                    AbroadServiceImpl abroadService1 = new AbroadServiceImpl();
                    abroadService1.displayAbroadList();
                    break;
                case 4: //Search
                    BrandServiceImpl brandService2 = new BrandServiceImpl();
                    brandService2.searchBrand();

                    AbroadServiceImpl abroadService2 = new AbroadServiceImpl();
                    abroadService2.searchAbroad();
                    break;
                case 5: //Exit
                    System.exit(0);
                    break;
            }
        } while (true);
    }

    public static void main(String[] args) throws NotFoundProductException {
        displayMenu();
    }
}
