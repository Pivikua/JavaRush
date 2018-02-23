package com.javarush.task.task18.task1810;

/*
DownloadException
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException{
        BufferedReader fileNameReader = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            FileInputStream fileInputStream = new FileInputStream(fileNameReader.readLine());
            if (fileInputStream.available() < 1000) {
                new DownloadException("Файл меньше 1000 байт");
                break;
            }
        }
    }

    public static class DownloadException extends Exception {
        public DownloadException(String message) {
            super(message);
            System.out.println(message);
        }
    }
}
