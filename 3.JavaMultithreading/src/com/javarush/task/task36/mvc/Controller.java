package com.javarush.task.task36.mvc;

import com.javarush.task.task36.mvc.model.DBLayer;
import com.javarush.task.task36.mvc.model.FileSystemLayer;
import com.javarush.task.task36.mvc.model.ModelLayer;
import com.javarush.task.task36.mvc.view.ConsoleView;
import com.javarush.task.task36.mvc.view.HtmlView;
import com.javarush.task.task36.mvc.view.View;

public class Controller {
    ModelLayer modelLayer = new DBLayer();
    ModelLayer modelLayer1 = new FileSystemLayer();
    View view = new ConsoleView();
    View view1 = new HtmlView();

    void execute() {
        Student student = modelLayer.getStudent();
        student.setName("Stepan");
        student.setAge(13);
        view1.showStudent(student);
    }
}
