package ss17_binary_file_serialization.exercise.product_management_of_files.view;

import ss17_binary_file_serialization.exercise.product_management_of_files.controller.ProductController;

import java.io.IOException;

public class MainView {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ProductController productController = new ProductController();
        productController.manuProduct();
    }
}
