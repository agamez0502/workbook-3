package com.pluralsight;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

//theApp needs to be capitalized because it is a class
public class theApp {

    //create pattern/formatter we need for the time stamp format
    static DateTimeFormatter timeStampFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    //create the scanner to get input from the user via the console
    static Scanner logScanner = new Scanner(System.in);

    public static void main(String[] args) {

        //here we are calling log actions method
        //it takes a string and knows what to do with that inputted info
        //it opens the file and puts it in that logs.txt file for us
        //the application launches, makes an entry in the log
        logAction("Launch");
        logAction("Exit");

        //create a variable that will keep us looping the question for the user
        boolean appRunning = true;

        while (appRunning) {

            //display question to user
            System.out.println("Enter a search term (x to exit)");

            //store user input in the variable searchTerm
            String searchTerm = logScanner.nextLine();

            //if statement for if the want to exit the application
            if (searchTerm.equalsIgnoreCase("x")) {
                System.out.println("You are exiting the application!");
                logAction("Exit");
                appRunning = false;
            }
            //else statement if they don't want to exit, it logs what they are searching
            else {

                //log the search term to the log file
                logAction("Search: " + searchTerm);
            }
        }

    }

    //this is the method that will create and maintain our log file
    public static void logAction(String theAction) {

        //allow us to try and write to the file
        try {

            //create a file writer and set append to true so it adds to the file
            //and not override its contents
            FileWriter outPutFile = new FileWriter("src/main/resources/logs.txt", true);

            //create the buffered writer to write to the log file
            BufferedWriter bufWriter = new BufferedWriter(outPutFile);

            //create a date and time
            LocalDateTime timeStamp = LocalDateTime.now();

            //create the line to write to the log by concating the timestamp in the correct format a space and the action
            bufWriter.write(timeStamp.format(timeStampFormatter) + " " + theAction);

            //make sure we have a new line in our file
            bufWriter.newLine();

            //close the buffered writer so it actually writes to the file
            bufWriter.close();

        } catch (Exception e) {

            //if we run into an issue writing to the file, display this instead
            System.out.println("Error writing to the file: " + e.getMessage());
        }
    }
}
