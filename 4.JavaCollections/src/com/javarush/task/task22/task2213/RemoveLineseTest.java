package com.javarush.task.task22.task2213;

import java.util.ArrayList;

public class RemoveLineseTest {
    public static void main(String[] args) {
        Field field = new Field(10, 10);

        for (int i = 0; i < field.getWidth(); i++) {
            field.getMatrix()[5][i] = 1;
        }

        printMatrix(field);
        System.out.println();

        removeFL(field.getMatrix());

        printMatrix(field);


    }

    private static void printMatrix(Field field) {
        for (int[] i : field.getMatrix()) {
            for (int ints : i) {
                System.out.print(ints + "  ");
            }
            System.out.println();
        }
    }

    public static void removeFL(int[][] matrix) {

        //Например так:
        //Создаем список для хранения линий
        ArrayList<int[]> arrayList = new ArrayList<>();

        int[] tmpLine;
        int[] nullLine = new int[] {0, 0, 0, 0, 0, 0, 0, 0, 0, 0};

        for (int i = 0; i < matrix.length; i++) {
            matrix[6][i] = 2;
        }

        matrix[7] = new int[] {0, 0, 0, 0, 1, 1, 0, 0, 0, 0};

        //Копируем все непустые линии в список.
        for (int[] ints : matrix) {
            int counter = 0;
            for (int i :ints) {
                if (i > 0) {
                    counter++;
                }
            }

            if (counter < matrix.length) {
                arrayList.add(ints);
            }
        }



        //Добавляем недостающие строки в начало списка.
        for (int i = 0; i < 10 - arrayList.size(); i++) {
            arrayList.add(0, new int[matrix.length]);
        }

        //Преобразуем список обратно в матрицу
        for (int i = 0; i < arrayList.size(); i++) {
            //matrix[i] = null;
            matrix[i] = arrayList.get(i);
        }
    }
}

