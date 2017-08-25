package com.javarush.task.task19.task1910;

/* 
Пунктуация
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader in = new BufferedReader(new FileReader(bufferedReader.readLine()));
        BufferedWriter out = new BufferedWriter(new FileWriter(bufferedReader.readLine()));
        StringBuilder stringBuilder = new StringBuilder();
        while (in.ready()){
            stringBuilder.append(in.readLine());
        }
        String result = stringBuilder.toString().replaceAll("\\p{Punct}|\\n", "");
        out.write(result);

        bufferedReader.close();
        in.close();
        out.close();
    }
}
