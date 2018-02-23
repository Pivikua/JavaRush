package com.javarush.task.task17.task1710;

public class Any {
    private static Any ourInstance = new Any();

    public static Any getInstance() {
        return ourInstance;
    }

    private Any() {
    }
}
