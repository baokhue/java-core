package mobilephone_management.service.impl;

import mobilephone_management.models.AbroadMobilePhone;
import mobilephone_management.service.util.MyUtil;
import mobilephone_management.service.util.NotFoundProductException;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AbroadServiceImpl {
    static List<AbroadMobilePhone> abroadMobilePhoneList = new ArrayList<>();
    Scanner scanner = new Scanner(System.in);

    static {
        AbroadMobilePhone abroadMobilePhone = new AbroadMobilePhone(1, "Samsung", 5000000, 1, "Korean", "USA", "Unfixed");
        AbroadMobilePhone abroadMobilePhone1 = new AbroadMobilePhone(2, "Iphone", 5500000, 1, "China", "USA", "Fixed");
        AbroadMobilePhone abroadMobilePhone2 = new AbroadMobilePhone(3, "Samsung", 4500000, 1, "Malaysia", "USA", "Unfixed");

        abroadMobilePhoneList.add(abroadMobilePhone);
        abroadMobilePhoneList.add(abroadMobilePhone1);
        abroadMobilePhoneList.add(abroadMobilePhone2);
        MyUtil.writeAbroad(abroadMobilePhoneList);
    }

    public void addAbroad(){
        abroadMobilePhoneList = MyUtil.readAbroad();
        int id = abroadMobilePhoneList.size() + 1;
        System.out.println("---Adding new Debit account.---");
        System.out.println("1. Mobile phone's name: ");
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
        String country = "";
        do {
            System.out.println("5. Country: ");
            country = scanner.nextLine();

            if (country.equals("Viet Nam")){
                country = "Does not match!";
            } else {
                break;
            }
        }while (country.equals("Viet Nam"));
        System.out.println("6. Status: ");
        String status = "";
        int select = 0;
        do {
            System.out.println("Please choose status: ");
            System.out.println("1. Fixed: ");
            System.out.println("2. Unfixed: ");
             select = Integer.parseInt(scanner.nextLine());

             switch (select){
                 case 1:
                     status = "Fixed";
                     break;
                 case 2:
                     status = "Unfixed";
                     break;
             }
             break;
        }while (true);

        AbroadMobilePhone abroadMobilePhone = new AbroadMobilePhone(id, name, cost, number, producer, country, status);
        abroadMobilePhoneList.add(abroadMobilePhone);
        MyUtil.writeAbroad(abroadMobilePhoneList);
    }

    public void removeAbroad() throws NotFoundProductException {
        abroadMobilePhoneList = MyUtil.readAbroad();
        System.out.println("Please input ID (Abroad): ");
        int delId = Integer.parseInt(scanner.nextLine());
        int delSelect = 0;

        for (int i = 0; i < abroadMobilePhoneList.size(); i++) {
            try {
                if (delId == abroadMobilePhoneList.get(i).getId()){
                    do {
                        System.out.println("1. Yes!");
                        System.out.println("2. No!");

                        System.out.println("Input a number: ");
                        delSelect = Integer.parseInt(scanner.nextLine());
                        switch (delSelect){
                            case 1:
                                abroadMobilePhoneList.remove(abroadMobilePhoneList.get(i));
                                MyUtil.writeAbroad(abroadMobilePhoneList);
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
            } catch (NotFoundProductException e){
                System.out.println("This ID does not exist (Abroad)!");
            }
        }
    }

    public void displayAbroadList(){
        abroadMobilePhoneList = MyUtil.readAbroad();
        for (AbroadMobilePhone abroadMobilePhone : abroadMobilePhoneList) {
            System.out.println(abroadMobilePhone);
        }
    }

    public void searchAbroad(){
        abroadMobilePhoneList = MyUtil.readAbroad();
        int searchingSelect;
        do {
            System.out.println("Please input ID or Name: ");
            searchingSelect = Integer.parseInt(scanner.nextLine());

            switch (searchingSelect){
                case 1:
                    System.out.println("Please in put ID: ");
                    int searchId = Integer.parseInt(scanner.nextLine());

                    for (int i = 0; i < abroadMobilePhoneList.size(); i++) {
                        if (searchId == abroadMobilePhoneList.get(i).getId()){
                            System.out.println(abroadMobilePhoneList.get(i));
                            break;
                        }
                    }
                    break;
                case 2:
                    System.out.println("Please input Name: ");
                    String searchingName = scanner.nextLine();

                    for (int i = 0; i < abroadMobilePhoneList.size(); i++) {
                        if (searchingName.equals(abroadMobilePhoneList.get(i).getName())){
                            System.out.println(abroadMobilePhoneList.get(i));
                            break;
                        }
                    }
                    break;
            }
            break;
        }while (true);


    }
}
