package com.pluralsight;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.TimeZone;

public class FormatDatesApp {

    public static void main(String[] args) {

        LocalDate today = LocalDate.now();
        LocalTime now = LocalTime.now();
        LocalDateTime current = LocalDateTime.now();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        String formattedDate = today.format(formatter);

        DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("MMMM d, yyyy");
        String formattedDateTwo = today.format(formatter2);

        ZonedDateTime gmtZone = ZonedDateTime.now(ZoneId.of("GMT"));
        DateTimeFormatter formatter3 = DateTimeFormatter.ofPattern("EEEE, MMM d, yyyy hh:mm a");
        String formattedDateThree = gmtZone.format(formatter3);

        ZonedDateTime cstZone = ZonedDateTime.now(ZoneId.of("America/Chicago"));
        DateTimeFormatter formatter4 = DateTimeFormatter.ofPattern("H:mm a 'on' dd-MMM-yyyy");
        String formattedDateFour = cstZone.format(formatter4);

        System.out.println(formattedDate);
        System.out.println(today);
        System.out.println(formattedDateTwo);
        System.out.println(formattedDateThree);
        System.out.println(formattedDateFour);

    }
}
