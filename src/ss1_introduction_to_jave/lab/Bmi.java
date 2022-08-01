package ss1_introduction_to_jave.lab;

import java.util.Scanner;

public class Bmi {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double weight,height,bmi;

        System.out.print("Nhập cân nặng (kg): ");
        weight = scanner.nextDouble();
        System.out.print("Nhập chiều cao (m): ");
        height = scanner.nextDouble();

        bmi = weight/Math.pow(height,2);

        if (bmi<18){
            System.out.println(bmi + " Thiếu cân");
        }else if (bmi<25.0){
            System.out.println(bmi + " Bình thường");
        }else if (bmi<30.0){
            System.out.println(bmi + " Thừa cân");
        }else {
            System.out.println(bmi + " Béo phì");
        }

    }
}
