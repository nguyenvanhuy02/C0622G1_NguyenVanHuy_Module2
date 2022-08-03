package ss3_array.exercise;

import java.util.Arrays;
import java.util.Scanner;

public class MaxElementArray {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập độ dài mảng : ");
        int n = scanner.nextInt();
        System.out.print("Nhập độ dài mảng con : ");
        int m = scanner.nextInt();
        int[][] arr = new int[n][m];
        int i, j;
        for (i = 0; i < n; i++) {
            for (j = 0; j < m; j++) {
                System.out.printf("Nhập phần tử mảng con [%d,%d] :", i, j);
                arr[i][j] = scanner.nextInt();
            }
        }
        int max = arr[0][0];
        for (i = 0; i < n; i++) {
            for (j = 0; j < m; j++) {
                if (arr[i][j] > max) {
                    max = arr[i][j];
                }
            }
        }
        System.out.println(Arrays.deepToString(arr));
        System.out.println("Giá trị lớn nhất: " + max);
    }
//      Scanner scanner = new Scanner(System.in);
//
//        System.out.print("Nhập độ dài của mảng ");
//        int size = scanner.nextInt();
//
//        int[][] array = new int[size][size]; // mảng mẹ
//
//        int max = array[0][0];
//
//        for (int i = 0; i < size ; i++) {
//            int[]arr = new int[size];   // mảng mẹ
//            for (int j = 0; j < size ; j++) {
//                System.out.printf("Nhập phần tử con [%d,%d]: ",i,j);
//                arr[j]= scanner.nextInt();
//            }
//            array[i]=arr;
//        }
//        for(int[] n : array){
//            for (int number : n){
//                System.out.print(number+ " ");
//            }
//            System.out.println(" ");
//        }
//        for (int i = 0; i < size ; i++) {
//            for (int j = 0; j <size ; j++) {
//                if (array[i][j]>max){
//                    max=array[i][j];
//                }
//            }
//        }
//        System.out.println("Phần tử lớn nhất :" + max);
//    }
}
