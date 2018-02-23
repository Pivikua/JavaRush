package com.javarush.task.task13.task1301;

/*
Пиво
*/

import com.sun.org.apache.xpath.internal.SourceTree;

public class Solution {

    int glassCounter = 0;
    int norma = 10;

    public static void main(String[] args) throws Exception {

        Beer beer = new Beer();
        beer.askMore("Налейте-ка мне кружечку пивка.");
    }

    public interface Drink {
        void askMore(String message);

        void sayThankYou();

        boolean isReadyToGoHome();
    }

    public interface Alcohol extends Drink {
        boolean READY_TO_GO_HOME = false;

        void sleepOnTheFloor();
    }

    public int getGlassCounter() {
        return glassCounter;
    }

    public void setGlassCounter(int glassCounter) {
        this.glassCounter = glassCounter;
    }

    public int getNorma() {
        return norma;
    }

    public void setNorma(int norma) {
        this.norma = norma;
    }

    public static class Beer implements Alcohol {

        Solution solution = new Solution();

        @Override
        public void askMore(String message) {
            System.out.println(message);
            solution.setGlassCounter(solution.glassCounter++);
        }

        @Override
        public void sayThankYou() {
            System.out.println("ThankYou!");
        }

        @Override
        public boolean isReadyToGoHome() {
            return READY_TO_GO_HOME;
        }

        @Override
        public void sleepOnTheFloor() {
            if (isReadyToGoHome()) {
                System.out.println("Я тут прилягу на минуточку! ИК!");
            } else {askMore("Пивная, еще кружечку!");}
        }
    }
}
