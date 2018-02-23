package com.javarush.task.task18.task1828;

/* 
Прайсы 2
*/

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = bufferedReader.readLine();
        FileInputStream inputFileStream = new FileInputStream(fileName);
        BufferedReader lineFileReder = new BufferedReader(new InputStreamReader(inputFileStream, StandardCharsets.UTF_8));

        String line;
        String outputLine = "";
        Solution sol = new Solution();
        ArrayList<String> strlists = new ArrayList<String>();

        while ((line = lineFileReder.readLine()) != null) {
            strlists.add(line);
        }

        if (args.length > 0) {
            for (int i = 0; i < strlists.size(); i++) {
                if (strlists.get(i).substring(0, 8).equals(sol.addedSpaces(args[1], 8))) {
                    if (args[0].equals("-u")) {
                        outputLine = outputLine + sol.addedSpaces(args[1], 8);
                        outputLine = outputLine + sol.addedSpaces(args[2], 30);
                        outputLine = outputLine + sol.addedSpaces(args[3], 8);
                        outputLine = outputLine + sol.addedSpaces(args[4], 4);
                        strlists.set(i, outputLine);
                    } else if (args[0].equals("-d")){
                        strlists.remove(i);
                    }
                }
            }
        }

        bufferedReader.close();
        inputFileStream.close();

        FileOutputStream fileOutputStream = new FileOutputStream(fileName);
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(fileOutputStream, StandardCharsets.UTF_8));

        for (String str : strlists) {
            bufferedWriter.write(str + "\r\n");
        }

        bufferedWriter.flush();
        bufferedWriter.close();
        fileOutputStream.close();
    }

    private String addedSpaces (String argsString, int strLength) {
        String outputLine = argsString;
        if (argsString.length() < strLength){
            for (int i = 0; i < strLength - argsString.length(); i++) {
                outputLine = outputLine + " ";
            }
        }
        return outputLine;
    }
}
