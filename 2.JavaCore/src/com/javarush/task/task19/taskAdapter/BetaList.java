package com.javarush.task.task19.taskAdapter;

public interface BetaList {
    int getValue(int index);
    void setValue(int index, int value);
    int getSize();
    void setSize(int newSize);
}
