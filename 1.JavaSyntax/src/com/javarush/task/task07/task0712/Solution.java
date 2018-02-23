package com.javarush.task.task07.task0712;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Самые-самые
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        ArrayList<String> strings = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String strlong = "";
        int indexLong = 0;
        int indexShort = 0;

        for (int i = 0; i < 10; i++) {
            strings.add(reader.readLine());
            if (strings.get(i).length() > strlong.length()) strlong = strings.get(i);
        }

        String strShort = strlong;
        for (int i = 0; i < strings.size(); i++) {
            if (strings.get(i).length() < strShort.length()) strShort = strings.get(i);
        }

        for (int i = 0; i < strings.size(); i++) {
            if (strings.get(i).equals(strlong)) {
                indexLong = i;
                break;
            }
        }
        for (int i = 0; i < strings.size(); i++) {
            if (strings.get(i).equals(strShort)) {
                indexShort = i;
                break;
            }
        }

        if (indexLong > indexShort) {
            for (int i = 0; i < strings.size(); i++) {
                if (strings.get(i).equals(strShort)) {
                    System.out.println(strings.get(i));
                }
            }
        } else {
            for (int i = 0; i < strings.size(); i++) {
                if (strings.get(i).equals(strlong)) {
                    System.out.println(strings.get(i));
                }
            }
        }
    }
}