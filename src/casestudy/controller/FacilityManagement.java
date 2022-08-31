package casestudy.controller;

import casestudy.service.IFacilityService;
import casestudy.service.impl.FacilityService;

import java.io.IOException;
import java.util.Scanner;

public class FacilityManagement {
    Scanner scanner = new Scanner(System.in);
    private static final IFacilityService facility = new FacilityService();
    public void facilityManagement() throws IOException {
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
                    facility.disPlayFacility();
                    break;
                case 2:
                    facility.addFacility();
                    break;
                case 3:
                    facility.disPlayMaintenance();
                    break;
                case 4:
                    break comeBank;
                default:
                    System.out.println("Lựa chọn của bạn không phù hợp vui lòng nhập lại!");
            }
        }
    }
}
