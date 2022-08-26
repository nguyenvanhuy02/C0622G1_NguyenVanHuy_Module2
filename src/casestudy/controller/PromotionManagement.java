package casestudy.controller;

import casestudy.service.IPromotionService;
import casestudy.service.impl.PromotionService;

import java.util.Scanner;

public class PromotionManagement {
    Scanner scanner = new Scanner(System.in);
    private static final IPromotionService promotion = new PromotionService();
    public void promotionManagement() {
        comeBank:
        while (true) {
            int choice;
            System.out.println("-------Quản lí khuyến mãi--------\n" +
                    "1. Hiển thị danh sách khách hàng sử dụng dịch vụ\n" +
                    "2. Hiển thị danh sách khách hàng nhận được chứng từ\n" +
                    "3. Trả lại menu chính");
            System.out.print("Lựa chọn của bạn(1->3): ");
            choice = Integer.parseInt(scanner.nextLine());
            switch (choice){
                case 1:
                    break;
                case 2:
                    break;
                case 3:
                    break comeBank;
                default:
                    System.out.println("Lựa chọn của bạn không phù hợp vui lòng nhập lại!");
            }
        }
    }
}
