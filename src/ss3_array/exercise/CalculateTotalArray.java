package ss3_array.exercise;

import java.util.Arrays;
import java.util.Scanner;

public class CalculateTotalArray {
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
        System.out.println(Arrays.deepToString(arr));
        System.out.println("Nhập cột muốn xoá ");
        int pillar = scanner.nextInt();
        int total =0;
        for ( i = 0; i < n ; i++) {
            for ( j = 0; j <m ; j++) {
                if (j==(pillar-1)){
                    total+=arr[i][j];
                }
            }
        }
        System.out.println("Tổng cột: " + total);
    }
}
