package com.javarush.task.task25.stepanu;

import com.javarush.task.task23.task2312.Mouse;

import java.awt.*;

public class Cat {
    int tail;
    int waith;
    int age;
    String name;
    boolean hungry;

    public Cat(int tail, int waith, int age, String name) {
        this.tail = tail;
        this.waith = waith;
        this.age = age;
        this.name = name;
    }

    public int getTail() {
        return tail;
    }

    public void setTail(int tail) {
        this.tail = tail;
    }

    public int getWaith() {
        return waith;
    }

    public void setWaith(int waith) {
        this.waith = waith;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void eat(com.javarush.task.task25.stepanu.Mouse mouse) {
        if (mouse != null){
            hungry = false;
        }
    }
}
