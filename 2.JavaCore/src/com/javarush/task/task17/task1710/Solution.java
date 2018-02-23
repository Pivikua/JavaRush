package com.javarush.task.task17.task1710;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/*
CRUD
*/

public class Solution {
    public static List<Person> allPeople = new ArrayList<Person>();

    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args) {
        //start here - начни тут
        try {
            switch (args[0]) {
                case "-c" :
                    createNewPeople(args);
                    break;
                case "-u" :
                    upgradePeople(args);
                    break;
                case "-d" :
                    deletePeople(args);
                    break;
                case "-i" :
                    infoByPeople(args);
                    break;
            }
        } catch (Exception e) {
            System.out.println("ОШИБКА! Строка аргументов неверная или отсуствует!");
        }
    }

    private static void createNewPeople(String[] args) {
        if (args[2].equals("м")) {
            allPeople.add(Person.createMale(args[1], getDate(args[3])));
        } else if (args[2].equals("ж")) {
            allPeople.add(Person.createFemale(args[1], getDate(args[3])));
        }
    }

    private static void upgradePeople(String[] args) {
        allPeople.get(Integer.parseInt(args[1])).setName(args[2]);
        allPeople.get(Integer.parseInt(args[1])).setSex(getSex(args[3]));
        allPeople.get(Integer.parseInt(args[1])).setBirthDay(getDate(args[4]));
    }

    private static void deletePeople(String[] args) {
        allPeople.remove(Integer.parseInt(args[1]));
    }

    private static void infoByPeople(String[] args) {
        DateFormat newFormat = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
        System.out.println(allPeople.get(Integer.parseInt(args[1])).getName() + " "
                + getSexLtter(allPeople.get(Integer.parseInt(args[1])).getSex()) + " "
                + newFormat.format(allPeople.get(Integer.parseInt(args[1])).getBirthDay()));
    }

    private static Date getDate(String string){
        try {
            DateFormat format = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
            Date date = format.parse(string);
            return date;
        } catch (ParseException e) {
            System.out.println("Неверный формат даты. Возварщен Null");
            return null;
        }
    }

    private static Sex getSex(String string) {
        if (string.equals("м")) {
            return Sex.MALE;
        } else if (string.equals("ж")) {
            return Sex.FEMALE;
        }
        return null;
    }

    private static String getSexLtter(Sex sex) {
        if (sex.equals(Sex.MALE)) {
            return "м";
        } else if (sex.equals(Sex.FEMALE)) {
            return "ж";
        }
        return null;
    }
}
