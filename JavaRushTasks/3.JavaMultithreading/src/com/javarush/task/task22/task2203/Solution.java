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
        if (string.matches("^(.*\\t){2,}.*")) {
            String firstTab = string.replaceFirst("\\t", "");
            return firstTab.replaceFirst("\\t.*", "").trim();
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