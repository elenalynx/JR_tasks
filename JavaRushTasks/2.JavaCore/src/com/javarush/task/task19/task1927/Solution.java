package com.javarush.task.task19.task1927;

/* 
Контекстная реклама
*/

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {
        PrintStream original = System.out;
        ByteArrayOutputStream arrayOutputStream = new ByteArrayOutputStream();
        PrintStream printStream = new MyStream(new PrintStream(arrayOutputStream));
        System.setOut(printStream);
        testString.printSomething();
        System.setOut(original);
        System.out.println(arrayOutputStream.toString());

//        String line = arrayOutputStream.toString();
//        String[] array = line.split("\n");
//        for (int i = 0; i < array.length; i++) {
//            System.out.println(array[i]);
//            if (i % 2 != 0) {
//                System.out.println("JavaRush — курсы Java онлайн");
//            }
//        }
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("first");
            System.out.println("second");
            System.out.println("third");
            System.out.println("fourth");
            System.out.println("fifth");
        }
    }

    public static class MyStream extends PrintStream {
        private static int count = 0;
        private String advertising = "JavaRush - курсы Java онлайн";
        private PrintStream printStream;

        MyStream(PrintStream printStream) {
            super(printStream);
            this.printStream = printStream;
        }

        public MyStream(OutputStream out){
            super(out);
        }

        @Override
        public void print(String s) {
            if (MyStream.count == 1){
                printStream.println(s);
                printStream.print(advertising);
                MyStream.count = 0;
            }else {
                printStream.print(s);
                MyStream.count++;
            }
        }

    }
}
