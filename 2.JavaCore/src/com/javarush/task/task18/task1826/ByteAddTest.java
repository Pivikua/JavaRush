package com.javarush.task.task18.task1826;

public class ByteAddTest {
    public static void main(String[] args) {
        String string  = "Text by Engleash";
        /*for (byte i = -128; i < 127; i++) {
            System.out.println((char)i + " " + i);
        }*/
        byte bytes[] = new byte[string.getBytes().length];
        bytes = string.getBytes();

        for (byte bytes1 : bytes) {
            System.out.println((char)(int) bytes1 + " " + bytes1);
        }

        System.out.println((int) 'Т');

    }
}
