package com.javarush.task.task18.task1814;

import java.io.*;
import java.nio.channels.FileChannel;

/*
UnsupportedFileName
*/

public class TxtInputStream extends FileInputStream {

    FileInputStream original;

    public TxtInputStream(String fileName) throws FileNotFoundException {
        super(fileName);
        original = new FileInputStream(fileName);

        if (!fileName.endsWith(".txt")) {
            new UnsupportedFileNameException("Данный файл имеет расширение отличное от .txt");
            try {
                close();
            } catch (IOException e) {
                System.out.println("Поток закрыт.");
            }
        }

    }

    @Override
    public int read() throws IOException {
        return original.read();
    }

    @Override
    public int read(byte[] b) throws IOException {
        return original.read(b);
    }

    @Override
    public int read(byte[] b, int off, int len) throws IOException {
        return original.read(b, off, len);
    }

    @Override
    public long skip(long n) throws IOException {
        return original.skip(n);
    }

    @Override
    public int available() throws IOException {
        return original.available();
    }

    @Override
    public void close() throws IOException {
        original.close();
    }

    @Override
    public FileChannel getChannel() {
        return original.getChannel();
    }

    public static void main(String[] args) {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        try {
            TxtInputStream txtInputStream = new TxtInputStream(bufferedReader.readLine());
            byte byteArray[] = new byte[txtInputStream.available()];
            txtInputStream.read(byteArray);

            for (byte aByte : byteArray) {
                System.out.print((char)aByte);
            }

        } catch (IOException e) {
            System.out.println("Поток закрыт.");
        }
    }
}