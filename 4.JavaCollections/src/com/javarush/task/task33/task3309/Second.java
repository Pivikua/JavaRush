package com.javarush.task.task33.task3309;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

//@XmlRootElement
//@XmlType(name = "second")
@XmlAccessorType(XmlAccessType.FIELD)
public class Second {
    String one;
    String two;

    public Second(String one) {
        this.one = one;
    }
}
