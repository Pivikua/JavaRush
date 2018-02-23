package com.javarush.task.task15.task1516;

/*
Значения по умолчанию
1. Создать 7 public полей класса. Убедитесь, что они инициализируются дефолтными значениями.
intVar типа int
doubleVar типа double
DoubleVar типа Double
booleanVar типа boolean
ObjectVar типа Object
ExceptionVar типа Exception
StringVar типа String
2. В методе main вывести их значения в заданном порядке.

Требования:
1. В классе Solution должно быть объявлено поле intVar типа int.
2. В классе Solution должно быть объявлено поле doubleVar типа double.
3. В классе Solution должно быть объявлено поле DoubleVar типа Double.
4. В классе Solution должно быть объявлено поле booleanVar типа boolean.
5. В классе Solution должно быть объявлено поле ObjectVar типа Object.
6. В классе Solution должно быть объявлено поле ExceptionVar типа Exception.
7. В классе Solution должно быть объявлено поле StringVar типа String.
8. Метод main должен выводить значения полей на экран(каждое с новой строки или через
    пробел) в заданном порядке. Инициализировать переменные не нужно.
*/

public class Solution {

    public int intVar = 0;
    public double doubleVar = 0.0d;
    public Double DoubleVar = null;
    public boolean booleanVar = false;
    public Object ObjectVar = null;
    public Exception ExceptionVar = null;
    public String StringVar = null;

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.getIntVar() + " "
                + solution.getdoubleVar() + " "
                + solution.getDoubleVar() + " "
                + solution.isBooleanVar() + " "
                + solution.getObjectVar() + " "
                + solution.getExceptionVar() + " "
                + solution.getStringVar());
    }

    public int getIntVar() {
        return intVar;
    }

    public double getdoubleVar() {
        return doubleVar;
    }

    public Double getDoubleVar() {
        return DoubleVar;
    }

    public boolean isBooleanVar() {
        return booleanVar;
    }

    public Object getObjectVar() {
        return ObjectVar;
    }

    public Exception getExceptionVar() {
        return ExceptionVar;
    }

    public String getStringVar() {
        return StringVar;
    }
}
