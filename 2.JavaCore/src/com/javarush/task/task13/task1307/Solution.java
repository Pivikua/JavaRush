package com.javarush.task.task13.task1307;

public class Solution {
    public static void main(String[] args) throws Exception {
        System.out.println(new StringObject[2].getClass().getSimpleName());
    }

    interface SimpleObject<T> {
        SimpleObject<T> getInstance();
    }

    class StringObject implements SimpleObject<String> //допишите здесь ваш код
    {
        @Override
        public SimpleObject<String> getInstance() {
            return null;
        }
    }
}
