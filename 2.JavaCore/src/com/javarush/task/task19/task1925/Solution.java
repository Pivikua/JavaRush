package com.javarush.task.task19.task1925;

/* 
Длинные слова
*/

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader fileReader = new BufferedReader(new FileReader(args[0]));
        ArrayList<String> arrayList = new ArrayList<>();
        while (fileReader.ready()) {
            String stringLine = fileReader.readLine();
            String[] splitLine = stringLine.split(" ");
            for (String str : splitLine) {
                if (str.length() > 6) {
                    arrayList.add(str);
                }
            }
        }
        fileReader.close();
        String outputString = "";
        for (String str : arrayList) {
            outputString = outputString + str + ",";
        }
        BufferedWriter fileWriter = new BufferedWriter(new FileWriter(args[1]));
        fileWriter.write(outputString.substring(0, outputString.length() - 1));
        fileWriter.close();
    }
}
