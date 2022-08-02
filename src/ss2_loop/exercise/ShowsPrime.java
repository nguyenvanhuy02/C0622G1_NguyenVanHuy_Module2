package ss2_loop.exercise;

import java.util.Scanner;

public class ShowsPrime {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập n số nguyên tố ");
        int number = scanner.nextInt();

        int count = 0;
        int countPrime = 0;
        for (int i = 2; i < 1000 ; i++) {
            if (countPrime < number){
                for (int j = 1; j <= i ; j++) {
                    if (i%j==0){
                        count +=1;
                    }
                }
                if (count==2){
                    System.out.println(i);
                    countPrime +=1;
                }
                count=0;
            }else {
                break;
            }
        }
    }
}
