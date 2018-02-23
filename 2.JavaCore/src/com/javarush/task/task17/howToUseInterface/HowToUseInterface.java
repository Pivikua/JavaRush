package com.javarush.task.task17.howToUseInterface;

public class HowToUseInterface {

    public static void main(String[] args) {
        // Создаем оъект Рисовальщика

        Painter painter = new Painter();
        painter.setGraphics(new Triangle());
        painter.drow();

        painter.setGraphics(new Square());
        painter.drow();

        painter.setGraphics(new Circle());
        painter.drow();
    }

}
    // Пишем интерфейс
    interface Graphics {
        void draw();
    }

    // Создаем классы фигур которые реализует интерфейс Graphics
    // Трегольник
    class Triangle implements Graphics {
        @Override
        public void draw() {
            System.out.println("Треугольник");
        }
    }
    // Квадрат
    class Square implements Graphics {
        @Override
        public void draw() {
            System.out.println("Квадрат");
        }
    }
    // Круг
    class Circle implements Graphics {
        @Override
        public void draw() {
            System.out.println("Круг");
        }
    }

    // Создаем класс который управляет всеми классами реализующими интерфейс Graphics

    class Painter {
        Graphics graphics; // Создаем переменную типа интерфейс
        void setGraphics(Graphics graphics) {
            this.graphics = graphics; // устанавливам фигуру
        }

        void drow() {
            graphics.draw(); // Выполняем метод рисования фигуры
        }
    }
