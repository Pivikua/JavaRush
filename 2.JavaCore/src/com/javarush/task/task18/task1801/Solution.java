package com.javarush.task.task18.task1801;

import java.io.FileInputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;

/*
Максимальный байт
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream fis = new FileInputStream(reader.readLine());

        int max = 0;
        int tmp = 0;

        while (fis.available() > 0) {
            tmp = fis.read();
            if (max < tmp) {
                max = tmp;
            }
        }

        System.out.println(max);
        fis.close();
        reader.close();
    }


}
