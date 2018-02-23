package com.javarush.task.task14.task1420;

/*
НОД
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        try {
            int first = Integer.parseInt(bufferedReader.readLine());
            int second = Integer.parseInt(bufferedReader.readLine());
            System.out.println(gcd(first, second));
        } catch (NumberFormatException e) {
            System.out.println("Неверный формат числа.");
        } catch (IOException e) {
            System.out.println("Ошибка ввода.");
        }
    }

    public static int gcd(int first, int second) {
        if (second == 0) return first;
        int x = first % second;
        return gcd(second, x);
    }
}
