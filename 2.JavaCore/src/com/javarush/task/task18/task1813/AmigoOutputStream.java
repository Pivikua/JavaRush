package com.javarush.task.task18.task1813;

import java.io.*;
import java.nio.channels.FileChannel;

public class AmigoOutputStream extends FileOutputStream {

    private static String fileName;
    private FileOutputStream original;

    public AmigoOutputStream(FileOutputStream original) throws FileNotFoundException {
        super(fileName);
        this.original = original;
    }

    static void setFileName(String fileName) {
        AmigoOutputStream.fileName = fileName;
    }

    @Override
    public void write(int b) throws IOException {
        original.write(b);
    }

    @Override
    public void write(byte[] b) throws IOException {
        original.write(b);
    }

    @Override
    public void write(byte[] b, int off, int len) throws IOException {
        original.write(b, off, len);
    }

    @Override
    public void close() throws IOException {
        flush();
        write("JavaRush © All rights reserved.".getBytes());
        original.close();
    }

    @Override
    public FileChannel getChannel() {
        return original.getChannel();
    }

    @Override
    public void flush() throws IOException {
        original.flush();
    }



    public static void main(String[] args) {
        AmigoOutputStream.setFileName("D:\\test\\1.txt");
        try {
            AmigoOutputStream amigoOutputStream = new AmigoOutputStream(new FileOutputStream(fileName));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }
}
