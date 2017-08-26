package com.javarush.task.task19.task1911;

/* 
Ридер обертка
*/

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {
        PrintStream originalStream = System.out;
        ByteArrayOutputStream byteArray = new ByteArrayOutputStream();
        PrintStream myStream = new PrintStream(byteArray);
        System.setOut(myStream);
        testString.printSomething();
        String result = byteArray.toString().toUpperCase();
        System.setOut(originalStream);
        System.out.println(result);
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("it's a text for testing");
        }
    }
}