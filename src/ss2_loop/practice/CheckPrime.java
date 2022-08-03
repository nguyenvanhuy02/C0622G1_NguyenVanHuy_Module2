package ss2_loop.practice;

import java.util.Scanner;

public class CheckPrime {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập số nguyên tố muốn kiếm tra ");
        int number = scanner.nextInt();


        if (number <2 ) {
            System.out.print(number + " Không phải là số nguyên tố ");
            return;
        }
        if (number==2){
            System.out.println(number + " Là số nguyên tố ");
            return;
        }
        for (int i = 2; i <=Math.sqrt(number) ; i++) {  //Math.sqrt() căn bậc 2
            if (number%i==0){
                System.out.println(number + " Không phải là số nguyên tố ");
                return;
            }
        }
        System.out.println(number + " Là số nguyên tố ");
//
//
//
//        int coutn=0;
//        if (number <2 ) {
//            System.out.print(number + " Không phải là số nguyên tố ");
//        }else {
//            for (int i = 2; i <= number; i++) {
//                if (number % i == 0) {
//                    coutn ++;
//                }
//            }
//            if (coutn == 1){
//                System.out.print(number + " là số nguyên tố  ");
//            }else {
//                System.out.print(number + " không phải số nguyên tố ");
//            }
//        }
    }
}
