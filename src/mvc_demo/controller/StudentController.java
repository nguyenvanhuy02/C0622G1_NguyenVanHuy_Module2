package mvc_demo.controller;

import mvc_demo.service.IStudentService;
import mvc_demo.service.impl.StudentService;

import java.util.Scanner;

public class StudentController {
    private IStudentService studentService = new StudentService();

    private static Scanner scanner = new Scanner(System.in);


    public void menuManagement() {

    while (true){
        System.out.println("---------------------------");
        System.out.println("Chào mừng bạn đến với Lớp C06");
        System.out.println("1.Hiển thị danh sách học viên");
        System.out.println("2.Thêm học sinh mới");
        System.out.println("3.Cập nhật thông tin học sinh");
        System.out.println("4.Tìm học sinh bằng id ");
        System.out.println("5.Tìm học sinh bằng tên ");
        System.out.println("6.Sắp xếp theo tên ");
        System.out.println("7.Xoá học sinh");
        System.out.println("8.Kết thúc");
        System.out.print("Mời bạn nhập chức năng 1->8: ");

        int choice = Integer.parseInt(scanner.nextLine());
        switch (choice){
            case 1:
                studentService.disPlayAllStudent();
                break;
            case 2:
                studentService.addStudent();
                break;
            case 3:
                studentService.editStudent();
                break;
            case 4:
                studentService.idStudent();
                break;
            case 5:
                studentService.nameStudent();
                break;
            case 6:
                studentService.sortNameStudent();
                break;
            case 7:
                studentService.removeStudent();
                break;
            case 8:
                System.out.println("------Công việc bạn đã hoàn thành ! ok------");
                return;
            default:
                System.out.println("Lựa chọn của bạn nhập vào không đúng!");
        }
    }
    }
}
