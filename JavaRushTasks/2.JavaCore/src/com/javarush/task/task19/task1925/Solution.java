package com.javarush.task.task19.task1925;

/* 
Длинные слова
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        String fileNme1 = args[0];
        String fileNme2 = args[1];
        int lengthWord = 6;
        BufferedReader reader = new BufferedReader(new FileReader(fileNme1));
        BufferedWriter writer = new BufferedWriter(new FileWriter(fileNme2));
        StringBuilder outLine = new StringBuilder();
        while (reader.ready()) {
            String line = reader.readLine();
            String[] arrayLine = line.split(" ");
            for (String s : arrayLine) {
                if (s.length() > lengthWord) {
                    outLine.append(s).append(",");
                }
            }
        }
        outLine.deleteCharAt(outLine.length() - 1);
        writer.write(outLine.toString());
        reader.close();
        writer.close();
    }
}