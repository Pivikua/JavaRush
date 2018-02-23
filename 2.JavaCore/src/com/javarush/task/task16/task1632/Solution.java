package com.javarush.task.task16.task1632;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static List<Thread> threads = new ArrayList<>(5);

    static {
        threads.add(new ThreadInfinitely("Thread Infinitely"));
        threads.add(new ThreadInterrupted("Thread Interrupted"));
        threads.add(new ThreadUra("Thread Ura"));
        threads.add(new ThreadMessage("Thread Message"));
        threads.add(new ThreadNumberInputs("Thread Number Inputs"));
    }

    public static void main(String[] args) {
        for (Thread thread : threads)
            thread.start();
    }
// --------------------------------------------------------
    public static class ThreadInfinitely extends Thread {

        public ThreadInfinitely(String name) {
            super(name);
        }

        @Override
        public void run() {
            while (true) {
            }
        }
    }
// ---------------------------------------------------------
    public static class ThreadInterrupted extends Thread {

        public ThreadInterrupted(String name) {
            super(name);
        }

        @Override
        public void run() {
            try {
                Thread.sleep(0);
            } catch (InterruptedException e) {
                System.out.println("InterruptedException");
            }
        }
    }
// ----------------------------------------------------------
    public static class ThreadUra extends Thread {

        public ThreadUra(String name) {
            super(name);
        }

        @Override
        public void run() {
            try {
                while (true) {
                    System.out.println("Ура");
                    Thread.sleep(2000);
                }
            } catch (InterruptedException e) {
            }
        }
    }
// ------------------------------------------------------------
    public static class ThreadMessage extends Thread implements Message {
        private boolean die;

        public ThreadMessage(String name) {
            super(name);
            this.die = false;
        }

        @Override
        public void run() {
            while (die == false) {
            }
        }

        @Override
        public void showWarning() {
            die = true;
        }

    }
// ----------------------------------------------------------
    public static class ThreadNumberInputs extends Thread {

        public ThreadNumberInputs(String name) {
            super(name);
        }

        @Override
        public void run() {
            try {
                BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
                int sum = 0;
                String s = null;
                while (true) {
                    s = reader.readLine();
                    if (s.contains("N") == true)
                        break;
                    try {
                        sum += Integer.parseInt(s);
                    } catch (NumberFormatException e) {
                    }
                }
                System.out.println(sum);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}