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

    private static final TeacherController teacher = new TeacherController();
    private static final StudentController studen = new StudentController();

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
                System.out.println("Chức năng bạn chọn không hợp lệ , vui lòng bạn chọn lại!");
                continue;
            }
            switch (choice) {
                case 1:
                    teacher.teacherController();
                    break;
                case 2:
                    studen.studentController();
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
