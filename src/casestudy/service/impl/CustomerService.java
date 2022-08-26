package casestudy.service.impl;

import casestudy.model.person.Customer;
import casestudy.model.person.Employee;
import casestudy.service.ICustomerService;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CustomerService implements ICustomerService {
    private static Scanner scanner = new Scanner(System.in);
    static List<Customer> customers = new ArrayList<>();
    static {
        customers.add(new Customer("15","Nguyễn Văn Huy","11/12/2003","nam",15201,123568,"maohuy112","khách mời","địa chỉ"));
    }

    @Override
    public void disPlayCustomerSevice() {
        for (Customer customer : customers){
            System.out.println(customer);
        }
    }

    @Override
    public void addCustomerSevice() {
        Customer customer = this.addCustomer();
        customers.add(customer);
        System.out.println("Thêm mới khách hàng thành công!");
    }

    @Override
    public void editCustomerSevic() {
        Customer customer = this.searchCode();
        if (customer == null) {
            System.out.println("Không tìm thấy nhân viên bạn cần chỉnh sửa!");
        } else {
            comeBank:
            while (true) {
                int choice;
                System.out.println(customer.toString());
                System.out.println("------Lựa chọn chỉnh sửa------\n" +
                        "1.Mã nhân viên\n" +
                        "2.Tên nhân viên\n" +
                        "3.Ngày sinh nhân viên\n" +
                        "4.Giới tính nhân viên\n" +
                        "5.CCCD\n" +
                        "6.Số điện thoại\n" +
                        "7.Email\n" +
                        "8.Khách mời\n" +
                        "9.Địa chỉ\n" +
                        "10.Quay lại");
                System.out.println("Mời bạn lựa chọn: ");
                choice = Integer.parseInt(scanner.nextLine());
                switch (choice) {
                    case 1:
                        customer.setCode(getEdit("mã nhân viên"));
                        break;
                    case 2:
                        customer.setName(getEdit("tên nhân viên"));
                        break;
                    case 3:
                        customer.setDateOfBirth(getEdit("ngày sinh"));
                        break;
                    case 4:
                        customer.setGender(getEdit("giới tính"));
                        break;
                    case 5:
                        customer.setCitizenship(Integer.parseInt(getEdit("CCCD")));
                        break;
                    case 6:
                        customer.setPhoneNumber(Integer.parseInt(getEdit("số điện thoại")));
                        break;
                    case 7:
                        customer.setEmail(getEdit("email"));
                        break;
                    case 8:
                        customer.setGuest("khách mời");
                        break;
                    case 9:
                        customer.setAddress("địa chỉ");
                        break;
                    case 10:
                        break comeBank;
                    default:
                        System.out.println("Lựa chọn của bạn không hợp lệ vui lòng chọn lại!");
                }
                System.out.println("Chỉnh sửa thành công!");
                System.out.println(
                        "---Bạn có muốn tiếp tục chỉnh sửa---\n" +
                                "1.Có\n" +
                                "2.Không");
                System.out.print("lựa chọn của bạn: ");
                choice = Integer.parseInt(scanner.nextLine());
                if (!(choice == 1)){
                    return;
                }
            }
        }
    }
    public String getEdit(String string) {
        System.out.print("Mời bạn nhập " + string + " mới: ");
        return scanner.nextLine();
    }

    public static Customer searchCode() {
        System.out.print("Mời bạn nhập mã khách hàng muốn tìm: ");
        String codeCustomer = scanner.nextLine();
        for (Customer customer : customers) {
            if (customer.getCode().equals(codeCustomer)) {
                return customer;
            }
        }
        return null;
    }

    public static Customer addCustomer() {
        System.out.print("Mời bạn nhập mã khác hàng: ");
        String code = scanner.nextLine();
        System.out.print("Mời bạn nhập tên khách hàng: ");
        String name = scanner.nextLine();
        System.out.print("Mời bạn nhập ngày sinh khách hàng: ");
        String dateOfBirth = scanner.nextLine();
        System.out.print("Mời bạn nhập giới tính(Nam/Nữ): ");
        String gender = scanner.nextLine();
        System.out.print("Mời bạn nhập CCCD: ");
        int citizenship = Integer.parseInt(scanner.nextLine());
        System.out.print("Mời bạn nhập số điện thoại: ");
        int phoneNumber = Integer.parseInt(scanner.nextLine());
        System.out.print("Mời bạn nhập email: ");
        String email = scanner.nextLine();
        System.out.print("Mời nhập khách mời: ");
        String guest = scanner.nextLine();
        System.out.print("Mời nhập địa chỉ: ");
        String address = scanner.nextLine();

        Customer customer = new Customer(code, name, dateOfBirth, gender, citizenship, phoneNumber, email, guest, address);
        return customer;
    }
}
