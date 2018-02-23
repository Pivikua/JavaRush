package com.javarush.task.task04.task0427;

/* 
Описываем числа
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String str = "";
        int number = Integer.parseInt(reader.readLine());
        if (number < 1000 && number > 0) {
            if (number % 2 == 0) {
                if (number >= 100 && number < 1000) {
                    str = "трехзначное";
                } else if (number >= 10 && number < 100) {
                    str = "двузначное";
                } else if (number > 0 && number < 10) {
                    str = "однозначное";
                }
                System.out.println("четное " + str + " число");
            } else {
                if (number >= 100 && number < 1000) {
                    str = "трехзначное";
                } else if (number >= 10 && number < 100) {
                    str = "двузначное";
                } else if (number > 0 && number < 10) {
                    str = "однозначное";
                }
                System.out.println("нечетное " + str + " число");
            }
        }
    }
}
