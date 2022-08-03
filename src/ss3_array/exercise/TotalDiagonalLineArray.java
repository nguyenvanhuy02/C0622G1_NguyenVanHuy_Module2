package ss3_array.exercise;

import java.util.Scanner;

public class TotalDiagonalLineArray {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Nhập độ dài của mảng ");
        int size = scanner.nextInt();

        int[][] array = new int[size][size]; // mảng mẹ

        int i,j;

        for ( i = 0; i < size ; i++) {
            int[]arr = new int[size];   // mảng mẹ
            for ( j = 0; j < size ; j++) {
                System.out.printf("Nhập phần tử con [%d,%d]: ",i,j);
                arr[j]= scanner.nextInt();
            }
            array[i]=arr;
        }
        for(int[] n : array){
            for (int number : n){
                System.out.print(number+ " ");
            }
            System.out.println(" ");
        }
        int total=0;
        for ( i = 0; i < array.length ; i++) {
            for ( j = 0; j < array.length ; j++) {
                if (i==j){
                    total += array[i][j];
                }
            }
        }
        System.out.println("Tổng đường chéo của mảng: " + total);

    }
}
