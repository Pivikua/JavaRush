package com.javarush.task.task20.task2022;

import java.io.*;

/* 
Переопределение сериализации в потоке
Сериализация/десериализация Solution не работает.
Исправь ошибки не меняя сигнатуры методов и класса.
Метод main не участвует в тестировании.
Написать код проверки самостоятельно в методе main:
1) создать экземпляр класса Solution
2) записать в него данные - writeObject
3) сериализовать класс Solution - writeObject(ObjectOutputStream out)
4) десериализовать, получаем новый объект
5) записать в новый объект данные - writeObject
6) проверить, что в файле есть данные из п.2 и п.5

Требования:
1. Поле stream должно быть объявлено с модификатором transient.
2. В методе writeObject(ObjectOutputStream out) не должен быть вызван метод close у потока полученного в качестве параметра.
3. В методе readObject(ObjectInputStream in) не должен быть вызван метод close у потока полученного в качестве параметра.
4. В методе readObject(ObjectInputStream in) поле stream должно быть инициализировано новым объектом типа FileOutputStream с параметрами(fileName, true).
5. В конструкторе класса Solution поле stream должно быть инициализировано новым объектом типа FileOutputStream с параметром(fileName).
*/
public class Solution implements Serializable, AutoCloseable {
    transient private FileOutputStream stream;
    private String fileName;

    public Solution(String fileName) throws FileNotFoundException {
        this.stream = new FileOutputStream(fileName);
        this.fileName = fileName;
    }

    public void writeObject(String string) throws IOException {
        stream.write(string.getBytes());
        stream.write("\n".getBytes());
        stream.flush();
    }

    private void writeObject(ObjectOutputStream out) throws IOException {
        out.defaultWriteObject();
    }

    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        in.defaultReadObject();
        stream = new FileOutputStream(fileName, true);
    }

    @Override
    public void close() throws Exception {
        System.out.println("Closing everything!");
        stream.close();
    }

    public static void main(String[] args) {
        String fileName = "D:\\test\\0.txt";
        Solution solution = null;
        Solution solution1 = null;
        try {
            solution = new Solution(fileName);
            solution1 = new Solution(fileName);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        try (FileInputStream fileInputStream = new FileInputStream(fileName);
            FileOutputStream fileOutputStream = new FileOutputStream(fileName)) {

            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);

            solution.writeObject("Какая-то строка.");
            objectOutputStream.writeObject(solution);

            solution1 = (Solution) objectInputStream.readObject();
            solution1.writeObject("Новая какая-то строка");

        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
