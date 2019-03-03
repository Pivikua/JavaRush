package com.javarush.task.task28.task2805;

import java.util.concurrent.atomic.AtomicInteger;

public class MyThread extends Thread {

    public static AtomicInteger priority = new AtomicInteger(1);

    public MyThread() {
        if (priority.get() < Thread.MAX_PRIORITY) {
            setPriority(priority.getAndIncrement());
        } else {
            setPriority(priority.get());
            priority.set(Thread.MIN_PRIORITY);
        }
    }

    public MyThread(Runnable target) {
        super(target);
        if (priority.get() < Thread.MAX_PRIORITY) {
            setPriority(priority.getAndIncrement());
        } else {
            setPriority(priority.get());
            priority.set(Thread.MIN_PRIORITY);
        }
    }

    public MyThread(ThreadGroup group, Runnable target) {
        super(group, target);
        if (priority.get() < Thread.MAX_PRIORITY) {
            setPriority(priority.getAndIncrement());
        } else {
            setPriority(priority.get());
            priority.set(Thread.MIN_PRIORITY);
        }
    }

    public MyThread(String name) {
        super(name);
        if (priority.get() < Thread.MAX_PRIORITY) {
            setPriority(priority.getAndIncrement());
        } else {
            setPriority(priority.get());
            priority.set(Thread.MIN_PRIORITY);
        }
    }

    public MyThread(ThreadGroup group, String name) {
        super(group, name);
        if (priority.get() < Thread.MAX_PRIORITY) {
            setPriority(priority.getAndIncrement());
        } else {
            setPriority(priority.get());
            priority.set(Thread.MIN_PRIORITY);
        }
    }

    public MyThread(Runnable target, String name) {
        super(target, name);
        if (priority.get() < Thread.MAX_PRIORITY) {
            setPriority(priority.getAndIncrement());
        } else {
            setPriority(priority.get());
            priority.set(Thread.MIN_PRIORITY);
        }
    }

    public MyThread(ThreadGroup group, Runnable target, String name) {
        super(group, target, name);
        if (priority.get() < Thread.MAX_PRIORITY) {
            setPriority(priority.getAndIncrement());
        } else {
            setPriority(priority.get());
            priority.set(Thread.MIN_PRIORITY);
        }
    }

    public MyThread(ThreadGroup group, Runnable target, String name, long stackSize) {
        super(group, target, name, stackSize);
        if (priority.get() < Thread.MAX_PRIORITY) {
            setPriority(priority.getAndIncrement());
        } else {
            setPriority(priority.get());
            priority.set(Thread.MIN_PRIORITY);
        }
    }

    @Override
    public void run() {

    }

}
