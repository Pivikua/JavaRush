package com.javarush.task.task19.task1902N;

/*
Адаптер
Используй класс AdapterFileOutputStream, чтобы адаптировать FileOutputStream к новому интерфейсу AmigoStringWriter.

Требования:
1. AmigoStringWriter должен быть интерфейсом.
2. Класс AdapterFileOutputStream должен реализовывать интерфейс AmigoStringWriter.
3. Класс AdapterFileOutputStream должен содержать приватное поле fileOutputStream типа FileOutputStream.
4. Класс AdapterFileOutputStream должен содержать конструктор с параметром FileOutputStream.
5. Метод flush() класса AdapterFileOutputStream должен делегировать полномочие такому же методу fileOutputStream.
6. Метод writeString(String s) класса AdapterFileOutputStream должен делегировать полномочие такому же методу fileOutputStream.
7. Метод close() класса AdapterFileOutputStream должен делегировать полномочие такому же методу fileOutputStream.
*/

import com.javarush.task.task19.task1902.AmigoStringWriter;

import java.io.FileOutputStream;
import java.io.IOException;

public class AdapterFileOutputStream implements AmigoStringWriter{

    public static void main(String[] args) {

    }

    FileOutputStream outputStream;

    public AdapterFileOutputStream(FileOutputStream outputStream) {
        this.outputStream = outputStream;
    }

    @Override
    public void flush() throws IOException {
        outputStream.flush();
    }

    @Override
    public void writeString(String s) throws IOException {
        outputStream.write(s.getBytes());
    }

    @Override
    public void close() throws IOException {
        outputStream.close();
    }
}