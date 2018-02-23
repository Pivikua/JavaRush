package com.javarush.task.task18.task1822;

/*
Поиск данных внутри файла
Считать с консоли имя файла.
Найти в файле информацию, которая относится к заданному id, и вывести ее на экран в виде, в котором она записана в файле.
Программа запускается с одним параметром: id (int).
Закрыть потоки.
В файле данные разделены пробелом и хранятся в следующей последовательности:
    id productName price quantity
    где id - int.
        productName - название товара, может содержать пробелы, String.
        price - цена, double.
        quantity - количество, int.
Информация по каждому товару хранится в отдельной строке.

Требования:
1. Программа должна считать имя файла с консоли.
2. Создай для файла поток для чтения.
3. Программа должна найти в файле и вывести информацию о id, который передается первым параметром.
4. Поток для чтения из файла должен быть закрыт.
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream firstrFileInputStream = new FileInputStream(bufferedReader.readLine());
        bufferedReader.close();
        int string;
        StringBuilder stringBuilder = new StringBuilder();
        while (firstrFileInputStream.available() > 0) {
            string = firstrFileInputStream.read();
            stringBuilder.append((char) string);
            if (test(stringBuilder.toString())) {
                if (stringBuilder.toString().startsWith(args[0])) {
                    System.out.println(stringBuilder.toString());
                }
                stringBuilder = new StringBuilder();
            }
        }
        firstrFileInputStream.close();
    }

    public static boolean test(String testString) {
        Pattern p = Pattern.compile("\\d+\\s(\\D+\\s*)\\s\\d+\\W\\d+\\s\\d+\\s");
        Matcher m = p.matcher(testString);
        return m.matches();
    }
}