package com.javarush.task.task20.task2007N;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/*
Как сериализовать JavaRush?
Сделай так, чтобы сериализация класса JavaRush была возможной.

Требования:
1. Класс JavaRush должен существовать внутри класса Solution.
2. Класс JavaRush должен быть статическим.
3. Класс JavaRush должен быть публичным.
4. Класс JavaRush должен поддерживать интерфейс Serializable.
*/

public class Solution {
    public static class JavaRush implements Serializable {
        public List<User> users = new ArrayList<>();
    }

    public static void main(String[] args) throws IOException, ParseException{
        JavaRush javaRush = new JavaRush();

        User user = new User();
        user.setFirstName("Alekandr");
        user.setLastName("Pivovarov");
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        user.setBirthDate(dateFormat.parse("11/20/1975"));
        user.setMale(true);
        user.setCountry(User.Country.UKRAINE);

        javaRush.users.add(user);

        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("D:\\test\\0.txt"));
        objectOutputStream.writeObject(javaRush);
        objectOutputStream.close();

    }
}

