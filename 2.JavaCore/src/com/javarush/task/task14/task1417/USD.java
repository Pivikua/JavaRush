package com.javarush.task.task14.task1417;

public class USD extends Money {

    public USD(double amount) {
        super.amount = amount;
    }

    public String getCurrencyName() {
        return "USD";
    }
}
