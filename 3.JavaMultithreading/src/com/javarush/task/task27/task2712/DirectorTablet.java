package com.javarush.task.task27.task2712;

import com.javarush.task.task27.task2712.ad.Advertisement;
import com.javarush.task.task27.task2712.ad.StatisticAdvertisementManager;
import com.javarush.task.task27.task2712.statistic.StatisticManager;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

public class DirectorTablet {

    private DateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy");

    public void printAdvertisementProfit() {
        StatisticManager statisticManager = StatisticManager.getInstance();
        double total = 0d;
        for (Map.Entry<Date, Double> entry : statisticManager.adProfit().entrySet()) {
            double profit = entry.getValue();
            ConsoleHelper.writeMessage(String.format("%s - %.2f", dateFormat.format(entry.getKey()), profit));
            total += profit;
        }
        ConsoleHelper.writeMessage(String.format("Total - %.2f", total));
    }

    public void printCookWorkloading() {
        StatisticManager statisticManager = StatisticManager.getInstance();
        for (Map.Entry<Date, Map<String, Integer>> entry : statisticManager.cookWork().entrySet()) {
            ConsoleHelper.writeMessage(dateFormat.format(entry.getKey()));
            for (Map.Entry<String, Integer> stringIntegerEntry : entry.getValue().entrySet()) {
                ConsoleHelper.writeMessage(stringIntegerEntry.getKey() + " - " + stringIntegerEntry.getValue() + " min");
            }
            ConsoleHelper.writeMessage("");
        }
    }

    public void printActiveVideoSet() {
        StatisticAdvertisementManager statisticAdvertisementManager = StatisticAdvertisementManager.getInstanve();
        for (Advertisement advertisement : statisticAdvertisementManager.activeVideoList()) {
            ConsoleHelper.writeMessage(advertisement.getName() + " - " + advertisement.getHits());
        }
    }

    public void printArchivedVideoSet() {
        StatisticAdvertisementManager statisticAdvertisementManager = StatisticAdvertisementManager.getInstanve();
        for (Advertisement advertisement :statisticAdvertisementManager.unActiveVideoList()) {
            ConsoleHelper.writeMessage(advertisement.getName());
        }
    }

}
