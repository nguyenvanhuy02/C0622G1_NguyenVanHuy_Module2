package casestudy.service.impl;

import casestudy.model.Booking;
import casestudy.model.person.Customer;
import casestudy.service.IBookingService;

import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class BookingService implements IBookingService {
    private static Scanner scanner = new Scanner(System.in);
    private static Set<Booking> bookings = new TreeSet<>();
    @Override
    public void addBooking() {
        Customer customer = new Customer();
        
    }

    @Override
    public void displayBooking() {
        for (Booking booking : bookings){
            System.out.println(booking);
        }
    }

    public static Booking infoBooking(){
        String code;
        while (true) {
            try {
                System.out.print("Mời bạn nhập mã booking: ");
                code = scanner.nextLine();
                break;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        System.out.println("Nhập ngày bắt đầu: ");
        String startDay = scanner.nextLine();
        System.out.println("Nhập ngày kết thúc: ");
        String endDay = scanner.nextLine();
        System.out.println("Mã khác hàng");
        String codeCustomer = scanner.nextLine();
        System.out.println("Tên dịch vụ: ");
        String serviceName = scanner.nextLine();
        System.out.println("Kiểu dịch vụ");
        String serviceType = scanner.nextLine();

        Booking booking = new Booking(code,startDay,endDay,codeCustomer,serviceName,serviceType);
        return booking;
    }
}
