package com.javarush.task.task18.task1825;

import java.io.*;
import java.nio.channels.FileChannel;
import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

/*
Собираем файл
Собираем файл из кусочков.
Считывать с консоли имена файлов.
Каждый файл имеет имя: [someName].partN.
Например, Lion.avi.part1, Lion.avi.part2, ..., Lion.avi.part37.
Имена файлов подаются в произвольном порядке. Ввод заканчивается словом "end".
В папке, где находятся все прочтенные файлы, создать файл без суффикса [.partN].
Например, Lion.avi.
В него переписать все байты из файлов-частей используя буфер.
Файлы переписывать в строгой последовательности, сначала первую часть, потом вторую, ..., в конце - последнюю.
Закрыть потоки.

Требования:
1. Программа должна считывать имена файлов с консоли, пока не будет введено слово "end".
2. Создай поток для записи в файл без суффикса [.partN] в папке, где находятся все считанные файлы.
3. В новый файл перепиши все байты из файлов-частей *.partN.
4. Чтение и запись должны происходить с использованием буфера.
5. Созданные для файлов потоки должны быть закрыты.
*/

public class Solution {
    public static void main(String[] args) throws IOException {

        TreeSet<MyFileInputStream> partsOfFile = new TreeSet<MyFileInputStream>(new MyComparator());
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String fileName;
        while (true) {
            fileName = (bufferedReader.readLine());
            if (fileName.equals("end")) {
                break;
            }
            partsOfFile.add(new MyFileInputStream(fileName, new FileInputStream(fileName)));
        }

        bufferedReader.close();

        FileOutputStream fileOutputStream = new FileOutputStream("D:\\test\\lion\\Lion.avi", true);

        for (MyFileInputStream stream : partsOfFile) {
            byte bytes[] = new byte[stream.getFileInputStream().available()];
            stream.getFileInputStream().read(bytes);
            fileOutputStream.write(bytes);
        }

        fileOutputStream.close();
    }

    public static class MyComparator implements Comparator<MyFileInputStream> {
        @Override
        public int compare(MyFileInputStream o1, MyFileInputStream o2) {
            int o1Part = Integer.parseInt(o1.fileName.substring(o1.fileName.indexOf(".part") + 5));
            int o2Part = Integer.parseInt(o2.fileName.substring(o2.fileName.indexOf(".part") + 5));
            if (o1Part > o2Part) {
                return 1;
            } else if (o1Part < o2Part) {
                return -1;
            } else {
                return 0;
            }
        }
    }

    public static class MyFileInputStream extends FileInputStream {

        String fileName;
        FileInputStream fileInputStream;

        public MyFileInputStream(String name, FileInputStream fileInputStream) throws FileNotFoundException {
            super(name);
            this.fileInputStream = fileInputStream;
            this.fileName = name;
        }

        public String getFileName() {
            return fileName;
        }

        public FileInputStream getFileInputStream() {
            return fileInputStream;
        }

        @Override
        public int read() throws IOException {
            return fileInputStream.read();
        }

        @Override
        public int read(byte[] b) throws IOException {
            return fileInputStream.read(b);
        }

        @Override
        public int read(byte[] b, int off, int len) throws IOException {
            return fileInputStream.read(b, off, len);
        }

        @Override
        public long skip(long n) throws IOException {
            return fileInputStream.skip(n);
        }

        @Override
        public int available() throws IOException {
            return fileInputStream.available();
        }

        @Override
        public void close() throws IOException {
            fileInputStream.close();
        }

        @Override
        public FileChannel getChannel() {
            return fileInputStream.getChannel();
        }
    }
}