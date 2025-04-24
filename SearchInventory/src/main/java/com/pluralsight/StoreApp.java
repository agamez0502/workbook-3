package com.pluralsight;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class StoreApp {

    public static void main(String[] args) {

        //fire up scanner that allows user input
        Scanner scanner = new Scanner(System.in);

        //welcome message
        System.out.println("Welcome to Alondra's store!");
        System.out.println("==================================================");

        //calling the getInventory method
        ArrayList<Product> inventory = getInventory();
        System.out.println("--------------------------------------------------");
        System.out.println("We carry the following inventory:");

        //for loop
        for (int i = 0; i < inventory.size(); i++) {
            Product p = inventory.get(i);
            System.out.printf("id: %d %s - Price: $%.2f%n",
                    p.getId(), p.getName(), p.getPrice());
        }
    }

    public static ArrayList<Product> getInventory() {

        Scanner myScanner = new Scanner(System.in);

        ArrayList<Product> inventory = new ArrayList<Product>();
        // this method loads product objects into inventory // and its details are not shown
        inventory.add(new Product(1, "Chicken    ", 20.99f));
        inventory.add(new Product(2, "Steak      ", 30.99f));
        inventory.add(new Product(3, "Turkey     ", 15.99f));
        inventory.add(new Product(4, "Ground Beef", 20.99f));
        inventory.add(new Product(5, "Beef Liver ", 10.99f));

        try {
            //ask user to enter employees file to display it
            System.out.println("Enter inventory.csv to process: ");
            String inventoryFile = myScanner.nextLine().trim();
            System.out.println("--------------------------------------------------");

            //create file input stream that opens inventory.csv file in our code
            FileReader csvFile = new FileReader("src/main/resources/inventory.csv");
            BufferedReader csvBufferedReader = new BufferedReader(csvFile);

            String theLine;
            while ((theLine = csvBufferedReader.readLine()) != null) {

                //splits the line
                String[] inventoryInform = theLine.split("\\|");

                //converting data types to strings to read
                int id = Integer.parseInt(inventoryInform[0]);
                String name = inventoryInform[1];
                float price = Float.parseFloat(inventoryInform[2]);

                //generate employee with data above ^^
                Product inventoryInfo = new Product(id, name, price);

                //displaying employees id | name | gross pay
                System.out.printf("ID: %d | Name: %-20s | Price: $%.2f%n",
                        inventoryInfo.getId(),
                        inventoryInfo.getName(),
                        inventoryInfo.getPrice());

//                String lineForOutputFile = Product.getId() + " | " + Product.getName() + " | " + Product.getPrice() + "\n";
            }

            //close reader and writer
            csvBufferedReader.close();


            //loop over each line in the csv file

            //create a product by splitting the new line on the |

            //create a product using the product class and pieces of the string

            //add that product to the inventory array list using inventory.csv

        } catch (Exception e) {
            System.out.println("Error" + e.getMessage());
        }
//        Collections.sort(ArrayList<Product>);
        return inventory;
    }

}
 