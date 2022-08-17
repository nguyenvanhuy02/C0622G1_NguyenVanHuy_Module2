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
        if (teacher == null) {
            System.out.println("Không tìm thấy đối tượng để xoá");
        } else {
            System.out.println("Bạn có chắc chắn muốn xoá đối tượng có id là " + teacher.getId() + "Không?");
            System.out.println("1.Có");
            System.out.println("2.Không");
            int choice = Integer.parseInt(scanner.nextLine());
            if (choice == 1) {
                teachers.remove(teacher);
                System.out.println("Xoá thành công ");
            }
        }
    }

    @Override
    public void showListTeacher() {
        for (Teacher teacher : teachers) {
            System.out.println(teacher);
        }
    }

    @Override
    public void editTeacherService() {
        Teacher teacher = this.findTeacher();
        if (teacher == null) {
            System.out.println("Không tìm thấy đối tượng chỉnh sửa");
        } else {
            int findTeacher = teachers.indexOf(teacher);
            Teacher teacher1 = infoTeachr();
            System.out.println("Chỉnh sửa thông tin giảng viên");
            teachers.get(findTeacher).setId(teacher1.getId());
            teachers.get(findTeacher).setName(teacher1.getName());
            teachers.get(findTeacher).setDateOfBirth(teacher1.getDateOfBirth());
            teachers.get(findTeacher).setGender(teacher1.getGender());
            teachers.get(findTeacher).setSpecialize(teacher1.getSpecialize());
            System.out.println("Chỉnh sửa thành công");
        }
    }

    @Override
    public void idTeacherService() {
        Teacher teacher = this.findTeacher();
        if (teacher == null) {
            System.out.println("Không tìm thấy id trong danh sách");
        } else {
            System.out.println("Thông tin giảng viên cần tìm ");
            System.out.println(teacher);
        }
    }

    @Override
    public void nameTeacherService() {
        System.out.println("Mời bạn nhập vào tên giảng viên: ");
        String name = scanner.nextLine();
        for (int i = 0; i < teachers.size(); i++) {
            if (teachers.get(i).getName().contains(name)) {
                System.out.println(teachers.get(i));
            }
        }
    }

//    public Teacher findNameTeacher() {
//        System.out.println("Mời bạn nhập vào tên giảng viên: ");
//        String name = scanner.nextLine();
//        for (int i = 0; i < teachers.size(); i++) {
//            if (teachers.get(i).getName().contains(name)) {
//                return teachers.get(i);
//            }
//        }
//        return null;
//    }

    public Teacher findTeacher() {
        System.out.print("Mời bạn nhập vào id cần chọn: ");
        int id = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < teachers.size(); i++) {
            if (teachers.get(i).getId() == id) {
                return teachers.get(i);
            }
        }
        return null;
    }

    public Teacher infoTeachr() {
        int id;
        while (true) {
            boolean checkID = false;
            System.out.println("Mời bạn nhập id: ");
            id = Integer.parseInt(scanner.nextLine());
            for (Teacher teacher : teachers) {
                if (teacher.getId() == id) {
                    System.out.print("id đã tồn tại vui lòng bạn nhập lại: ");
                    checkID = true;
                }
            }
            if (!checkID) {
                break;
            }
        }

        System.out.print("Mời bạn nhập tên: ");
        String name = scanner.nextLine();

        System.out.print("Mời bạn nhập ngày sinh: ");
        String dateOfBirth = scanner.nextLine();

        System.out.print("Mời bạn nhập giới tính: ");
        String gender = scanner.nextLine();

        System.out.print("Mời bạn nhập chuyên môn: ");
        String specialize = scanner.nextLine();

        Teacher teacher = new Teacher(id, name, dateOfBirth, gender, specialize);
        return teacher;


    }

}
