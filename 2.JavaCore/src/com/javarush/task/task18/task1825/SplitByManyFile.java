package com.javarush.task.task18.task1825;

import java.io.*;

public class SplitByManyFile {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream fileInputStream = new FileInputStream(bufferedReader.readLine());
        FileOutputStream fileOutputStream;
        int fileSize = fileInputStream.available();
        int blockSizes = 5000;
        System.out.println(fileSize);
        int i = 0;
        byte blockSize[];
        while (fileInputStream.available() > 0) {
            if (fileSize > blockSizes) {
                blockSize = new byte[blockSizes];
            } else {
                blockSize = new byte[fileSize];
            }
            String fileName = "D:\\test\\lion\\" + "Lion.avi.part" + i;
                fileOutputStream = new FileOutputStream(fileName);
                fileInputStream.read(blockSize);
                fileOutputStream.write(blockSize);
                fileSize -= blockSizes;
                i++;
        }
        fileInputStream.close();
    }
}
