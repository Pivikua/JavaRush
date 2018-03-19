package com.javarush.task.task19.task1914N;

/*
Решаем пример
В методе main подмени объект System.out написанной тобой ридер-оберткой по аналогии с лекцией.
Твоя ридер-обертка должна выводить на консоль решенный пример.
Вызови готовый метод printSomething(), воспользуйтесь testString.
Верни переменной System.out первоначальный поток.
Возможные операции: + - *
Шаблон входных данных и вывода: a [знак] b = c
Отрицательных и дробных чисел, унарных операторов - нет.
Пример вывода:
3 + 6 = 9

Требования:
1. Класс Solution должен содержать класс TestString.
2. Класс Solution должен содержать публичное статическое поле testString типа TestString, которое сразу проинициализировано.
3. Класс TestString должен содержать публичный void метод printSomething().
4. Метод printSomething() класса TestString должен выводить на экран строку "3 + 6 = ".
5. Метод main(String[] args) класса Solution должен
    создавать поток PrintStream (используй PrintStream c параметром конструктора ByteArrayOutputStream).
6. Метод main(String[] args) класса Solution должен
    подменять и восстанавливать поток вывода в консоль объекта System.out.
7. Метод main(String[] args) класса Solution должен
    вызывать метод printSomething(),объекта testString.
8. Метод main(String[] args) класса Solution должен
    модифицировать строку выведенную методом printSomething() согласно заданию, и выводить её в консоль.
*/

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {
        PrintStream savedStream = System.out;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PrintStream newStream = new PrintStream(byteArrayOutputStream);
        System.setOut(newStream);
        testString.printSomething();
        System.setOut(savedStream);
        String string = byteArrayOutputStream.toString().replaceAll("\\s", "").replace("=", "");
        if (string.contains("+")) {
            String[] spleted = new String[string.length()];
            spleted = string.split("[+]");
            System.out.println(spleted[0] + " + " + spleted[1] + " = " + (int) (Integer.parseInt(spleted[0]) + Integer.parseInt(spleted[1])));
        } else if (string.contains("-")) {
            String[] spleted = new String[string.length()];
            spleted = string.split("[-]");
            System.out.println(spleted[0] + " - " + spleted[1] + " = " + (int) (Integer.parseInt(spleted[0]) - Integer.parseInt(spleted[1])));
        }
    }


    public static class TestString {
        public void printSomething() {
            System.out.println("9 - 6 = ");
        }
    }
}