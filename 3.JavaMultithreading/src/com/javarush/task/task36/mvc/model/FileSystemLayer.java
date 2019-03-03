package com.javarush.task.task36.mvc.model;

import com.javarush.task.task36.mvc.Student;

public class FileSystemLayer implements ModelLayer {
    @Override
    public Student getStudent() {
        return new Student();
    }
}
