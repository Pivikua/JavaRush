package com.javarush.task.task29.task2909.car;

public class TestCar {
    public static void main(String[] args) {
        Car cabrio = new Cabriolet(2);
        cabrio.setDriverAvailable(false);
        cabrio.fuel = 0.0;
        System.out.println(cabrio.getNumberOfPassengersCanBeTransferred());
    }
}
