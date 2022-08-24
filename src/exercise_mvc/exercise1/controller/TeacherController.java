package exercise_mvc.exercise1.controller;

import exercise_mvc.exercise1.service.ITeacherService;
import exercise_mvc.exercise1.service.impl.TeacherService;

import java.io.IOException;
import java.util.Scanner;

public class TeacherController {
    private static final Scanner scanner = new Scanner(System.in);
    private static final ITeacherService teacherService = new TeacherService();
    public static void teacherController() {
        boolean isLoop = true;
        int choices;
        while (isLoop) {
            try {
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
                            try {
                                System.out.println("----------Tìm Kiếm-----------\n" +
                                        "1.Tìm kiếm bằng tên.\n" +
                                        "2.Tìm kiếm bằng id.\n" +
                                        "3.Quay lại.");
                                System.out.print("Chọn(1->3): ");
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
                            }catch (NumberFormatException e){
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
                            try {
                                System.out.println(
                                        "-----------------Sắp xếp--------------\n" +
                                                "1.Sắp xếp bằng tên.\n" +
                                                "2.Sắp xếp bằng id.\n" +
                                                "3.Quay lại.");
                                int choice;
                                System.out.print("Chọn (1->3): ");
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
                            }catch (NumberFormatException e){
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
            } catch (NumberFormatException | IOException e) {
                System.out.println("Chức năng bạn chọn không hợp lệ , vui lòng bạn chọn lại!");
            }
        }
    }
}
