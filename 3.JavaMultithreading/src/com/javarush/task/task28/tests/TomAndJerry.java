package com.javarush.task.task28.tests;

public class TomAndJerry {
    public static void main(String[] args)throws Exception {
        Cat cat = new Cat();
        int a = 5;
        String text = cat.toString() + a + "Cat is " + cat + a;
        System.out.println(text);
    }

    static class Cat{}


}
