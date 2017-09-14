package com.javarush.task.task20.task2014;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;

/* 
Serializable Solution
*/
public class Solution implements Serializable {
    public static void main(String[] args) {
        System.out.println(new Solution(4));
        try {
            File file = File.createTempFile("2014", ".txt", new File("D:\\JAVA\\"));
            ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(file));
            ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(file));

            Solution savedObject = new Solution(5);
            System.out.println(savedObject);
            outputStream.writeObject(savedObject);
            outputStream.flush();
            outputStream.close();

            Solution loadedObject = new Solution(6);
            System.out.println(loadedObject);
            loadedObject = (Solution) inputStream.readObject();
            System.out.println(loadedObject);
            inputStream.close();
            System.out.println((savedObject.string.equals(loadedObject.string) ? "y" : "n"));

        }catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private transient final String pattern = "dd MMMM yyyy, EEEE";
    private transient Date currentDate;
    private transient int temperature;
    String string;

    public Solution(int temperature) {
        this.currentDate = new Date();
        this.temperature = temperature;

        string = "Today is %s, and current temperature is %s C";
        SimpleDateFormat format = new SimpleDateFormat(pattern);
        this.string = String.format(string, format.format(currentDate), temperature);
    }

    @Override
    public String toString() {
        return this.string;
    }
}