package com.javarush.task.task19.task1908;

/* 
Выделяем числа
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader in = new BufferedReader(new FileReader(bufferedReader.readLine()));
        BufferedWriter out = new BufferedWriter(new FileWriter(bufferedReader.readLine()));

        StringBuilder data = new StringBuilder();
        while (in.ready()) {
            data.append(in.readLine());
        }

        String[] array = data.toString().split(" ");  // "\\W" ne prinimaet
        for (String s : array) {
            if (s.matches("[0-9]+")) {
                out.write(s + " ");
            }
        }
        bufferedReader.close();
        in.close();
        out.close();
    }
}
