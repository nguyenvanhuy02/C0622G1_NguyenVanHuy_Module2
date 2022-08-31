package casestudy.controller;

import casestudy.service.ICustomerService;
import casestudy.service.impl.CustomerService;

import java.io.IOException;
import java.util.Scanner;

public class CustomerManagement {
    Scanner scanner = new Scanner(System.in);
    private static final ICustomerService customer = new CustomerService();

    public void customerManagement() throws IOException {
        comeBank:
        while (true) {
            int choice;
            System.out.println("--------Quản lí khách hàng--------\n" +
                    "1. Hiển thị danh sách khách hàng\n" +
                    "2. Thêm khách hàng mới\n" +
                    "3. Chỉnh sửa khách hàng\n" +
                    "4. Quay lại");
            System.out.print("Lựa chọn của bạn(1->4): ");
            choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    customer.disPlayCustomerSevice();
                    break;
                case 2:
                    customer.addCustomerSevice();
                    break;
                case 3:
                    customer.editCustomerSevic();
                    break;
                case 4:
                    break comeBank;
                default:
                    System.out.println("Lựa chọn của bạn không hợp lệ vui lòng chọn lại!");
            }
        }
    }
}
