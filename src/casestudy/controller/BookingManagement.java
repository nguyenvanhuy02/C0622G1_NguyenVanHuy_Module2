package casestudy.controller;

import casestudy.service.IBookingService;
import casestudy.service.impl.BookingService;

import java.util.Scanner;

public class BookingManagement {
    Scanner scanner = new Scanner(System.in);
    private static final IBookingService booking = new BookingService();
    public void bookingManagement() {
        comeBank:
        while (true) {
            int choice;
            System.out.println("-------Quản lí đặt phòng------\n" +
                    "1. Thêm phòng mới\n" +
                    "2. Hiển thị danh sách phòng \n" +
                    "3. Tạo mới hợp đồng\n" +
                    "4. Hiển thị danh sách hợp đồng\n" +
                    "5. Chỉnh sửa hợp đồng\n" +
                    "6. Quay lại");
            System.out.print("Lựa chọn của bạn(1->6): ");
            choice = Integer.parseInt(scanner.nextLine());
            switch (choice){
                case 1:
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    break;
                case 6:
                    break comeBank;
                default:
                    System.out.println("Lựa chọn của bạn không hợp lệ vui lòng nhập lịa!");
            }
        }
    }
}
