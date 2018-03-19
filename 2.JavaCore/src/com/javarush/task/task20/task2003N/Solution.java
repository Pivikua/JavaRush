package com.javarush.task.task20.task2003N;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

/*
Знакомство с properties
В методе fillInPropertiesMap считайте имя файла с консоли и заполни карту properties данными из файла.
Про .properties почитать тут - http://ru.wikipedia.org/wiki/.properties
Реализуй логику записи в файл и чтения из файла для карты properties.

Требования:
1. Метод fillInPropertiesMap должен считывать данные с консоли.
2. Метод fillInPropertiesMap должен создавать FileInputStream, передавая считанную строку в качестве параметра.
3. Метод fillInPropertiesMap должен вызывать метод load передавая только что созданный FileInputStream в качестве параметра.
4. Метод save должен сохранять карту properties в полученный в качестве параметра объект типа OutputStream.
5. Метод load должен восстанавливать состояние карты properties из полученного в качестве параметра объекта типа InputStream.
*/
public class Solution {
    public static Map<String, String> properties = new HashMap<>();
    BufferedReader fileName;

    public void fillInPropertiesMap() throws IOException {
        //implement this method - реализуйте этот метод
        System.out.println("Введите файл для чтения .properties");
        fileName = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream fileInputStream = new FileInputStream(fileName.readLine());
        try {
            load(fileInputStream);
        } catch (Exception e) {
            e.printStackTrace();
        }
        fileInputStream.close();
        //fileName.close();
    }

    public void save(OutputStream outputStream) throws Exception {
        //implement this method - реализуйте этот метод
        BufferedWriter lineWriter = new BufferedWriter(new OutputStreamWriter(outputStream));
        for (Map.Entry<String, String> pair : properties.entrySet())
        {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(pair.getKey());
            //stringBuilder.append(":");
            stringBuilder.append(pair.getValue());
            stringBuilder.append("\n");
            lineWriter.write(new String(stringBuilder));
        }
        lineWriter.flush();
    }

    public void load(InputStream inputStream) throws Exception {
        //implement this method - реализуйте этот метод
        BufferedReader lineReader = new BufferedReader(new InputStreamReader(inputStream));
        while (lineReader.ready()) {
            String line = lineReader.readLine();
            if (line.contains(":") || line.contains("=")) {
                properties.put(line.substring(0, line.indexOf(":")).trim(), line.substring(line.indexOf(":"), line.length()).trim());
            }
        }
        lineReader.close();
    }

    public static void main(String[] args) throws IOException {
        Solution solution = new Solution();
        solution.fillInPropertiesMap();
        System.out.println("Введите файл для записи .properties");
        solution.fileName = new BufferedReader(new InputStreamReader(System.in));
        FileOutputStream fileOutputStream = new FileOutputStream(solution.fileName.readLine());

        try {
            solution.save(fileOutputStream);
        } catch (Exception e) {
            e.printStackTrace();
        }
        fileOutputStream.close();
        solution.fileName.close();
    }
}
