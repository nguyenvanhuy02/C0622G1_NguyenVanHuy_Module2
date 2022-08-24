package exercise_mvc.exercise1.service.impl;

import exercise_mvc.exercise1.model.Student1;
import exercise_mvc.exercise1.service.IStudentService1;
import exercise_mvc.exercise1.service.exception.CheckPointException;
import exercise_mvc.exercise1.service.exception.GenderException;
import exercise_mvc.exercise1.service.exception.NameException;
import exercise_mvc.exercise1.service.read_write.readFile;
import exercise_mvc.exercise1.service.read_write.writeFile;


import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Pattern;


public class StudentService1 implements IStudentService1 {
    private static Scanner scanner = new Scanner(System.in);
    static List<Student1> student1s;
    private static final String PATH_FILE = "src\\exercise_mvc\\exercise1\\data\\filestudent.txt";

    @Override
    public void insetStudent() throws IOException {
        student1s = readFile.readStudentFile(PATH_FILE);
        Student1 student = infoStudent();
        student1s.add(student);
        System.out.println("Thêm học sinh thành công");
        writeFile.wriStudentFile(PATH_FILE, student1s);
    }

    @Override
    public void deleStudent() throws IOException {
        student1s = readFile.readStudentFile(PATH_FILE);
        Student1 student1 = this.findStudent();
        if (student1 == null) {
            System.out.println("Không tìm thấy đối tượng để xoá");
        } else {
            System.out.println("Bạn có chắc chắn muốn xoá đối tượng có id là " + student1.getId() + "Không?");
            System.out.println("1.Có");
            System.out.println("2.Không");
            int choice = Integer.parseInt(scanner.nextLine());
            if (choice == 1) {
                student1s.remove(student1);
                System.out.println("Xoá thành công ");
            }
        }
    }

    @Override
    public void showListStudent() throws IOException {
        student1s = readFile.readStudentFile(PATH_FILE);
        for (Student1 student : student1s) {
            System.out.println(student);
        }
    }

    @Override
    public void editStudent() throws IOException {
        student1s = readFile.readStudentFile(PATH_FILE);
        Student1 student1 = this.findStudent();
        if (student1 == null) {
            System.out.println("Không tìm thấy đối tượng bạn cần chỉnh sửa");
        } else {
            int findStudent = student1s.indexOf(student1);
            Student1 editStudent = infoStudent();
            System.out.println("Chỉnh sửa thông tin học sinh!");
            student1s.get(findStudent).setId(editStudent.getId());
            student1s.get(findStudent).setName(editStudent.getName());
            student1s.get(findStudent).setDateOfBirth(editStudent.getDateOfBirth());
            student1s.get(findStudent).setGender(editStudent.getGender());
            student1s.get(findStudent).setNameClass(editStudent.getNameClass());
            student1s.get(findStudent).setPoint(editStudent.getPoint());
            System.out.println("Chỉnh sửa thành công!");
        }
        writeFile.wriStudentFile(PATH_FILE, student1s);
    }

    @Override
    public void idStundent() throws IOException {
        student1s = readFile.readStudentFile(PATH_FILE);
        Student1 student1 = this.findStudent();
        if (student1 == null) {
            System.out.println("ID không tồn tại trong danh sách!");
        } else {
            System.out.println("Thông tin học sinh tìm bằng id !");
            System.out.println(student1);
        }
        writeFile.wriStudentFile(PATH_FILE, student1s);
    }

    @Override
    public void nameStudent() throws IOException {
        student1s = readFile.readStudentFile(PATH_FILE);
        System.out.print("Mời bạn nhập tên cần tìm: ");
        String name = scanner.nextLine();
        int count = 0;
        for (int i = 0; i < student1s.size(); i++) {
            if (student1s.get(i).getName().toLowerCase().contains(name.toLowerCase())) {
                System.out.println(student1s.get(i));
                count++;
            }
        }
        if (count == 0) {
            System.out.println("Không có tên trong danh sách!");
        }
        writeFile.wriStudentFile(PATH_FILE, student1s);
    }

    @Override
    public void sortNameStudent() throws IOException {
        student1s = readFile.readStudentFile(PATH_FILE);
        if (student1s.size() <= 0) {
            System.out.println("Hiện không có danh sách để sắp xếp!");
            return;
        }
        boolean isSwap = true;
        for (int i = 0; i < student1s.size() - 1 && isSwap; i++) {
            isSwap = false;
            for (int j = 0; j < student1s.size() - 1 - i; j++) {
                if (student1s.get(j).getName().compareTo(student1s.get(j + 1).getName()) > 0) {
                    isSwap = true;
                    Student1 temp = student1s.get(j + 1);
                    student1s.set(j + 1, student1s.get(j));
                    student1s.set(j, temp);
                }
            }
        }
        System.out.println("Sắp xếp thành công!");
        writeFile.wriStudentFile(PATH_FILE, student1s);
    }

    @Override
    public void sortPointStudent() throws IOException {
        student1s = readFile.readStudentFile(PATH_FILE);
        if (student1s.size() <= 0) {
            System.out.println("Hiện không có danh sách để sắp xếp!");
            return;
        }
        boolean isSwap = true;
        for (int i = 0; i < student1s.size() - 1 && isSwap; i++) {
            isSwap = false;
            for (int j = 0; j < student1s.size() - 1 - i; j++) {
                if (student1s.get(j).getPoint() > (student1s.get(j + 1).getPoint())) {
                    isSwap = true;
                    Student1 temp = student1s.get(j + 1);
                    student1s.set(j + 1, student1s.get(j));
                    student1s.set(j, temp);
                }
            }
        }
        System.out.println("Sắp xếp thành công!");
        writeFile.wriStudentFile(PATH_FILE, student1s);
    }

    public Student1 findStudent() {
        System.out.print("Mời bạn nhập vào id cần chọn: ");
        int id = Integer.parseInt(scanner.nextLine());
        for (Student1 student1 : student1s) {
            if (student1.getId() == id) {
                return student1;
            }
        }
        return null;
    }

    public static Student1 infoStudent() {
        int id;
        do {
            System.out.print("Mời bạn nhập id: ");
            try {
                id = Integer.parseInt(scanner.nextLine());
                if (id < 0) {
                    throw new CheckPointException("id phải >0: ");
                }
                for (Student1 student : student1s) {
                    if (student.getId() == id) {
                        throw new CheckPointException("id đã tồn tại vui lòng nhập lại!");
                    }
                }
                break;
            } catch (NumberFormatException e) {
                System.out.println("id không hợp lệ vui lòng nhập lại!");
            } catch (CheckPointException e) {
                System.out.println(e.getMessage());
            }
        } while (true);


        String name;
        while (true) {
            try {
                System.out.print("Mời bạn nhập tên: ");
                name = scanner.nextLine();
               if (name.matches("\\W+")) {
                    throw new NameException("Họ và tên không được để trống");
                }
                String str;
                for (int i = 0; i < name.length() ; i++) {
                    str = "";
                    if ((str + name.charAt(i)).matches("\\d")){
                        throw new NameException("Họ và tên không được có số!");
                    }
                }
                break;
            } catch (NameException e) {
                System.out.println(e.getMessage());
            }
        }

        String dataOfBirth;
        while (true) {
            System.out.print("Mời bạn nhập ngày sinh(dd/MM/yyy): ");
            String regex = "^([0-2][0-9]||3[0-1])/(0[0-9]||1[0-2])/([0-9][0-9])?[0-9][0-9]$";
            dataOfBirth = scanner.nextLine();
            if(Pattern.matches(regex, dataOfBirth)) {
                break;
            } else {
                System.out.println("Nhập sai định dạng vui lòng nhập lại!");
            }

        }

        String gender;
        while (true) {
            try {
                System.out.print("Mời bạn nhâpk giới tính (Nam/Nữ): ");
                gender = scanner.nextLine();
                if (!gender.matches("Nam") && !gender.matches("Nữ")) {
                    throw new GenderException("Bạn nhập giới tính không hợp lệ vui lòng nhập lại!");
                }
                break;
            } catch (GenderException e) {
                System.out.println(e.getMessage());
            }
        }

        System.out.print("Mời bạn nhập tên lớp: ");
        String nameClass = scanner.nextLine();

        double point;
        while (true) {
            try {
                System.out.print("Mời bạn nhập điểm: ");
                point = Double.parseDouble(scanner.nextLine());
                if (point < 0 || point > 1000) {
                    throw new CheckPointException("Điểm bạn không hợp lệ phải lớn hơn 0 và nhỏ hơn 1000, vui lòng bạn nhập lại!");
                }
                break;
            } catch (NumberFormatException e) {
                System.out.println("Điểm bạn nhập không hợp lệ vui lòng nhập lại!");
            } catch (CheckPointException e) {
                System.out.println(e.getMessage());
            }
        }


        Student1 student1 = new Student1(id, name, dataOfBirth, gender, nameClass, point);
        return student1;

    }
}
