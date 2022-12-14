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
        System.out.println("Th??m nh??n vi??n m???i th??nh c??ng!");
        WirteFile.writeEmployee(PATH_FILE,employees);
    }


    @Override
    public void editService() throws IOException {
        employees = ReadFile.readEmployeeFile(PATH_FILE);
        Employee employee = this.searchCode();
        if (employee == null) {
            System.out.println("Kh??ng t??m th???y nh??n vi??n b???n c???n ch???nh s???a!");
        } else {
            comeBank:
            while (true) {
                int choice;
                System.out.println(employee.toString());
                System.out.println("------L???a ch???n ch???nh s???a------\n" +
                        "1.M?? nh??n vi??n\n" +
                        "2.T??n nh??n vi??n\n" +
                        "3.Ng??y sinh nh??n vi??n\n" +
                        "4.Gi???i t??nh nh??n vi??n\n" +
                        "5.CCCD\n" +
                        "6.S??? ??i???n tho???i\n" +
                        "7.Email\n" +
                        "8.Tr??nh ????? nh??n vi??n\n" +
                        "9.V??? tr?? nh??n vi??n\n" +
                        "10.L????ng nh??n vi??n\n" +
                        "11.Quay l???i");
                System.out.println("M???i b???n l???a ch???n: ");
                choice = Integer.parseInt(scanner.nextLine());
                switch (choice) {
                    case 1:
                        employee.setCode(getEdit("m?? nh??n vi??n"));
                        break;
                    case 2:
                        employee.setName(getEdit("t??n nh??n vi??n"));
                        break;
                    case 3:
                        employee.setDateOfBirth(getEdit("ng??y sinh"));
                        break;
                    case 4:
                        employee.setGender(getEdit("gi???i t??nh"));
                        break;
                    case 5:
                        employee.setCitizenship(getEdit("CCCD"));
                        break;
                    case 6:
                        employee.setPhoneNumber(getEdit("s??? ??i???n tho???i"));
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
                        employee.setWage(Double.parseDouble(getEdit("l????ng")));
                        break;
                    case 11:
                        break comeBank;
                    default:
                        System.out.println("L???a ch???n c???a b???n kh??ng h???p l??? vui l??ng ch???n l???i!");
                }
                WirteFile.writeEmployee(PATH_FILE,employees);
                System.out.println("Ch???nh s???a th??nh c??ng!");
                System.out.println(
                        "---B???n c?? mu???n ti???p t???c ch???nh s???a---\n" +
                                "1.C??\n" +
                                "2.Kh??ng");
                System.out.print("l???a ch???n c???a b???n: ");
                choice = Integer.parseInt(scanner.nextLine());
                if (!(choice == 1)) {
                    return;
                }
            }
        }
    }

    public String getEdit(String string) {
        System.out.print("M???i b???n nh???p " + string + " m???i: ");
        return scanner.nextLine();
    }

    public static Employee searchCode() {
        System.out.print("M???i b???n nh???p m?? nh??n vi??n mu???n t??m: ");
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
                System.out.print("M???i b???n nh???p m?? nh??n vi??n: ");
                code = scanner.nextLine();
                break;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }

        String name;
        while (true) {
            try {
                System.out.print("M???i b???n nh???p t??n nh??n vi??n: ");
                name = scanner.nextLine();
                String regex = "^\\p{Lu}\\p{Ll}+(\\s\\p{Lu}\\p{Ll}+)*$";
                if (!(name.matches(regex))) {
                    throw new NameException("T??n b???n nh???p kh??ng h???p l??? vui l??ng nh???p l???i!");
                }
                if (!(name.matches("\\D{5,50}"))){
                    throw new NameException("T??n b???n nh???p kh??ng h???p l??? vui l??ng nh???p l???i!");
                }
                break;
            } catch (NameException e) {
                System.out.println(e.getMessage());
            }
        }

//        String dateOfBirth;
//        while (true) {
//            try {
//                System.out.print("M???i b???n nh???p ng??y sinh(dd/MM/yyy): ");
//                dateOfBirth = scanner.nextLine();
//                String regex = "([0-2][0-9]||3[0-1])/(0[0-9]||1[0-2])/([0-9][0-9])?[0-9][0-9]";
//                if (!(dateOfBirth.matches(regex))) {
//                    throw new DateOfBirthException("B???n nh???p kh??ng ????ng ?????nh d???ng vui l??ng nh???p l???i!");
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
                System.out.print("M???i b???n nh???p nh???p ngay sinh theo dd/MM/yyyy: ");
                day = scanner.nextLine();
                dateOfBirth = LocalDate.parse(day, DateTimeFormatter.ofPattern("dd/MM/uuuu").withResolverStyle(ResolverStyle.STRICT));
                Period periodToNextJavaRelease = Period.between(dateOfBirth, dateNow);
                if (periodToNextJavaRelease.getYears() < 100 && periodToNextJavaRelease.getYears() > 18) {
                    break;
                }
                check = false;
                System.out.println("B???n nh???p kh??ng ????ng ?????nh d???ng vui l??ng nh???p l???i! ");
            } catch (DateTimeParseException e) {
                System.out.println("B???n nh???p kh??ng ????ng ?????nh d???ng vui l??ng nh???p l???i! ");
                check = false;
            }
        } while (!check);


        String gender;
        while (true) {
            try {
                System.out.print("M???i b???n nh???p gi???i t??nh(Nam/N???): ");
                gender = scanner.nextLine();
                if (!(gender.matches("Nam|nam")) && !(gender.matches("N???|nu"))) {
                    throw new GenderException("B???n nh???p kh??ng h???p l??? vui l??ng nh???p l???i!");
                }
                break;
            } catch (GenderException e) {
                System.out.println(e.getMessage());
            }
        }
        String citizenship;
        while (true) {
            try {
                System.out.print("M???i b???n nh???p CCCD (12 s???): ");
                citizenship = scanner.nextLine();
                String regex = "[0-9]{12}";
                if (!(citizenship.matches(regex))) {
                    throw new CitizenshipException("B???n nh???p kh??ng ????ng vui l??ng nh???p l???i!");
                }
                break;
            } catch (CitizenshipException e) {
                System.out.println(e.getMessage());
            }
        }

        String phoneNumber;
        while (true) {
            try {
                System.out.print("M???i b???n nh???p s??? ??i???n tho???i: ");
                phoneNumber = scanner.nextLine();
                String regex = "[0][0-9]{9}";
                if (!(phoneNumber.matches(regex))) {
                    throw new PhoneNumberException("S??? ??i???n tho???i b???n nh???p kh??ng h???p l??? vui l??ng nh???p l???i!");
                }
                break;
            } catch (PhoneNumberException e) {
                System.out.println(e.getMessage());
            }
        }

        String email;
        while (true) {
            try {
                System.out.print("M???i b???n nh???p email: ");
                email = scanner.nextLine();
                String regex = "[A-Za-z0-9]+[A-Za-z0-9]*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)";
                if (!(email.matches(regex))) {
                    throw new EmailException("Email b???n nh???p sai vui l??ng nh???p l???i!");
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
                System.out.print("M???i b???n nh???p l????ng: ");
                wage = Double.parseDouble(scanner.nextLine());
                if (!(wage > 0)){
                    throw new CheckWageException("Nh???p kh??ng h???p l??? vui l??ng nh???p l???i!");
                }
                break;
            }catch (NumberFormatException e){
                System.out.println("Nh???p kh??ng ????ng d???ng vui l??ng nh???p l???i!");
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
                System.out.print("M???i b???n l???a ch???n v??? tr??:\n" +
                        "1.L??? t??n\n" +
                        "2.Ph???c v???\n" +
                        "3.Chuy??n vi??n\n" +
                        "4.Gi??m s??t\n" +
                        "5.Qu???n l??\n" +
                        "6.Gi??m ?????c\n");
                System.out.print("Vui l??ng ch???n tr??nh ????? c???a b???n: ");
                choice = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("L???a ch???n c???a b???n kh??ng ph?? h???p vui l??ng ch???n l???i!");
                continue;
            }
            switch (choice) {
                case 1:
                    return levell += "L??? t??n";
                case 2:
                    return levell += "Ph???c v???";
                case 3:
                    return levell += "Chuy??n vi??n";
                case 4:
                    return levell += "Gi??m s??t";
                case 5:
                    return levell += "Qu???n l??";
                case 6:
                    return levell += "Gi??m ?????c";
                default:
                    System.out.println("l???a ch???n b???n kh??ng ph?? h???p!");
            }
        }
    }

    public static String employeeLevel() {
        int choice;
        String levell = "";
        while (true) {
            try {
                System.out.print("M???i b???n l???a ch???n tr??nh ?????:\n" +
                        "1.Trung c???p\n" +
                        "2.Cao ?????ng\n" +
                        "3.?????i h???c\n" +
                        "4.Sau ?????i h???c\n");
                System.out.print("Vui l??ng ch???n tr??nh ????? c???a b???n: ");
                choice = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("L???a ch???n c???a b???n kh??ng ph?? h???p vui l??ng ch???n l???i!");
                continue;
            }
            switch (choice) {
                case 1:
                    return levell += "Trung c???p";
                case 2:
                    return levell += "Cao ?????ng";
                case 3:
                    return levell += "?????i h???c";
                case 4:
                    return levell += "Sau ?????i h???c";
                default:
                    System.out.println("l???a ch???n b???n kh??ng ph?? h???p!");
            }
        }
    }
}
