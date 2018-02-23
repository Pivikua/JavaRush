package com.javarush.task.task18.task1807;

/*
Подсчет запятых
*/

import java.io.FileInputStream;

public class Solution {
    public static void main(String[] args) throws Exception {
        FileInputStream fileInputStream;
        int count;
        for (int ansiiCode = 0; ansiiCode < 127; ansiiCode++) {
            fileInputStream = new FileInputStream("D:\\test\\222.txt");
            count = 0;
            while (fileInputStream.available() > 0) {
                if (fileInputStream.read() == ansiiCode) {
                    count++;
                }
            }
            System.out.println((char) ansiiCode + " : " + count);
            fileInputStream.close();
        }
    }
}