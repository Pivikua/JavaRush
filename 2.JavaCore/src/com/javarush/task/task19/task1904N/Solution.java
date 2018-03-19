package com.javarush.task.task19.task1904N;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/*
И еще один адаптер
Адаптировать Scanner к PersonScanner.
Классом-адаптером является PersonScannerAdapter.
В классе адаптере создать приватное финальное поле Scanner fileScanner.
Поле инициализировать в конструкторе с одним аргументом типа Scanner.
Данные в файле хранятся в следующем виде:
    Иванов Иван Иванович 31 12 1950
    Петров Петр Петрович 31 12 1957
В файле хранится большое количество людей, данные одного человека находятся в одной строке.
Метод read() должен читать данные только одного человека.

Требования:
1. PersonScanner должен быть интерфейсом.
2. Класс PersonScannerAdapter должен реализовывать интерфейс PersonScanner.
3. Класс PersonScannerAdapter должен содержать приватное поле fileScanner типа Scanner.
4. Класс PersonScannerAdapter должен содержать конструктор с параметром Scanner.
5. Метод close() класса PersonScannerAdapter должен делегировать полномочие такому же методу fileScanner.
6. Метод read() класса PersonScannerAdapter должен читать строку с файла, парсить её,
    и возвращать данные только одного человека, в виде объекта класса Person.
*/

public class Solution {

    public static void main(String[] args) {

    }

    public static class PersonScannerAdapter implements PersonScanner {
        Scanner fileScanner;

        public PersonScannerAdapter(Scanner fileScanner) {
            this.fileScanner = fileScanner;
        }

        @Override
        public Person read() throws IOException {
            Person person= null;
            String firstName, secondName, middleName, dateLine;
            String[] line;
            Date bdDate;

            if (fileScanner.hasNext()) {
                line = fileScanner.nextLine().split(" ");
                secondName = line[0];
                firstName = line[1];
                middleName = line[2];
                SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
                try {
                    bdDate = format.parse(line[3] + "/" + line[4] + "/" + line[5]);
                } catch (ParseException e) {
                    bdDate = null;
                }
                person = new Person(firstName, secondName, middleName, bdDate);
            }

            return person;
        }

        @Override
        public void close() throws IOException {
            fileScanner.close();
        }
    }
}
