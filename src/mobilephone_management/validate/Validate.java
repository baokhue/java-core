package mobilephone_management.validate;

import java.util.Scanner;

public class Validate {
    private static Scanner scanner = new Scanner(System.in);

    public static long inputCost() {
       long cost;
       while (true) {
           try {
               System.out.println("Input cost: ");
               cost = Long.parseLong(scanner.nextLine());
               if (cost < 0){
                   throw new NumberFormatException();
               } else {
                   return cost;
               }
           } catch (NumberFormatException e) {
               System.out.println("Cost must be a positive number!");
           }
       }
   }

   public static int inputNumber() {
       int number;
       while (true) {
           try {
               System.out.println("Input number: ");
               number = Integer.parseInt(scanner.nextLine());
               if (number < 0){
                   throw new NumberFormatException();
               } else {
                   return number;
               }
           } catch (NumberFormatException e) {
               System.out.println("Number must be a positive number!");
           }
       }
   }

    public static void inputScope() {
        String scope = scanner.nextLine();
        if (scope.equals("Global")){
            System.out.println("Global");
        } else if (scope.equals("International")){
            System.out.println("International");
        } else {
            System.out.println("Scope does not exist!");
        }

    }
}
