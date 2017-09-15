package com.javarush.task.task20.task2022;

import java.io.*;

/* 
Переопределение сериализации в потоке
*/
public class Solution implements Serializable, AutoCloseable {
    transient private FileOutputStream stream;
    private String fileName;

    public Solution(String fileName) throws FileNotFoundException {
        this.stream = new FileOutputStream(fileName);
        this.fileName = fileName;
    }

    public void writeObject(String string) throws IOException {
        stream.write(string.getBytes());
        stream.write("\n".getBytes());
        stream.flush();
//        writeObject(new ObjectOutputStream(stream));
    }

    private void writeObject(ObjectOutputStream out) throws IOException {
        out.defaultWriteObject();
//        out.close();
    }

    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        in.defaultReadObject();
        this.stream = new FileOutputStream(fileName,true);
//        in.close();
    }

    @Override
    public void close() throws Exception {
        System.out.println("Closing everything!");
        stream.close();
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Solution solution = new Solution("D:\\JAVA\\2022.txt");
        solution.writeObject("ra");
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("D:\\JAVA\\2022_out.txt"));
        objectOutputStream.writeObject(solution);


        Solution newSolution = (Solution) new ObjectInputStream(new FileInputStream("D:\\JAVA\\2022_out.txt")).readObject();
        newSolution.writeObject("yes");
    }
}