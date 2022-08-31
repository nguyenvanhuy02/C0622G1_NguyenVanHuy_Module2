package casestudy.view;

import casestudy.controller.FuramaController;

import java.io.IOException;

public class MainView {
    public static void main(String[] args) throws IOException {
        FuramaController furamaController = new FuramaController();
        furamaController.displayMainMenu();
    }
}
