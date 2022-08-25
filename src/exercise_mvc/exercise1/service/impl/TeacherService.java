package exercise_mvc.exercise1.service.impl;

import exercise_mvc.exercise1.model.Teacher;
import exercise_mvc.exercise1.service.ITeacherService;
import exercise_mvc.exercise1.service.exception.CheckPointException;
import exercise_mvc.exercise1.service.exception.GenderException;
import exercise_mvc.exercise1.service.exception.NameException;
import exercise_mvc.exercise1.service.read_write.readFile;
import exercise_mvc.exercise1.service.read_write.writeFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

public class TeacherService implements ITeacherService {
    private static Scanner scanner = new Scanner(System.in);
    private List<Teacher> teachers;
    private static final String PATH_FILE = "src\\exercise_mvc\\exercise1\\data\\fileTeacher.txt";

    @Override
    public void insetTeacher() throws IOException {
        teachers = readFile.readTeacherFile(PATH_FILE);
        Teacher teacher = this.infoTeachr();
        teachers.add(teacher);
        System.out.println("Thêm giảng viên thành công!");
        writeFile.wriTeachertFile(PATH_FILE,teachers);
    }

    @Override
    public void deleTeacherService() throws IOException {
        teachers = readFile.readTeacherFile(PATH_FILE);
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
    public void showListTeacher() throws IOException {
        teachers = readFile.readTeacherFile(PATH_FILE);
        for (Teacher teacher : teachers) {
            System.out.println(teacher);
        }
    }

    @Override
    public void editTeacherService() throws IOException {
        teachers = readFile.readTeacherFile(PATH_FILE);
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
        writeFile.wriTeachertFile(PATH_FILE,teachers);
    }

    @Override
    public void idTeacherService() throws IOException {
        teachers = readFile.readTeacherFile(PATH_FILE);
        Teacher teacher = this.findTeacher();
        if (teacher == null) {
            System.out.println("Không tìm thấy id trong danh sách");
        } else {
            System.out.println("Thông tin giảng viên cần tìm ");
            System.out.println(teacher);
        }
        writeFile.wriTeachertFile(PATH_FILE,teachers);
    }

    @Override
    public void nameTeacherService() throws IOException {
        teachers = readFile.readTeacherFile(PATH_FILE);
        System.out.print("Mời bạn nhập vào tên giảng viên: ");
        String name = scanner.nextLine();
        int count = 0;
        for (int i = 0; i < teachers.size(); i++) {
            if (teachers.get(i).getName().toLowerCase().contains(name.toLowerCase())) {
                System.out.println(teachers.get(i));
                count++;
            }
        }
        if (count == 0) {
            System.out.println("Không có tên trong danh sách!");
        }
        writeFile.wriTeachertFile(PATH_FILE,teachers);
    }

    @Override
    public void sortNameTeacher() throws IOException {
        teachers = readFile.readTeacherFile(PATH_FILE);
        if (teachers.size() <= 0) {
            System.out.println("Hiện không có danh sách để sắp xếp!");
            return;
        }
        boolean isWap = true;
        for (int i = 0; i < teachers.size() - 1 && isWap; i++) {
            isWap = false;
            for (int j = 0; j < teachers.size() - 1 - i; j++) {
                if (teachers.get(j).getName().compareTo(teachers.get(j + 1).getName()) > 0) {
                    isWap = true;
                    Teacher temp = teachers.get(j + 1);
                    teachers.set(j + 1, teachers.get(i));
                    teachers.set(j, temp);
                }
            }
        }
        System.out.println("Sắp xếp thành công!");
        writeFile.wriTeachertFile(PATH_FILE,teachers);
    }

    @Override
    public void sortIDTeacher() throws IOException {
        teachers = readFile.readTeacherFile(PATH_FILE);
        if (teachers.size() <= 0) {
            System.out.println("Hiện không có danh sách để sắp xếp!");
            return;
        }
        boolean isSwap = true;
        for (int i = 0; i < teachers.size() - 1 && isSwap; i++) {
            isSwap = false;
            for (int j = 0; j < teachers.size() - 1 - i; j++) {
                if (teachers.get(j).getId() > (teachers.get(j + 1).getId())) {
                    isSwap = true;
                    Teacher temp = teachers.get(j + 1);
                    teachers.set(j + 1, teachers.get(i));
                    teachers.set(j, temp);
                }
            }
        }
        System.out.println("Sắp xếp thành công!");
        writeFile.wriTeachertFile(PATH_FILE,teachers);
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
        String regexName = "[a-zA-z ]{5,50}";
        while (true) {
            try {
                System.out.print("Mời bạn nhập tên: ");
                name = scanner.nextLine();
                if (!(name.matches(regexName))){
                    throw new NameException("Tên bạn nhập không hợp lệ vui lòng nhập lại!");
                }
                break;
            } catch (NameException e) {
                System.out.println(e.getMessage());
            }
        }

        String dataOfBirth;
        do {
            try {
                System.out.print("Mời bạn nhập ngày sinh(dd/MM/yyy): ");
                dataOfBirth = scanner.nextLine();
                if (!dataOfBirth.matches("\\d+\\d+\\W+\\d+\\d+\\W+\\d+\\d+\\d+\\d")) {
                    throw new CheckPointException("Bạn nhập ngày sinh không hợp lệ , vui lòng nhập lại!");
                }
                if (Integer.parseInt(dataOfBirth.substring(0, 1).concat(dataOfBirth.substring(1, 2))) > 31) {
                    throw new CheckPointException("Bạn nhập ngày sinh không hợp lệ , vui lòng nhập lại!");
                }
                if (Integer.parseInt(dataOfBirth.substring(3, 4).concat(dataOfBirth.substring(4, 5))) > 12) {
                    throw new CheckPointException("Bạn nhập ngày sinh không hợp lệ , vui lòng nhập lại!");
                }
                if (!checkDayMonthYear(dataOfBirth)) {
                    throw new CheckPointException("Bạn nhập ngày sinh không hợp lệ , vui lòng nhập lại!");
                }
                if (Integer.parseInt(dataOfBirth.substring(6)) > 2015) {
                    throw new CheckPointException("Bạn nhập ngày sinh không hợp lệ , vui lòng nhập lại!");
                }
                break;
            } catch (CheckPointException e) {
                System.out.println(e.getMessage());
            }
        } while (true);

        String gender;
        while (true) {
            try {
                System.out.print("Mời bạn nhập giới tính (Nam/Nữ): ");
                gender = scanner.nextLine();
                if (!gender.matches("Nam") && !gender.matches("Nữ")) {
                    throw new GenderException("Bạn nhập giới tính không hợp lệ vui lòng nhập lại!");
                }
                break;
            } catch (GenderException e) {
                System.out.println(e.getMessage());
            }
        }

        System.out.print("Mời bạn nhập chuyên môn: ");
        String specialize = scanner.nextLine();

        Teacher teacher = new Teacher(id, name, dataOfBirth, gender, specialize);
        return teacher;


    }

    public static boolean checkDayMonthYear(String string) {
        int[] day = {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        int[] arr = new int[3];
        arr[0] = Integer.parseInt(string.substring(0, 1).concat(string.substring(1, 2)));
        arr[1] = Integer.parseInt(string.substring(3, 4).concat(string.substring(4, 5)));
        arr[2] = Integer.parseInt(string.substring(6));
        return arr[1] <= day[arr[1] - 1];
    }
}
