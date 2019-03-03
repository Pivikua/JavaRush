package com.javarush.task.task25.stepanu;

public class Mouse {
    int longe;
    int age;
    String name;

    public Mouse(int longe, int age, String name) {
        this.longe = longe;
        this.age = age;
        this.name = name;
    }

    public int getLonge() {
        return longe;
    }

    public void setLonge(int longe) {
        this.longe = longe;
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
}
