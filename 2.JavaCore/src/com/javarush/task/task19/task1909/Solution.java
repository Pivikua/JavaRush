package com.javarush.task.task19.task1909;

/* 
Замена знаков
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException{
        BufferedReader fileNamesReader = new BufferedReader(new InputStreamReader(System.in));
        String firstFileName = fileNamesReader.readLine();
        String secondFileName = fileNamesReader.readLine();
        fileNamesReader.close();

        BufferedReader fileReader = new BufferedReader(new FileReader(firstFileName));
        BufferedWriter fileWriter = new BufferedWriter(new FileWriter(secondFileName));

        String str = "";
        while (fileReader.ready()) {
            str += fileReader.readLine();
            str = str.replaceAll("\\.", "!");
            fileWriter.write(str);
        }
        fileReader.close();
        fileWriter.close();
    }
}
