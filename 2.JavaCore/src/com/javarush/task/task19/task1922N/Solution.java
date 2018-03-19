package com.javarush.task.task19.task1922N;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/*
Ищем нужные строки
Считать с консоли имя файла.
Вывести в консоль все строки из файла, которые содержат всего 2 слова из списка words.
Закрыть потоки.
Пример:
words содержит слова А, Б, В
Строки:
    В Б А Д //3 слова из words, не подходит
    А Б А Д //3 слова из words, не подходит
    Д А Д //1 слово из words, не подходит
    Д А Б Д //2 слова - подходит, выводим
    Д А А Д //2 слова - подходит, выводим

Требования:
1. Класс Solution должен содержать публичное статическое поле words типа List, которое должно быть сразу проинициализировано.
2. Класс Solution должен содержать статический блок, в котором добавляются три или больше слов в список words.
3. Программа должна считывать имя файла с консоли (используй BufferedReader).
4. BufferedReader для считывания данных с консоли должен быть закрыт.
5. Программа должна считывать содержимое файла (используй FileReader).
6. Поток чтения из файла (FileReader) должен быть закрыт.
7. Программа должна выводить в консоль все строки из файла, которые содержат всего 2 слова из списка words.
*/

public class Solution {
    public static List<String> words = new ArrayList<String>();

    static {
        words.add("файл");
        words.add("вид");
        words.add("В");
    }

    public static void main(String[] args) throws IOException {
        BufferedReader fileLinessReader = new BufferedReader(new FileReader(new BufferedReader(new InputStreamReader(System.in)).readLine()));
        String lineFromFile;
        String[] splitedLine;
        while ((lineFromFile = fileLinessReader.readLine()) != null) {
            int counter = 0;
            splitedLine = new String[lineFromFile.split(" ").length];
            splitedLine = lineFromFile.split(" ");
            for (int i = 0; i < splitedLine.length; i++) {
                for (int j = 0; j < words.size(); j++) {
                    if (splitedLine[i].equals(words.get(j))) {
                        counter++;
                    }
                }
            }
            if (counter == 2) {
                System.out.println(lineFromFile);
            }
        }

        fileLinessReader.close();
    }
}