package exercise_mvc.exercise1.controller;

import exercise_mvc.exercise1.service.IStudentService1;
import exercise_mvc.exercise1.service.impl.StudentService1;

import java.io.IOException;
import java.util.Scanner;

public class StudentController {
    private static final Scanner scanner = new Scanner(System.in);
    private static final IStudentService1 studentService1 = new StudentService1();
    public static void studentController() throws IOException {
        boolean isloop1 = true;
        int choice1;
        while (isloop1) {
            try {
                System.out.println("--------------Học Sinh-------------");
                System.out.println("1.Thêm mới học sinh");
                System.out.println("2.Xoá học sinh");
                System.out.println("3.Tìm kiếm học sinh");
                System.out.println("4.Chỉnh sửa thông tin học sinh");
                System.out.println("5.Sắp xếp");
                System.out.println("6.Danh sách học sinh");
                System.out.println("7.Quay lại");
                System.out.print("Chọn 1->7: ");
                choice1 = Integer.parseInt(scanner.nextLine());
                switch (choice1) {
                    case 1:
                        System.out.println("Nhập thông tin học sinh:");
                        studentService1.insetStudent();
                        break;
                    case 2:
                        studentService1.deleStudent();
                        break;
                    case 3:
                        comeBack:
                        while (true) {
                            try {
                                System.out.println(
                                        "-----------------Tìm kiếm--------------\n" +
                                                "1.Tìm kiếm bằng tên.\n" +
                                                "2.Tìm kiếm bằng id.\n" +
                                                "3.Quay lại.");
                                int choices;
                                System.out.print("Chọn (1->3): ");
                                choices = Integer.parseInt(scanner.nextLine());
                                switch (choices) {
                                    case 1:
                                        studentService1.nameStudent();
                                        break;
                                    case 2:
                                        studentService1.idStundent();
                                        break;
                                    case 3:
                                        break comeBack;
                                    default:
                                        System.out.println("Lựa chọn của bạn không hợp lệ vui lòng nhập lại!");
                                }
                            }catch (NumberFormatException e){
                                System.out.println("Lựa chọn của bạn không hợp lệ !");
                            }
                        }
                        break;
                    case 4:
                        studentService1.editStudent();
                        break;
                    case 5:
                        comeBack:
                        while (true) {
                            try {
                                System.out.println("----------Sắp xếp------------\n" +
                                        "1.Sắp xếp theo tên.\n" +
                                        "2.Sắp xếp theo điểm.\n" +
                                        "3.Quay lại");
                                int choice;
                                System.out.print("Chọn (1->3): ");
                                choice = Integer.parseInt(scanner.nextLine());
                                switch (choice) {
                                    case 1:
                                        studentService1.sortNameStudent();
                                        break;
                                    case 2:
                                        studentService1.sortPointStudent();
                                        break;
                                    case 3:
                                        break comeBack;
                                    default:
                                        System.out.println("Lựa chọn của bạn không hợp lệ vui lòng nhập lại!");
                                }
                            }catch (NumberFormatException e){
                                System.out.println("Lựa chọn của bạn không hợp lệ vui lòng nhập lại!");
                            }
                        }
                        break;
                    case 6:
                        studentService1.showListStudent();
                        break;
                    case 7:
                        isloop1 = false;
                        break;
                    default:
                        System.out.println("Lựa chọn của bạn không phù hợp");
                }
            }catch (NumberFormatException e){
                e.printStackTrace();
                System.out.println("Lựa chọn của bạn không hợp lệ vui lòng chọn lại!");
            }
        }
    }
}
