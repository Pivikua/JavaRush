package com.javarush.task.task30.task3008;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ConsoleHelper {
    private static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

    public static void writeMessage(String message){
        System.out.println(message);
    }

    public static String readString() {
        String outString = null;
        boolean exitReader = true;
        while (exitReader) {
            try {
                outString = bufferedReader.readLine();
                exitReader = false;
            } catch (IOException e) {
                System.out.println("Произошла ошибка при попытке ввода текста. Попробуйте еще раз.");
            }
        }
        return outString;
    }

    public static int readInt() {
        int outInt = 0;
        boolean exitReader = true;
        while (exitReader) {
            try {
                outInt = Integer.parseInt(readString());
                exitReader = false;
            } catch (NumberFormatException e) {
                System.out.println("Произошла ошибка при попытке ввода числа. Попробуйте еще раз.");
            }
        }
        return outInt;
    }
}
