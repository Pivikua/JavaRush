package com.javarush.task.task35.task3513;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        Model model = new Model();
        Controller controller = new Controller(model);
        JFrame gamejFrame = new JFrame();
        gamejFrame.setTitle("2048");
        gamejFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        gamejFrame.setSize(450, 500);
        gamejFrame.setResizable(false);

        gamejFrame.add(controller.getView());

        gamejFrame.setLocationRelativeTo(null);
        gamejFrame.setVisible(true);

    }
}
