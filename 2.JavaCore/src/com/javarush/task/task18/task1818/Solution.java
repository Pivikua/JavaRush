package com.javarush.task.task18.task1818;

/*
Два в одном
Считать с консоли 3 имени файла.
Записать в первый файл содержимого второго файла, а потом дописать в первый файл содержимое третьего файла.
Закрыть потоки.

Требования:
1. Программа должна три раза считать имена файлов с консоли.
2. Для первого файла создай поток для записи. Для двух других - потоки для чтения.
3. Содержимое второго файла нужно переписать в первый файл.
4. Содержимое третьего файла нужно дописать в первый файл (в который уже записан второй файл).
5. Созданные для файлов потоки должны быть закрыты.
*/

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Solution {
    public static void main(String[] args) throws IOException{
        FileOutputStream fistOutputStream = new FileOutputStream(args[0], true);
        FileInputStream secondInputStream = new FileInputStream(args[1]);
        FileInputStream threedInputStream = new FileInputStream(args[2]);

        byte seconFileBytesArray[] = new byte[secondInputStream.available()];
        secondInputStream.read(seconFileBytesArray);
        byte threedFileBytesArray[] = new byte[threedInputStream.available()];
        threedInputStream.read(threedFileBytesArray);

        secondInputStream.close();
        threedInputStream.close();

        fistOutputStream.write(seconFileBytesArray);
        fistOutputStream.flush();
        fistOutputStream.write(threedFileBytesArray);
        fistOutputStream.close();
    }
}
