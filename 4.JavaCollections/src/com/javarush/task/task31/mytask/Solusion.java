package com.javarush.task.task31.mytask;

import java.io.File;
import java.io.IOException;

public class Solusion {

    String n = "name";

    public static void main(String[] args) {

        File fileFirstName = new File("D:\\test\\firstNamedFile.txt");
        try {
            System.out.println("Файл с именем " + fileFirstName.getName() + " создан? " + fileFirstName.createNewFile());
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        File fileSecondName = new File("D:\\test\\secondNamedFile.txt");
        System.out.println("Файл с именем " + fileSecondName.getName() + " переименован? " + fileFirstName.renameTo(fileSecondName));

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Файл с именем " + fileSecondName.getName() + " удален? " + fileSecondName.delete());

        fileSecondName.getName();
    }

}
