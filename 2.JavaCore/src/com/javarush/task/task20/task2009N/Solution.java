package com.javarush.task.task20.task2009N;

/*
Как сериализовать static?
Сделай так, чтобы сериализация класса ClassWithStatic была возможной.

Требования:
1. Класс ClassWithStatic должен существовать внутри класса Solution.
2. Класс ClassWithStatic должен быть статическим.
3. Класс ClassWithStatic должен быть публичным.
4. Класс ClassWithStatic должен поддерживать интерфейс Serializable.
*/

import java.io.*;

public class Solution{
    public static class ClassWithStatic implements Serializable{
        public static String staticString = "it's test static string";
        public int i;
        public int j;

        public String toString() {
            return staticString;
        }

        public static void serializeStatic (ObjectOutputStream objectOutputStream) {
            try {
                objectOutputStream.writeObject(staticString);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        public static void deserializeStatic (ObjectInputStream objectInputStream) {
            try {
                staticString = (String) objectInputStream.readObject();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
        ClassWithStatic classWithStatic = new ClassWithStatic();
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("D:\\test\\0.txt"));
        objectOutputStream.writeObject(classWithStatic);
        objectOutputStream.close();

        ClassWithStatic classWithStatic1;
        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("D:\\test\\0.txt"));
        classWithStatic1 = (ClassWithStatic) objectInputStream.readObject();
        objectInputStream.close();

        System.out.println(classWithStatic1.equals(classWithStatic));
    }
}

