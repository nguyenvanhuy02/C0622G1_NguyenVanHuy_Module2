package casestudy.service.impl;

import casestudy.model.person.Employee;
import casestudy.service.IEmployeeService;
import casestudy.service.exception.*;
import casestudy.service.read_write.ReadFile;
import casestudy.service.read_write.WirteFile;

import java.io.IOException;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.format.ResolverStyle;
import java.util.List;
import java.util.Scanner;

public class EmployeeService implements IEmployeeService {
    private static Scanner scanner = new Scanner(System.in);
    static List<Employee> employees;
    private static final String PATH_FILE ="src/casestudy/service/data/fileEmployee.csv";



    @Override
    public void disPlayService() throws IOException {
        employees = ReadFile.readEmployeeFile(PATH_FILE);
//        String propertyOfEmployee;
//        String showPropertyOFE;
//        showPropertyOFE = showPOfE();
////        System.out.println(showPropertyOFE);
//        for (Employee employee : employees) {
//            propertyOfEmployee = convertProperty(employee.toString());
//
//            System.out.println(propertyOfEmployee);
//        }
        for (Employee employee : employees){
            System.out.println(employee);
        }
    }

//    private String showPOfE() {
//      return String.format("|%-20s||%-20s||%-20s||%-20s||%-10s||%-10s||%-20s||%-20s||%-20s||%-12s|",
//                "ID", "NAME", "DAY OF BIRTH", "GENDER", "IDENTITY",
//                "PHONE NUMBER", "EMAIL", "LeVEL", "POSITION", "SALARY");
//    }

//    private String convertProperty(String pEString) {
//        String[] propertyE = pEString.split(",");
//        StringBuilder result = new StringBuilder();
//        for(String p : propertyE) {
//            result.append(p);
//        }
//        return result.toString();
//    }

    @Override
    public void addService() throws IOException {
        employees = ReadFile.readEmployeeFile(PATH_FILE);
        Employee employee = this.addEmloyee();
        employees.add(employee);
        System.out.println("Thêm nhân viên mới thành công!");
        WirteFile.writeEmployee(PATH_FILE,employees);
    }


    @Override
    public void editService() throws IOException {
        employees = ReadFile.readEmployeeFile(PATH_FILE);
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
                        employee.setCitizenship(getEdit("CCCD"));
                        break;
                    case 6:
                        employee.setPhoneNumber(getEdit("số điện thoại"));
                        break;
                    case 7:
                        employee.setEmail(getEdit("email"));
                        break;
                    case 8:
                        employee.setLevel(employeeLevel());
                        break;
                    case 9:
                        employee.setLocation(employeeLocation());
                        break;
                    case 10:
                        employee.setWage(Double.parseDouble(getEdit("lương")));
                        break;
                    case 11:
                        break comeBank;
                    default:
                        System.out.println("Lựa chọn của bạn không hợp lệ vui lòng chọn lại!");
                }
                WirteFile.writeEmployee(PATH_FILE,employees);
                System.out.println("Chỉnh sửa thành công!");
                System.out.println(
                        "---Bạn có muốn tiếp tục chỉnh sửa---\n" +
                                "1.Có\n" +
                                "2.Không");
                System.out.print("lựa chọn của bạn: ");
                choice = Integer.parseInt(scanner.nextLine());
                if (!(choice == 1)) {
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

        String code;
        while (true) {
            try {
                System.out.print("Mời bạn nhập mã nhân viên: ");
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


        String gender;
        while (true) {
            try {
                System.out.print("Mời bạn nhập giới tính(Nam/Nữ): ");
                gender = scanner.nextLine();
                if (!(gender.matches("Nam|nam")) && !(gender.matches("Nữ|nu"))) {
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
        String level = employeeLevel();

        String location = employeeLocation();

        Double wage;
        while (true){
            try {
                System.out.print("Mời bạn nhập lương: ");
                wage = Double.parseDouble(scanner.nextLine());
                if (!(wage > 0)){
                    throw new CheckWageException("Nhập không hợp lệ vui lòng nhập lại!");
                }
                break;
            }catch (NumberFormatException e){
                System.out.println("Nhập không đúng dạng vui lòng nhập lại!");
            }catch (CheckWageException e){
                System.out.println(e.getMessage());
            }
        }



        Employee employee = new Employee(code, name, day, gender, citizenship, phoneNumber, email, level, location, wage);
        return employee;
    }

    public static String employeeLocation() {
        int choice;
        String levell = "";
        while (true) {
            try {
                System.out.print("Mời bạn lựa chọn vị trí:\n" +
                        "1.Lễ tân\n" +
                        "2.Phục vụ\n" +
                        "3.Chuyên viên\n" +
                        "4.Giám sát\n" +
                        "5.Quản lý\n" +
                        "6.Giám đốc\n");
                System.out.print("Vui lòng chọn trình độ của bạn: ");
                choice = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Lựa chọn của bạn không phù hợp vui lòng chọn lại!");
                continue;
            }
            switch (choice) {
                case 1:
                    return levell += "Lễ tân";
                case 2:
                    return levell += "Phục vụ";
                case 3:
                    return levell += "Chuyên viên";
                case 4:
                    return levell += "Giám sát";
                case 5:
                    return levell += "Quản lý";
                case 6:
                    return levell += "Giám đốc";
                default:
                    System.out.println("lựa chọn bạn không phù hợp!");
            }
        }
    }

    public static String employeeLevel() {
        int choice;
        String levell = "";
        while (true) {
            try {
                System.out.print("Mời bạn lựa chọn trình độ:\n" +
                        "1.Trung cấp\n" +
                        "2.Cao đẳng\n" +
                        "3.Đại học\n" +
                        "4.Sau đại học\n");
                System.out.print("Vui lòng chọn trình độ của bạn: ");
                choice = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Lựa chọn của bạn không phù hợp vui lòng chọn lại!");
                continue;
            }
            switch (choice) {
                case 1:
                    return levell += "Trung cấp";
                case 2:
                    return levell += "Cao đẳng";
                case 3:
                    return levell += "Đại học";
                case 4:
                    return levell += "Sau đại học";
                default:
                    System.out.println("lựa chọn bạn không phù hợp!");
            }
        }
    }
}
