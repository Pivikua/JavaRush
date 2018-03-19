package com.javarush.task.task19.taskAdapter;


public class ListAdapter implements BetaList {
    private AlphaList list;

    public ListAdapter(AlphaList list) {
        this.list = list;
    }

    @Override
    public int getValue(int index) {
        return this.list.get(index);
    }

    @Override
    public void setValue(int index, int value) {
        this.list.set(index, value);
    }

    @Override
    public int getSize() {
        return this.list.count();
    }

    @Override
    public void setSize(int newSize) {
        if (newSize > this.list.count()) {
            while (this.list.count() < newSize) {
                this.list.add(newSize);
            }
        } else if (newSize < this.list.count()) {
            while (this.list.count() > newSize) {
                list.remove(list.count() - 1);
            }
        }
    }
}
