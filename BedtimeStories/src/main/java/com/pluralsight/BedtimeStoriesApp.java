package com.pluralsight;

import java.io.FileInputStream;
import java.util.Scanner;

public class BedtimeStoriesApp {

    //fire up the scanner for user input
    static Scanner storiesScanner = new Scanner(System.in);

    public static void main(String[] args) {

        //try catch statement
        try {

            //displaying input options for user
            //prompting user to enter the file of the bedtime story they want
            System.out.println("Welcome! Would you like me to read you a bedtime story?");
            System.out.println("-----------------------------------------------------------");
            System.out.println("For Goldilocks and The Three Bears, Enter: goldilocks.txt");
            System.out.println("For Hansel and Gretel, Enter: hansel_and_gretel.txt");
            System.out.println("For Mary Had a Little Lamb, Enter: mary_had_a_little_lamb.txt");
            System.out.println("\nEnter the name of the bedtime story you would like?");
            String storySelection = storiesScanner.nextLine();
            System.out.println("-----------------------------------------------------------");

            //create file input stream that brings our file into our code
            //file is in resources folder
            FileInputStream fis = new FileInputStream("src/main/resources/" + storySelection);
            Scanner fileScanner = new Scanner(fis);

            //while loop for printing out the stories
            int lineNumber = 1;
            while (fileScanner.hasNextLine()) {

                //prints out line number and bedtime story
                System.out.println(lineNumber + ": " + fileScanner.nextLine());
                lineNumber++;
            }
            //close scanners
            fileScanner.close();
            fis.close();

            //catches exceptions and gives them a message
        } catch (Exception e) {
            System.out.println("That file doesn't exist");
        }
    }
}

