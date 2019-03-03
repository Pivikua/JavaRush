package com.javarush.task.task32.ServiceLocatorPattren;

class Service2 implements Service {
    @Override
    public String getName() {
        return this.getClass().getSimpleName();
    }

    @Override
    public void execute() {
        System.out.println("Executing " + getName());
    }
}
