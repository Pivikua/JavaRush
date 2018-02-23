package com.javarush.task.task07.task0706;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Улицы и дома
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        int[] mssive = new int[15];
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < mssive.length; i++) {
            mssive[i] = Integer.parseInt(reader.readLine());
        }

        int even = 0, odd = 0;

        for (int i = 0; i < mssive.length; i++) {
            if (i == 0 || i % 2 == 0) {
                //System.out.println("Четные" + i + " " + mssive[i]);
                even += mssive[i];
            } else {
                //System.out.println("Нечетные" + i + " " + mssive[i]);
                odd += mssive[i];
            }
        }

        if (even < odd){
            System.out.println("В домах с нечетными номерами проживает больше жителей.");
        } else System.out.println("В домах с четными номерами проживает больше жителей.");
    }
}
