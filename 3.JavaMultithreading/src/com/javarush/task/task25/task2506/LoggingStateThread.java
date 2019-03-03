package com.javarush.task.task25.task2506;

public class LoggingStateThread extends Thread {
    Thread thread;

    public LoggingStateThread(Thread thread) {
        this.thread = thread;
    }

    @Override
    public void run() {
        super.run();
        Thread.State currentState = thread.getState();
        System.out.println(currentState);
        do {
            if (currentState != thread.getState()) {
                System.out.println(thread.getState());
                currentState = thread.getState();
            }
        } while (thread.getState() != State.TERMINATED);
        this.interrupt();
    }
}
