package exercise_mvc.exercise1.service.impl;

import exercise_mvc.exercise1.model.Student1;
import exercise_mvc.exercise1.service.IStudentService1;
import exercise_mvc.exercise1.service.exception.CheckPointException;
import exercise_mvc.exercise1.service.exception.GenderException;
import exercise_mvc.exercise1.service.exception.IDException;
import exercise_mvc.exercise1.service.exception.NameException;
import exercise_mvc.exercise1.service.read_write.readFile;
import exercise_mvc.exercise1.service.read_write.writeFile;


import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;


public class StudentService1 implements IStudentService1 {
    private static Scanner scanner = new Scanner(System.in);
    private List<Student1> student1s = new ArrayList<>();
    private static final String PATH_FILE = "src\\exercise_mvc\\exercise1\\data\\filestudent.txt";
    @Override
    public void insetStudent() throws IOException {
        student1s = readFile.readStudentFile(PATH_FILE);
        Student1 student = this.infoStudent();
        student1s.add(student);
        System.out.println("Thêm học sinh thành công");
        writeFile.wriStudentFile(PATH_FILE,student1s);
    }

    @Override
    public void deleStudent() {
        Student1 student1 = this.findStudent();
        if (student1 == null){
            System.out.println("Không tìm thấy đối tượng để xoá");
        }else {
            System.out.println("Bạn có chắc chắn muốn xoá đối tượng có id là " + student1.getId() + "Không?");
            System.out.println("1.Có");
            System.out.println("2.Không");
            int choice = Integer.parseInt(scanner.nextLine());
            if (choice == 1){
                student1s.remove(student1);
                System.out.println("Xoá thành công ");
            }
        }
    }

    @Override
    public void showListStudent() throws IOException {
        student1s = readFile.readStudentFile(PATH_FILE);
        for (Student1 student1 : student1s){
            System.out.println(student1);
        }
    }

    @Override
    public void editStudent() {
        Student1 student1 = this.findStudent();
        if (student1 == null){
            System.out.println("Không tìm thấy đối tượng bạn cần chỉnh sửa");
        }else {
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
    }

    @Override
    public void idStundent() {
        Student1 student1 = this.findStudent();
        if (student1 == null){
            System.out.println("ID không tồn tại trong danh sách!");
        }else {
            System.out.println("Thông tin học sinh tìm bằng id !");
            System.out.println(student1);
        }
    }

    @Override
    public void nameStudent() {
        System.out.print("Mời bạn nhập tên cần tìm: ");
        String name = scanner.nextLine();
        int count = 0;
        for (int i = 0; i < student1s.size() ; i++) {
            if (!student1s.get(i).getName().contains(name)){
                System.out.println(student1s.get(i));
                count++;
            }
        }
        if (count == 0){
            System.out.println("Không có tên trong danh sách!");
        }
    }

    @Override
    public void sortNameStudent() {
        if (student1s.size() <= 0){
            System.out.println("Hiện không có danh sách để sắp xếp!");
            return;
        }
        boolean isSwap = true;
        for (int i = 0; i < student1s.size() - 1 && isSwap; i++) {
            isSwap = false;
            for (int j = 0; j < student1s.size() - 1 - i; j++) {
                if (student1s.get(j).getName().compareTo(student1s.get(j + 1).getName())>0) {
                    isSwap = true;
                    Student1 temp = student1s.get(j + 1);
                    student1s.set(j + 1, student1s.get(j));
                    student1s.set(j, temp);
                }
            }
        }
        System.out.println("Sắp xếp thành công!");
    }

    @Override
    public void sortPointStudent() {
        if (student1s.size() <= 0){
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

    }
    public Student1 findStudent(){
        System.out.print("Mời bạn nhập vào id cần chọn: ");
        int id = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < student1s.size() ; i++) {
            if (student1s.get(i).getId() == id ){
                return student1s.get(i);
            }
        }
        return null;
    }

    public Student1 infoStudent(){
        int id;
        while (true){
            boolean checkID = false;
            while (true){
                try {
                    System.out.print("Mời bạn nhập id : ");
                    id = Integer.parseInt(scanner.nextLine());
                    if (id < 0){
                        throw new IDException("ID không hợp lệ phải >0,vui lòng bạn nhập lại!");
                    }
                    break;
                }catch (NumberFormatException e){
                    System.out.println("id không hợp lệ, vui lòng bạn nhâp lai!");
                }catch (IDException e){
                    System.out.println(e.getMessage());
                }
            }
            for (Student1 student1 : student1s){
                if (student1.getId() == id){
                    System.out.println("Id đã tồn tại vui lòng nhập lại!");
                    checkID = true;
                }
            }
            if (!checkID){
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

        String dataOfBirth;
        while (true){
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
            System.out.print("Mời bạn nhập ngày sinh(dd/MM/yyy): ");
            dataOfBirth = scanner.nextLine();
            break;
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

        System.out.print("Mời bạn nhập tên lớp: ");
        String nameClass = scanner.nextLine();

        double point;
        while (true){
            try {
                System.out.print("Mời bạn nhập điểm: ");
                point = Double.parseDouble(scanner.nextLine());
                if (point < 0 || point > 1000){
                    throw new CheckPointException("Điểm bạn không hợp lệ phải lớn hơn 0 và nhỏ hơn 1000, vui lòng bạn nhập lại!");
                }
                break;
            }catch (NumberFormatException e){
                System.out.println("Điểm bạn nhập không hợp lệ vui lòng nhập lại!");
            }catch (CheckPointException e){
                System.out.println(e.getMessage());
            }
        }


        Student1 student1 = new Student1(id,name,dataOfBirth,gender,nameClass,point);
        return student1;

    }
}
