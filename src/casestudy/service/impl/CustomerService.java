package casestudy.service.impl;

import casestudy.model.person.Customer;
import casestudy.model.person.Employee;
import casestudy.service.ICustomerService;
import casestudy.service.exception.*;
import casestudy.service.read_write.ReadFile;
import casestudy.service.read_write.WirteFile;

import java.io.IOException;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.format.ResolverStyle;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CustomerService implements ICustomerService {
    private static Scanner scanner = new Scanner(System.in);
    static List<Customer> customers;
    private static final String PATH_FILE = "src/casestudy/service/data/fileCustomer.csv";

    @Override
    public void disPlayCustomerSevice() throws IOException {
        customers = ReadFile.readCustomerFile(PATH_FILE);
        for (Customer customer : customers){
            System.out.println(customer);
        }
    }

    @Override
    public void addCustomerSevice() throws IOException {
        customers = ReadFile.readCustomerFile(PATH_FILE);
        Customer customer = this.addCustomer();
        customers.add(customer);
        System.out.println("Thêm mới khách hàng thành công!");
        WirteFile.writeCustomer(PATH_FILE,customers);
    }

    @Override
    public void editCustomerSevic() throws IOException {
        customers = ReadFile.readCustomerFile(PATH_FILE);
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
                        customer.setCitizenship(getEdit("CCCD"));
                        break;
                    case 6:
                        customer.setPhoneNumber(getEdit("số điện thoại"));
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
                WirteFile.writeCustomer(PATH_FILE,customers);
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
        String code;
        while (true) {
            try {
                System.out.print("Mời bạn nhập mã khách hàng: ");
                code = scanner.nextLine();
                break;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }

        String name;
        while (true) {
            try {
                System.out.print("Mời bạn nhập tên nhân viên: ");
                name = scanner.nextLine();
                String regex = "^\\p{Lu}\\p{Ll}+(\\s\\p{Lu}\\p{Ll}+)*$";
                if (!(name.matches(regex))) {
                    throw new NameException("Tên bạn nhập không hợp lệ vui lòng nhập lại!");
                }
                if (!(name.matches("\\D{5,50}"))){
                    throw new NameException("Tên bạn nhập không hợp lệ vui lòng nhập lại!");
                }
                break;
            } catch (NameException e) {
                System.out.println(e.getMessage());
            }
        }
        String day = null;
        LocalDate dateNow = LocalDate.now();
        boolean check;
        LocalDate dateOfBirth;
        do {
            try {
                System.out.print("Mời bạn nhập nhập ngay sinh theo dd/MM/yyyy: ");
                 day = scanner.nextLine();
                dateOfBirth = LocalDate.parse(day, DateTimeFormatter.ofPattern("dd/MM/uuuu").withResolverStyle(ResolverStyle.STRICT));
                Period periodToNextJavaRelease = Period.between(dateOfBirth, dateNow);
                if (periodToNextJavaRelease.getYears() < 100 && periodToNextJavaRelease.getYears() > 18) {
                    break;
                }
                check = false;
                System.out.println("Bạn nhập không đúng định dạng vui lòng nhập lại! ");
            } catch (DateTimeParseException e) {
                System.out.println("Bạn nhập không đúng định dạng vui lòng nhập lại! ");
                check = false;
            }
        } while (!check);
//        String dateOfBirth;
//        while (true) {
//            try {
//                System.out.print("Mời bạn nhập ngày sinh(dd/MM/yyy): ");
//                dateOfBirth = scanner.nextLine();
//                String regex = "([0-2][0-9]||3[0-1])/(0[0-9]||1[0-2])/([0-9][0-9])?[0-9][0-9]";
//                if (!(dateOfBirth.matches(regex))) {
//                    throw new DateOfBirthException("Bạn nhập không đúng định dạng vui lòng nhập lại!");
//                }
//                break;
//            } catch (DateOfBirthException e) {
//                System.out.println(e.getMessage());
//            }
//        }

        String gender;
        while (true) {
            try {
                System.out.print("Mời bạn nhập giới tính(Nam/Nữ): ");
                gender = scanner.nextLine();
                if (!(gender.matches("Nam".toLowerCase())) && !(gender.matches("Nữ".toLowerCase()))) {
                    throw new GenderException("Bạn nhập không hợp lệ vui lòng nhập lại!");
                }
                break;
            } catch (GenderException e) {
                System.out.println(e.getMessage());
            }
        }
        String citizenship;
        while (true) {
            try {
                System.out.print("Mời bạn nhập CCCD (12 số): ");
                citizenship = scanner.nextLine();
                String regex = "[0-9]{12}";
                if (!(citizenship.matches(regex))) {
                    throw new CitizenshipException("Bạn nhập không đúng vui lòng nhập lại!");
                }
                break;
            } catch (CitizenshipException e) {
                System.out.println(e.getMessage());
            }
        }

        String phoneNumber;
        while (true) {
            try {
                System.out.print("Mời bạn nhập số điện thoại: ");
                phoneNumber = scanner.nextLine();
                String regex = "[0][0-9]{9}";
                if (!(phoneNumber.matches(regex))) {
                    throw new PhoneNumberException("Số điện thoại bạn nhập không hợp lệ vui lòng nhập lại!");
                }
                break;
            } catch (PhoneNumberException e) {
                System.out.println(e.getMessage());
            }
        }

        String email;
        while (true) {
            try {
                System.out.print("Mời bạn nhập email: ");
                email = scanner.nextLine();
                String regex = "[A-Za-z0-9]+[A-Za-z0-9]*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)";
                if (!(email.matches(regex))) {
                    throw new EmailException("Email bạn nhập sai vui lòng nhập lại!");
                }
                break;
            } catch (EmailException e) {
                System.out.println(e.getMessage());
            }
        }

        String guest = guestCustomer();

        System.out.print("Mời nhập địa chỉ: ");
        String address = scanner.nextLine();

        Customer customer = new Customer(code, name, day, gender, citizenship, phoneNumber, email, guest, address);
        return customer;
    }
    public static String guestCustomer(){
        int choice;
        String levell = "";
        while (true) {
            try {
                System.out.print("Mời bạn lựa chọn loại khách:\n" +
                        "1.Kim cương\n" +
                        "2.Bạch kim\n" +
                        "3.Vàng\n" +
                        "4.Bạc\n" +
                        "5.Thành viên\n");
                System.out.print("Vui lòng chọn trình độ của bạn: ");
                choice = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Lựa chọn của bạn không phù hợp vui lòng chọn lại!");
                continue;
            }
            switch (choice) {
                case 1:
                    return levell += "Kim cương";
                case 2:
                    return levell += "Bạch kim";
                case 3:
                    return levell += "Vàng";
                case 4:
                    return levell += "Bạc";
                case 5:
                    return levell += "Thành viên";
                default:
                    System.out.println("lựa chọn bạn không phù hợp!");
            }
        }
    }
}
