package com.javarush.task.task19.task1917;

/* 
Свой FileWriter
*/

import java.io.FileWriter;
import java.io.IOException;

public class FileConsoleWriter {

    private FileWriter fileWriter;

    /*private char[] cbuf;
    int off, len, c;
    String str;

    public FileConsoleWriter(char[] cbuf, int off, int len) {
        this.cbuf = cbuf;
        this.off = off;
        this.len = len;
    }

    public FileConsoleWriter(int c) {
        this.c = c;
    }

    public FileConsoleWriter(String str) {
        this.str = str;
    }

    public FileConsoleWriter(String str, int off, int len) {
        this.off = off;
        this.len = len;
        this.str = str;
    }

    public FileConsoleWriter(char[] cbuf) {
        this.cbuf = cbuf;
    }*/

    public void write(char[] cbuf, int off, int len) throws IOException {
        fileWriter.write(cbuf, off, len);

        for (int i = off; i < off + len; i++) {
            System.out.print(cbuf[i]);
        }
    }

    public void write(int c) throws IOException {
        fileWriter.write(c);
        System.out.println(c);
    }

    public void write(String str) throws IOException {
        fileWriter.write(str);
        System.out.println(str);
    }

    public void write(String str, int off, int len) throws Exception{
        fileWriter.write(str, off, len);
        System.out.println(str.substring(off, off + len));
    }

    public void write(char[] cbuf) throws IOException {
        fileWriter.write(cbuf);
        String cbufStr = new String(cbuf);
        System.out.println(cbufStr);
    }

    public void close() throws IOException {
        fileWriter.close();
    }

    public static void main(String[] args) {
        FileConsoleWriter fileConsoleWriter = new FileConsoleWriter();

        //System.out.println(fileConsoleWriter.getClass().toString().equals());
    }

}
