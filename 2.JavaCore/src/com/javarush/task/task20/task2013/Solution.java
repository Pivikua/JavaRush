package com.javarush.task.task20.task2013;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/* 
Externalizable Person
*/

//Выполнено.
public class Solution {
    public static class Person implements Externalizable{

        private static final long serialVersionUID = -7604766932017737115L;

        private String firstName;
        private String lastName;
        private int age;
        transient private Person mother;
        transient private Person father;
        transient private List<Person> children;

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

        // @Override  - мое исправление
        public void writeExternal(ObjectOutput out) throws IOException, InvalidClassException {
            out.writeChars(firstName);
            out.writeChars(lastName);
            out.writeInt(age);
            out.writeObject(father);
            out.writeObject(mother);
            out.writeObject(children);
        }

        // @Override -  - мое исправление
        public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
            firstName = in.readLine();
            lastName = in.readLine();
            age = in.readInt();
            father = (Person)in.readObject();
            mother = (Person)in.readObject();
            children = (List)in.readObject();
        }
    }

    public static void main(String[] args) throws Exception {

        /*File fileName = new File("E:/test/5.txt");
        Person person = new Person("firstName", "lastName", 23);
        //Serializing the singleton instance
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName));
        oos.writeObject(person);
        oos.close();

        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName));
        Person loadedPerson = (Person) ois.readObject();
        System.out.println(loadedPerson.firstName + " : " + loadedPerson.lastName + " : " + loadedPerson.age);
        ois.close();*/
    }
}
