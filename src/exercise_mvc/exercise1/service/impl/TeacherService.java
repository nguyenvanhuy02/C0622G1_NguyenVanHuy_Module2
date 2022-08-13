package exercise_mvc.exercise1.service.impl;

import exercise_mvc.exercise1.model.Student1;
import exercise_mvc.exercise1.model.Teacher;
import exercise_mvc.exercise1.service.ITeacherService;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TeacherService implements ITeacherService {
    private static Scanner scanner = new Scanner(System.in);
    private List<Teacher> teachers = new ArrayList<>();
    @Override
    public void insetTeacher() {
        Teacher teacher = this.infoTeachr();
        teachers.add(teacher);
        System.out.println("Thêm giảng viên thành công!");
    }

    @Override
    public void deleTeacherService() {
        Teacher teacher = this.findTeacher();
        if (teacher == null){
            System.out.println("Không tìm thấy đối tượng để xoá");
        }else {
            System.out.println("Bạn có chắc chắn muốn xoá đối tượng có id là " + teacher.getId() + "Không?");
            System.out.println("1.Có");
            System.out.println("2.Không");
            int choice = Integer.parseInt(scanner.nextLine());
            if (choice == 1){
                teachers.remove(teacher);
                System.out.println("Xoá thành công ");
            }
        }
    }

    @Override
    public void showListTeacher() {
        for (Teacher teacher : teachers){
            System.out.println(teacher);
        }
    }

    public Teacher findTeacher(){
        System.out.print("Mời bạn nhập vào id cần chọn: ");
        int id = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < teachers.size() ; i++) {
            if (teachers.get(i).getId() == id ){
                return teachers.get(i);
            }
        }
        return null;
    }

    public Teacher infoTeachr(){
        System.out.print("Mời bạn nhập id : ");
        int id = Integer.parseInt(scanner.nextLine());

        System.out.print("Mời bạn nhập tên: ");
        String name = scanner.nextLine();

        System.out.print("Mời bạn nhập ngày sinh: ");
        String dateOfBirth = scanner.nextLine();

        System.out.print("Mời bạn nhập giới tính: ");
        String gender = scanner.nextLine();

        System.out.print("Mời bạn nhập chuyên môn");
        String specialize = scanner.nextLine();

        Teacher teacher = new Teacher(id,name,dateOfBirth,gender,specialize);
        return teacher;


    }

}
