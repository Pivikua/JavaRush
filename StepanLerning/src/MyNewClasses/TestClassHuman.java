package MyNewClasses;

import java.awt.*;

public class TestClassHuman {
    public static void main(String[] args) {
        Human chelovek = new Human("Саша", 12, 152, true);
        Human devochka = new Human("Мордор", 11, 140, false);
        Human deduchka = new Human( "Юра", 60, 180, true);

//        Cat cat = new Cat( "Мурзик", 5, Color.BLACK);
//        Dog dog = new Dog( "Шарик", 4, Color.white);
//        Mouse mouse = new Mouse( "Соня", 1, Color.ORANGE);
//
//        cat.sayMyu();
//        dog.seyGow();
//        mouse.sayPi();

        chelovek.sayName();
        chelovek.sayAge();
        System.out.println("Я " + chelovek.OldYang());
        chelovek.sayHeight();

        System.out.println();

//        chelovek.sayUra3();
//        chelovek.n10();

        devochka.sayName();
        devochka.sayAge();
        System.out.println("Я " + devochka.OldYang());
        devochka.sayHeight();
//        devochka.sayUra3();

        System.out.println();

        deduchka.sayName();
        deduchka.sayAge();
        System.out.println("Я " + deduchka.OldYang());
        deduchka.sayHeight();
//        deduchka.sayUra3();

        Cube cube = new Cube(5);

        System.out.println("Обїем куба " + cube.Volume());
        System.out.println("Площадь гнаней куба " + cube.Scuare());
        int dlinreb = cube.DlinReb();
        System.out.println("Длина всех ребер куба " + dlinreb);
    }
}
