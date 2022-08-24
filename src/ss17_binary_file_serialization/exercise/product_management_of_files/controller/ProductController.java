package ss17_binary_file_serialization.exercise.product_management_of_files.controller;

import ss17_binary_file_serialization.exercise.product_management_of_files.service.IProductService;
import ss17_binary_file_serialization.exercise.product_management_of_files.service.ProductService;

import java.io.IOException;
import java.util.Scanner;

public class ProductController {
    private static Scanner scanner = new Scanner(System.in);
    private IProductService productService = new ProductService();

    public void manuProduct() throws IOException, ClassNotFoundException {
        int choice;
        while (true) {
            System.out.println("-------Quản lí sản phẩm---------\n" +
                    "1. Thêm Sản phẩm\n" +
                    "2. Hiển thị sản phẩm\n" +
                    "3. Tìm kiếm sản phẩm\n" +
                    "4. Thoát");
            System.out.print("Lựa chọn của bạn: ");
            choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    productService.addProductService();
                    break;
                case 2:
                    productService.disPlayProductService();
                    break;
                case 3:
                    productService.searchProductService();
                    break;
                case 4:
                    return;
                default:
                    System.out.println("Lựa chọn của bạn không phù hợp vui lòng chọn lại!");
            }
        }
    }
}
