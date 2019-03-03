package com.javarush.task.task22.LogTest;

public class LogTest {
    public static void main(String[] args) {
        int logtest;
        for (int i = 1; i < 20; i++) {
            if (i > 0 && i < 12) {
                logtest = 500 - (int) (Math.log10(i) * 193);
            } else if (i > 11 && i < 15) {
                logtest = 300 - (int) (Math.log10(i - 10) * 100);
            } else {
                logtest = 200;
            }
            System.out.println(i + " : " + logtest);
        }
    }
}
