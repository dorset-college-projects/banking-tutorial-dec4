package com.dorsetcollegeoop;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Formatter;

public class FileManager {
    private static Formatter output;

    private static String CustomerFile = "customerlisting.txt";


    public static void AddCustomerToFile(Customer customer) {
        OpenFile(CustomerFile);
        output.format("%s %s %n",customer.firstName, customer.lastName);
        CloseFile();

    }

    public static void CreateCustomerAccount(String customerAccountName) {
        OpenFile(customerAccountName);

        output.format("testing customer account %n");
        CloseFile();
    }



    private static void OpenFile(String fileToOpen) {

        try {
            FileWriter f = new FileWriter(fileToOpen, true);
            output = new Formatter(f);
        } catch (SecurityException securityException) {
            System.out.println("Write permission denied");
            System.exit(1);
        } catch (FileNotFoundException fileNotFoundException) {
            System.out.println("Error opening file, Terminating");
            System.exit(1);
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }

    }


    private static void CloseFile() {

        if (output != null) {
            output.close();
        }


    }


}
