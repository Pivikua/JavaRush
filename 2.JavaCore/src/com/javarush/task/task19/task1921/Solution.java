package com.javarush.task.task19.task1921;

import com.sun.org.apache.xpath.internal.SourceTree;

import java.io.BufferedReader;
import java.io.FileReader;
import java.text.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* 
Хуан Хуанович
*/

public class Solution {
    public static final List<Person> PEOPLE = new ArrayList<Person>();
    public static void main(String[] args) throws Exception {
        BufferedReader fileLine = new BufferedReader(new FileReader(args[0]));
        while (fileLine.ready()) {
            String[] split = fileLine.readLine().split(" ");
            String name = "";
            String strDate = "";
            Date bddate = new Date();
            Pattern namePattern = Pattern.compile("\\W+");
            Pattern datePattern = Pattern.compile("\\w+");
            for (int i = 0; i < split.length; i++) {
                Matcher nameMatcher = namePattern.matcher(split[i]);
                Matcher dateMatcher = datePattern.matcher(split[i]);
                if (nameMatcher.matches()) {
                    name = name + split[i] + " ";
                } else if (dateMatcher.matches()) {
                    strDate = strDate + split[i] + " ";
                }
            }

            SimpleDateFormat dateFormat = new SimpleDateFormat("dd MM yyyy");
            bddate = dateFormat.parse(strDate.trim());
            PEOPLE.add(new Person(name.trim(), bddate));
        }

        fileLine.close();
    }
}
