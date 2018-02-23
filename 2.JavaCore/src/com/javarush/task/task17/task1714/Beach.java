package com.javarush.task.task17.task1714;

/*
Comparable
Реализуйте интерфейс Comparable<Beach> в классе Beach.
Пляжи(Beach) будут использоваться нитями, поэтому позаботьтесь, чтобы все методы были синхронизированы.
Реализовать метод compareTo так, чтобы он при сравнении двух пляжей выдавал число,
    которое показывает что первый пляж лучше(позитивное число)
или второй пляж лучше (негативное число),и насколько он лучше.

Требования:
1. Класс Beach должен содержать три поля: String name, float distance, int quality.
2. Класс Beach должен реализовывать интерфейс Comparable.
3. Метод compareTo класса Beach как минимум должен учитывать качество пляжа и дистанцию.
4. Все методы класса Beach, кроме метода main, должны быть синхронизированы.
*/

public class Beach implements Comparable<Beach>{
    private volatile String name;      //название
    private volatile float distance;   //расстояние
    private volatile int quality;    //качество

    public Beach(String name, float distance, int quality) {
        this.name = name;
        this.distance = distance;
        this.quality = quality;
    }

    public synchronized String getName() {
        return name;
    }

    public synchronized void setName(String name) {
        this.name = name;
    }

    public synchronized float getDistance() {
        return distance;
    }

    public synchronized void setDistance(float distance) {
        this.distance = distance;
    }

    public synchronized int getQuality() {
        return quality;
    }

    public synchronized void setQuality(int quality) {
        this.quality = quality;
    }

    public static void main(String[] args) {
        Beach beach;
        Beach beach1 = new Beach("BlackSea", (int) (Math.random() * 10), (int) (Math.random() * 10));
        Beach beach2 = new Beach("AsovSea", (int) (Math.random() * 10), (int) (Math.random() * 10));
        if (beach1.compareTo(beach2) >= 0) {
                beach = beach1;
        } else {
            beach = beach2;
        }

        System.out.println(beach.getName() + " Лучьше!");
        System.out.println("Расстояние " + beach.getDistance() + " : " + "Качество " + beach.getQuality());
    }

    //-----------------------------------------//

    @Override
    public synchronized int compareTo(Beach beach) {
        return (this.distance + this.quality) / 2 >= (beach.getDistance() + beach.getQuality()) / 2 ? 1 : -1;
    }
}
