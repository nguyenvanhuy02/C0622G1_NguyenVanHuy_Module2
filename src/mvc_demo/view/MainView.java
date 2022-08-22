package mvc_demo.view;

import mvc_demo.controller.StudentController;

import java.io.IOException;

public class MainView {
    public static void main(String[] args) throws IOException {
        StudentController studentController = new StudentController();
        studentController.menuManagement();
    }
}
