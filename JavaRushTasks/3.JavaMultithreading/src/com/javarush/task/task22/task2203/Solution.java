package com.javarush.task.task22.task2203;

import java.util.regex.Pattern;

/*
Между табуляциями
*/
public class Solution {
    public static String getPartOfString(String string) throws TooShortStringException {
        if (string == null) {
            throw new TooShortStringException();
        }
        if (string.length() < 2) {
            throw new TooShortStringException();
        }
        if (string.matches("^(.*\\t){2,}.*")) {
//            return string.replaceAll("^\\t([^\\t]+).*$", "$1");  //не принимает
            return string.substring(string.indexOf("\t")+1, string.indexOf("\t", string.indexOf("\t")+1));
        } else {
            throw new TooShortStringException();
        }
    }

    public static class TooShortStringException extends Exception {
    }

    public static void main(String[] args) throws TooShortStringException {
        System.out.println(getPartOfString("\tJavaRush - лучший сервис \tобучения Java\t."));
    }
}