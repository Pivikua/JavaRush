package com.javarush.task.task20.task2014;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.text.SimpleDateFormat;
import java.util.Date;

/* 
Serializable Solution
*/

// Доделать Написать код проверки самостоятельно в методе main! Важно!

public class Solution implements Externalizable {
    public static void main(String[] args) {
        System.out.println(new Solution(4));


    }

    transient private final String pattern = "dd MMMM yyyy, EEEE";
    transient private Date currentDate;
    transient private int temperature;
    String string;

    public Solution(){

    }

    public Solution(int temperature) {
        this.currentDate = new Date();
        this.temperature = temperature;

        string = "Today is %s, and current temperature is %s C";
        SimpleDateFormat format = new SimpleDateFormat(pattern);
        this.string = String.format(string, format.format(currentDate), temperature);
    }

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeInt(temperature);
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        temperature = in.readInt();
    }

    @Override
    public String toString() {
        return this.string;
    }
}
