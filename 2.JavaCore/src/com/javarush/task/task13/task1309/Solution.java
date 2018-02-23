package com.javarush.task.task13.task1309;

public class Solution {
    public static void main(String[] args) throws Exception {
    }

    interface Movable {
        public Double Speed();
    }

    interface Flyable extends Movable{
        public Double Speed(Flyable flyable);
    }

    public static class Ball implements Movable {

        @Override
        public Double Speed() {
            return null;
        }
    }
}
