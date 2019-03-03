package com.javarush.task.test.task3513;

public class RotateArray {

    static int[][] baseArray = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};

    public static void main(String[] args) {
        //oneRightRotate();
        printArray(baseArray);
    }

/*    private static void oneRightRotate() {
        int tmp;
        int baseArrayLength = baseArray.length;
        for (int i = 0; i < baseArrayLength / 2; i++) {
            for (int j = i; j < baseArrayLength - 1 - i; j++) {
                tmp = baseArray[i][j];
                baseArray[i][j] = baseArray[baseArrayLength - j - 1][i];
                baseArray[baseArrayLength - j - 1][i] = baseArray[baseArrayLength - i - 1][baseArrayLength - j - 1];
                baseArray[baseArrayLength - i - 1][baseArrayLength - j - 1] = baseArray[j][baseArrayLength - i - 1];
                baseArray[j][baseArrayLength - i - 1] = tmp;
            }
        }
    }*/


    private static void printArray(int[][] array) {
        for (int[] ints : array) {
            for (int i : ints) {
                System.out.print(i + " ");
            }
            System.out.println();
        }

    }
}
