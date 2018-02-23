package com.javarush.task.task09.task0918;

/* 
Все свои, даже исключения
*/

public class Solution {
    public static void main(String[] args) {
    }
    
    static class MyException extends ClassNotFoundException {
    }

    static class MyException2 extends InterruptedException {

    }

    static class MyException3 extends ArithmeticException {
    }

    static class MyException4 extends NullPointerException {
    }
}

