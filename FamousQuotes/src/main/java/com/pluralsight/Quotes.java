package com.pluralsight;

import java.util.Scanner;

public class Quotes {

    public static void main(String[] args) {

        //fire up the scanner to allow user input
        Scanner quoteScanner = new Scanner(System.in);

        //quotes
        String[] quotes = {"Time is money",
                "Where there is love there is life",
                "The only thing we have to fear is fear itself",
                "To be or not to be, that is the question",
                "All limitations are self-imposed",
                "Never regret anything that made you smile",
                "Every moment is a fresh beginning",
                "You never fail until you stop trying",
                "If you can dream it you can achieve it",
                "Everything happens for a reason"};

        boolean appRunning = true;

        while (appRunning) {

            try {
                //ask user to pick a number
                System.out.println("Pick a number between 1-10 for the quote you want?");
                int numQuote = quoteScanner.nextInt();

                System.out.println(quotes[numQuote - 1]);
                Thread.sleep(1000);

                quoteScanner.nextLine();

            } catch (Exception e) {
                System.out.println("Sorry, enter a valid number!");
            }
        }
    }
}
