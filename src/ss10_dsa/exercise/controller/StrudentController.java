package ss10_dsa.exercise.controller;

import ss10_dsa.exercise.model.MyArrayList;
import ss10_dsa.exercise.model.Student;

public class StrudentController {
    public static void main(String[] args) {
        Student a = new Student(1,"Huy");
        Student b = new Student(2,"Nam");
        Student c = new Student(3,"Mao");
        Student d = new Student(4,"Anh");
        Student e = new Student(5,"Vũ");
        Student f = new Student(6,"Huyền");

        MyArrayList<Student> studentMyArrayList = new MyArrayList<>();


        studentMyArrayList.add(a);
        studentMyArrayList.add(b);
        studentMyArrayList.add(c);
        studentMyArrayList.add(d);
        studentMyArrayList.add(e);

        studentMyArrayList.add(f,2); // ép vị trí thứ 6 vào vị trí thứ 2

        //studentMyArrayList.clear(); -> Xoá

        //System.out.println(studentMyArrayList.size()); -> Hiển thị độ dài của mảng

        //System.out.println(studentMyArrayList.get(2).getName()); ->Phương thức lấy 1 element tại vị trí index

        //System.out.println(studentMyArrayList.indexOf(b)); -> Tìm vị trí phần tử

        //System.out.println(studentMyArrayList.contains(b)); -> Kiểm tra một phần tử có trong Array không?

        //studentMyArrayList.remove(0); -> xoá phần tự muốn chọn

//        Student student = studentMyArrayList.remove(1); -> xuất phần tự Bị xoá
//        System.out.println(student);

        for (int i = 0 ; i < studentMyArrayList.size(); i++){
            Student student = (Student) studentMyArrayList.elements[i];
            System.out.println(student.getId());
            System.out.println(student.getName());

        }


//        MyArrayList<Student> newMyArrayList = new MyArrayList<>();
//        newMyArrayList = studentMyArrayList.clone();                  -> tạo ra 1 bản sao MyArrayList
//        for (int i = 0; i < newMyArrayList.size() ; i++) {
//            System.out.println(newMyArrayList.get(i).getName());
//        }
    }
}
