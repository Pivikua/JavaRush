package com.javarush.task.task18.task1809;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader fileNameReader = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream fileInputStream = new FileInputStream(fileNameReader.readLine());
        byte content[] = new byte[fileInputStream.available()];
        fileInputStream.read(content);
        fileInputStream.close();

        FileOutputStream fileOutputStream = new FileOutputStream(fileNameReader.readLine());
        fileOutputStream.write(reverceMassive(content));
    }

    private static byte[] reverceMassive(byte massive[]) {
        byte tmp;
        for (int i = 0; i < massive.length / 2; i++) {
            tmp = massive[i];
            massive[i] = massive[massive.length - 1 - i];
            massive[massive.length - 1 - i] = tmp;
        }
        return massive;
    }

}
