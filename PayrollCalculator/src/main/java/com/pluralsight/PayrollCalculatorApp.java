package com.pluralsight;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Scanner;

public class PayrollCalculatorApp {

    //fire up the scanner for user input
    static Scanner csvScanner = new Scanner(System.in);

    public static void main(String[] args) {

        //try catch statement
        try {

            //file name; where it is located
//            String fileName = "src/main/resources/employees.csv"; // hardcoded employee file
//            String outputFile = "payroll-sept-2023.csv"; //hardcoded payroll file
//            String outputFile2 = "payroll-sept-2023.json"; //bonus? will work on later

            //ask user to enter employees file to display it
            System.out.println("Enter the name of the file employees file to process: ");
            String employeeFile = csvScanner.nextLine().trim();

            //ask user to create a new payroll file
            System.out.println("Enter the name of the payroll file to create: ");
            String payrollFile = csvScanner.nextLine().trim();

            //description of file
            System.out.println("\nHere is the current employee information:");
            System.out.println("---------------------------------------------------------");

            //create file input stream that brings file into our code
            FileReader csvFile = new FileReader("src/main/resources/" + employeeFile);
            BufferedReader csvBufferedReader = new BufferedReader(csvFile);

            //eats the header line in the file aka the first line
            //you can also use csv.BufferReader.readLine(); to eat the first line
            String header = csvBufferedReader.readLine();

            //create a FileWriter
            FileWriter fileWriter = new FileWriter("src/main/resources/" + payrollFile);

            //create a BufferedWriter
            BufferedWriter bufWriter = new BufferedWriter(fileWriter);

            //using buffer writer to display the header
            String header2 = "id | name | grosspay\n";
            bufWriter.write(header2);

            //looping with the buffered reader
            String theLine;
            while ((theLine = csvBufferedReader.readLine()) != null) {

                //splits the line
                String[] employeeInfo = theLine.split("\\|");

                //converting data types to strings to read
                int employeeId = Integer.parseInt(employeeInfo[0]);
                String name = employeeInfo[1];
                double hoursWorked = Double.parseDouble(employeeInfo[2]);
                double payRate = Double.parseDouble(employeeInfo[3]);

                //generate employee with data above ^^
                Employee employee = new Employee(employeeId, name, hoursWorked, payRate);

                //displaying employees id | name | gross pay
                System.out.printf("ID: %d | Name: %-20s | Gross Pay: $%.2f%n",
                        employee.getEmployeeId(),
                        employee.getName(),
                        employee.getGrossPay());

                String lineForOutputFile = employee.getEmployeeId() + " | " + employee.getName() + " | " + employee.getGrossPay() + "\n";
                bufWriter.write(lineForOutputFile);
            }

            //close reader and writer
            bufWriter.close();
            csvBufferedReader.close();

            //catches exceptions and displays error message
            //e.getMessage() to display error to me
        } catch (Exception e) {
            System.out.println("Error, something went wrong! " + e.getMessage());
        }
    }
}
