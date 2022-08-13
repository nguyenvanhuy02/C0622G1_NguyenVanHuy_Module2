package exercise_mvc.exercise1.view;

import exercise_mvc.exercise1.controller.ManagerController;

public class MainView {
    public static void main(String[] args) {
        ManagerController managerController = new ManagerController();
        managerController.manuManager();
    }
}
