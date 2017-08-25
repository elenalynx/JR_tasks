package com.javarush.task.task19.task1907;

/* 
Считаем слово
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String fn = bufferedReader.readLine();  //D:\JAVA\countworld.txt
        bufferedReader.close();

        int count = 0;
        String regex = "world";
        StringBuilder sb = new StringBuilder();
        FileReader reader = new FileReader(fn);
        while (reader.ready()) {
            sb.append((char) reader.read());
        }
        reader.close();
        String[] data = sb.toString().split("\\W");
        for (String s : data) {
            if (s.equals(regex)) {
                count++;
            }
        }
        System.out.println(count);
    }
}

