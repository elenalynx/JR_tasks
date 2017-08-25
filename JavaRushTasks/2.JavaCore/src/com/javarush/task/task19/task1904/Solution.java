package com.javarush.task.task19.task1904;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/* 
И еще один адаптер
*/

public class Solution {

    public static void main(String[] args) {

    }

    public static class PersonScannerAdapter implements PersonScanner {
        private final Scanner fileScanner;

        public PersonScannerAdapter(Scanner fileScanner) {
            this.fileScanner = fileScanner;
        }


        @Override
        public Person read() throws IOException, ParseException {
            String lastName = fileScanner.next();
            String firstName = fileScanner.next();
            String middleName = fileScanner.next();
            int day = fileScanner.nextInt();
            int month = fileScanner.nextInt();
            int year = fileScanner.nextInt();
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd MM yyyy");
            String dataParse = (day + " " + month + " " + year);
            Date birthDate = dateFormat.parse(dataParse);

//            String data = fileScanner.nextLine();
//            String[] personDataArray = data.split(" ");
//            String lastName = personDataArray[0];
//            String firstName = personDataArray[1];
//            String middleName = personDataArray[2];
//
//            SimpleDateFormat dateFormat = new SimpleDateFormat("dd MM yyyy");
//            String dataParse = (personDataArray[3] + " "
//                    + (Integer.parseInt(personDataArray[4]) - 1) + " " + personDataArray[5]);
//            Date birthDate = dateFormat.parse(dataParse);
            return new Person(firstName, middleName, lastName, birthDate);

        }

        @Override
        public void close() throws IOException {
            this.fileScanner.close();
        }
    }
}
