package com.javarush.task.task19.task1916;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* 
Отслеживаем изменения
*/

public class Solution {
    public static List<LineItem> lines = new ArrayList<LineItem>();

    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String fileName1 = bufferedReader.readLine();
        String fileName2 = bufferedReader.readLine();
        bufferedReader.close();

        BufferedReader lineReader1 = new BufferedReader(new FileReader(fileName1));
        BufferedReader lineReader2 = new BufferedReader(new FileReader(fileName2));
        String line = "";

        ArrayList<String> arrayList1 = new ArrayList<>();
        while ((line = lineReader1.readLine()) != null) {
            arrayList1.add(line);
        }

        ArrayList<String> arrayList2 = new ArrayList<>();
        while ((line = lineReader2.readLine()) != null) {
            arrayList2.add(line);
        }

        lineReader1.close();
        lineReader2.close();

        if (arrayList1.size() > arrayList2.size()) {
            arrayList2.add("");
        } else {
            arrayList2.add("");
        }

        for (int i = 0; i < arrayList1.size(); i++) {
            if (arrayList1.get(i).equals(arrayList2.get(i))) {
                lines.add(new LineItem(Type.SAME, arrayList1.get(i)));
            } else if (arrayList1.get(i).contains(arrayList2.get(i))) {
                lines.add(new LineItem(Type.REMOVED, arrayList1.get(i)));
            } else if (arrayList2.get(i).contains(arrayList1.get(i))) {
                lines.add(new LineItem(Type.ADDED, arrayList2.get(i)));
            }
        }

        for (LineItem lineItem: lines) {
            System.out.println(lineItem.type.toString() + " " + lineItem.line);
        }

    }

    public static enum Type {
        ADDED,        //добавлена новая строка
        REMOVED,      //удалена строка
        SAME          //без изменений
    }

    public static class LineItem {
        public Type type;
        public String line;

        public LineItem(Type type, String line) {
            this.type = type;
            this.line = line;
        }
    }
}
