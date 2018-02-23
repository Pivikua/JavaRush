package com.javarush.task.task18.task1816;

/*
Английские буквы
В метод main первым параметром приходит имя файла.
Посчитать количество букв английского алфавита, которое есть в этом файле.
Вывести на экран число (количество букв).
Закрыть потоки.

Требования:
1. Считывать с консоли ничего не нужно.
2. Создай поток чтения из файла, который приходит первым параметром в main.
3. В файле необходимо посчитать буквы английского алфавита и вывести это число в консоль.
4. Нужно учитывать заглавные и строчные буквы.
5. Поток чтения из файла должен быть закрыт.
*/

import java.io.FileInputStream;
import java.io.IOException;

public class Solution {
    public static void main(String[] args) throws IOException {
        FileInputStream fileInputStream = new FileInputStream(args[0]);
        int counter = 0;
        int readedByteLikeInt = 0;
        while (fileInputStream.available() > 0) {
            readedByteLikeInt = fileInputStream.read();
            if (readedByteLikeInt > 64 & readedByteLikeInt < 91) {
                counter++;
            } else if (readedByteLikeInt > 96 & readedByteLikeInt < 123 ) {
                counter++;
            }
        }
        System.out.println(counter);
        fileInputStream.close();
    }
}
