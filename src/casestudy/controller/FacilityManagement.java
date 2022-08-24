package casestudy.controller;

import java.util.Scanner;

public class FacilityManagement {
    Scanner scanner = new Scanner(System.in);

    public void facilityManagement() {
        comeBank:
        while (true) {
            int choice;
            System.out.println("-------Quản lí cơ sở------\n" +
                    "1 Hiển thị danh sách cơ sở\n" +
                    "2 Thêm cơ sở mới\n" +
                    "3 Hiển thi danh sách cơ sở bảo trì\n" +
                    "4 Quay lại");
            System.out.print("Lựa chọn của bạn(1->4): ");
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
                    System.out.println("Lựa chọn của bạn không phù hợp vui lòng nhập lại!");
            }
        }
    }
}
