package com.javarush.task.task13.task1308;

public class Solution {
    public static void main(String[] args) throws Exception {

        Human human = new Human(true);

        System.out.println(human.isAlive);
    }

    interface Person {
        public boolean isAlive();
    }

    interface Presentable extends Person {

    }

    static class Human implements Presentable {

        boolean isAlive;

        public Human(boolean isAlive) {
            this.isAlive = isAlive;
        }

        @Override
        public boolean isAlive() {
            return isAlive;
        }
    }

}
