package com.javarush.task.task19.task1919;

/* 
Считаем зарплаты
*/

import java.io.*;
import java.util.Map;
import java.util.TreeMap;

public class Solution {
    public static void main(String[] args) throws IOException {
        Map<String, Double> treeMap = new TreeMap<>();
        BufferedReader bufferedReader = new BufferedReader(new FileReader(args[0]));
        while (bufferedReader.ready()) {
            String line = bufferedReader.readLine();
            String[] data = line.split(" ");
            if (treeMap.containsKey(data[0])) {
                treeMap.put(data[0], treeMap.get(data[0]) + Double.valueOf(data[1]));
            }else {
                treeMap.put(data[0], Double.valueOf(data[1]));
            }
        }
        bufferedReader.close();
        for (Map.Entry<String, Double> entry : treeMap.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
    }
}