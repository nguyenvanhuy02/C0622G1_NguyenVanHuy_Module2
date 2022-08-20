package exercise_mvc.exercise1.controller;

import exercise_mvc.exercise1.service.IStudentService1;
import exercise_mvc.exercise1.service.ITeacherService;
import exercise_mvc.exercise1.service.impl.StudentService1;
import exercise_mvc.exercise1.service.impl.TeacherService;


import java.util.Scanner;

public class ManagerController {
    private static IStudentService1 studentService1 = new StudentService1();
    private static ITeacherService teacherService = new TeacherService();
    private static Scanner scanner = new Scanner(System.in);

    public void manuManager() {
        while (true) {
            int choice = 0;
            try {
                System.out.println("-----------------------------------");
                System.out.println("Chào mừng bạn đến với danh sách quản lí học sinh và giảng viên");
                System.out.println("1.Giảng viên");
                System.out.println("2.Học sinh");
                System.out.println("3.Thoát");
                System.out.print("Chọn chức (1->3): ");
                choice = Integer.parseInt(scanner.nextLine());

            } catch (NumberFormatException e) {
                System.out.println("Chắc năng bạn chọn không hợp lệ , vui lòng bạn chọn lại!");
            }
            switch (choice) {
                case 1:
                    boolean isLoop = true;
                    int choices;
                    while (isLoop) {
                        System.out.println("-----------Giảng viên:------------");
                        System.out.println("1.Thêm Mới giảng viên");
                        System.out.println("2.Xoá giảng viên");
                        System.out.println("3.Tìm giảng viên");
                        System.out.println("4.Chỉnh sửa thông tin giảng viên");
                        System.out.println("5.Sắp xếp");
                        System.out.println("6.Danh sách giảng viên");
                        System.out.println("7.Quay lại");
                        System.out.print("Chọn 1->7: ");
                        choices = Integer.parseInt(scanner.nextLine());
                        switch (choices) {
                            case 1:
                                System.out.println("Nhập thông tin giảng viên:");
                                teacherService.insetTeacher();
                                break;
                            case 2:
                                teacherService.deleTeacherService();
                                break;
                            case 3:
                                comeBack:
                                while (true) {
                                    System.out.println("----------Tìm Kiếm-----------\n" +
                                            "1.Tìm kiếm bằng tên.\n" +
                                            "2.Tìm kiếm bằng id.\n" +
                                            "3.Quay lại.");
                                    choices = Integer.parseInt(scanner.nextLine());
                                    switch (choices) {
                                        case 1:
                                            teacherService.nameTeacherService();
                                            break;
                                        case 2:
                                            teacherService.idTeacherService();
                                            break;
                                        case 3:
                                            break comeBack;
                                        default:
                                            System.out.println("Lựa chọn của bạn không hợp lệ vui lòng nhập lại!");
                                    }
                                }
                                break;
                            case 4:
                                teacherService.editTeacherService();
                                break;
                            case 5:
                                comeBank:
                                while (true) {
                                    System.out.println(
                                            "-----------------Tìm kiếm--------------\n" +
                                                    "1.Tìm kiếm bằng tên.\n" +
                                                    "2.Tìm kiếm bằng id.\n" +
                                                    "3.Quay lại.");
                                    choice = Integer.parseInt(scanner.nextLine());
                                    switch (choice) {
                                        case 1:
                                            teacherService.sortNameTeacher();
                                            break;
                                        case 2:
                                            teacherService.sortIDTeacher();
                                            break;
                                        case 3:
                                            break comeBank;
                                        default:
                                            System.out.println("Lựa chọn của bạn không hợp lệ vui lòng nhập lại!");
                                    }
                                }
                                break;
                            case 6:
                                teacherService.showListTeacher();
                                break;
                            case 7:
                                isLoop = false;
                                break;
                            default:
                                System.out.println("Lựa chọn của bạn không phù hợp ");
                        }
                    }
                    break;
                case 2:
                    boolean isloop1 = true;
                    while (isloop1) {
                        System.out.println("--------------Học Sinh-------------");
                        System.out.println("1.Thêm mới học sinh");
                        System.out.println("2.Xoá học sinh");
                        System.out.println("3.Tìm kiếm học sinh");
                        System.out.println("4.Chỉnh sửa thông tin học sinh");
                        System.out.println("5.Sắp xếp");
                        System.out.println("6.Danh sách học sinh");
                        System.out.println("7.Quay lại");
                        System.out.print("Chọn 1->6: ");
                        int choice1 = Integer.parseInt(scanner.nextLine());
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
                                    System.out.println(
                                            "-----------------Tìm kiếm--------------\n" +
                                                    "1.Tìm kiếm bằng tên.\n" +
                                                    "2.Tìm kiếm bằng id.\n" +
                                                    "3.Quay lại.");
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
                                }
                                break;
                            case 4:
                                studentService1.editStudent();
                                break;
                            case 5:
                                comeBack:
                                while (true) {
                                    System.out.println("----------Sắp xếp------------\n" +
                                            "1.Sắp xếp theo tên.\n" +
                                            "2.Sắp xếp theo điểm.\n" +
                                            "3.Quay lại");
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
                    }
                    break;
                case 3:
                    System.out.println("---Hoàn thành công việc----");
                    return;
                default:
                    System.out.println("Lựa chọn của bạn nhập vào không phù hợp!");
            }
        }
    }
}
