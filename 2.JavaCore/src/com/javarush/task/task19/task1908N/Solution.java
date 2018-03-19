package com.javarush.task.task19.task1908N;

/*
Выделяем числа
Считать с консоли 2 имени файла.
Вывести во второй файл все числа, которые есть в первом файле.
Числа выводить через пробел.
Закрыть потоки.
    Пример тела файла:
        12 text var2 14 8v 1
    Результат:
        12 14 1

Требования:
1. Программа должна считывать имена файлов с консоли (используй BufferedReader).
2. BufferedReader для считывания данных с консоли должен быть закрыт.
3. Программа должна считывать содержимое первого файла (используй BufferedReader c конструктором FileReader).
4. Поток чтения из файла (BufferedReader) должен быть закрыт.
5. Программа должна записывать во второй файл все числа, через пробел, из первого файла
(используй BufferedWriter с конструктором FileWriter).
6. Поток записи в файл (BufferedWriter) должен быть закрыт.
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader fileLineReader = new BufferedReader(new FileReader(bufferedReader.readLine()));
        BufferedWriter fileLineWriter = new BufferedWriter(new FileWriter(bufferedReader.readLine()));
        String line;
        while ((line = fileLineReader.readLine()) != null) {
            String[] splitedLine = new String[line.split(" ").length];
            splitedLine = line.split(" ");
            for (String string :splitedLine) {
                try {
                    //System.out.print(Integer.parseInt(string) + " ");
                    fileLineWriter.write(Integer.parseInt(string) + " ");
                } catch (NumberFormatException e) {

                }
            }
        }
        fileLineWriter.close();
        fileLineReader.close();
        bufferedReader.close();
    }
}