package com.javarush.task.task13.task1319;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.InputStreamReader;

/*
Писатель в файл с консоли
1. Прочесть с консоли имя файла.
2. Считывать строки с консоли, пока пользователь не введет строку "exit".
3. Вывести абсолютно все введенные строки в файл, каждую строчку с новой строки.

Требования:
1. Программа должна считывать c консоли имя файла.
2. Создай и используй объект типа BufferedWriter.
3. Программа не должна ничего читать из файловой системы.
4. Программа должна читывать строки с консоли, пока пользователь не введет строку "exit".
5. Программа должна записать абсолютно все введенные строки (включая "exit") в файл, каждую строчку с новой строки.
6. Метод main должен закрывать объект типа BufferedWriter после использования.
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        // напишите тут ваш код
        BufferedReader fileName = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader lineReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter toFileLinesWriter = new BufferedWriter(new FileWriter(fileName.readLine()));
        String line = "";
        while ((line = lineReader.readLine()) != null) {
            toFileLinesWriter.write(line + "\r\n");
            toFileLinesWriter.flush();
            if (line.equals("exit")) {
                return;
            }
        }
        toFileLinesWriter.close();
        fileName.close();
        lineReader.close();
    }
}
