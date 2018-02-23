package com.javarush.task.task20.task2002;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* 
Читаем и пишем в файл: JavaRush
*/
public class Solution {
    public static void main(String[] args) {
        //you can find your_file_name.tmp in your TMP directory or fix outputStream/inputStream according to your real file location
        //вы можете найти your_file_name.tmp в папке TMP или исправьте outputStream/inputStream в соответствии с путем к вашему реальному файлу
        try {
            File your_file_name = File.createTempFile("file", ".tmp", new File("E:/test/"));
            OutputStream outputStream = new FileOutputStream(your_file_name);
            InputStream inputStream = new FileInputStream(your_file_name);
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd.MM.yyyy", Locale.ENGLISH);

            JavaRush javaRush = new JavaRush();
            //initialize users field for the javaRush object here - инициализируйте поле users для объекта javaRush тут
            User user1 = new User();
            user1.setFirstName("Александр");
            user1.setLastName("Чуднов");
            user1.setBirthDate(simpleDateFormat.parse("21.12.1985"));
            user1.setMale(true);
            user1.setCountry(User.Country.UKRAINE);

            User user2 = new User();
            user2.setFirstName("Соня");
            user2.setLastName("Чуднова");
            user2.setBirthDate(simpleDateFormat.parse("09.10.2003"));
            user2.setMale(false);
            user2.setCountry(User.Country.OTHER);

            User user3 = new User();
            user3.setFirstName("Степан");
            user3.setLastName("Чуднов");
            user3.setBirthDate(simpleDateFormat.parse("06.09.2005"));
            user3.setMale(true);
            user3.setCountry(User.Country.UKRAINE);

            javaRush.users.add(user1);
            javaRush.users.add(user2);
            javaRush.users.add(user3);

            javaRush.save(outputStream);
            outputStream.flush();

            JavaRush loadedObject = new JavaRush();
            loadedObject.load(inputStream);

            //check here that javaRush object equals to loadedObject object - проверьте тут, что javaRush и loadedObject равны
            System.out.println(loadedObject.equals(javaRush) ? "OK" : "FAILED");

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
        SimpleDateFormat df = new SimpleDateFormat("dd.MM.yyyy");


        public void save(OutputStream outputStream) throws Exception {
            //implement this method - реализуйте этот метод
            PrintWriter pw = new PrintWriter(outputStream);
            for (User u : users)
            {
                String s = u.getFirstName();
                if (s == null) s = "NoName";
                pw.println(s);

                s = u.getLastName();
                if (s == null) s = "NoLastName";
                pw.println(s);

                Date d = u.getBirthDate();
                if (d == null) s = "NoDate";
                else s = df.format(d);

                pw.println(s);
                pw.println(u.isMale());

                if (u.getCountry() == null) s = "NoCountry";
                else s = String.valueOf(u.getCountry());

                pw.println(s);
            }
            pw.close();
        }

        public void load(InputStream inputStream) throws Exception {
            //implement this method - реализуйте этот метод
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            while (reader.ready()) {
                User user = new User();
                String s = new String();

                s = reader.readLine();
                if (s.equals("NoName")) user.setFirstName(null);
                else user.setFirstName(s);

                s = reader.readLine();
                if (s.equals("NoLastName")) user.setLastName(null);
                else user.setLastName(s);

                s = reader.readLine();
                if (s.equals("NoDate")) user.setBirthDate(null);
                else user.setBirthDate(df.parse(s));

                if (reader.readLine().equals("true")) user.setMale(true);
                else user.setMale(false);

                s = reader.readLine();
                if (s.equals("NoCountry")) user.setCountry(null);
                else user.setCountry(User.Country.valueOf(s));

                users.add(user);
            }
            reader.close();
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

    /*    public static class JavaRush {
        public List<User> users = new ArrayList<>();
        private static int objCount = 0;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd.MM.yyyy", Locale.ENGLISH);

        public void save(OutputStream outputStream) throws Exception {
            //implement this method - реализуйте этот метод

            PrintWriter writer = new PrintWriter(outputStream);

            if (users.size() > 0) {
                for (User user : users) {
                    writer.println("------");
                    String firstName = user.getFirstName();
                    if (firstName == null) {
                        firstName = "noName";
                    }
                    writer.println(firstName);

                    String lastName = user.getLastName();
                    if (lastName == null) {
                        lastName = "noLastname";
                    }
                    writer.println(lastName);

                    writer.println(simpleDateFormat.format(user.getBirthDate()));
                    writer.println(String.valueOf(user.isMale()));
                    writer.println(user.getCountry());
                }
            }
        }

        public void load(InputStream inputStream) throws IOException, ParseException {
            //implement this method - реализуйте этот метод
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));

            while (reader.ready()) {
                String separator = reader.readLine();

                if (separator.equals("------")) {
                    User user = new User();
                    String firstName = reader.readLine();
                    if (firstName.equals("noName")) {
                        firstName = null;
                    }
                    user.setFirstName(firstName);

                    String secondName = reader.readLine();
                    if (secondName.equals("noLastname")) {
                        secondName = null;
                    }
                    user.setLastName(secondName);

                    user.setBirthDate(simpleDateFormat.parse(reader.readLine()));

                    if (reader.readLine().equals("true")) {
                        user.setMale(true);
                    } else user.setMale(false);

                    String country = reader.readLine();

                    System.out.println(User.Country.valueOf(country));

                    user.setCountry(User.Country.valueOf(country));
                    users.add(user);
                }
            }
            reader.close();
        }
    }
}*/
