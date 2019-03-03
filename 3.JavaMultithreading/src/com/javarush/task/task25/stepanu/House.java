package com.javarush.task.task25.stepanu;


public class House {
    public static void main(String[] args) {
        Mouse mouse = new Mouse(10, 2, "Мышонок");
        Cat cat = new Cat(40, 40, 10, "Мурзик");
        cat.hungry = true;

        cat.eat(mouse);

        System.out.println(mouse.getName() + " " + mouse.getLonge() + " " + mouse.getAge());
        System.out.println(cat.getName() + " " + cat.getWaith() + " " + cat.getAge() + " " + cat.hungry);

    }
}
