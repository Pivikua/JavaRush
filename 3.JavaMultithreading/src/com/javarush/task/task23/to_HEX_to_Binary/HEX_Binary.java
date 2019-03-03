package com.javarush.task.task23.to_HEX_to_Binary;

public class HEX_Binary {
    public static void main(String[] args) {

        System.out.println(intToHEX(123456789));
        System.out.println(intToBin(123456789));
    }

    public static String intToHEX(int n) {
        return Integer.toHexString(n);
    }

    public static String intToBin(int n) {
        return Integer.toBinaryString(n);
    }
}
