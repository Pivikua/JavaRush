package com.javarush.task.task08.task0818;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* 
Только для богачей
*/

public class Solution {
    public static HashMap<String, Integer> createMap() {
        //напишите тут ваш код
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        map.put("Petrov", 100);
        map.put("Sidorov", 1000);
        map.put("Ivanov", 500);
        map.put("Stepanov", 2000);
        map.put("Volkov", 1000);
        map.put("Zaremba", 1000);
        map.put("Google", 100);
        map.put("Yandex", 1000);
        map.put("Rambler", 1000);
        map.put("Skuka", 100);

        return map;
    }

    public static void removeItemFromMap(HashMap<String, Integer> map) {
        //напишите тут ваш код
        ArrayList<String> keyList = new ArrayList<>();
        for (Map.Entry<String, Integer> pair : map.entrySet())
        {
            String key = pair.getKey();                      //ключ
            Integer value = pair.getValue();                  //значение
            if (value < 500){
                keyList.add(key);
            }
        }

        for (String key: keyList) {
            map.remove(key);
        }
    }

    public static void main(String[] args) {
        HashMap<String, Integer> map = createMap();
        removeItemFromMap(map);
    }
}