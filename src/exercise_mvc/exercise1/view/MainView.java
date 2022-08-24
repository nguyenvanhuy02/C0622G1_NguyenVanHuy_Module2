package exercise_mvc.exercise1.view;

import exercise_mvc.exercise1.controller.ManagerController;

import java.io.IOException;

public class MainView {
    public static void main(String[] args) throws IOException {
        ManagerController managerController = new ManagerController();
        managerController.manuManager();
    }
}
