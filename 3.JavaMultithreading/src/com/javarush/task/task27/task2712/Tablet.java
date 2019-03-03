package com.javarush.task.task27.task2712;

import com.javarush.task.task27.task2712.ad.AdvertisementManager;
import com.javarush.task.task27.task2712.ad.NoVideoAvailableException;
import com.javarush.task.task27.task2712.kitchen.Order;
import com.javarush.task.task27.task2712.kitchen.TestOrder;

import java.io.IOException;
import java.util.Observable;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Tablet/* extends Observable*/ {

    final int number;
    private static Logger logger = Logger.getLogger(Tablet.class.getName());
    private LinkedBlockingQueue<Order> queue = new LinkedBlockingQueue<>();

    public Tablet(int number) {
        this.number = number;
    }

    public Order createOrder() {
        Order order = null;
        try {
            order = new Order(this);
            ConsoleHelper.writeMessage(order.toString());
            adOrder(order);
        } catch (IOException e) {
            logger.log(Level.SEVERE, "Console is unavailable.");
        }
        return order;
    }

    private void adOrder(Order order) {
        AdvertisementManager advertisementManager;
        if (!order.isEmpty()) {
            try {
                advertisementManager = new AdvertisementManager(order.getTotalCookingTime() * 60);
                advertisementManager.processVideos();
            } catch (NoVideoAvailableException e) {
                logger.log(Level.INFO, "No video is available for the order " + order);
            }
//            setChanged();
//            notifyObservers(order);
            try {
                queue.put(order);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void createTestOrder() {
        TestOrder testOrder = null;
        try {
            testOrder = new TestOrder(this);
            ConsoleHelper.writeMessage(testOrder.toString());
            adOrder(testOrder);
        } catch (IOException e) {
            logger.log(Level.SEVERE, "Console is unavailable.");
        }
        //return testOrder;
    }

    @Override
    public String toString() {
        return "Tablet{" +
                "number=" + number +
                '}';
    }

    public void setQueue(LinkedBlockingQueue<Order> queue) {
        this.queue = queue;
    }
}