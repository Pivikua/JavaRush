package com.javarush.task.task30.task3003;

import java.util.concurrent.TransferQueue;

public class Consumer implements Runnable {
    private TransferQueue<ShareItem> queue;
    static boolean flagConsumer = true;

    public Consumer(TransferQueue<ShareItem> queue) {
        this.queue = queue;
    }

    public static void setFlagConsumer(boolean flag) {
        Consumer.flagConsumer = flag;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(450);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        while (flagConsumer) {
            try {
                if (!queue.isEmpty()) {
                    System.out.format("Processing %s\n", queue.take().toString());
                }

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        Producer.setFlagProducer(false);
    }
}
