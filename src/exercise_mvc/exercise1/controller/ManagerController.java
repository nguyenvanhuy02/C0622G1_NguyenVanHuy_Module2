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
            System.out.println("-----------------------------------");
            System.out.println("Chào mừng bạn đến với danh sách quản lí học sinh và giảng viên");
            System.out.println("1.Thêm mới giảng viên hoặc học sinh");
            System.out.println("2.Xoá giảng viên hoặc học sinh");
            System.out.println("3.Xem danh sách giảng viên hoặc học sinh");
            System.out.println("4.Thoát");
            System.out.print("Chọn chức (1->4): ");
            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1:
                    boolean isLoop = true;
                    while (isLoop) {
                        System.out.println("-----------Thêm mới:------------");
                        System.out.println("1.Học Sinh");
                        System.out.println("2.Giảng viên");
                        System.out.println("3.Quay lại");
                        System.out.print("Chọn 1->3: ");
                        int choices = Integer.parseInt(scanner.nextLine());
                        switch (choices) {
                            case 1:
                                System.out.println("Nhập thông tin học sinh:");
                                studentService1.insetStudent();
                                break;
                            case 2:
                                System.out.println("Nhập thông tin giảng viên:");
                                teacherService.insetTeacher();
                                break;
                            case 3:
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
                        System.out.println("--------------Xoá-------------");
                        System.out.println("1.Học sinh");
                        System.out.println("2.Giảng viên");
                        System.out.println("3.Quay lại");
                        int choice1 = Integer.parseInt(scanner.nextLine());
                        switch (choice1) {
                            case 1:
                                studentService1.deleStudent();
                                break;
                            case 2:
                                teacherService.deleTeacherService();
                                break;
                            case 3:
                                isloop1 = false;
                                break;
                            default:
                                System.out.println("Lựa chọn của bạn không phù hợp");
                        }
                    }
                    break;
                case 3:
                    boolean isloop2 = true;
                    while (isloop2){
                        System.out.println("--------------Danh sách-------------");
                        System.out.println("1.Học sinh");
                        System.out.println("2.Giảng viên");
                        System.out.println("3.Quay lại");
                        int choice1 = Integer.parseInt(scanner.nextLine());
                        switch (choice1) {
                            case 1:
                                studentService1.showListStudent();
                                break;
                            case 2:
                                teacherService.showListTeacher();
                                break;
                            case 3:
                                isloop2 = false;
                                break;
                            default:
                                System.out.println("Lựa chọn của bạn không phù hợp");
                        }
                    }
                    break;
                case 4:
                    System.out.println("---Hoàn thành công việc----");
                    return;
                default:
                    System.out.println("Lựa chọn của bạn nhập vào không phù hợp!");
            }
        }
    }
}
