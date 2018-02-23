package com.javarush.task.task18.task18MyStream;

import java.io.*;

public class MyStream {
    public static void main(String[] args) throws IOException {
        //эмулирование ввода нескольких значений с консоли

        //кладем данные в строку
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Lena").append("\n");
        stringBuilder.append("Olya").append("\n");
        stringBuilder.append("Anya").append("\n");
        String data = stringBuilder.toString();
        //System.out.println(data);

        //оборачиваем строку в класс ByteArrayInputStream
        InputStream inputStream = new ByteArrayInputStream(data.getBytes());

        //подменяем in
        System.setIn(inputStream);

        //вызываем обычный метод, который не подозревает о наших манипуляциях
        readAndPrintLin();
    }

    public static void readAndPrintLin() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            String line = reader.readLine();
            if (line == null) break;
            System.out.print(line);
        }

        reader.close();
    }
}
