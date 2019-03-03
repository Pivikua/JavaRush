package com.javarush.task.task20.task2016N;

import java.io.*;

/*
Минимум изменений
Используя минимум изменений кода сделайте так, чтобы сериализация класса C стала возможной.

Требования:
1. В классе Solution должен существовать класс A.
2. В классе Solution должен существовать класс B.
3. В классе Solution должен существовать класс C.
4. Класс B должен быть потомком класса A.
5. Класс C должен быть потомком класса B.
6. Класс A должен поддерживать интерфейс Serializable.
7. Класс B не должен явно поддерживать интерфейс Serializable.
8. Класс C не должен явно поддерживать интерфейс Serializable.
*/
public class Solution implements Serializable {
    public class A  implements Serializable {
        String name = "A";

        public A(String name) {
            this.name += name;
        }

        @Override
        public String toString() {
            return name;
        }
    }

    public class B extends A{
        String name = "B";

        public B(String name) {
            super(name);
            this.name += name;
        }
    }

    public class C extends B {
        String name = "C";

        public C(String name) {
            super(name);
            this.name = name;
        }
    }

    public static void main(String[] args) {
        String fileName = "D:\\test\\0.txt";
        C c = new Solution().new C("MyName");
        C newC = new Solution().new C("");

        try {
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(fileName));
            objectOutputStream.writeObject(c);

            ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(fileName));
            newC = (C) objectInputStream.readObject();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        System.out.println(newC.name);
    }
}
