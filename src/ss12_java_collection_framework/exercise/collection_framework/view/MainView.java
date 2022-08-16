package ss12_java_collection_framework.exercise.collection_framework.view;

import ss12_java_collection_framework.exercise.collection_framework.controller.ProductController;

public class MainView {
    public static void main(String[] args) {
        ProductController productController = new ProductController();
        productController.manuProduct();
    }
}
