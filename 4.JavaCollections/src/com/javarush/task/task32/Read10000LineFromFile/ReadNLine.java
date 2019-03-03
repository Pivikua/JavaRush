package com.javarush.task.task32.Read10000LineFromFile;

import java.io.RandomAccessFile;

public class ReadNLine {
    public static void main(String[] args) throws Exception {
        RandomAccessFile randomAccessFile = new RandomAccessFile("D:/test/Klients.csv", "rw");
        randomAccessFile.readLine();
    }
}
