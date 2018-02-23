package com.javarush.task.task19.task1906;

/* 
Четные байты
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileReader fileReader = new FileReader(reader.readLine());
        FileWriter fileWriter = new FileWriter(reader.readLine());
        reader.close();
        int itr = 0;
        while(fileReader.ready()){
            itr++;
            int data = fileReader.read();
            if(itr % 2 == 0){
                fileWriter.write(data);
            }
        }
        fileReader.close();
        fileWriter.close();
    }
}
