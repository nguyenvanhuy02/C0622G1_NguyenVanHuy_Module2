package casestudy.controller;

import java.util.Scanner;

public class EmployeeManagement {
    Scanner scanner = new Scanner(System.in);

    public void employeeManagement() {
        comeBank:
        while (true) {
            int choice;
            System.out.println("-------Quản lý nhân viên------" +
                    "1. Hiển thị danh sách\n" +
                    "2 Thêm nhân viên mới\n" +
                    "3 Chỉnh sửa nhân viên\n" +
                    "4 Quay lại");
            System.out.print("Lựa chọn của bạn (1->4): ");
            choice = Integer.parseInt(scanner.nextLine());
            switch (choice){
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
