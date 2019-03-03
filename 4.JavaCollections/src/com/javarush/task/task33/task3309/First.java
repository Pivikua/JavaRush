package com.javarush.task.task33.task3309;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement
@XmlType(propOrder={"second", "age"})
@XmlAccessorType(XmlAccessType.FIELD)
public class First {

    private Second second;
    private int age;

    public First() {
    }

    public First(Second second, int age) {
        this.second = second;
        this.age = age;
    }

    public Second getSecond() {
        return second;
    }

    public void setSecond(Second second) {
        this.second = second;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
