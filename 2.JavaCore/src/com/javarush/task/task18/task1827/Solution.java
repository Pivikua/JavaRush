package com.javarush.task.task18.task1827;

/* 
Прайсы
CrUD для таблицы внутри файла.
Считать с консоли имя файла для операций CrUD.
Программа запускается со следующим набором параметров:
    -c productName price quantity
Значения параметров:
    где
    id - 8 символов.
    productName - название товара, 30 chars (60 bytes).
    price - цена, 8 символов.
    quantity - количество, 4 символа.
    -c - добавляет товар с заданными параметрами в конец файла, генерирует id самостоятельно, инкрементируя максимальный id, найденный в файле.
В файле данные хранятся в следующей последовательности (без разделяющих пробелов):
    id productName price quantity
Данные дополнены пробелами до их длины.
    Пример:
        19846   Шорты пляжные синие           159.00  12
        198478  Шорты пляжные черные с рисунко173.00  17
        19847983Куртка для сноубордистов, разм10173.991234

Требования:
1. Программа должна считать имя файла для операций CrUD с консоли.
2. При запуске программы без параметров список товаров должен остаться неизменным.
3. При запуске программы с параметрами "-c productName price quantity" в конец файла должна добавится новая строка с товаром.
4. Товар должен иметь следующий id, после максимального, найденного в файле.
5. Форматирование новой строки товара должно четко совпадать с указанным в задании.
6. Созданные для файлов потоки должны быть закрыты.
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        FileInputStream inputFileStream = new FileInputStream(fileName);
        FileOutputStream fileOutputStream = new FileOutputStream(fileName, true);
        byte[] lineBytes = new byte[50];
        Integer id = Integer.valueOf(0);
        Integer maxId = Integer.valueOf(0);

        String blanckStr;
        while(inputFileStream.available() > 0) {
            inputFileStream.read(lineBytes);
            blanckStr = (new String(lineBytes)).substring(0, 8);
            id = Integer.valueOf(Integer.parseInt(blanckStr.trim()));
            if(id.intValue() > maxId.intValue()) {
                maxId = id;
            }
        }

        maxId = Integer.valueOf(maxId.intValue() + 1);
        blanckStr = "                                                           ";
        String idStr = String.valueOf(maxId);
        idStr = idStr + blanckStr.substring(0, 8 - idStr.length());
        String productName = args[1] + blanckStr.substring(0, 30 - args[1].length());
        String price = args[2] + blanckStr.substring(0, 8 - args[2].length());
        String quantity = args[3] + blanckStr.substring(0, 4 - args[3].length());
        String newLine = "\n" + idStr + productName + price + quantity;
        System.out.println(newLine);
        lineBytes = newLine.getBytes("Cp1251");
        fileOutputStream.write(lineBytes);
        reader.close();
        inputFileStream.close();
        fileOutputStream.close();
    }
}
