package com.javarush.task.task19.task1921;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/* 
Хуан Хуанович
*/

public class Solution {
    public static final List<Person> PEOPLE = new ArrayList<Person>();

    public static void main(String[] args) throws IOException, ParseException {
        BufferedReader reader = new BufferedReader(new FileReader(args[0]));
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd MM yyyy");
        while (reader.ready()) {
            String line = reader.readLine();
            String[] data = line.split(" ");
            int day = Integer.parseInt(data[data.length - 3]);
            int month = Integer.parseInt(data[data.length - 2]);
            int year = Integer.parseInt(data[data.length - 1]);
            String dataLine = day + " " + month + " " + year;
            String name = data[0];
            for (int i = 1; i < data.length-3; i++){
                name+=" " + data[i];
            }
//                    line.substring(0, line.length() - 11)
            PEOPLE.add(new Person(name, dateFormat.parse(dataLine)));
        }
        reader.close();
    }
}