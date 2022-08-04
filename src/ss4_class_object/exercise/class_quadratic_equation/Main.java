package ss4_class_object.exercise.class_quadratic_equation;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập số a: ");
        double a = scanner.nextDouble();
        System.out.print("Nhập số b: ");
        double b = scanner.nextDouble();
        System.out.print("Nhập số c: ");
        double c = scanner.nextDouble();
        ClassQuadraticEquation quadraticEquation = new ClassQuadraticEquation(a, b, c);

        if (quadraticEquation.getDiscriminant() == 0) {
            System.out.printf("Phương trình có nghiệm kép [%.2f] ",quadraticEquation.getDoubleSolution());
        } else if (quadraticEquation.getDiscriminant() > 0) {
            System.out.printf("Phương trình có 2 nghiệm [%.2f,%s,%.2f] ",quadraticEquation.getRoot1()," và ",quadraticEquation.getRoot2());
        } else {
            System.out.println("Phương trình vô nghiệm");
        }
    }
}
