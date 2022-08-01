package ss1_introduction_to_jave.lab;

import java.util.Scanner;

public class Operator {
    public static void main(String[] args) {
        float width;
        float height;
        Scanner scanner = new Scanner(System.in); // khai báo đối tượng scanner

        System.out.println("Enter width: ");
        width = scanner.nextFloat(); // Nhập chiều rộng
        System.out.println("Enter height: ");
        height = scanner.nextFloat(); // Nhập chiều dài
        float area = width * height ;
        System.out.println("Area is : " + area);
    }
}
