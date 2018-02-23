package com.javarush.task.task14.task1419;

import java.io.*;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.Vector;

/*
Нашествие исключений
*/

public class Solution {
    public static List<Exception> exceptions = new ArrayList<Exception>();

    public static void main(String[] args) {
        initExceptions();

        for (Exception exception : exceptions) {
            System.out.println(exception);
        }
    }

    private static void initExceptions() {   //it's first exception
        // Exception 1
        try {
            float i = 1 / 0;

        } catch (Exception e) {
            exceptions.add(e);
        }

        // Exception 2
        try {
            ArrayList<Integer> list = new ArrayList<>();
            list.get(list.size() + 1);
        } catch (Exception e) {
            exceptions.add(e);
        }

        // Exception 3
        try {
            String fileName = "";
            FileReader fileReader = new FileReader(fileName);
        } catch (FileNotFoundException e) {
            exceptions.add(e);
        }

        // Exception 4
        try {
            String fileName = null;
            FileReader fileReader = new FileReader(fileName);
        } catch (Exception e) {
            exceptions.add(e);
        }

        // Exception 5
        try {
            Object x[] = new String[3];
            x[0] = new Integer(0);
        } catch (Exception e) {
            exceptions.add(e);
        }

        // Exception 6
        try {
            Object x = new Integer(0);
            System.out.println((String)x);
        } catch (Exception e) {
            exceptions.add(e);
        }

        // Exception 7
        try {
            String string = "123456789";
            string.substring(1, 10);
        } catch (Exception e) {
            exceptions.add(e);
        }

        // Exception 8
        try {
            String str[] = new String[-1];
        } catch (Exception e) {
            exceptions.add(e);
        }

        // Exception 9
        try {
            Vector<String> v = new Vector<>();
            for (Enumeration<String> e = v.elements(); ;)
                e.nextElement();
        } catch (Exception e) {
            exceptions.add(e);
        }


    }
}