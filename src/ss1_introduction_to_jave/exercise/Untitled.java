package ss1_introduction_to_jave.exercise;

import java.util.Scanner;

public class Untitled {
    public static void main(String[] args) {
        double vnd = 23000;
        double usd;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập số tiền USD : ");
        usd = scanner.nextDouble();
        double quyDoi = usd * vnd;
        System.out.println("Giá trị VND : " + quyDoi);
    }
}
