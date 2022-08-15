package exercise_mvc.exercise1.service.impl;

import exercise_mvc.exercise1.model.Student1;
import exercise_mvc.exercise1.service.IStudentService1;



import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class StudentService1 implements IStudentService1 {
    private static Scanner scanner = new Scanner(System.in);
    private List<Student1> student1s = new ArrayList<>();
    @Override
    public void insetStudent() {
        Student1 student = this.infoStudent();
        student1s.add(student);
        System.out.println("Thêm học sinh thành công");
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
    public void showListStudent() {
        for (Student1 student1 : student1s){
            System.out.println(student1);
        }
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
        System.out.print("Mời bạn nhập id : ");
        int id = Integer.parseInt(scanner.nextLine());

        System.out.print("Mời bạn nhập tên: ");
        String name = scanner.nextLine();

        System.out.print("Mời bạn nhập ngày sinh: ");
        String dateOfBirth = scanner.nextLine();

        System.out.print("Mời bạn nhâpk giới tính: ");
        String gender = scanner.nextLine();

        System.out.print("Mời bạn nhập tên lớp: ");
        String nameClass = scanner.nextLine();


        System.out.print("Mời bạn nhập điểm: ");
        double point = Double.parseDouble(scanner.nextLine());

        Student1 student1 = new Student1(id,name,dateOfBirth,gender,nameClass,point);
        return student1;

    }
}
