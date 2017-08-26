package com.javarush.task.task19.task1912;

/* 
Ридер обертка 2
*/

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {
        PrintStream originalSystemOut = System.out;
        ByteArrayOutputStream byteArray = new ByteArrayOutputStream();
        PrintStream newSystemOut = new PrintStream(byteArray);
        System.setOut(newSystemOut);
        testString.printSomething();
        String line = byteArray.toString().replaceAll("te", "??");
        System.setOut(originalSystemOut);
        System.out.println(line);
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("it's a text for testing");
        }
    }
}