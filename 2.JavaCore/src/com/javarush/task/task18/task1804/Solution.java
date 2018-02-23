package com.javarush.task.task18.task1804;


import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream fileInputStream = new FileInputStream(reader.readLine());

        Map<Integer,Integer> map = new HashMap<>();
        Integer readedByte;
        Integer valueByKey;
        Integer minValue = 999;

        while (fileInputStream.available() > 0) {
            readedByte = fileInputStream.read();
            if (!map.containsKey(readedByte)) {
                map.put(readedByte, 1);
            } else if (map.containsKey(readedByte)) {
                valueByKey = map.get(readedByte);
                valueByKey++;
                map.put(readedByte, valueByKey);
            }
        }

        for (Map.Entry entry : map.entrySet()) {
            if(minValue > Integer.parseInt(entry.getValue().toString())) {
                minValue = (Integer) entry.getValue();
            }
        }

        for (Map.Entry entry : map.entrySet()) {
            if(minValue == Integer.parseInt(entry.getValue().toString())) {
                System.out.println("Key: " + (char) Integer.parseInt(entry.getKey().toString()) + " Value: "
                        + entry.getValue());
            }
        }

        fileInputStream.close();
        reader.close();
    }
}