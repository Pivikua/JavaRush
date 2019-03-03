package com.javarush.task.task27.task2712;

import java.util.ArrayList;
import java.util.List;

public class RandomOrderGeneratorTask implements Runnable {

    private int splitTime;
    private List<Tablet> tabletList = new ArrayList<>();

    public RandomOrderGeneratorTask(List<Tablet> tablets, int interval) {
        this.splitTime = splitTime;
        this.tabletList = tabletList;
    }

    @Override
    public void run() {
        if(tabletList.isEmpty()){
            return;
        }

        try {
            Tablet tablet;
            while (true) {
                if (!Thread.currentThread().isInterrupted()) {
                    tablet = tabletList.get((int) Math.random() * tabletList.size());
                    tablet.createOrder();
                    Thread.sleep(splitTime);
                }
            }
        } catch (InterruptedException e) {
            //e.printStackTrace();
        }
    }
}
