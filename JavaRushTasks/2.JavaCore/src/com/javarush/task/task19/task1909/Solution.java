package com.javarush.task.task19.task1909;

/* 
Замена знаков
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

        String replaceString = data.toString().replace(".", "!");

        out.write(replaceString);
        bufferedReader.close();
        in.close();
        out.close();

    }
}