package com.javarush.task.task29.task2909.human;

import java.util.ArrayList;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        Student student1 = new Student("name1", 20, 4.4);
        Student student2 = new Student("name2", 20, 3.8);
        Student student3 = new Student("name3", 20, 4.0);
        Student student4 = new Student("name4", 20, 4.2);
        Student student5 = new Student("name5", 20, 4.1);
        Student student6 = new Student("name6", 20, 3.9);

        University university = new University("univarsity", 50);

        List<Student> students = new ArrayList<>();
        students.add(student1);
        students.add(student2);
        students.add(student3);
        students.add(student4);
        students.add(student5);
        students.add(student6);

        university.setStudents(students);

        //System.out.println(university.getStudentWithMaxAverageGrade().getName());
        //System.out.println(university.getStudentWithMinAverageGrade().getName());
        university.expel(university.getStudentWithMinAverageGrade());

        for (Student student :students) {
            System.out.println(student.getName());
        }

    }
}
