package com.javarush.task.task19.task1920;

/* 
Самый богатый
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        Map<String, Double> hashMap = new HashMap<>();
        ArrayList<String> list;
        BufferedReader bufferedReader = new BufferedReader(new FileReader(args[0]));
        while (bufferedReader.ready()) {
            String line = bufferedReader.readLine();
            String[] data = line.split(" ");
            if (hashMap.containsKey(data[0])) {
                hashMap.put(data[0], hashMap.get(data[0]) + Double.valueOf(data[1]));
            }else {
                hashMap.put(data[0], Double.valueOf(data[1]));
            }
        }
        bufferedReader.close();

        list = rich(hashMap);
        Collections.sort(list);
        for (String name:list) {
            System.out.println(name);
        }
    }

    public static ArrayList rich(Map<String, Double> hashMap) {
        ArrayList<String> list = new ArrayList<>();
        double max = 0;
        String name;
        for (Double d : hashMap.values()){
            if (max < d){
                max = d;
            }
        }
        for (Map.Entry<String, Double>entry:hashMap.entrySet()){
            if (entry.getValue().equals(max)){
                list.add(entry.getKey());
            }
        }
        return list;
    }
}
