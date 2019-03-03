package com.javarush.task.task21.task2104;

import java.util.HashSet;
import java.util.Set;

/*
Equals and HashCode
В классе Solution исправить пару методов equals/hashCode в соответствии с правилами
    реализации этих методов(детали уточни у своего любимого поисковика).
Обе строки first и last должны принимать участие в сравнении с помощью метода equals и вычислении hashcode.
Метод main не участвует в тестировании.

Требования:
1. Хешкоды одинаковых объектов должны быть равны.
2. Метод equals должен проверять равен ли переданный объект текущему(сравнение через ==).
3. Метод equals должен проверять является ли переданный объект объектом класса Solution.
4. Метод equals должен возвращать true в случае, если поля first и last равны у переданного объекта
    и текущего(не забудь что они могут быть равны null).
5. Должно быть обеспечено корректное поведение HashSet с типом элементов Solution.
*/
public class Solution {
    private final String first, last;

    public Solution(String first, String last) {
        this.first = first;
        this.last = last;
    }

    @Override
    public int hashCode() {
        return 31 * (first == null ? 0 : first.hashCode()) + (last == null ? 0 : last.hashCode());
    }

    @Override
    public boolean equals(Object obj) {
        // Проверяем на идентичность объектов.
        if (obj == this)
            return true;
        // Проверяем не null ли объект
        if (obj == null)
            return false;
        // Спавниваем хешкоды переданого объекта и объекта класса
        if (obj.hashCode() != this.hashCode())
            return false;
        // Проверка принадлежит ли переданый объект данному классу
        if (!(obj instanceof Solution))
            return false;

        Solution n = (Solution) obj;
        if (first != n.first && (first == null || n.first == null))
            return false;
        // Если не равны фамилии и одно из фамилий null - объекты не эквивалентны
        if (last != n.last && (last == null ||n.last == null))
            return false;
        // Если не равны имена (при этом условии уже ни одно из имен не буде null т.к. отсеялось выше)
        // и имена не эквиваленты тогда объект тоже не эквивалентен
        if (first != n.first && !first.equals(n.first))
            return false;
        // Если не равны фамилии (при этом условии ужен ни одна из фамилий не будет null т.к. этот случай отсеялся выше)
        // и фамилии не эквиваленты тогда объект тоже не эквивалентен
        if (last != n.last && !last.equals(n.last))
            return false;
        return true;
    }

    public static void main(String[] args) {
        Set<Solution> s = new HashSet<>();
        s.add(new Solution("Donald", "Duck"));
        System.out.println(s.contains(new Solution("Donald", "Duck")));
    }
}
