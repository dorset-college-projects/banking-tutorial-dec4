package com.dorsetcollegeoop;

import java.util.Scanner;

import static com.dorsetcollegeoop.AppConstants.CUSTOMER_CREATE;

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


    private static int transactionMenu() {

        int selection;
        Scanner input = new Scanner(System.in);

        System.out.println("-------------------------\n");
        System.out.println("1 - Lodge Money");
        System.out.println("2 - Withdraw Money");


        selection = input.nextInt();
        return selection;

    }

    private static BankingTransaction CreateTransactionLodgeForm() {

        System.out.println("Transaction lodge form goes here");

        BankingTransactionLodge btl = new BankingTransactionLodge();

        return btl;
    }

    private static BankingTransaction CreateTransactionWithdrawForm() {

        System.out.println("Transaction widthraw form goes here");

        BankingTransactionWithdraw btl = new BankingTransactionWithdraw();

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
        System.out.println("4 - List Customers");
        System.out.println("5 - Quit");

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

                        case AppConstants.CUSTOMER_CREATE:
                            Customer newCustomer = AddCustomerForm();
                            BankingAction.AddCustomer(newCustomer);
                            break;

                        case 2: break;
                        case AppConstants.TRANSACTION_CREATE:
                            int transactionChoice = MenuBuilder.transactionMenu();

                            switch(transactionChoice) {
                                case AppConstants.TRANSACTION_LODGE:

                                    BankingTransaction btl = CreateTransactionLodgeForm();
                                    BankingAction.CreateTransaction(btl);

                                    break;
                                case AppConstants.TRANSACTION_WITHDRAW:
                                    BankingTransaction btw = CreateTransactionWithdrawForm();
                                    BankingAction.CreateTransaction(btw);

                                    break;

                            }




                            break;

                        case AppConstants.CUSTOMER_LIST:
                            System.out.println("Listing customers");
                            FileManager.ListCustomers();
                            break; // AppConstants.CUSTOMER_LIST


                    }






                } else {
                    System.out.println("Authenicationn error....");
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
