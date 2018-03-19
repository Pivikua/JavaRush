package com.javarush.task.task18.task1826;

/*
Шифровка
Придумать механизм шифровки/дешифровки.
Программа запускается с одним из следующих наборов параметров:
    -e fileName fileOutputName
    -d fileName fileOutputName
где:
    fileName - имя файла, который необходимо зашифровать/расшифровать.
    fileOutputName - имя файла, куда необходимо записать результат шифрования/дешифрования.
        -e - ключ указывает, что необходимо зашифровать данные.
        -d - ключ указывает, что необходимо расшифровать данные.

Требования:
1. Считывать с консоли ничего не нужно.
2. Создай поток для чтения из файла, который приходит вторым параметром ([fileName]).
3. Создай поток для записи в файл, который приходит третьим параметром ([fileOutputName]).
4. В режиме "-e" программа должна зашифровать [fileName] и записать в [fileOutputName].
5. В режиме "-d" программа должна расшифровать [fileName] и записать в [fileOutputName].
6. Созданные для файлов потоки должны быть закрыты.
*/

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Solution {
    public static void main(String[] args) throws IOException {
        FileInputStream fileInputStream = new FileInputStream(args[1]);
        byte fileBytes[] = new byte[fileInputStream.available()];
        fileInputStream.read(fileBytes);
        fileInputStream.close();

        FileOutputStream fileOutputStream = new FileOutputStream(args[2]);

        if (args[0].equals("-e")) {
            fileOutputStream.write(encrypt(fileBytes));
        } else if (args[0].equals("-d")) {
            fileOutputStream.write(decrypt(fileBytes));
        }

        fileOutputStream.close();
    }

    private static byte[] encrypt(byte[] byteMassive) {
        for (int i = 0; i < byteMassive.length; i++) {
            if (byteMassive[i] > 123) {
                byteMassive[i] += (4 - 127);
            } else {
                byteMassive[i] += 4;
            }
        }
        return byteMassive;
    }

    private static byte[] decrypt(byte[] byteMassive) {
        for (int i = 0; i < byteMassive.length; i++) {
            if (byteMassive[i] < 4) {
                byteMassive[i] -= (127 - 4);
            } else {
                byteMassive[i] -= 4;
            }
        }
        return byteMassive;
    }
}