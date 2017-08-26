package com.javarush.task.task19.task1914;

/* 
Решаем пример
*/

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {
        PrintStream originalPrintStream = System.out;
        ByteArrayOutputStream byteArray = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(byteArray);
        System.setOut(printStream);
        testString.printSomething();
        System.setOut(originalPrintStream);
        String[] data = byteArray.toString().split("\\s");
        int a = Integer.parseInt(data[0]);
        int b = Integer.parseInt(data[2]);
        int c = 0;
        String operation = data[1];
        if (operation.equals("+")) {
            c = a + b;
        }
        if (operation.equals("-")) {
            c = a - b;
        }
        if (operation.equals("*")) {
            c = a * b;
        }

        String result = String.format("%d %s %d %s %d", a, operation, b, data[3], c);
        System.out.println(result);
//        System.out.println(byteArray.toString() + c);
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("3 + 6 = ");
        }
    }
}

