package com.javarush.task.task19.task1923;

/* 
Слова с цифрами
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        String fileName1 = args[0];
        String fileName2 = args[1];
        BufferedReader reader = new BufferedReader(new FileReader(fileName1));
        BufferedWriter writer = new BufferedWriter(new FileWriter(fileName2));
        while (reader.ready()){
            String line = reader.readLine();
            String[] data = line.split(" ");
            for (String word : data){
                if (!word.matches("^\\D*$")){
                    writer.write(word+" ");
                }
            }
        }
        reader.close();
        writer.close();
    }
}