package ss3_array.exercise;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class DeleteElementInArray {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        System.out.print("Nhập phần tử muốn xoá ");
        int dell = scanner.nextInt();

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == dell) {
                for (int j = i; j < arr.length - 1; j++) {
                    arr[j] = arr[j + 1];
                }
                arr[arr.length - 1] = 0;
                break;
            }
        }
        System.out.println(Arrays.toString(arr));
    }
}
