package com.javarush.task.task19.task1918;

/* 
Знакомство с тегами
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    public static void main(String[] args) throws IOException {
        String openTeg = "<" + args[0];
        String closeTeg = "</" + args[0] + ">";
        BufferedReader fileNameReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader fileReader = new BufferedReader(new FileReader(fileNameReader.readLine()));
        String line;
        StringBuilder stringBuilder = new StringBuilder();
        while ((line = fileReader.readLine()) != null) {
            stringBuilder.append(line);
        }
        String globalLine = new String(stringBuilder);
        System.out.println(globalLine);

        ArrayList<String> strings = new ArrayList<>();

        //--------------------------------------------------------------//
        /*int tegBlockStart = 0;
        int tegBlockEnd = 0;
        int countBlock = 0;

        ArrayList<Integer> startsPointArray = new ArrayList<>();
        ArrayList<Integer> endPointArray = new ArrayList<>();
        ArrayList<Integer> levels = new ArrayList<>();

        int[][] levelPlusPoint = new int[globalLine.length()][3];

        for (int i = 0; i < globalLine.length() - openTeg.length(); i++) {
            if(globalLine.substring(i).startsWith(openTeg)){
                startsPointArray.add(i);
                //tegBlockStart++;
                countBlock++;
                levels.add(countBlock);
            }

            if(globalLine.substring(i).startsWith(closeTeg)) {
                endPointArray.add(i);
                //tegBlockEnd++;
                levels.add(countBlock);
                countBlock--;
            }
        }

        System.out.println(levels);
        System.out.println(startsPointArray);
        System.out.println(endPointArray);

        for (int index = 0; index < levels.size(); index++) {
            levelPlusPoint[index][]
            if (levels.get(index) = )
        }*/
        //----------------------------------------------------------------//
        /*String outString;
        int indexStart = 0;
        int indexFinish = 0;
        int levelOpen = 0;
        boolean flag = false;
        StringBuilder stringBuilderNext = new StringBuilder();
        for (int i = 0; i < globalLine.length() - openTeg.length(); i++) {
            if(globalLine.substring(i).startsWith(openTeg)){
                flag = true;
                levelOpen++;
            }

            if(levelOpen > 0) {
                if (flag) {
                    indexStart = i;

                }
            }

            if(globalLine.substring(i).startsWith(closeTeg)) {
                levelOpen--;
                if (levelOpen == 0) {
                    indexFinish = i - 1 + closeTeg.length();
                    break;

                }
            }
        }
        System.out.println(globalLine.substring(indexStart, indexFinish));
    }*/
        //---------------------------------------------------------------------//

        String stringPattern = "<" + args[0] + ".*?>(.*?)<\\/" + args[0] + ".*?>";
        //String stringPattern = "<" + args[0] + ".*?>(.*?)<" + args[0] + ".*?>";
        Pattern pattern = Pattern.compile(stringPattern);
        Matcher matcher = pattern.matcher(globalLine);
        while(matcher.find()) {
            strings.add(matcher.group());
        }

        for (String string :strings) {
            System.out.println(string);
        }

    }
}
