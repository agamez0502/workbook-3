package com.pluralsight;

import java.io.BufferedReader;
import java.io.FileReader;

public class PayrollCalculatorApp {

    public static void main(String[] args) {

        //try catch statement
        try {

            //file name; where it is located
            String fileName = "src/main/resources/employees.csv";

            //create file input stream that brings file into our code
            FileReader csvFile = new FileReader(fileName);
            BufferedReader csvBufferedReader = new BufferedReader(csvFile);

            //eats the header line in the file aka the first line
            String header = csvBufferedReader.readLine();
            //or csv.BufferReader.readLine(); to eat the first line

            //description of file
            System.out.println("Here is the current employee information:");
            System.out.println("---------------------------------------------------------");

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
            }

            //close reader
            csvBufferedReader.close();

          //catches exceptions and displays error message
          //e.getMessage() to display error to me
        } catch (Exception e) {
            System.out.println("Error, something went wrong!");
        }
    }
}
