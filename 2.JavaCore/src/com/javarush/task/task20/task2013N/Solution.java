package com.javarush.task.task20.task2013N;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/*
Externalizable Person
Класс Person должен сериализовываться с помощью интерфейса Externalizable.
Исправь ошибку сериализации.
Сигнатуры методов менять нельзя.

Требования:
1. Класс Solution.Person должен поддерживать интерфейс Externalizable.
2. Методы readExternal и writeExternal должны позволять корректно сериализовывать и десериализовывать объекты типа Person.
3. В классе Solution.Person должен быть создан конструктор без параметров.
4. В классе Solution.Person должен быть создан конструктор с тремя параметрами (String firstName, String lastName, int age).
*/
public class Solution {
    public static class Person implements Externalizable {

        private static final long serialVersionUID = -7604766932017737115L;

        private String firstName;
        private String lastName;
        private int age;
        private Person mother;
        private Person father;
        private List<Person> children;

        public Person() {
        }

        public Person(String firstName, String lastName, int age) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.age = age;
        }

        public void setMother(Person mother) {
            this.mother = mother;
        }

        public void setFather(Person father) {
            this.father = father;
        }

        public void setChildren(List<Person> children) {
            this.children = children;
        }

        @Override
        public void writeExternal(ObjectOutput out) throws IOException {
            out.writeChars(firstName);
            out.writeChars(lastName);
            out.writeInt(age);
            out.writeObject(father);
            out.writeObject(mother);
            out.writeObject(children);
        }

        @Override
        public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
            firstName = in.readLine();
            lastName = in.readLine();
            age = in.readInt();
            father = (Person)in.readObject();
            mother = (Person)in.readObject();
            children = (List)in.readObject();
        }
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {

        Person originalPerson = new Person("Pivovarov", "Oleksandr", 42);
        originalPerson.setFather(new Person("Pivovarov", "Oleksandr", 64));
        originalPerson.setMother(new Person("Pivovarova", "Anna", 62));
        ArrayList<Person> children = new ArrayList<>();
        children.add(new Person("Pivovarov", "Stpan", 13));
        children.add(new Person("Pivovarova", "Cofija", 15));
        originalPerson.setChildren(children);

        String fileName = "D:\\test\\0.txt";

        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(fileName));
        originalPerson.writeExternal(objectOutputStream);
        objectOutputStream.close();

        Person secondPrson = new Person();
        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(fileName));
        secondPrson.readExternal(objectInputStream);
        objectInputStream.close();

        System.out.println(secondPrson);
    }
}
