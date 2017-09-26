package com.javarush.task.task22.task2202;

/* 
Найти подстроку
*/
public class Solution {
    public static void main(String[] args) {
//        System.out.println(getPartOfString("JavaRush - лучший сервис"));
        System.out.println(getPartOfString("JavaRush - лучший сервис обучения Java."));
    }

    public static String getPartOfString(String string) {
        if (string == null){
            throw new TooShortStringException();
        }
//        String substring;
        if (string.matches("^.*(.*\\s){4,}.*")){
            String result = string.replaceAll("^\\S*\\s(\\S*\\s\\S*\\s\\S*\\s\\S*).*$", "$1");
            return result;
        }else {
            System.out.println("no");
            throw  new TooShortStringException();
        }
    }

    public static class TooShortStringException extends RuntimeException{
    }
}