package com.javarush.task.task19.task1914;

/* 
Решаем пример
*/

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {
        PrintStream printStream = System.out;
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream stream = new PrintStream(outputStream);
        System.setOut(stream);
        testString.printSomething();
        String result = outputStream.toString();
        System.setOut(printStream);
        String znak = result.replaceAll("\\d", "").replaceAll("=", "").replaceAll("\\n", "").replaceAll("\\r", "").replaceAll(" ", "");
        String[] split = result.replaceAll("\\p{Punct}", " ").split("   ");
        int firstN = Integer.parseInt(split[0]);
        int secondN = Integer.parseInt(split[1]);
        int arifmResult = 0;
        if (znak.equals("+")){
            arifmResult = firstN + secondN;
        }else if (znak.equals("-")){
            arifmResult = firstN - secondN;
        }else if (znak.equals("*")){
            arifmResult = firstN * secondN;
        }
        String string = firstN + " " + znak + " " + secondN + " = " + arifmResult;
        System.out.println(string);
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("3 + 6 = ");
        }
    }
}

