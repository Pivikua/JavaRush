package com.javarush.task.task18.task1823;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/*
Нити и байты
Читайте с консоли имена файлов, пока не будет введено слово "exit".
Передайте имя файла в нить ReadThread.
Нить ReadThread должна найти байт, который встречается в файле максимальное число раз, и добавить его в словарь resultMap,
где параметр String - это имя файла, параметр Integer - это искомый байт.
Закрыть потоки.

Требования:
1. Программа должна считывать имена файлов с консоли, пока не будет введено слово "exit".
2. Для каждого файла создай нить ReadThread и запусти ее.
3. После запуска каждая нить ReadThread должна создать свой поток для чтения из файла.
4. Затем, нити должны найти максимально встречающийся байт в своем файле и добавить его в словарь resultMap.
5. Поток для чтения из файла в каждой нити должен быть закрыт.
*/

public class Solution {
    public static Map<String, Integer> resultMap = new HashMap<String, Integer>();

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String fileName = null;
        while(true) {
            fileName = bufferedReader.readLine();
            if(fileName.equals("exit")) break;
            ReadThread readThread = new ReadThread(fileName);
        }

        for (Map.Entry<String, Integer> pair : resultMap.entrySet())
        {
            String key = pair.getKey();                      //ключ
            Integer value = pair.getValue();                  //значение
            System.out.println(key + ":" + value);
        }
    }

    public static class ReadThread extends Thread {

        String fileName;
        public ReadThread(String fileName) {
            //implement constructor body
            this.fileName = fileName;
            System.out.println("Thread " + this.fileName + " is started!");
            start();
        }

        // implement file reading here - реализуйте чтение из файла тут

        @Override
        public void run() {

            int byteLine[] = new int[0];
            try {
                byteLine = new int[256];
                FileInputStream fileInputStream = new FileInputStream(fileName);

                while (fileInputStream.available() > 0) {
                    byteLine[fileInputStream.read()]++;
                }

                fileInputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

            int maxCount = 0;
            int maxByte = 0;
            for (int i = 0; i < 256; i++) {
                if (byteLine[i] > maxCount) {
                    maxCount = byteLine[i];
                    maxByte = i;
                }
            }
            resultMap.put(fileName, maxByte);
        }
    }
}
