package com.javarush.task.task29.task2909.human;

public class Soldier extends Human /*implements Alive*/ {

    private String university;

    public Soldier(String name, int age) {
        super(name, age);
    }

    public void live() {
            fight();
    }

    public void fight() {
    }

    public String getUniversity() {
        return university;
    }

    public void setUniversity(String university) {
        this.university = university;
    }
}
