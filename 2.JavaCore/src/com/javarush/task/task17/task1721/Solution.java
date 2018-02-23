package com.javarush.task.task17.task1721;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
Транзакционность
*/

public class Solution {
    public static List<String> allLines = new ArrayList<String>();
    public static List<String> forRemoveLines = new ArrayList<String>();

    public static void main(String[] args) {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        try {
            allLines = Files.readAllLines(Paths.get(reader.readLine()));
            forRemoveLines = Files.readAllLines(Paths.get(reader.readLine()));
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("allLines : " + allLines);
        System.out.println("forRemoveLines : " + forRemoveLines);

        Solution solution = new Solution();
        try {
            solution.joinData();
        } catch (CorruptedDataException e) {
            System.out.println("Cach Exception!");
        }
    }

    public synchronized void joinData () throws CorruptedDataException {

        int size = allLines.size();
        for (String sfR : forRemoveLines) {
            for (int index = 0; index < size; index++) {
                if (sfR.equals(allLines.get(index))) {
                    allLines.remove(index);
                    size = allLines.size();
                }
            }
        }

        System.out.println("After work!");
        System.out.println("allLines : " + allLines);
        System.out.println("forRemoveLines : " + forRemoveLines);

        if (allLines.size() != 0) {
            allLines.clear();
            throw new CorruptedDataException();
        }



    }
}
