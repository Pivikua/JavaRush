package com.javarush.task.task18.task1808;

/*
Разделение файла
Считать с консоли три имени файла: файл1, файл2, файл3.
Разделить файл1 по следующему критерию:
Первую половину байт записать в файл2, вторую половину байт записать в файл3.
Если в файл1 количество байт нечетное, то файл2 должен содержать большую часть.
Закрыть потоки.

Требования:
1. Программа должна три раза считать имена файлов с консоли.
2. Для чтения из файла используй поток FileInputStream, для записи в файлы - FileOutputStream
3. Первую половину байт из первого файла нужно записать во второй файл.
4. Вторую половину байт из первого файла нужно записать в третий файл.
5. Потоки FileInputStream и FileOutputStream должны быть закрыты.
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader fileNameReader = new BufferedReader(new InputStreamReader(System.in));

        FileInputStream sourceFile  = new FileInputStream(fileNameReader.readLine());
        byte fileConsist[] = new byte[sourceFile.available()];
        sourceFile.read(fileConsist);
        sourceFile.close();

        int halfFilePoint = fileConsist.length / 2 + (int)(fileConsist.length % 2 + 0.5);

        FileOutputStream destFileOne = new FileOutputStream(fileNameReader.readLine());
        destFileOne.write(fileConsist, 0, halfFilePoint);
        destFileOne.close();

        FileOutputStream destFileTwo = new FileOutputStream(fileNameReader.readLine());
        destFileTwo.write(fileConsist, halfFilePoint, fileConsist.length - halfFilePoint);
        destFileTwo.close();
    }
}
