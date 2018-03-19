package com.javarush.task.task19.task1910N;

/*
Пунктуация
Считать с консоли 2 имени файла.
Первый Файл содержит текст.
Считать содержимое первого файла, удалить все знаки пунктуации, включая символы новой строки.
Результат вывести во второй файл.
Закрыть потоки.

Требования:
1. Программа должна считывать имена файлов с консоли (используй BufferedReader).
2. BufferedReader для считывания данных с консоли должен быть закрыт.
3. Программа должна считывать содержимое первого файла (используй BufferedReader c конструктором FileReader).
4. Поток чтения из файла (BufferedReader) должен быть закрыт.
5. Программа должна записывать во второй файл содержимое первого файла,
    где удалены все знаки пунктуации, включая символы новой строки
    (Для записи в файл используй BufferedWriter с конструктором FileWriter).
6. Поток записи в файл (BufferedWriter) должен быть закрыт.
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader consoleBufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader fileLineReader = new BufferedReader(new FileReader(consoleBufferedReader.readLine()));
        BufferedWriter fileLineWriter = new BufferedWriter(new FileWriter(consoleBufferedReader.readLine()));

        String line;

        while ((line = fileLineReader.readLine()) != null) {
            char[] charsLine = new char[line.length()];
            char[] charsOutLine = new char[line.length()];
            charsLine = line.toCharArray();
            int outIndex = 0;
            for (int indx = 0; indx < charsLine.length; indx++) {
                if (((int)charsLine[indx]) > 65) {
                    charsOutLine[outIndex] = charsLine[indx];
                    outIndex++;
                }
            }
            fileLineWriter.write(new String(charsOutLine).trim());
        }

        fileLineWriter.close();
        fileLineReader.close();
        consoleBufferedReader.close();
    }
}
