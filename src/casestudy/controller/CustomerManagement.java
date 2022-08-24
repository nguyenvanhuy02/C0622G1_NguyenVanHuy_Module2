package casestudy.controller;

import java.util.Scanner;

public class CustomerManagement {
    Scanner scanner = new Scanner(System.in);

    public void customerManagement() {
        comeBank:
        while (true) {
            int choice;
            System.out.println("--------Quản lí khách hàng--------" +
                    "1. Hiển thị danh sách khách hàng\n" +
                    "2. Thêm khách hàng mới\n" +
                    "3. Chỉnh sửa khách hàng\n" +
                    "4. Quay lại");
            System.out.print("Lựa chọn của bạn(1->4): ");
            choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break comeBank;
                default:
                    System.out.println("Lựa chọn của bạn không hợp lệ vui lòng chọn lại!");
            }
        }
    }
}
