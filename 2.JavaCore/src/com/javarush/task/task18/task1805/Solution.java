package com.javarush.task.task18.task1805;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream fileInputStream = new FileInputStream(reader.readLine());

        ArrayList<Integer> byteList = new ArrayList<>();

        while (fileInputStream.available() > 0) {
            byteList.add(fileInputStream.read());
        }

        Comparator<Integer> comparator = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1.compareTo(o2);
            }
        };

        byteList.sort(comparator);

        for (Integer integer : byteList) {
            System.out.println(integer);
        }

        fileInputStream.close();
        reader.close();
    }
}
