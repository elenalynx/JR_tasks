package com.javarush.task.task20.task2002;

import java.io.*;
import java.util.ArrayList;
import java.util.*;

/*
Читаем и пишем в файл: JavaRush
*/
public class Solution {
    public static void main(String[] args) {
        //you can find your_file_name.tmp in your TMP directory or fix outputStream/inputStream according to your real file location
        //вы можете найти your_file_name.tmp в папке TMP или исправьте outputStream/inputStream в соответствии с путем к вашему реальному файлу
        try {
            File your_file_name = File.createTempFile("your_file_name", null);
            OutputStream outputStream = new FileOutputStream(your_file_name);
            InputStream inputStream = new FileInputStream(your_file_name);

            JavaRush javaRush = new JavaRush();
            //initialize users field for the javaRush object here - инициализируйте поле users для объекта javaRush тут
            User a = new User();
            a.setFirstName("Иван");
            a.setLastName("Иванов");
            a.setBirthDate(new Date(2000, 5, 25));
            a.setMale(true);
            a.setCountry(User.Country.UKRAINE);
            javaRush.users.add(a);

            javaRush.save(outputStream);
            outputStream.flush();

            JavaRush loadedObject = new JavaRush();
            loadedObject.load(inputStream);
            //check here that javaRush object equals to loadedObject object - проверьте тут, что javaRush и loadedObject равны

            outputStream.close();
            inputStream.close();

        } catch (IOException e) {
            //e.printStackTrace();
            System.out.println("Oops, something wrong with my file");
        } catch (Exception e) {
            //e.printStackTrace();
            System.out.println("Oops, something wrong with save/load method");
        }
    }

    public static class JavaRush {
        public List<User> users = new ArrayList<>();

        public void save(OutputStream outputStream) throws Exception {
            if(users == null)
                throw new  Exception();
            PrintWriter printWriter = new PrintWriter(outputStream);
            for (User a: users){
                String b = a.getFirstName() + " " + a.getLastName();
                b =  b + " " + a.getBirthDate().getTime();
                if (a.isMale())
                    b = b + " " + "М";
                else
                    b = b + " " + "Ж";
                b = b + " " + a.getCountry().getDisplayedName();
                printWriter.println(b);
            }
            printWriter.flush();
        }

        public void load(InputStream inputStream) throws Exception {
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));

            users = new ArrayList();
            while (reader.ready()) {
                String b = reader.readLine();
                String[] c = b.split(" ");
                User d = new User();
                d.setFirstName(c[0]);
                d.setLastName(c[1]);
                d.setBirthDate(new Date(Long.parseLong(c[2])));
                if (c[3].equals("М"))
                    d.setMale(true);
                else if (c[3].equals("Ж"))
                    d.setMale(false);
                if (c[4].equals("Ukraine"))
                    d.setCountry(User.Country.UKRAINE);
                if (c[4].equals("Russia"))
                    d.setCountry(User.Country.RUSSIA);
                if (c[4].equals("Other"))
                    d.setCountry(User.Country.OTHER);
                users.add(d);
            }
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            JavaRush javaRush = (JavaRush) o;

            return users != null ? users.equals(javaRush.users) : javaRush.users == null;

        }

        @Override
        public int hashCode() {
            return users != null ? users.hashCode() : 0;
        }
    }
}


//import java.io.*;
//import java.text.SimpleDateFormat;
//import java.util.ArrayList;
//import java.util.Date;
//import java.util.GregorianCalendar;
//import java.util.List;
//
///*
//Читаем и пишем в файл: JavaRush
//*/
//public class Solution {
//    public static void main(String[] args) {
//        //you can find your_file_name.tmp in your TMP directory or fix outputStream/inputStream according to your real file location
//        //вы можете найти your_file_name.tmp в папке TMP или исправьте outputStream/inputStream в соответствии с путем к вашему реальному файлу
//        try {
//            File your_file_name = File.createTempFile("your_file_name", null);
//            OutputStream outputStream = new FileOutputStream(your_file_name);
//            InputStream inputStream = new FileInputStream(your_file_name);
//
//            JavaRush javaRush = new JavaRush();
//            //initialize users field for the javaRush object here - инициализируйте поле users для объекта javaRush тут
//            User a = new User();
//            a.setFirstName("Mik");
//            a.setLastName("Makov");
//            a.setBirthDate(new GregorianCalendar(2000, 1, 11).getTime());
//            a.setMale(true);
//            a.setCountry(User.Country.UKRAINE);
//            javaRush.users.add(a);
//
//            javaRush.save(outputStream);
//            outputStream.flush();
//
//            JavaRush loadedObject = new JavaRush();
//            loadedObject.load(inputStream);
//            //check here that javaRush object equals to loadedObject object - проверьте тут, что javaRush и loadedObject равны
//            if (javaRush.equals(loadedObject)) {
//                System.out.println("y");
//            } else {
//                System.out.println("n");
//            }
//
//            outputStream.close();
//            inputStream.close();
//
//        } catch (IOException e) {
//            //e.printStackTrace();
//            System.out.println("Oops, something wrong with my file");
//        } catch (Exception e) {
//            //e.printStackTrace();
//            System.out.println("Oops, something wrong with save/load method");
//        }
//    }
//
//    public static class JavaRush {
//        public List<User> users = new ArrayList<>();
//
//        public void save(OutputStream outputStream) throws Exception {
//            //implement this method - реализуйте этот метод
//            PrintWriter printWriter = new PrintWriter(outputStream);
//            SimpleDateFormat dateFormat = new SimpleDateFormat("dd MM yyyy");
//            if (users != null) {
//                for (User user : users) {
//                    printWriter.println(new StringBuilder().append(user.getFirstName()).append(" ")
//                            .append(user.getLastName()).append(" ")
//                            .append(dateFormat.format(user.getBirthDate().getTime())).append(" ")
//                            .append(user.isMale() ? "men" : "women").append(" ")
//                            .append(user.getCountry().getDisplayedName()));
//                }
//                printWriter.flush();
//            } else {
//                throw new Exception();
//            }
//
//        }
//
//        public void load(InputStream inputStream) throws Exception {
//            //implement this method - реализуйте этот метод
//            if (inputStream != null) {
//                BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
//                users = new ArrayList<>();
////                StringBuilder stringBuilder = new StringBuilder();
//                while (reader.ready()) {
//                    String data = reader.readLine();
//                    String[] arrayData = data.split(" ");
//                    User user = new User();
////                    if (arrayData.length == 5){
//                    user.setFirstName(arrayData[0]);
//                    user.setLastName(arrayData[1]);
//                    user.setBirthDate(new Date(Long.parseLong(arrayData[2])));
//                    if (arrayData[3].equals("men")) {
//                        user.setMale(true);
//                    }
//                    if (arrayData[3].equals("women")) {
//                        user.setMale(false);
//                    }
//                    if (arrayData[4].equals("Ukraine")) {
//                        user.setCountry(User.Country.UKRAINE);
//                    }
//                    if (arrayData[4].equals("Russia")) {
//                        user.setCountry(User.Country.RUSSIA);
//                    }
//                    if (arrayData[4].equals("Other")) {
//                        user.setCountry(User.Country.OTHER);
//                    }
////                    }
//                    if (users == null) {
//                        users.add(user);
//                    } else {
//                        if (!users.contains(user)) {
//                            users.add(user);
//                        }
//                    }
//                }
//            }
//        }
//
//        @Override
//        public boolean equals(Object o) {
//            if (this == o) return true;
//            if (o == null || getClass() != o.getClass()) return false;
//
//            JavaRush javaRush = (JavaRush) o;
//
//            return users != null ? users.equals(javaRush.users) : javaRush.users == null;
//
//        }
//
//        @Override
//        public int hashCode() {
//            return users != null ? users.hashCode() : 0;
//        }
//    }
//}
