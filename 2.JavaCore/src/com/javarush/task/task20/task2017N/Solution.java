package com.javarush.task.task20.task2017N;

import java.io.*;

/*
Десериализация
На вход подается поток, в который записан сериализованный объект класса A либо класса B.
Десериализуй объект в методе getOriginalObject так,
чтобы в случае возникновения исключения было выведено сообщение на экран и возвращен null.
Реализуй интерфейс Serializable где необходимо.

Требования:
1. Класс B должен быть потомком класса A.
2. Класс A должен поддерживать интерфейс Serializable.
3. Класс B не должен явно поддерживать интерфейс Serializable.
4. Метод getOriginalObject должен возвращать объект типа A полученный из потока ObjectInputStream.
5. Метод getOriginalObject должен возвращать null, если при попытке десериализации не был получен объект типа A.
6. Метод getOriginalObject должен возвращать null, если при попытке десериализации возникло исключение.
*/
public class Solution implements Serializable {
    public A getOriginalObject(ObjectInputStream objectStream) {
        A a = null;
        Object o = null;
        try {
            o = objectStream.readObject();
            System.out.println(o.getClass().getSimpleName());
            a = (A) o;
            System.out.println(a.getClass().getSimpleName());
        } catch (IOException e) {
            System.out.println(e);
            return null;
        } catch (ClassNotFoundException e) {
            System.out.println(e);
            return null;
        }
        return a;
    }

    public class A implements Serializable {
    }

    public class B extends A {
        public B() {
            System.out.println("inside B");
        }
    }

    public static void main(String[] args) {
        String fileName = "D:\\test\\0.txt";
        B b = new Solution().new B();
        Object o = null;
        try {
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(fileName));
            objectOutputStream.writeObject(b);

            ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(fileName));
            Solution solution = new Solution();
            o = solution.getOriginalObject(objectInputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println(o.getClass().getSimpleName());
    }
}
