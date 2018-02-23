package com.javarush.task.task19.task1926;

/* 
Перевертыши
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader fileNameReader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = fileNameReader.readLine();
        fileNameReader.close();
        BufferedReader fileLineReader = new BufferedReader(new FileReader(fileName));
        while (fileLineReader.ready()) {
            String filesLine = fileLineReader.readLine();
            StringBuffer stringBuffer = new StringBuffer(filesLine);
            String str = new String(stringBuffer.reverse());
            filesLine = str;
            System.out.println(filesLine);
        }
        fileLineReader.close();
    }
}
