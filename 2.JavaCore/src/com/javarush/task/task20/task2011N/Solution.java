package com.javarush.task.task20.task2011N;

import java.io.*;

/*
Externalizable для апартаментов
Реализуй интерфейс Externalizable в классе Apartment.

Требования:
1. Класс Solution.Apartment должен поддерживать интерфейс Externalizable.
2. В классе Solution.Apartment должен быть реализован метод writeExternal с одним параметром типа ObjectOutput.
3. В классе Solution.Apartment должен быть реализован метод readExternal с одним параметром типа ObjectInput.
4. В методе writeExternal, на полученном в качестве параметра объекте типа ObjectOutput должен быть вызван метод writeObject с параметром address.
5. В методе writeExternal, на полученном в качестве параметра объекте типа ObjectOutput должен быть вызван метод writeInt с параметром year.
6. Метод readExternal должен корректно восстанавливать из ObjectInput значение поля address.
7. Метод readExternal должен корректно восстанавливать из ObjectInput значение поля year.
*/
public class Solution {

    public static class Apartment implements Externalizable {

        private String address;
        private int year;

        /**
         * Mandatory public no-arg constructor.
         */
        public Apartment() {
            super();
        }

        public Apartment(String adr, int y) {
            address = adr;
            year = y;
        }

        /**
         * Prints out the fields. used for testing!
         */
        public String toString() {
            return ("Address: " + address + "\n" + "Year: " + year);
        }

        @Override
        public void writeExternal(ObjectOutput out) throws IOException {
            out.writeObject(address);
            out.writeInt(year);
        }

        @Override
        public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
            address = (String) in.readObject();
            year = in.readInt();
        }
    }

    public static void main(String[] args) throws IOException, FileNotFoundException, ClassNotFoundException {
        Apartment apartmentX1 = new Apartment("Kurchatova", 31);
        Apartment apartmentX2 = new Apartment();
        Apartment apartmentX3 = new Apartment();
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("D:\\test\\0.txt"));
        apartmentX1.writeExternal(objectOutputStream);
        apartmentX2.writeExternal(objectOutputStream);
        apartmentX3.writeExternal(objectOutputStream);
        objectOutputStream.close();

        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("D:\\test\\0.txt"));
        Apartment apartment = new Apartment();
        apartment.readExternal(objectInputStream);
        //System.out.println(apartment.address + " " + apartment.year);
        System.out.println(apartmentX1.hashCode());
        System.out.println(apartment.hashCode());
        //System.out.println(apartmentX1.equals(apartment));
        objectInputStream.close();
    }
}
