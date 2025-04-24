package com.pluralsight;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.TimeZone;

public class FormatDatesApp {

    public static void main(String[] args) {

        //create a date
        LocalDate today = LocalDate.now();

        //create a time
        LocalTime now = LocalTime.now();

        //create a date and time
        LocalDateTime current = LocalDateTime.now();

        //create patter/formatter we need for this format: 2025-04-24
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        String formattedDate = today.format(formatter);

        //create patter/formatter we need for this format: April, 24, 2025
        DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("MMMM d, yyyy");
        String formattedDateTwo = today.format(formatter2);

        //create timezone so we can display GMT timezone
        ZonedDateTime gmtZone = ZonedDateTime.now(ZoneId.of("GMT"));

        //create patter/formatter we need for this format: Thursday, Apr 24, 2025 04:07 PM
        //HH:mm shows military time
        //a adds AM or PM
        DateTimeFormatter formatter3 = DateTimeFormatter.ofPattern("EEEE, MMM d, yyyy hh:mm a");
        String formattedDateThree = gmtZone.format(formatter3);

        //create timezone so we can display my timezone (CST)
        ZonedDateTime cstZone = ZonedDateTime.now(ZoneId.of("America/Chicago"));

        //create patter/formatter we need for this format: 11:07 AM on 24-Apr-2025
        DateTimeFormatter formatter4 = DateTimeFormatter.ofPattern("hh:mm a 'on' dd-MMM-yyyy");
        String formattedDateFour = cstZone.format(formatter4);

        //welcome user to app
        System.out.println("Welcome, Here are some different formats of today's date and time!");
        System.out.println("------------------------------------------------------------------");

        //printing out formatted date and time
        System.out.println(formattedDate);
        System.out.println(today);
        System.out.println(formattedDateTwo);
        System.out.println(formattedDateThree + " (GMT Time Zone)");
        System.out.println(formattedDateFour + " (My Time Zone CST)");

    }
}
