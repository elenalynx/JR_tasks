package com.javarush.task.task19.task1906;

/* 
Четные символы
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String firstFileName = bufferedReader.readLine();
        String secondFileName = bufferedReader.readLine();
        bufferedReader.close();
        FileReader reader = new FileReader(firstFileName);
        FileWriter writer = new FileWriter(secondFileName);
        char[]chars;
        int index = 0;
        while (reader.ready()){
            int data = reader.read();
            index++;
            if (index%2 == 0){
                writer.write(data);
            }
        }
        reader.close();
        writer.close();
    }
}
