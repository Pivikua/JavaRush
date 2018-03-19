package com.javarush.task.task20.task2012N;

import java.io.*;

/*
OutputToConsole
Класс OutputToConsole должен сериализовываться с помощью интерфейса Externalizable.
Найди и исправь ошибку.

Требования:
1. Класс Solution.OutputToConsole должен поддерживать интерфейс Externalizable.
2. Класс OutputToConsole должен быть создан в классе Solution.
3. Класс OutputToConsole должен быть публичным.
4. Класс OutputToConsole должен быть статическим.
*/
public class Solution {
    public static String greeting = "Hello world";

    /**
     * OutputToConsole is the inner base class for improving your attentiveness.
     * An OutputToConsole object encapsulates the information needed
     * for the displaying [greeting] variable to the console.
     *
     * @author JavaRush
     */
    public static class OutputToConsole implements Externalizable {
        private int counter;

        /**
         * @param out A stream for an externalization
         * @throws java.io.IOException
         */
        @Override
        public void writeExternal(ObjectOutput out) throws IOException {
            out.writeInt(counter);
        }

        /**
         * @param in A stream for a de-externalization
         * @throws java.io.IOException
         * @throws ClassNotFoundException
         */
        @Override
        public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
            counter = in.readInt();
        }

        /**
         * Class constructor specifying fake private field [i].
         */
        public OutputToConsole(int counter) {
            this.counter = counter;
        }

        /**
         * Prints greeting message to console counter times.
         */
        public void printMessage() {
            for (int i = 0; i < counter; i++) {
                System.out.println(greeting);
            }
        }
    }

    public static void main(String[] args) throws FileNotFoundException, IOException {

        OutputToConsole outputToConsole = new OutputToConsole(5);

        String filName = "D:\\test\\0.txt";

        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(filName));
        outputToConsole.writeExternal(objectOutputStream);
        objectOutputStream.close();

        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(filName));
        Solution.OutputToConsole
    }
}