package com.javarush.task.task19.task1907N;

/*
Считаем слово
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileReader fileReader = new FileReader(reader.readLine());
        reader.close();
        StringBuffer stringBuffer = new StringBuffer();
        int counter = 0;
        String world = "";

        while (!world.contains("world")) {
            while (fileReader.ready()) {
                world = stringBuffer.append((char) fileReader.read()).toString().toLowerCase();
                if (world.contains("world")) {
                    counter++;
                    stringBuffer = new StringBuffer();
                    world = "";
                }
            }
            break;
        }
        fileReader.close();
        System.out.println(counter);
    }
}