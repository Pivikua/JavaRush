package com.javarush.task.task27.task2712;

import com.javarush.task.task27.task2712.kitchen.Cook;
import com.javarush.task.task27.task2712.kitchen.Order;
import com.javarush.task.task27.task2712.kitchen.Waiter;
import com.javarush.task.task27.task2712.statistic.StatisticManager;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.LinkedBlockingQueue;

public class Restaurant {
    private static final int ORDER_CREATING_INTERVAL = 100;
    private final static LinkedBlockingQueue<Order> orderQueue = new LinkedBlockingQueue<>();

    public static void main(String[] args) {

        StatisticManager statisticManager = StatisticManager.getInstance();
        Cook cook1 = new Cook("Amigo");
        cook1.setQueue(orderQueue);
        Cook cook2 = new Cook("Amigo2");
        cook1.setQueue(orderQueue);
        statisticManager.register(cook1);
        statisticManager.register(cook2);
        Waiter waiter = new Waiter();
        cook1.addObserver(waiter);
        cook2.addObserver(waiter);

        List<Tablet> tabletList = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            Tablet tablet = new Tablet(i);
            tablet.setQueue(orderQueue);
            tabletList.add(tablet);
        }

        RandomOrderGeneratorTask randomOrderGeneratorTask = new RandomOrderGeneratorTask(tabletList, ORDER_CREATING_INTERVAL);
        //Thread randomOrGenThread = new Thread(randomOrderGeneratorTask);
        Thread thread = new Thread(randomOrderGeneratorTask);
        Thread cookThread1 = new Thread(cook2);
        Thread cookThread2 = new Thread(cook2);
        thread.start();
        cookThread1.start();
        cookThread2.start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        thread.interrupt();
        cookThread1.interrupt();
        cookThread2.interrupt();

        DirectorTablet directorTablet = new DirectorTablet();

        directorTablet.printAdvertisementProfit();
        directorTablet.printCookWorkloading();
        directorTablet.printActiveVideoSet();
        directorTablet.printArchivedVideoSet();
    }

    /*public static class OrderManager implements Observer, Runnable {

    //    private LinkedBlockingQueue<Order> orderQueue = new LinkedBlockingQueue<>();

        public OrderManager() {
            Thread thread = new Thread(this);
            thread.setDaemon(true);
            thread.start();
        }

        @Override
        public void update(Observable o, Object arg) {
            Order order = (Order) arg;

            try {
                orderQueue.put(order);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        @Override
        public void run() {
    *//*        while (true) {
                if (orderQueue.size() > 0) {
                    for (Cook cook : StatisticManager.getInstance().getCooks()) {
                        if (cook.isBusy() == false) {
                            cook.startCookingOrder(orderQueue.poll());
                        }
                    }
                }
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    //e.printStackTrace();
                }
            }*//*
        }
    }*/
}
