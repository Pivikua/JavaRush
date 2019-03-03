package com.javarush.task.task36.mvc.view;

import com.javarush.task.task36.mvc.Student;

public class HtmlView implements View {
    @Override
    public void showStudent(Student student) {
        System.out.println("<html><body>Student name: " + student.getName() + " age: " + student.getAge() + "</body></html>");
    }
}
