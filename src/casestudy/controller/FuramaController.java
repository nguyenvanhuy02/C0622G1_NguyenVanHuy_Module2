package casestudy.controller;

import java.util.Scanner;

public class FuramaController {
    private static Scanner scanner = new Scanner(System.in);
    private static final EmployeeManagement employee = new EmployeeManagement();
    private static final CustomerManagement customer = new CustomerManagement();
    private static final FacilityManagement facility = new FacilityManagement();
    private static final BookingManagement booking = new BookingManagement();
    private static final PromotionManagement promotion = new PromotionManagement();

    public void displayMainMenu() {
        while (true) {
            int choice = 0;
            System.out.println(
                    "---------Quản lý Danh sách--------\n" +
                    "1. Quản lý nhân viên\n" +
                    "2. Quản lý khách hàng\n" +
                    "3. Quản lý cơ sở\n" +
                    "4. Quản lý đặt phòng\n" +
                    "5. Quản lý khuyến mãi\n" +
                    "6.Thoát!.");
            System.out.print("lựa chọn của bạn: ");
            choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    employee.employeeManagement();
                    break;
                case 2:
                    customer.customerManagement();
                    break;
                case 3:
                    facility.facilityManagement();
                    break;
                case 4:
                    booking.bookingManagement();
                    break;
                case 5:
                    promotion.promotionManagement();
                    break;
                case 6:
                    return;
                default:
                    System.out.println("Lựa chọn của bạn không phù hợp vui lòng chọn lại!");
            }
        }
    }
}
