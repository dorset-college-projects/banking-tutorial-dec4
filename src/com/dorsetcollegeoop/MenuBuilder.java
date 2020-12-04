package com.dorsetcollegeoop;

import java.util.Scanner;

public class MenuBuilder {

    private static int startMenu() {

        int selection;
        Scanner input = new Scanner(System.in);
        /***************************************************/

        System.out.println("Choose from these choices");

        System.out.println("-------------------------\n");
        System.out.println("1 - Bank Employee Login");
        System.out.println("2 - Customer Login");
        System.out.println("3 - Quit");

        selection = input.nextInt();
        return selection;

    }

    private static int customerMenu() {

        int selection;
        Scanner input = new Scanner(System.in);

        System.out.println("-------------------------\n");
        System.out.println("1 - Login");
        System.out.println("2 - customerMenuOption 2");
        System.out.println("3 - customerMenuOption 3");
        System.out.println("4 - customerMenuQuit");

        selection = input.nextInt();
        return selection;

    }

    private static Customer AddCustomerForm() {
        Scanner myObj = new Scanner(System.in);  // Create a Scanner object
        System.out.println("Enter First Name");

        String firstName = myObj.nextLine();  // Read user input
        System.out.println("FirstName  is: " + firstName);  // Output user input

        String lastName = myObj.nextLine();  // Read user input
        System.out.println("LastName  is: " + lastName);  // Output user input

        // You might validate here.....

        Customer customer = new Customer(firstName, lastName);
        // And if happy /// create the customer

        return customer;

    }

    private static BankingTransaction CreateTransactionForm() {

        System.out.println("Transaction form goes here");

        BankingTransactionLodge btl = new BankingTransactionLodge();

        return btl;
    }


    private static  void DeleteCustomer() {


    }


    private static int bankingMenu() {

        int selection;
        Scanner input = new Scanner(System.in);

        System.out.println("-------------------------\n");
        System.out.println("1 - Add Customer");
        System.out.println("2 - Delete Customer");
        System.out.println("3 - Create Transaction");
        System.out.println("4 - Quit");

        selection = input.nextInt();
        return selection;

    }

    private static String  getBankEmployeePin() {
        Scanner myObj = new Scanner(System.in);  // Create a Scanner object
        System.out.println("Enter PIN");

        String pin = myObj.nextLine();  // Read user input
        System.out.println("PIN is: " + pin);  // Output user input

        return pin;

    }

    public static void Run() {

        int userChoice = MenuBuilder.startMenu();

        switch (userChoice) {

            case 1:

                // Get the banking Pin from employee
                String pin = getBankEmployeePin();
                SecurityBanking sb = new SecurityBanking();
                boolean isAuthenticated = sb.login(pin);

                // add logic here if isAuthenticated

                if (isAuthenticated) {

                    int bankEmployeeAction = MenuBuilder.bankingMenu();


                    switch (bankEmployeeAction) {

                        case 1:
                            Customer newCustomer = AddCustomerForm();
                            BankingAction.AddCustomer(newCustomer);
                            break;
                        case 2: break;
                        case 3:
                            BankingTransaction btl = CreateTransactionForm();
                            BankingAction.CreateTransaction(btl);
                            break;


                    }






                } else {
                    System.out.println("error....");
                    return;
                }


                break;
            case 2:

                // Get the banking Pin from employee
                //String pin = getBankEmployeePin();
                //SecurityBanking sb = new SecurityBanking();
               /// boolean isAuthenticated = sb.login(pin);

                // add logic here if isAuthenticated

               // if (isAuthenticated) {

                    // int customerAction = MenuBuilder.customerMneu();

               // userChoice = MenuBuilder.customerMenu();

               // } else {
                   // System.out.println("error....");
                  //  return;
              //  }


                break;
            case 3:
                System.out.println("Option 3s");
                break;
            case 4:
                return;
        }

    }
}
