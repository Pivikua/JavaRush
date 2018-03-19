package com.javarush.task.task20.task2002N;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/*
Читаем и пишем в файл: JavaRush
Реализуйте логику записи в файл и чтения из файла для класса JavaRush.
В файле your_file_name.tmp может быть несколько объектов JavaRush.
Метод main реализован только для вас и не участвует в тестировании.

Требования:
1. Логика чтения/записи реализованная в методах save/load должна работать корректно в случае, если список users пустой.
2. Логика чтения/записи реализованная в методах save/load должна работать корректно в случае, если список users не пустой.
3. Класс Solution.JavaRush не должен поддерживать интерфейс Serializable.
4. Класс Solution.JavaRush должен быть публичным.
5. Класс Solution.JavaRush не должен поддерживать интерфейс Externalizable.
*/

public class Solution {
    public static void main(String[] args) {
        //you can find your_file_name.tmp in your TMP directory or fix outputStream/inputStream according to your real file location
        //вы можете найти your_file_name.tmp в папке TMP или исправьте outputStream/inputStream в соответствии с путем к вашему реальному файлу
        try {
            File your_file_name = File.createTempFile("name", null, new File("D:\\test\\"));
            OutputStream outputStream = new FileOutputStream(your_file_name);
            InputStream inputStream = new FileInputStream(your_file_name);
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

            JavaRush javaRush = new JavaRush();
            //initialize users field for the javaRush object here - инициализируйте поле users для объекта javaRush тут
            User pivik = new User();
            pivik.setFirstName("Alexandr");
            pivik.setLastName("Pivovarov");
            pivik.setBirthDate(dateFormat.parse("12/12/2012"));
            pivik.setMale(true);
            pivik.setCountry(User.Country.UKRAINE);

            User user2 = new User();
            user2.setFirstName("Соня");
            user2.setLastName("Чуднова");
            user2.setBirthDate(dateFormat.parse("09/10/2003"));
            user2.setMale(false);
            user2.setCountry(User.Country.OTHER);

            User user3 = new User();
            user3.setFirstName("Степан");
            user3.setLastName("Чуднов");
            user3.setBirthDate(dateFormat.parse("06/09/2005"));
            user3.setMale(true);
            user3.setCountry(User.Country.RUSSIA);

            javaRush.users.add(pivik);
            javaRush.users.add(user2);
            javaRush.users.add(user3);



            javaRush.save(outputStream);
            outputStream.flush();

            JavaRush loadedObject = new JavaRush();
            loadedObject.load(inputStream);
            System.out.println(loadedObject.toString());
            System.out.println(loadedObject.users.size());
            /*for (User user : loadedObject.users) {
                System.out.println(user.getFirstName());
                System.out.println(user.getLastName());
                System.out.println(dateFormat.format(user.getBirthDate()));
                System.out.println(user.isMale());
                System.out.println(user.getCountry().getDisplayedName());
            }*/

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
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

        public void save(OutputStream outputStream) {
            //implement this method - реализуйте этот метод
            try {
                PrintWriter writer = new PrintWriter(outputStream);
                for (User user: users) {
                    if (user == null) {
                        writer.println("NoName");
                    }
                    writer.println(user.getFirstName());

                    if (user == null) {
                        writer.println("NoSecName");
                    }
                    writer.println(user.getLastName());

                    if (user == null) {
                        writer.println("NoBDInfo");
                    }
                    writer.println(dateFormat.format(user.getBirthDate()));

                    if (user == null) {
                        writer.println("NoSexInfo");
                    }
                    writer.println(user.isMale());

                    if (user == null) {
                        writer.println("NoCountryInfo");
                    }
                    writer.println(user.getCountry().getDisplayedName());

                    writer.flush();
                }
                writer.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        public void load(InputStream inputStream) {
            //implement this method - реализуйте этот метод
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            String line;
            User newUser;
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

            try {
                while (reader.ready()) {
                    newUser = new User();

                    String firstname = reader.readLine();
                    if (firstname.equals("NoName")) {
                        newUser.setFirstName(null);
                    }
                    newUser.setFirstName(firstname);
                    System.out.println(newUser.getFirstName());

                    String secName = reader.readLine();
                    if (secName.equals("NoSecName")) {
                        newUser.setFirstName(null);
                    }
                    newUser.setLastName(secName);
                    System.out.println(newUser.getLastName());

                    String bd = reader.readLine();
                    if (bd.equals("NoBDInfo")) {
                        newUser.setFirstName(null);
                    }
                    newUser.setBirthDate(dateFormat.parse(bd));
                    System.out.println(dateFormat.format(newUser.getBirthDate()));

                    String sex = reader.readLine();
                    if (sex.equals("NoSexInfo")) {
                        newUser.setFirstName(null);
                    }
                    newUser.setMale(Boolean.parseBoolean(sex));
                    System.out.println(newUser.isMale());

                    String country = reader.readLine();
                    if (country.equals("NoCountryInfo")) {
                        newUser.setFirstName(null);
                    }
                    newUser.setCountry(User.Country.valueOf(country));
                    System.out.println(newUser.getCountry());

                    users.add(newUser);
                }
                reader.close();

            } catch (IOException e) {
                e.printStackTrace();
            } catch (ParseException e) {
                e.printStackTrace();
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
