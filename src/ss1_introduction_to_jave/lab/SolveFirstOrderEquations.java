package ss1_introduction_to_jave.lab;

import java.util.Scanner;

public class SolveFirstOrderEquations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("a: ");
        double a = scanner.nextDouble();

        System.out.print("b: ");
        double b = scanner.nextDouble();

        System.out.print("c: ");
        double c = scanner.nextDouble();

        if (a!=0){
            double result = (c-b)/a;
            System.out.print("Phương trình có 1 nghiệm " + result );
        }else {
            if (b==0){
                System.out.print("Vô số nghiệm");
            }else {
                System.out.print("Vô nghiệm ");
            }
        }
    }
}
