package com.javarush.task.task18.task1819;

/*
Объединение файлов
Считать с консоли 2 имени файла.
В начало первого файла записать содержимое второго файла так, чтобы получилось объединение файлов.
Закрыть потоки.

Требования:
1. Программа должна два раза считать имена файлов с консоли.
2. Для первого файла создай поток для чтения и считай его содержимое.
3. Затем, для первого файла создай поток для записи. Для второго - для чтения.
4. Содержимое первого и второго файла нужно объединить в первом файле.
5. Сначала должно идти содержимое второго файла, затем содержимое первого.
6. Созданные для файлов потоки должны быть закрыты.
*/

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Solution {
    public static void main(String[] args) throws IOException {
        FileOutputStream fistOutputStream = new FileOutputStream(args[0], true);
        FileInputStream firstInputStream = new FileInputStream(args[0]);
        FileInputStream secondInputStream = new FileInputStream(args[1]);

        byte firstFileBytesArray[] = new byte[firstInputStream.available()];
        firstInputStream.read(firstFileBytesArray);
        byte seconFileBytesArray[] = new byte[secondInputStream.available()];
        secondInputStream.read(seconFileBytesArray);

        secondInputStream.close();
        firstInputStream.close();

        fistOutputStream.write(seconFileBytesArray);
        fistOutputStream.flush();
        fistOutputStream.write(firstFileBytesArray);
        fistOutputStream.close();
    }
}
