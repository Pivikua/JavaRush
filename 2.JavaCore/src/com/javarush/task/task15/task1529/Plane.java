package com.javarush.task.task15.task1529;

public class Plane implements Flyable {

    int passagers;

    public Plane(int passagers) {
        this.passagers = passagers;
    }

    @Override
    public void fly() {

    }

    public int getPassagers() {
        return passagers;
    }
}
