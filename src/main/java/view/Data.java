package view;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Data {
    public static void main(String[]args){

        LocalDate d01 = LocalDate.now();
        LocalDate d02 = LocalDate.of(2024,02,28);
        LocalDate d03 = LocalDate.parse("2006-03-15");

        LocalDateTime d04 = LocalDateTime.now();
        LocalDateTime d05 = LocalDateTime.of(2024,03,21,15,58);
        LocalDateTime d06 = LocalDateTime.parse("2041-03-15T16:00");

        Instant d07 = Instant.now();
        Instant d08 = Instant.parse("2024-03-15t16:04:50Z");
//        Instant d09 = Instant.parse("2024-03-21t16:05-3:00");
        // verificar o erro
        LocalDate d10 = LocalDate.now();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-YYYY");

        System.out.println(d01);
        System.out.println(d02);
        System.out.println(d03);
        System.out.println(d04);
        System.out.println(d05);
        System.out.println(d06);
        System.out.println(d07);
        System.out.println(d08);
  //      System.out.println(d09);
        System.out.println(d10.format(dtf));
    }

}
