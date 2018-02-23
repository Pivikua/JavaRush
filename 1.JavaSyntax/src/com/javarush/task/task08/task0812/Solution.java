package com.javarush.task.task08.task0812;

import java.io.*;
import java.util.ArrayList;

/* 
Cамая длинная последовательность
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        //напишите тут ваш код
        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < 10; i++) {
            Integer arrMemb = Integer.parseInt(bufferedReader.readLine());
            //System.out.println(arrMemb);
            arrayList.add(arrMemb);
        }

        int maxChain = 1;
        int currentChain = 1;

        for (int i = 0; i < arrayList.size() - 1; i++) {
            if (arrayList.get(i) == arrayList.get(i + 1)) {
                currentChain++;
                if (maxChain <= currentChain) {
                    maxChain = currentChain;
                }
            } else {
                currentChain = 1;
            }
        }

        System.out.println(maxChain);
    }
}