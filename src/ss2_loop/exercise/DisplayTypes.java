package ss2_loop.exercise;

import java.util.Scanner;

public class DisplayTypes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice = -1 ;
        while (choice != 0){
            System.out.println("Menu");
            System.out.println("1. Print the rectangle");
            System.out.println("2. Print the square triangle");
            System.out.println("3. Print isosceles triangle");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            int i;
            int j;
            switch (choice){
                case 1:
                    System.out.print("Nhập chiều cao ");
                    int height = scanner.nextInt();
                    System.out.print("Nhập chiều rông ");
                    int width = scanner.nextInt();

                    for ( i = 1; i <= height ; i++) {
                        for ( j = 1; j <= width ; j++) {
                            System.out.print("*");
                        }
                        System.out.println("");
                    }
                    break;
                case 2:
                    System.out.print("Nhập chiều dài ");
                    int longs = scanner.nextInt();

                    for ( i = 1; i <= longs ; i++) {
                        for ( j = 0; j < i ; j++) {
                            System.out.print("*");
                        }
                        System.out.println();
                    }
                    break;
                case 3:
                    System.out.print("Nhập chiều dài ");
                    int longs2 = scanner.nextInt();

                    for ( i = longs2; i >=1 ; i--) {
                        for ( j = 1; j <=i ; j++) {
                            System.out.print("*");
                        }
                        System.out.println();
                    }
                    break;
                case 0:
                    System.exit(0);
                default:
                    System.out.println("No choice!");


            }
        }
    }
}
