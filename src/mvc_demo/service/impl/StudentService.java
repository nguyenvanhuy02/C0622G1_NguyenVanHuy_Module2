package mvc_demo.service.impl;

import mvc_demo.model.Student;
import mvc_demo.service.IStudentService;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class StudentService implements IStudentService {

    private static Scanner scanner = new Scanner(System.in);
    private List<Student> students = new ArrayList<>();

    @Override
    public void addStudent() {
        Student student = this.infoStudent();
        students.add(student);
        System.out.println("Thêm học sinh thành công");

    }

    @Override
    public void disPlayAllStudent() {
        for (Student student : students){
            System.out.println(student);
        }
    }

    @Override
    public void removeStudent() {
        Student student = this.findStudent();
        if (student == null){
            System.out.println("Không tìm thấy đối tượng để xoá");
        }else {
            System.out.println("Bạn có chắc chắn muốn xoá đối tượng có id là " + student.getId() + "Không?");
            System.out.println("1.Có");
            System.out.println("2.Không");
            int choice = Integer.parseInt(scanner.nextLine());
            if (choice == 1){
                students.remove(student);
                System.out.println("Xoá thành công ");
            }
        }
    }

    @Override
    public void editStudent() {
        Student student = this.findStudent();
        if (student == null){
            System.out.println("Không tìm thấy đối tượng để chỉnh sửa");
        }else {
            int findStudents = students.indexOf(student);
            while (true){
                System.out.println("Chỉnh Sửa thông tin!");
                System.out.println("1.Chỉnh sửa lại toàn bộ thông tin mới");
                System.out.println("Hoặc chỉ chỉnh sửa 1 số thông tin dưới đây thôi!");
                System.out.println("2.Chỉnh sửa lại id");
                System.out.println("3.Chỉnh sửa lại tên");
                System.out.println("4.Chỉnh sửa lại ngày sinh");
                System.out.println("5.Chỉnh sửa lại tên lớp");
                System.out.println("6.Chỉnh sửa lại điểm");
                System.out.println("7.Kết thúc");
                System.out.print("Nhập thông tin từ 1-7: ");
                int choice = Integer.parseInt(scanner.nextLine());
                switch (choice){
                    case 1:
                        Student studentEdit = infoStudent();
                        System.out.println("Nhập thông tin cho sinh viên mới");
                        students.get(findStudents).setId(studentEdit.getId());
                        students.get(findStudents).setName(studentEdit.getName());
                        students.get(findStudents).setDateOfBirth(studentEdit.getDateOfBirth());
                        students.get(findStudents).setNameClass(studentEdit.getNameClass());
                        students.get(findStudents).setPoint(studentEdit.getPoint());
                        System.out.println("Cập nhật thông tin mới thành công");
                        break;
                    case 2:
                        System.out.print("Nhập Id mới: ");
                        int newId = Integer.parseInt(scanner.nextLine());
                        students.get(findStudents).setId(newId);
                        System.out.println("Cập nhật Id thành thông");
                        break;
                    case 3:
                        System.out.print("Nhập tên mới");
                        String newName = scanner.nextLine();
                        students.get(findStudents).setName(newName);
                        System.out.println("Cập nhật tên thành công");
                        break;
                    case 4:
                        System.out.print("Nhập ngày sinh mới: ");
                        String newDateOfDay = scanner.nextLine();
                        students.get(findStudents).setDateOfBirth(newDateOfDay);
                        System.out.println("Cập nhật ngày sinh thành công");
                        break;
                    case 5:
                        System.out.print("Nhập tên lớp mới: ");
                        String newNameClass = scanner.nextLine();
                        students.get(findStudents).setNameClass(newNameClass);
                        System.out.println("Cập nhật tên lớp thành công");
                        break;
                    case 6:
                        System.out.print("Nhập điểm mới: ");
                        Double newPoint = Double.parseDouble(scanner.nextLine());
                        students.get(findStudents).setPoint(newPoint);
                        System.out.println("Cập nhật điểm thành công");
                        break;
                    case 7:
                        System.out.println("Chỉnh sửa của ban đã hoàn thành");
                        return;
                    default:
                        System.out.println("Lựa chọn của bạn sai!");
                }
            }
        }
    }


    public Student findStudent(){
        System.out.print("Mời bạn nhập vào id cần chọn: ");
        int id = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < students.size() ; i++) {
            if (students.get(i).getId() == id ){
                return students.get(i);
            }
        }
        return null;
    }

    public Student infoStudent(){
        System.out.print("Mời bạn nhập id : ");
        int id = Integer.parseInt(scanner.nextLine());
        System.out.print("Mời bạn nhập tên: ");
        String name = scanner.nextLine();
        System.out.print("Mời bạn nhập ngày sinh: ");
        String dateOfBirth = scanner.nextLine();
        System.out.print("Mời bạn nhập điểm: ");
        double point = Double.parseDouble(scanner.nextLine());
        System.out.print("Mời bạn nhập tên lớp: ");
        String nameClass = scanner.nextLine();

        Student student = new Student(id,name,dateOfBirth,point,nameClass);
        return student;

    }
}
