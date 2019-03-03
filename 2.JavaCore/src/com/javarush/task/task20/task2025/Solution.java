package com.javarush.task.task20.task2025;

import java.util.ArrayList;
import java.util.Date;

/*
Алгоритмы-числа
Число S состоит из M цифр, например, S=370 и M (количество цифр) = 3
Реализовать логику метода getNumbers, который должен среди натуральных чисел меньше N (long)
находить все числа, удовлетворяющие следующему критерию:
число S равно сумме его цифр, возведенных в M степень
getNumbers должен возвращать все такие числа в порядке возрастания.
    Пример искомого числа:
        370 = 3*3*3 + 7*7*7 + 0*0*0
        8208 = 8*8*8*8 + 2*2*2*2 + 0*0*0*0 + 8*8*8*8
На выполнение дается 10 секунд и 50 МБ памяти.

Требования:
1. В классе Solution должен присутствовать метод getNumbers c одним параметром типа long.
2. Метод getNumbers должен быть публичным.
3. Метод getNumbers должен быть статическим.
4. Метод getNumbers должен возвращать массив чисел удовлетворяющих условию задачи.
*/
public class Solution {
    public static long[] getNumbers(long N) {
        ArrayList<Long> longList = new ArrayList<>();
        longList.addAll(ArmstrongNumbersMultiSetLongOpt.generate(String.valueOf(N).length()));
        int counter = 0;
        for (long l :longList) {
            if (N > l) counter++;
        }

        long[] result = new long[counter];
        for (int i = 0; i < counter; i++) {
            result[i] = longList.get(i);
        }
        return result;
    }

    public static void main(String[] args) {
        Long t0 = System.currentTimeMillis();
        //long n = 2000;
        long m = Long.MAX_VALUE;
        //System.out.println(m);
        long[] lst = getNumbers(m);

        for (int i = 0; i < lst.length; i++) {
            System.out.println(lst[i]);
        }
        Long t1 = System.currentTimeMillis();
        System.out.println("time: " + (t1 - t0) / 1000d + " sec");
        System.out.println("memory: " + (Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()) / (1024 * 1024) + " mb");
    }
}