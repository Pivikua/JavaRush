package com.javarush.task.task24.task2401;

public class SelfInterfaceMarkerImpl implements SelfInterfaceMarker {
    public void print() {
        System.out.println("Output to console.");
    }

    public void multipy() {
        for (int i = 0; i < 5; i++) {
            print();
        }
    }
}
