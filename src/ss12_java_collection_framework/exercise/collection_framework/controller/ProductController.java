package ss12_java_collection_framework.exercise.collection_framework.controller;

import ss12_java_collection_framework.exercise.collection_framework.service.IProductSrvice;
import ss12_java_collection_framework.exercise.collection_framework.service.ProductService;

import java.util.Scanner;

public class ProductController {
    private IProductSrvice productSrvice = new ProductService();
    private Scanner scanner = new Scanner(System.in);
    int choice = 0;
    public void manuProduct() {
        do{
            System.out.println("--------------------------------");
            System.out.println("Quản lý sản phẩm");
            System.out.println(
                    "1.Thêm sản phẩm\n" +
                    "2.Sửa thông tin sản phẩm theo id\n" +
                    "3.Xoá sản phẩm theo id\n" +
                    "4.Hiển thị danh sách sản phẩm\n" +
                    "5.Tìm kiếm sản phẩm theo tên\n" +
                    "6.Sắp xếp sản phẩm tăng dần, giảm dần theo giá\n"+
                    "0.Thoát "
            );
            System.out.print("Người dùng lựa chọn(0->6): ");
            choice = Integer.parseInt(scanner.nextLine());

            if (choice==1){
                productSrvice.addProductSrvice();
            }else if (choice==2){
                productSrvice.fixProductSrvice();
            }else if (choice==3){
                productSrvice.dellProductSrvice();
            }else if (choice==4){
                productSrvice.disPlayProductSrvice();
            }else if (choice==5){
                productSrvice.searchProductSrvice();
            }else if (choice==6){
                productSrvice.sortProductSrvice();
            }else {
                System.out.println("Vui lòng nhập lại lựa chọn của bạn!");
            }

        }while (choice!=0);
    }
}
