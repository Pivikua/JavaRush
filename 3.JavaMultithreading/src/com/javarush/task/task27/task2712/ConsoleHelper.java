package com.javarush.task.task27.task2712;

import com.javarush.task.task27.task2712.kitchen.Dish;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class ConsoleHelper {
    private static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

    public static void writeMessage(String message) {
        System.out.println(message);
    }

    public static String readString() throws IOException {
        return bufferedReader.readLine();
    }

    public static List<Dish> getAllDishesForOrder() throws IOException {
        writeMessage(Dish.allDishesToString());
        writeMessage("Введите желаемое блюдо:");
        List<Dish> dishList = new ArrayList<>();
        Dish dish;
        String inputString;
        while (true) {
            dish = null;
            inputString = readString();
            if (inputString.equalsIgnoreCase("exit")) {
                break;
            }

            if (inputString.isEmpty()) {
                writeMessage("Блюдо не выбрано.");
                continue;
            }

            boolean found = false;
            for(Dish d : Dish.values())
                if(d.name().equalsIgnoreCase(inputString)) {
                    dishList.add(d);
                    found = true;
                }

            if(!found){
                writeMessage("Нет такого блюда");
            }
        }

        //System.out.println(dishList);
        return dishList;
    }
}
