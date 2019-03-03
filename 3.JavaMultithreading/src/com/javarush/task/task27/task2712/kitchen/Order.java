package com.javarush.task.task27.task2712.kitchen;

import com.javarush.task.task27.task2712.ConsoleHelper;
import com.javarush.task.task27.task2712.Tablet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Order {
    private final Tablet tablet;
    protected List<Dish> dishes = new ArrayList<>();

    public Order(Tablet tablet) throws IOException {
        this.tablet = tablet;
        //this.dishes = ConsoleHelper.getAllDishesForOrder();
        initDishes();
    }

    @Override
    public String toString() {
        return dishes.isEmpty() ? "" : "Your order: " + dishes + " of " + tablet;
    }

    public int getTotalCookingTime() {
        int time = 0;
        for (Dish dish :dishes) {
            time += dish.getDuration();
        }
        return time;
    }

    public boolean isEmpty() {
        return dishes.isEmpty();
    }

    public List<Dish> getDishes() {
        return dishes;
    }

    public Tablet getTablet() {
        return tablet;
    }

    protected void initDishes() throws IOException {
        dishes = ConsoleHelper.getAllDishesForOrder();
    }
}
