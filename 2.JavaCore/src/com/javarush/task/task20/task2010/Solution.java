package com.javarush.task.task20.task2010;

/* 
Как сериализовать что-то свое?
*/

// Выполнено.

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Solution implements Serializable {
    public static class Object implements Serializable {
        public String string1;
        public String string2;
    }

    public static int countStrings;

    public static class String implements Serializable {
        private final int number;

        public String() {
            number = ++countStrings;
        }

        public void print() {
            System.out.println("string #" + number);
        }

    }

    public static void serializeStatic(ObjectOutputStream oos) throws IOException {
        oos.writeInt(countStrings);
    }
    public static void deserializeStatic(ObjectInputStream ois) throws IOException{
        countStrings = ois.readInt();
    }


    public static void main(String[] args) {

    }
}
