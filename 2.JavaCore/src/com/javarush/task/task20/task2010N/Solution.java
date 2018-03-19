package com.javarush.task.task20.task2010N;

/*
Как сериализовать что-то свое?
Сделайте так, чтобы сериализация класса Object была возможной.

Требования:
1. Класс Object должен существовать внутри класса Solution.
2. Класс Solution.Object должен быть статическим.
3. Класс Solution.Object должен быть публичным.
4. Класс Solution.Object должен поддерживать интерфейс Serializable.
5. Класс Solution.String должен поддерживать интерфейс Serializable.
*/

import java.io.*;

public class Solution {

    public static void main(String[] args) throws IOException, FileNotFoundException {
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("D:\\test\\0.txt"));
        Solution.Object object = new Solution.Object();
        objectOutputStream.writeObject(object);
        serializeStatic(objectOutputStream);
        objectOutputStream.close();
    }

    public static class Object implements Serializable {
        public String string1;
        public String string2;
    }

    public static int countStrings;

    public static class String1 implements Serializable {
        private final int number;

        public String1() {
            number = ++countStrings;
        }

        public void print() {
            System.out.println("string #" + number);
        }
    }

    public static void serializeStatic (ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.writeInt(countStrings);
    }

    public static void deSerializeStatic (ObjectInputStream inputStream) throws IOException {
        countStrings = inputStream.readInt();
    }

}