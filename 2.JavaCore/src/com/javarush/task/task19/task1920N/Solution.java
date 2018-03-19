package com.javarush.task.task19.task1920N;

/*
Самый богатый
В метод main первым параметром приходит имя файла.
В этом файле каждая строка имеет следующий вид:
имя значение
где [имя] - String, [значение] - double. [имя] и [значение] разделены пробелом.
Для каждого имени посчитать сумму всех его значений.
Вывести в консоль имена в алфавитном порядке, у которых максимальная сумма.
Имена разделять пробелом либо выводить с новой строки.
Закрыть потоки.
Пример входного файла:
    Петров 0.501
    Иванов 1.35
    Петров 0.85
Пример вывода:
    Петров

Требования:
1. Программа НЕ должна считывать данные с консоли.
2. Программа должна считывать содержимое файла (используй FileReader).
3. Поток чтения из файла (FileReader) должен быть закрыт.
4. Программа должна выводить в консоль имена, у которых максимальная сумма.
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader fileReader = new BufferedReader(new FileReader(args[0]));
        TreeMap<String, Double> humanList = new TreeMap<>();
        TreeMap<String, Double> maxNHuman = new TreeMap<>();
        String line;
        String[] splitedLine = new String[2];

        while ((line = fileReader.readLine()) != null) {
            splitedLine = line.split(" ");
            if (humanList.containsKey(splitedLine[0])) {
                humanList.put(splitedLine[0], humanList.get(splitedLine[0]) + Double.parseDouble(splitedLine[1]));
            } else if (!humanList.containsKey(splitedLine[0])) {
                humanList.put(splitedLine[0], Double.parseDouble(splitedLine[1]));
            }
        }

        fileReader.close();

        Double maxid = 0.0;

        for (Map.Entry<String, Double> pair : humanList.entrySet()) {
            if (maxid <= pair.getValue()) {
                maxid = pair.getValue();
            }
        }

        for (Map.Entry<String, Double> pair : humanList.entrySet()) {
            if (maxid.equals(pair.getValue())) {
                maxNHuman.put(pair.getKey(), pair.getValue());
            }
        }

        for (Map.Entry<String, Double> pair : maxNHuman.entrySet()) {
            String name = pair.getKey();
            Double id = pair.getValue();
            System.out.println(name);
        }
    }
}
