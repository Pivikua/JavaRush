package com.javarush.task.task19.task1923N;

/*
Слова с цифрами
В метод main первым параметром приходит имя файла1, вторым - файла2.
Файл1 содержит строки со словами, разделенные пробелом.
Записать через пробел в Файл2 все слова, которые содержат цифры, например, а1 или abc3d.
Закрыть потоки.

Требования:
1. Программа НЕ должна считывать данные с консоли.
2. Программа должна считывать содержимое первого файла (используй FileReader c конструктором String).
3. Поток чтения из файла (FileReader) должен быть закрыт.
4. Программа должна записывать во второй файл все слова из первого файла которые содержат цифры (используй FileWriter).
5. Поток записи в файл (FileWriter) должен быть закрыт.
*/

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader fileLineReader = new BufferedReader(new FileReader(args[0]));
        BufferedWriter fileLineWriter = new BufferedWriter(new FileWriter(args[1]));
        String lineFromFile;
        String[] splitedLine;
        String string = "";
        StringBuilder stringBuilder;
        while ((lineFromFile = fileLineReader.readLine()) != null) {
            splitedLine = new String[lineFromFile.split(" ").length];
            splitedLine = lineFromFile.split(" ");
            for (int index = 0; index < splitedLine.length; index++) {
                stringBuilder = new StringBuilder();
                String pattern = "(.*)(\\d+)(.*)";
                Pattern r = Pattern.compile(pattern);
                Matcher m = r.matcher(splitedLine[index]);
                if (m.matches()) { // RegEx
                    stringBuilder.append(splitedLine[index] + " ");
                }
                string = new String(stringBuilder);
                fileLineWriter.write(string);
            }
        }
        fileLineWriter.close();
        fileLineReader.close();
    }
}
