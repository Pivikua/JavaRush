package com.javarush.task.task27.task2712.ad;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class StatisticAdvertisementManager {

    private static StatisticAdvertisementManager statisticAdvertisementManager = new StatisticAdvertisementManager();
    private AdvertisementStorage advertisementStorage = AdvertisementStorage.getInstance();

    private StatisticAdvertisementManager() {

    }

    public static StatisticAdvertisementManager getInstanve() {
        return statisticAdvertisementManager;
    }

    public List<Advertisement> activeVideoList() {
        List<Advertisement> activeVideoList = new ArrayList<>();
        for (Advertisement advertisement : advertisementStorage.list()) {
            if (advertisement.getHits() > 0) {
                activeVideoList.add(advertisement);
            }
        }

        Collections.sort(activeVideoList, new Comparator<Advertisement>() {
            @Override
            public int compare(Advertisement o1, Advertisement o2) {
                return o1.getName().compareToIgnoreCase(o2.getName());
            }
        });
        return activeVideoList;
    }

    public List<Advertisement> unActiveVideoList() {
        List<Advertisement> unActiveVideoList = new ArrayList<>();
        for (Advertisement advertisement : advertisementStorage.list()) {
            if (advertisement.getHits() <= 0) {
                unActiveVideoList.add(advertisement);
            }
        }

        Collections.sort(unActiveVideoList, new Comparator<Advertisement>() {
            @Override
            public int compare(Advertisement o1, Advertisement o2) {
                return o1.getName().compareToIgnoreCase(o2.getName());
            }
        });
        return unActiveVideoList;
    }
}
