package com.javarush.task.task05.task0507;

/* 
Среднее арифметическое
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String strNumber;
        int summa = 0;
        int count = 0;
        while(true){
            strNumber = reader.readLine();
            if ((strNumber).equals("-1")){
                break;
            }
            int number = Integer.parseInt(strNumber);
            summa += number;
            count++;
        }
        System.out.println((double) summa / count);
    }
}

