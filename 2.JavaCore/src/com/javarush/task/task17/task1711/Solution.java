package com.javarush.task.task17.task1711;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* 
CRUD 2
*/

public class Solution {
    public static volatile List<Person> allPeople = new ArrayList<Person>();

    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args) {
        //start here - начни тут
        if (args.length < 2) {
            return;
        }

        SimpleDateFormat dateFormatIn = new SimpleDateFormat("dd/MM/yy", Locale.ENGLISH);
        SimpleDateFormat dateFormatOut = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);

        String idIn;
        String name;
        String sex;
        Date bdate;

        switch (args[0]) {
            case "-c":
                for (int i = 1; i < args.length; i += 3) {
                    name = args[i];
                    sex = args[i + 1];
                    try {
                        bdate = dateFormatIn.parse(args[i + 2]);

                        if (sex.equals("ж")) {
                            allPeople.add(Person.createFemale(name, bdate));
                            System.out.println(allPeople.size() - 1);
                        }
                        if (sex.equals("м")) {
                            allPeople.add(Person.createMale(name, bdate));
                            System.out.println(allPeople.size() - 1);
                        }
                    } catch (ParseException e) {
                    }
                }
                break;
            case "-u":
                for (int i = 1; i < args.length; i += 4) {
                    idIn = args[i];
                    name = args[i + 1];
                    sex = args[i + 2];
                    try {
                        bdate = dateFormatIn.parse(args[i + 3]);

                        int idInt = Integer.parseInt(idIn);

                        allPeople.get(idInt).setName(name);
                        if (sex.equals("ж")) {
                            Person person = Person.createFemale(name, bdate);
                            allPeople.set(idInt, person);
                        }
                        if (sex.equals("м")) {
                            Person person = Person.createMale(name, bdate);
                            allPeople.set(idInt, person);
                        }
                    } catch (ParseException e) {
                    }
                }
                break;
            case "-d":
                for (int i = 1; i < args.length; i++) {
                    int idInt = Integer.parseInt(args[i]);
                    if (idInt > allPeople.size() - 1) {
                        break;
                    }
                    allPeople.get(idInt).setName(null);
                    allPeople.get(idInt).setSex(null);
                    allPeople.get(idInt).setBirthDay(null);
                }
                break;
            case "-i":
                for (int i = 1; i < args.length; i++) {
                    try {
                        int id = Integer.parseInt(args[i]);
                        if (id > allPeople.size() - 1) {
                            break;
                        }
                        Person p = allPeople.get(id);
                        String sexi;
                        if (p.getSex() == Sex.FEMALE) {
                            sexi = "ж";
                        } else sexi = "м";
                        System.out.println(p.getName() + " " + sexi + " " + dateFormatOut.format(p.getBirthDay()));
                    } catch (Exception e) {
                    }
                }
            /*default:
                break;*/
        }
    }
}
