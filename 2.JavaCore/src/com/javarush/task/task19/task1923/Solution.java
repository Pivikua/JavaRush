package com.javarush.task.task19.task1923;

/* 
Слова с цифрами
*/

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader fileLine = new BufferedReader(new FileReader(args[0]));
        BufferedWriter writedLine = new BufferedWriter(new FileWriter(args[1]));
        String outputString = "";
        while (fileLine.ready()) {
            String[] split = fileLine.readLine().split(" ");
            Pattern digiPattern = Pattern.compile("^\\D*$");
            for (int i = 0; i < split.length; i++) {
                Matcher digiMatcher = digiPattern.matcher(split[i]);
                if (!digiMatcher.matches()) {
                    outputString = outputString + split[i] + " ";
                }
            }
        }
        fileLine.close();
        writedLine.write(outputString);
        writedLine.close();
    }
}