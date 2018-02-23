package com.javarush.task.task17.task1713;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;

/*
Общий список
1. Изменить класс Solution так, чтобы он стал списком. (Необходимо реализовать интерфейс java.util.List).
2. Список Solution должен работать только с целыми числами Long.
3. Воспользуйтесь полем original.
4. Список будет использоваться нитями, поэтому позаботьтесь, чтобы все методы были синхронизированы.

Требования:
1. Класс Solution должен реализовывать интерфейс List.
2. Класс Solution должен содержать private поле original типа ArrayList.
3. Все переопределенные методы интерфейса List должны делегировать полномочия методам объекта original.
4. Все методы класса Solution, кроме метода main, должны быть синхронизированы.
*/

public class Solution implements java.util.List {
    private ArrayList<Long> original = new ArrayList<Long>();

    public static void main(String[] args) {

    }

    @Override
    public synchronized int size() {
        return original.size();
    }

    @Override
    public synchronized boolean isEmpty() {
        return original.isEmpty();
    }

    @Override
    public synchronized boolean contains(Object o) {
        return original.contains(o);
    }

    @Override
    public synchronized Iterator iterator() {
        return original.iterator();
    }

    @Override
    public synchronized Object[] toArray() {
        return original.toArray();
    }

    @Override
    public synchronized Object[] toArray(Object[] a) {
        return original.toArray((Long[])a);
    }

    @Override
    public synchronized boolean add(Object aLong) {
        return original.add((Long)aLong);
    }

    @Override
    public synchronized boolean remove(Object aLong) {
        return original.remove((Long) aLong);
    }

    @Override
    public synchronized boolean containsAll(Collection c) {
        return original.containsAll(c);
    }

    @Override
    public synchronized boolean addAll(Collection c) {
        return original.addAll(c);
    }

    @Override
    public synchronized boolean addAll(int index, Collection c) {
        return original.addAll(index, c);
    }

    @Override
    public synchronized boolean removeAll(Collection c) {
        return original.removeAll(c);
    }

    @Override
    public synchronized boolean retainAll(Collection c) {
        return original.retainAll(c);
    }

    @Override
    public synchronized void clear() {
        original.clear();
    }

    @Override
    public synchronized Long get(int index) {
        return original.get(index);
    }

    @Override
    public synchronized Long set(int index, Object aLong) {
        return original.set(index, (Long)aLong);
    }

    @Override
    public synchronized void add(int index, Object aLong) {
        original.add(index, (Long)aLong);
    }

    @Override
    public synchronized Object remove(int index) {
        return original.remove(index);
    }

    @Override
    public synchronized int indexOf(Object aLong) {
        return original.indexOf((Long)aLong);
    }

    @Override
    public synchronized int lastIndexOf(Object aLong) {
        return original.lastIndexOf((Long) aLong);
    }

    @Override
    public synchronized ListIterator listIterator() {
        return original.listIterator();
    }

    @Override
    public synchronized ListIterator listIterator(int index) {
        return original.listIterator(index);
    }

    @Override
    public synchronized List subList(int fromIndex, int toIndex) {
        return original.subList(fromIndex, toIndex);
    }
}
