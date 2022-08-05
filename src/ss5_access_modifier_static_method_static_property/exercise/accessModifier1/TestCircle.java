package ss5_access_modifier_static_method_static_property.exercise.accessModifier1;

import java.util.Scanner;

public class TestCircle {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập bán kính: ");
        double radius = Double.parseDouble(scanner.nextLine());

        Circle circle = new Circle(radius);

        System.out.println("Bán kính: " + circle.getRadius());
        System.out.printf("DIện tích hình tròn: [%.2f] \n",circle.getArea());
        System.out.println("Màu hình tròn:  " + circle.getColor());
    }
}
