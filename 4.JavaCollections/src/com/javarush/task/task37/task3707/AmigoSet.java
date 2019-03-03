package com.javarush.task.task37.task3707;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.*;

public class AmigoSet<E> extends AbstractSet<E> implements Serializable, Cloneable, Set<E> {
    private E element;
    private static final Object PRESENT = new Object();
    private transient HashMap<E, Object> map;

    protected AmigoSet() {
        map = new HashMap<>();
    }

    public AmigoSet(Collection<? extends E> collection) {
        map = new HashMap<E, Object>(Math.max(16, (int) (collection.size() / .75f) + 1));
        addAll(collection);
    }

    @Override
    public boolean equals(Object o) {
        return super.equals(o);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean removeAll(Collection c) {
        return super.removeAll(c);
    }

    @Override
    public boolean isEmpty() {
        return map.isEmpty();
    }

    @Override
    public boolean contains(Object o) {
        return map.containsKey(o);
    }

    @Override
    public Object[] toArray() {
        return super.toArray();
    }

    @Override
    public Object[] toArray(Object[] a) {
        return super.toArray(a);
    }

    @Override
    public boolean add(E e) {
        return map.put(e, PRESENT) == null;
    }

    @Override
    public boolean remove(Object o) {
        return map.remove(o) == PRESENT;
    }

    @Override
    public boolean containsAll(Collection c) {
        return super.containsAll(c);
    }

    @Override
    public boolean addAll(Collection c) {
        return super.addAll(c);
    }

    @Override
    public boolean retainAll(Collection c) {
        return super.retainAll(c);
    }

    @Override
    public void clear() {
        map.clear();
    }

    @Override
    public String toString() {
        return super.toString();
    }

    @Override
    public Iterator iterator() {
        return map.keySet().iterator();
    }

    @Override
    public int size() {
        return map.size();
    }

    @Override
    public Object clone() {
        try {
            AmigoSet<E> mySet = (AmigoSet<E>) super.clone();
            mySet.map = (HashMap<E, Object>) map.clone();
            return mySet;
        } catch (Exception e) {
            throw new InternalError(e);
        }
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
    }

    private void writeObject (ObjectOutputStream objectOutputStream) {
        float loadFactor = HashMapReflectionHelper.callHiddenMethod(map, "loadFactor");
        int capacity = HashMapReflectionHelper.callHiddenMethod(map, "capacity");

        try {
            objectOutputStream.defaultWriteObject();
            objectOutputStream.writeInt(capacity);
            objectOutputStream.writeFloat(loadFactor);
            objectOutputStream.writeInt(map.size());
            for (E e :map.keySet()) {
                objectOutputStream.writeObject(e);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void readObject (ObjectInputStream objectInputStream) {
        try {
            objectInputStream.defaultReadObject();
            int capacity  = objectInputStream.readInt();
            float loadFactor = objectInputStream.readFloat();
            int size = objectInputStream.readInt();
            map = new HashMap<E, Object>(capacity, loadFactor);
            for (int i = 0; i < size; i++) {
                E e = (E) objectInputStream.readObject();
                map.put(e, PRESENT);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }


}