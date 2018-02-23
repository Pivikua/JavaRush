package com.javarush.task.task04.task0429;

/* 
Положительные и отрицательные числа
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] numbers = {Integer.parseInt(reader.readLine()), Integer.parseInt(reader.readLine()), Integer.parseInt(reader.readLine())};
        int polog = 0, otric = 0;
        for (int i = 0; i < numbers.length; i++) {
            if(numbers[i] > 0)
                polog++;
            else if (numbers[i] < 0)
                otric++;
        }
        System.out.println("количество отрицательных чисел: " + otric);
        System.out.println("количество положительных чисел: " + polog);
    }
}
