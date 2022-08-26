package casestudy.service.impl;

import casestudy.model.person.Employee;
import casestudy.service.IEmployeeService;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EmployeeService implements IEmployeeService {
    private static Scanner scanner = new Scanner(System.in);
    static List<Employee> employees = new ArrayList<>();
    static {
        employees.add( new Employee("12","huy","11/12/2003/","nam",123456,01234567,"maohuy123gmail.com","12","cao","123"));
    }

    @Override
    public void disPlayService() {
        for (Employee employee : employees) {
            System.out.println(employee);
        }
    }

    @Override
    public void addService() {
        Employee employee = this.addEmloyee();
        employees.add(employee);
        System.out.println("Thêm nhân viên mới thành công!");
    }


    @Override
    public void editService() {
        Employee employee = this.searchCode();
        if (employee == null) {
            System.out.println("Không tìm thấy nhân viên bạn cần chỉnh sửa!");
        } else {
            comeBank:
            while (true) {
                int choice;
                System.out.println(employee.toString());
                System.out.println("------Lựa chọn chỉnh sửa------\n" +
                        "1.Mã nhân viên\n" +
                        "2.Tên nhân viên\n" +
                        "3.Ngày sinh nhân viên\n" +
                        "4.Giới tính nhân viên\n" +
                        "5.CCCD\n" +
                        "6.Số điện thoại\n" +
                        "7.Email\n" +
                        "8.Trình độ nhân viên\n" +
                        "9.Vị trí nhân viên\n" +
                        "10.Lương nhân viên\n" +
                        "11.Quay lại");
                System.out.println("Mời bạn lựa chọn: ");
                choice = Integer.parseInt(scanner.nextLine());
                switch (choice) {
                    case 1:
                        employee.setCode(getEdit("mã nhân viên"));
                        break;
                    case 2:
                        employee.setName(getEdit("tên nhân viên"));
                        break;
                    case 3:
                        employee.setDateOfBirth(getEdit("ngày sinh"));
                        break;
                    case 4:
                        employee.setGender(getEdit("giới tính"));
                        break;
                    case 5:
                        employee.setCitizenship(Integer.parseInt(getEdit("CCCD")));
                        break;
                    case 6:
                        employee.setPhoneNumber(Integer.parseInt(getEdit("số điện thoại")));
                        break;
                    case 7:
                        employee.setEmail(getEdit("email"));
                        break;
                    case 8:
                        employee.setLevel(getEdit("trình độ"));
                        break;
                    case 9:
                        employee.setLocation(getEdit("vị trí"));
                        break;
                    case 10:
                        employee.setWage(getEdit("lương"));
                        break;
                    case 11:
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

    public static Employee searchCode() {
        System.out.print("Mời bạn nhập mã nhân viên muốn tìm: ");
        String codeEmployee = scanner.nextLine();
        for (Employee employee : employees) {
            if (employee.getCode().equals(codeEmployee)) {
                return employee;
            }
        }
        return null;
    }

    public static Employee addEmloyee() {
        System.out.print("Mời bạn nhập mã nhân viên: ");
        String code = scanner.nextLine();
        System.out.print("Mời bạn nhập tên nhân viên: ");
        String name = scanner.nextLine();
        System.out.print("Mời bạn nhập ngày sinh nhân viên: ");
        String dateOfBirth = scanner.nextLine();
        System.out.print("Mời bạn nhập giới tính(Nam/Nữ): ");
        String gender = scanner.nextLine();
        System.out.print("Mời bạn nhập CCCD: ");
        int citizenship = Integer.parseInt(scanner.nextLine());
        System.out.print("Mời bạn nhập số điện thoại: ");
        int phoneNumber = Integer.parseInt(scanner.nextLine());
        System.out.print("Mời bạn nhập email: ");
        String email = scanner.nextLine();
        System.out.print("Mời bạn nhập trình độ: ");
        String level = scanner.nextLine();
        System.out.print("Mời bạn nhập vị trí: ");
        String location = scanner.nextLine();
        System.out.print("Mời bạn nhập lương: ");
        String wage = scanner.nextLine();

        Employee employee = new Employee(code, name, dateOfBirth, gender, citizenship, phoneNumber, email, level, location, wage);
        return employee;
    }
}
