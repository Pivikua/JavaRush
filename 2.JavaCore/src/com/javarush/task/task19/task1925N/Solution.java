package com.javarush.task.task19.task1925N;
/*
Длинные слова
В метод main первым параметром приходит имя файла1, вторым - файла2.
Файл1 содержит слова, разделенные пробелом.
Записать через запятую в Файл2 слова, длина которых строго больше 6.
В конце файла2 запятой не должно быть.
Закрыть потоки.
Пример выходных данных в файл2:
длинное,короткое,аббревиатура

Требования:
1. Программа НЕ должна считывать данные с консоли.
2. Программа должна считывать содержимое первого файла (используй FileReader c конструктором String).
3. Поток чтения из файла (FileReader) должен быть закрыт.
4. Программа должна записывать через запятую во второй файл все слова из первого
    файла длина которых строго больше 6(используй FileWriter).
5. Поток записи в файл (FileWriter) должен быть закрыт.
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader fileLineReader = new BufferedReader(new FileReader(new BufferedReader(new InputStreamReader(System.in)).readLine()));
        BufferedWriter fileLineWriter = new BufferedWriter(new FileWriter(new BufferedReader(new InputStreamReader(System.in)).readLine()));
        String lineFromFile;
        String[] splitedLine;
        StringBuilder stringBuilder;
        while ((lineFromFile = fileLineReader.readLine()) != null) {
            splitedLine = new String[lineFromFile.split("\\s").length];
            splitedLine = lineFromFile.split("\\s");
            stringBuilder = new StringBuilder();
            for (int i = 0; i < splitedLine.length; i++) {
                if (splitedLine[i].length() > 6) {
                    if (i < splitedLine.length - 1) {
                        stringBuilder.append(splitedLine[i] + ",");
                    } else {
                        stringBuilder.append(splitedLine[i]);
                    }
                }
            }
            fileLineWriter.write(new String(stringBuilder));
        }
        fileLineWriter.close();
        fileLineReader.close();
    }
}