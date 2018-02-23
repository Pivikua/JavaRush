package com.javarush.task.task15.task1530;

/*
Template pattern
1. В отдельном файле создать класс DrinkMaker с тремя абстрактными методами:
- void getRightCup() - выбрать подходящую чашку
- void putIngredient() - положить ингредиенты
- void pour() - залить жидкостью
2. В классе DrinkMaker создать и реализовать метод void makeDrink(), который готовит напиток
    в такой последовательности: выбирает чашку, кладет ингредиенты, заливает жидкостью.
3. В отдельных файлах создать классы LatteMaker и TeaMaker, которые наследуются от DrinkMaker.
4. Распредели следующие фразы между всеми методами в классах LatteMaker и TeaMaker, различные
    фразы для различных методов.
5. Каждый метод должен выводить в консоль свою фразу не пересекаясь с другими методами.
6. Фразы:
"Заливаем кипятком"
"Берем чашку для латте"
"Насыпаем чай"
"Берем чашку для чая"
"Заливаем молоком с пенкой"
"Делаем кофе"

Требования:
1. Класс DrinkMaker должен быть создан в отдельном файле и быть абстрактным.
2. В классе DrinkMaker должны содержаться объявления трех абстрактных методов getRightCup, putIngredient и pour.
3. В классе DrinkMaker должен быть реализован метод makeDrink который будет вызывать абстрактные
    методы этого класса в последовательности заданной условием.
4. Класс LatteMaker должен быть создан в отдельном файле и быть потомком класса DrinkMaker.
5. Класс TeaMaker должен быть создан в отдельном файле и быть потомком класса DrinkMaker.
6. Метод getRightCup в классе LatteMaker должен выводить на экран фразу "Берем чашку для латте".
7. Метод putIngredient в классе LatteMaker должен выводить на экран фразу "Делаем кофе".
8. Метод pour в классе LatteMaker должен выводить на экран фразу "Заливаем молоком с пенкой".
9. Метод getRightCup в классе TeaMaker должен выводить на экран фразу "Берем чашку для чая".
10. Метод putIngredient в классе TeaMaker должен выводить на экран фразу "Насыпаем чай".
11. Метод pour в классе TeaMaker должен выводить на экран фразу "Заливаем кипятком".
*/

public class Solution {
    public static void main(String[] args) {
        LatteMaker latteMaker = new LatteMaker();
        latteMaker.makeDrink();

        TeaMaker teaMaker = new TeaMaker();
        teaMaker.makeDrink();
    }
}
