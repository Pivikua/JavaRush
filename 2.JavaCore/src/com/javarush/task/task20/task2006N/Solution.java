package com.javarush.task.task20.task2006N;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
Как сериализовать?
Сделай так, чтобы сериализация класса Human была возможной.

Требования:
1. Класс Human должен существовать внутри класса Solution.
2. Класс Human должен быть статическим.
3. Класс Human должен быть публичным.
4. Класс Human должен поддерживать интерфейс Serializable.
*/
public class Solution {
    public static class Human implements Serializable {
        public String name;
        public List<Asset> assets = new ArrayList<>();

        public Human() {
        }

        public Human(String name, Asset... assets) {
            this.name = name;
            if (assets != null) {
                this.assets.addAll(Arrays.asList(assets));
            }
        }
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Human vasya = new Human("Vasya", new Asset("Home"));

        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("D:\\test\\0.txt"));
        objectOutputStream.writeObject(vasya);
        objectOutputStream.close();

        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("D:\\test\\0.txt"));
        Human loadedHuman = (Human) objectInputStream.readObject();

        System.out.println(loadedHuman.name + " " + loadedHuman.assets.get(0).getName());
    }
}
