package com.javarush.task.task21.task2113;

import java.util.ArrayList;

public class Hippodrome {
    static Hippodrome game;
    private ArrayList<Horse> horses = new ArrayList<>();

    public Hippodrome(ArrayList<Horse> horses) {
        this.horses = horses;
    }

    public static void main(String[] args) {
        game = new Hippodrome();
        game.horses.add(new Horse("Horse1", 3, 0));
        game.horses.add(new Horse("Horse2", 3, 0));
        game.horses.add(new Horse("Horse3", 3, 0));
        game.run();
        game.printWinner();
    }

    public Hippodrome() {
    }

    public ArrayList<Horse> getHorses() {
        return horses;
    }

    void run(){
        for (int i = 0; i < 100; i++) {
            move();
            print();
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    void move() {
        for (int i = 0; i < game.horses.size(); i++) {
            game.getHorses().get(i).move();
        }
    }

    void print() {
        for (int i = 0; i < game.horses.size(); i++) {
            getHorses().get(i).print();
        }
        System.out.println();
    }

    public Horse getWinner() {
        if (getHorses().get(0).distance > getHorses().get(1).distance && getHorses().get(0).distance > getHorses().get(2).distance) {
            return getHorses().get(0);
        }else if (getHorses().get(1).distance > getHorses().get(0).distance && getHorses().get(1).distance > getHorses().get(2).distance) {
            return getHorses().get(1);
        } else {
            return getHorses().get(2);
        }
    }

    public void printWinner() {
        System.out.println("Winner is " + getWinner().getName() + "!");
    }
}
