package com.javarush.task.task19.task1922;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* 
Ищем нужные строки
*/

public class Solution {
    public static List<String> words = new ArrayList<String>();

    static {
        words.add("файл");
        words.add("вид");
        words.add("В");
    }

    public static void main(String[] args) throws Exception {
        BufferedReader fileNameReader = new BufferedReader(new InputStreamReader(System.in));
        String filename = fileNameReader.readLine();
        fileNameReader.close();

        BufferedReader fileLineReder = new BufferedReader(new FileReader(filename));

        while (fileLineReder.ready()) {
            String line = fileLineReder.readLine();
            String[] readedWords = line.split(" ");
            int counter = 0;
            for (int i = 0; i < readedWords.length; i++) {
                if(words.contains(readedWords[i]))
                    counter++;
            }
            /*for (String strWords: words) {
                if (line.contains(strWords)){
                    counter++;
                }
            }*/

            if (counter == 2) {
                System.out.println(line);
            }
        }

        fileLineReder.close();
    }
}
