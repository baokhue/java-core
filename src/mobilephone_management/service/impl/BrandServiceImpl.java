package mobilephone_management.service.impl;

import mobilephone_management.models.BrandMobilePhone;
import mobilephone_management.service.util.MyUtil;
import mobilephone_management.service.util.NotFoundProductException;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BrandServiceImpl {
    static List<BrandMobilePhone> brandMobilePhoneList = new ArrayList<>();
    Scanner scanner = new Scanner(System.in);

    static {
        BrandMobilePhone brandMobilePhone = new BrandMobilePhone(1, "Iphone", 7500000, 1, "USA", "365", "International");
        BrandMobilePhone brandMobilePhone1 = new BrandMobilePhone(2, "Samsung", 6500000, 1, "USA", "365", "Global");
        BrandMobilePhone brandMobilePhone2 = new BrandMobilePhone(3, "Nokia", 700000, 1, "China", "365", "International");

        brandMobilePhoneList.add(brandMobilePhone);
        brandMobilePhoneList.add(brandMobilePhone1);
        brandMobilePhoneList.add(brandMobilePhone2);
        MyUtil.writeBrand(brandMobilePhoneList);
    }

    public void addBrand() {
        brandMobilePhoneList = MyUtil.readBrand();
        int id = brandMobilePhoneList.size() + 1;
        System.out.println("---Adding new Saving account.---");
        System.out.println("1. Name: ");
        String name = scanner.nextLine();
        long cost;
        do {
            System.out.println("2. Cost: ");
            cost = Long.parseLong(scanner.nextLine());
            if (cost < 0) {
                System.out.println("Cost must be a positive number!");
            } else {
                break;
            }
        } while (cost < 0);
        int number;
        do {
            System.out.println("3. Number: ");
            number = Integer.parseInt(scanner.nextLine());
            if (number < 0) {
                System.out.println("Number must be a positive number!");
            } else {
                break;
            }
        } while (number < 0);
        System.out.println("4. Producer: ");
        String producer = scanner.nextLine();
        System.out.println("5. Date of security: ");
        String date = scanner.nextLine();
        System.out.println("6. Scope of security: ");
        String scope = "";
        int select = 0;
        do {
            System.out.println("Please choose scope: ");
            System.out.println("1. Global: ");
            System.out.println("2. International: ");
            select = Integer.parseInt(scanner.nextLine());

            switch (select){
                case 1:
                    scope = "Global";
                    break;
                case 2:
                    scope = "International";
                    break;
            }
            break;
        }while (true);

        BrandMobilePhone brandMobilePhone = new BrandMobilePhone(id, name, cost, number, producer, date, scope);
        brandMobilePhoneList.add(brandMobilePhone);
        MyUtil.writeBrand(brandMobilePhoneList);
    }

    public void removeBrand() {
        brandMobilePhoneList = MyUtil.readBrand();
        System.out.println("Please input ID (Brand): ");
        int delId = Integer.parseInt(scanner.nextLine());
        int delSelect = 0;
        try {
            for (int i = 0; i < brandMobilePhoneList.size(); i++) {
                if (delId == brandMobilePhoneList.get(i).getId()) {
                    do {
                        System.out.println("1. Yes!");
                        System.out.println("2. No!");

                        System.out.println("Input a number: ");
                        delSelect = Integer.parseInt(scanner.nextLine());
                        switch (delSelect) {
                            case 1:
                                brandMobilePhoneList.remove(brandMobilePhoneList.get(i));
                                MyUtil.writeBrand(brandMobilePhoneList);
                                System.out.println("Deleted!");
                                break;
                            case 2:
                                break;
                        }
                        break;
                    } while (true);
                } else {
                    throw new NotFoundProductException();
                }
                break;
            }
        } catch (NotFoundProductException e){
            System.out.println("This ID does not exist (Brand)!");
        }
    }

    public void displayBrandList(){
        brandMobilePhoneList = MyUtil.readBrand();
        for (BrandMobilePhone brandMobilePhone : brandMobilePhoneList) {
            System.out.println(brandMobilePhone);
        }
    }

    public void searchBrand(){
        brandMobilePhoneList = MyUtil.readBrand();
        int searchingSelect= 0;
        do {
            System.out.println("Please input ID or Name: ");
            searchingSelect = Integer.parseInt(scanner.nextLine());

            switch (searchingSelect){
                case 1:
                    System.out.println("Please input ID: ");
                    int searchId = Integer.parseInt(scanner.nextLine());

                    for (int i = 0; i < brandMobilePhoneList.size(); i++) {
                        if (searchId == brandMobilePhoneList.get(i).getId()){
                            System.out.println(brandMobilePhoneList.get(i));
                            break;
                        }
                    }
                    break;
                case 2:
                    System.out.println("Please input Name: ");
                    String searchingName = scanner.nextLine();

                    for (int i = 0; i < brandMobilePhoneList.size(); i++) {
                        if (searchingName.equals(brandMobilePhoneList.get(i).getName())){
                            System.out.println(brandMobilePhoneList.get(i));
                            break;
                        }
                    }
                    break;
            }
            break;
        }while (true);
    }
}
