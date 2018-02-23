package com.javarush.task.task19.task1920;

/* 
Самый богатый
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class Solution {
    public static void main(String[] args) throws Exception {
        String fileName = args[0];
        BufferedReader fileReader = new BufferedReader(new FileReader(fileName));
        TreeMap<String, Double> map = new TreeMap<String, Double>();
        String fileLine = "";
        String secondName = "";
        Double salary = 0.0;
        Double summa = 0.0;

        while (fileReader.ready()) {
            fileLine = fileReader.readLine();
            String[] splitLine = fileLine.split(" ");
            secondName = splitLine[0];
            salary = Double.parseDouble(splitLine[1]);
            if (map.containsKey(secondName)) {
                summa = map.get(secondName) + salary;
                map.put(secondName, summa);
            } else map.put(secondName, salary);
        }

        fileReader.close();

        for (Map.Entry<String, Double> pairs : map.entrySet()) {
            if (pairs.getValue() > summa) {
                summa = pairs.getValue();
            }
        }

        for (Map.Entry<String, Double> pairs : map.entrySet()) {
            if (pairs.getValue().equals(summa)) {
                System.out.println(pairs.getKey());
            }
        }
    }
}
