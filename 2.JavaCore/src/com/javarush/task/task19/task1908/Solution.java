package com.javarush.task.task19.task1908;

/* 
Выделяем числа
*/

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    public static void main(String[] args) throws IOException {

        BufferedReader fileNamesReader = new BufferedReader(new InputStreamReader(System.in));
        String firstFileName = fileNamesReader.readLine();
        String secondFileName = fileNamesReader.readLine();
        fileNamesReader.close();

        BufferedReader fileReader = new BufferedReader(new FileReader(firstFileName));
        BufferedWriter fileWriter = new BufferedWriter(new FileWriter(secondFileName));

        String str = "";
        while (fileReader.ready()) {
            //char symbol = (char) fileReader.read();
            //str += String.valueOf(symbol).toLowerCase();
            str += fileReader.readLine() + " ";
        }
        fileReader.close();

        //str = str.replaceAll("\\p{Punct}", " ");
        //str = str.replaceAll("\n", " ");

        System.out.println(str);

        String[] inMassive = str.split(" ");

        Pattern p = Pattern.compile("^\\d*$");
        String stringToOut = "";

        for (int i = 0; i < inMassive.length; i++) {
            Matcher m = p.matcher(inMassive[i]);
            if (m.matches()) {
                stringToOut += inMassive[i] + " ";
            }
        }
        fileWriter.write(stringToOut);
        fileWriter.close();
    }
}
