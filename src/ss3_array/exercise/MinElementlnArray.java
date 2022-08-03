package ss3_array.exercise;

import java.util.Arrays;
import java.util.Scanner;

public class MinElementlnArray {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size;
        int i;
        System.out.print("Nhập độ dài của mảng : ");
        size = scanner.nextInt();

        int[]array = new int[size];

        for ( i = 0; i < size  ; i++) {
            System.out.printf("Nhập phần tử của mảng vị trí [%d]: ",i);
            array[i] = scanner.nextInt();
        }
        int min = array[0];
        for ( i = 2; i < array.length ; i++) {
            if (array[i]<min){
                min = array[i];
            }
        }
        System.out.println(Arrays.toString(array));
        System.out.println("Giá trị nhỏ nhất: " + min);
    }
}
