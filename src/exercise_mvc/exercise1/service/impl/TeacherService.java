package exercise_mvc.exercise1.service.impl;

import exercise_mvc.exercise1.model.Student1;
import exercise_mvc.exercise1.model.Teacher;
import exercise_mvc.exercise1.service.ITeacherService;
import exercise_mvc.exercise1.service.exception.GenderException;
import exercise_mvc.exercise1.service.exception.NameException;

import javax.xml.crypto.Data;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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
        System.out.print("Mời bạn nhập vào tên giảng viên: ");
        String name = scanner.nextLine();
        int count = 0;
        for (int i = 0; i < teachers.size(); i++) {
            if (teachers.get(i).getName().contains(name)) {
                System.out.println(teachers.get(i));
                count++;
            }
        }
        if (count==0){
            System.out.println("Không có tên trong danh sách!");
        }
    }

    @Override
    public void sortNameTeacher() {
        if (teachers.size() <= 0){
            System.out.println("Hiện không có danh sách để sắp xếp!");
            return;
        }
        boolean isWap = true;
        for (int i = 0; i < teachers.size() -1 && isWap ; i++) {
            isWap = false;
            for (int j = 0; j < teachers.size() - 1 -i  ; j++) {
                if (teachers.get(j).getName().compareTo(teachers.get(j+1).getName()) > 0){
                    isWap = true;
                    Teacher temp =  teachers.get(j + 1);
                    teachers.set(j+1,teachers.get(i));
                    teachers.set(j,temp);
                }
            }
        }
        System.out.println("Sắp xếp thành công!");
    }

    @Override
    public void sortIDTeacher() {
        if (teachers.size() <= 0){
            System.out.println("Hiện không có danh sách để sắp xếp!");
            return;
        }
        boolean isSwap = true;
        for (int i = 0; i < teachers.size() -1 && isSwap ; i++) {
            isSwap = false;
            for (int j = 0; j < teachers.size() - 1 -i  ; j++) {
                if (teachers.get(j).getId()>(teachers.get(j+1).getId())){
                    isSwap = true;
                    Teacher temp =  teachers.get(j + 1);
                    teachers.set(j+1,teachers.get(i));
                    teachers.set(j,temp);
                }
            }
        }
        System.out.println("Sắp xếp thành công!");
    }


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
            System.out.print("Mời bạn nhập id: ");
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

        String name;
        while (true){
            try {
                System.out.print("Mời bạn nhập tên: ");
                name = scanner.nextLine();
                if (name.length() == 0){
                    throw new NameException("Họ tên không được để trống!");
                }else if (name.matches("\\W+")){
                    throw new NameException("Họ tên chỉ chứa các chữ cái!");
                }
                break;
            }catch (NameException e){
                System.out.println(e.getMessage());
            }
        }

        Date dataOfBirth;
        while (true){
            try {
                SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
                System.out.print("Mời bạn nhập ngày sinh: ");
                dataOfBirth = dateFormat.parse(scanner.nextLine());
                break;
            } catch (ParseException e) {
                System.out.println("Ngày sinh bạn nhập không hợp lệ");
            }
        }

        String gender;
        while (true){
            try {
                System.out.print("Mời bạn nhâpk giới tính (Nam/Nữ): ");
                gender = scanner.nextLine();
                if (!gender.matches("Nam") && !gender.matches("Nữ")){
                    throw new GenderException("Bạn nhập giới tính không hợp lệ vui lòng nhập lại!");
                }
                break;
            }catch (GenderException e){
                System.out.println(e.getMessage());
            }
        }

        System.out.print("Mời bạn nhập chuyên môn: ");
        String specialize = scanner.nextLine();

        Teacher teacher = new Teacher(id, name, (Data) dataOfBirth, gender, specialize);
        return teacher;


    }

}
