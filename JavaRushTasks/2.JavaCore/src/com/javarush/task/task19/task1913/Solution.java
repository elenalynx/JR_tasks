package com.javarush.task.task19.task1913;

/* 
Выводим только цифры
*/

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {
        PrintStream originalStream = System.out;
        ByteArrayOutputStream byteArray = new ByteArrayOutputStream();
        PrintStream newStream = new PrintStream(byteArray);
        System.setOut(newStream);
        testString.printSomething();
        System.setOut(originalStream);
        String line = byteArray.toString();
        String numbers = line.replaceAll("\\D", "");
        System.out.println(numbers);
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("it's 1 a 23 text 4 f5-6or7 tes8ting");
        }
    }
}