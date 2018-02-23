package com.javarush.task.task15.task1514;

import java.util.HashMap;
import java.util.Map;

/*
Статики-1
В статическом блоке инициализировать labels 5 различными парами ключ-значение.

Требования:
1. В классе Solution должен быть только один метод(main).
2. В классе Solution должно быть объявлено статическое поле labels типа Map.
3. Поле labels должно быть заполнен 5 различными парами ключ-значение в статическом блоке.
4. Метод main должен выводить содержимое labels на экран.
*/

public class Solution {
    public static Map<Double, String> labels = new HashMap<Double, String>();

    public static void main(String[] args) {
        System.out.println(labels);
    }

    static {
        labels.put(1258d, "Masha");
        labels.put(1259d, "Sasha");
        labels.put(1260d, "Pasha");
        labels.put(1261d, "Kasha");
        labels.put(1262d, "Tasha");
    }
}