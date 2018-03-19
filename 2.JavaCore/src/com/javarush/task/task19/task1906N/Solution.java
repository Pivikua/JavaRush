package com.javarush.task.task19.task1906N;

/*
Четные символы
Считать с консоли 2 имени файла.
Вывести во второй файл все символы с четным индексом.
Пример первого файла:
    text in file
Вывод во втором файле:
    eti ie
Закрыть потоки ввода-вывод

Требования:
1. Программа должна считывать имена файлов с консоли (используй BufferedReader).
2. BufferedReader для считывания данных с консоли должен быть закрыт.
3. Программа должна считывать содержимое первого файла (используй FileReader c конструктором String).
4. Поток чтения из файла (FileReader) должен быть закрыт.
5. Программа должна записывать во второй файл все байты из первого файла с четным индексом (используй FileWriter).
6. Поток записи в файл (FileWriter) должен быть закрыт.
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException{
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        FileReader fileReader = new FileReader(bufferedReader.readLine());
        FileWriter fileWriter = new FileWriter(bufferedReader.readLine());
        bufferedReader.close();



        int byteFromFile = 0;
        int counter = 0;
        while (fileReader.ready()) {
            byteFromFile = fileReader.read();
            if (counter%2 > 0) {
                fileWriter.write(byteFromFile);
            }
            counter++;
        }
        fileWriter.close();
        fileReader.close();
    }
}
