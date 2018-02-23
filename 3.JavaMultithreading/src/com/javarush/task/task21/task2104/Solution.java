package com.javarush.task.task21.task2104;

import java.util.HashSet;
import java.util.Set;

/* 
Equals and HashCode
*/
public class Solution {
    private final String first, last;

    public Solution(String first, String last) {
        this.first = first;
        this.last = last;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (obj.hashCode() != this.hashCode())
            return false;
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

    @Override
    public int hashCode() {
        return 31 * (first == null ? 0 : first.hashCode()) + (last == null ? 0 : last.hashCode());
    }

    public static void main(String[] args) {
        Set<Solution> s = new HashSet<>();
        s.add(new Solution("Donald", "Duck"));
        System.out.println(s.contains(new Solution("Donald", "Duck")));
    }
}
