package com.javarush.task.task19.task1924;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

/* 
Замена чисел
*/

public class Solution {
    public static Map<Integer, String> map = new HashMap<Integer, String>();
    static {
        map.put(0, "ноль");
        map.put(1, "один");
        map.put(2, "два");
        map.put(3, "три");
        map.put(4, "четыре");
        map.put(5, "пять");
        map.put(6, "шесть");
        map.put(7, "семь");
        map.put(8, "восемь");
        map.put(9, "девять");
        map.put(10, "десять");
        map.put(11, "одиннадцать");
        map.put(12, "двенадцать");
    }

    public static void main(String[] args) throws Exception {
        BufferedReader fileNameReader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = fileNameReader.readLine();
        fileNameReader.close();

        BufferedReader fileLineReader = new BufferedReader(new FileReader(fileName));
        while (fileLineReader.ready()) {
            String filesLine = fileLineReader.readLine();
            String[] splitLine = filesLine.split(" ");
            for (int i = 0; i < splitLine.length; i++) {
                if (splitLine[i].matches("^\\d+$")) {
                    if (map.containsKey(Integer.parseInt(splitLine[i]))) {
                        splitLine[i] = map.get(Integer.parseInt(splitLine[i]));
                    }
                }
            }
            String outputString = "";
            for (String str : splitLine) {
                outputString = outputString + str + " ";
            }
            outputString.trim();
            System.out.println(outputString);
        }
        fileLineReader.close();
    }
}
