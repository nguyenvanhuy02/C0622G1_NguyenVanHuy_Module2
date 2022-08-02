package ss2_loop.practice;

import java.util.Scanner;

public class CheckPrime {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập số nguyên tố muốn kiếm tra ");
        int number = scanner.nextInt();

        int coutn=0;
        if (number <2 ){
            System.out.print( number + " Không phải là số nguyên tố ");

        }else {
            for (int i = 2; i <= number; i++) {
                if (number % i == 0) {
                    coutn ++;
                }
            }
            if (coutn == 1){
                System.out.print(number + " là số nguyên tố  ");
            }else {
                System.out.print(number + " không phải số nguyên tố ");
            }
        }
    }
}
