package com.javarush.task.task19.task1926;

/* 
Перевертыши
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        reader.close();
        BufferedReader readerText = new BufferedReader(new FileReader(fileName));
        while (readerText.ready()){
            StringBuilder line = new StringBuilder();
            line.append(readerText.readLine());
            System.out.println(line.reverse());
        }
        readerText.close();
    }
}