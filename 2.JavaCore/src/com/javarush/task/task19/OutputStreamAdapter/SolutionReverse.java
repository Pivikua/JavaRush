package com.javarush.task.task19.OutputStreamAdapter;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class SolutionReverse {
    public static void main(String[] args) throws Exception {
        // Запоминаем настоящий ПринтСтрим в специальню переменную
        PrintStream consoleStream = System.out;

        // Создаем динамический массив
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

        // Создаем адаптер к классу ПринтСтрим
        PrintStream stream = new PrintStream(outputStream);

        // Устанавливаем его как текущий Систем.аут
        System.setOut(stream);

        // Вызываем фнкцию котоая ничего не знает о наших манипляциях
        printSomthing();

        // Преобразовываем записанные в наш БайтЭррэй данные в строку
        String result = outputStream.toString();

        // Возвращаем все как было
        System.setOut(consoleStream);

        // Разворачиваем строку
        StringBuilder stringBuilder = new StringBuilder(result);
        stringBuilder.reverse();
        String reversedString = stringBuilder.toString();

        // Выводим ее в консоль
        System.out.println(reversedString);
    }

    public static void printSomthing() {
        System.out.println("Hi");
        System.out.println("My name is Amigo");
        System.out.println("Bye-bye!");
    }
}
