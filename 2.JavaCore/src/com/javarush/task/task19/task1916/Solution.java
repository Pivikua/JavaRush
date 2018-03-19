package com.javarush.task.task19.task1916;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* 
Отслеживаем изменения
Считать с консоли 2 имени файла - file1, file2.
Файлы содержат строки, file2 является обновленной версией file1, часть строк совпадают.
Нужно создать объединенную версию строк, записать их в список lines.
Операции ADDED и REMOVED не могут идти подряд, они всегда разделены SAME.
В оригинальном и редактируемом файлах пустых строк нет.
Пример:
оригинальный    редактированный    общий
file1:          file2:             результат:(lines)

строка1         строка1            SAME строка1
строка2                            REMOVED строка2
строка3         строка3            SAME строка3
строка4                            REMOVED строка4
строка5         строка5            SAME строка5
                строка0            ADDED строка0
строка1         строка1            SAME строка1
строка2                            REMOVED строка2
строка3         строка3            SAME строка3
                строка5            ADDED строка5
строка4         строка4            SAME строка4
строка5                            REMOVED строка5

Требования:
1. Класс Solution должен содержать класс LineItem.
2. Класс Solution должен содержать enum Type.
3. Класс Solution должен содержать публичное статическое поле lines типа List, которое сразу проинициализировано.
4. В методе main(String[] args) программа должна считывать имена файлов с консоли (используй BufferedReader).
5. В методе main(String[] args) BufferedReader для считывания данных с консоли должен быть закрыт.
6. Программа должна считывать содержимое первого и второго файла (используй FileReader).
7. Потоки чтения из файлов (FileReader) должны быть закрыты.
8. Список lines должен содержать объединенную версию строк из файлов, где для каждой строки указана одна из
    операций ADDED, REMOVED, SAME.
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

        //----------------------------------------------------------------------------------//

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
