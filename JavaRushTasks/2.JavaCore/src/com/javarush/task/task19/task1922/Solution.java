package com.javarush.task.task19.task1922;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/* 
Ищем нужные строки
*/

public class Solution {
    public static List<String> words = new ArrayList<String>();

    static {
        words.add("файл");
        words.add("вид");
        words.add("В");
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();  //D:\JAVA\1922.txt
        reader.close();

        reader = new BufferedReader(new FileReader(fileName));
        while (reader.ready()) {
            String line = reader.readLine();
            String[] dataLine = line.replaceAll("[\\p{Punct}+]", "").split(" ");
            List<String> list = new LinkedList<>(Arrays.asList(dataLine));
            list.retainAll(words);
            if (list.size() == 2) {
                System.out.println(line);
            }
        }
        reader.close();
    }
}