package com.javarush.task.task20.task2017;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;

/* 
Десериализация
На вход подается поток, в который записан сериализованный объект класса A либо класса B.
Десериализуй объект в методе getOriginalObject так, чтобы в
случае возникновения исключения было выведено сообщение на экран и возвращен null.
Реализуй интерфейс Serializable где необходимо.
*/

// Выполнено.
public class Solution {
    public A getOriginalObject(ObjectInputStream objectStream) {

        A o = null;
        try {
            o = (A)objectStream.readObject();
        } catch (Exception e) {
            return null;
        }
        return o;
    }

    public class A implements Serializable {

    }

    public class B extends A {
        public B() {
            System.out.println("inside B");
        }

    }

    public static void main(String[] args) {

    }
}
