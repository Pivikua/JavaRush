package com.javarush.task.task13.task1305;

public class Solution {
    public static void main(String[] args) throws Exception {

        System.out.println(new Hobbie().HOBBIE.toString());
        System.out.println(new Hobbie().toString());

    }

    interface Desire {
    }

    interface Dream {
        public static Hobbie HOBBIE = new Hobbie();
    }

    public static class Hobbie implements Dream, Desire {
        static int INDEX = 1;

        @Override
        public String toString() {
            INDEX++;
            return "" + INDEX;
        }
    }
}
