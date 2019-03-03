package com.javarush.task.task21.task2113A;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by HiEND on 22.03.2017.
 */
public class Hippodrome {
    public static void main(String[] args) {

        Horse horse1 = new Horse("Клюковка", 3, 0);
        Horse horse2 = new Horse("Малинка", 3, 0);
        Horse horse3 = new Horse("Грибок", 3, 0);

        game = new Hippodrome();

        game.getHorses().add(horse1);
        game.getHorses().add(horse2);
        game.getHorses().add(horse3);

        game.run();
        game.printWinner();
    }

    static Hippodrome game;

    public Hippodrome() {
    }

    public Hippodrome(List<Horse> horses) {
        this.horses = horses;
    }

    private List<Horse> horses = new ArrayList<>();

    public List<Horse> getHorses() {
        return horses;
    }

    public void run() {
        for (int i = 0; i < 100; i++) {
            move();
            print();
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                //e.printStackTrace();
            }
        }
    }

    public void move() {
        for (Horse horse : horses) {
            horse.move();
        }
    }

    public void print() {
        for (Horse horse : horses) {
            horse.print();
        }

        for (int i = 0; i < 10; i++) {
            System.out.println();
        }
    }

    public Horse getWinner(){
        if(horses.get(0).getDistance() > horses.get(1).getDistance() &&
                horses.get(0).getDistance() > horses.get(2).getDistance()){ return horses.get(0); }
        if(horses.get(1).getDistance() > horses.get(0).getDistance() &&
                horses.get(1).getDistance() > horses.get(2).getDistance()){ return horses.get(1); }
        if(horses.get(2).getDistance() > horses.get(0).getDistance() &&
                horses.get(2).getDistance() > horses.get(1).getDistance()){ return horses.get(2); }
        return horses.get(0);
    }

    public void printWinner() {
        System.out.println("Winner is " + getWinner().getName() + "!");
    }
}
