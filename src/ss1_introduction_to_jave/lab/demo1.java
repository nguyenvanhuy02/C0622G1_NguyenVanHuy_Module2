package ss1_introduction_to_jave.lab;

import java.util.Arrays;
import java.util.Scanner;

public class demo1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập độ dài của mảng mẹ: ");
        int n = Integer.parseInt(scanner.nextLine());
        System.out.println("Nhập độ dài của mảng con: ");
        int m = Integer.parseInt(scanner.nextLine());
        int[][] array = new int[n][m];

        for (int i = 0; i < n ; i++) {
            for (int j = 0; j <m ; j++) {
                System.out.printf("Nhập phần tử con [%d,%d] : ",i,j);
                array[i][j]=Integer.parseInt(scanner.nextLine());
            }
        }
        System.out.println(Arrays.deepToString(array));
        int max =array[0][0];
        for (int i = 0; i <n ; i++) {
            for (int j = 0; j <m ; j++) {
                if (array[i][j]>max){
                    max=array[i][j];
                }
            }
        }
        System.out.println(max);
    }
}
