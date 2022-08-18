package ss14_sort.exercise.insertion_sort;

import java.util.Arrays;
import java.util.Scanner;

public class InsertionSort {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size;
        do {
            System.out.print("Nhập số lương : ");
            size = Integer.parseInt(scanner.nextLine());

            if (size < 0) {
                System.out.print("Yêu cầu nhập lại số lượng: ");
            }
        } while (size < 0);

        int[] array = new int[size];

        for (int i = 0; i < size; i++) {
            System.out.print("Nhập phần tử thứ " + (i + 1) + ": ");
            array[i] = Integer.parseInt(scanner.nextLine());
        }
        System.out.println("Mảng ban đầu" + Arrays.toString(array));
        System.out.println("Mảng đã được sắp xếp " + Arrays.toString(insertonSort(array)));
    }
    public static int [] insertonSort(int[]arr){
        for (int i = 1; i < arr.length ; i++) {  //đoạn array[0] đã sắp xếp
            int key = arr[i];
            int j;
            for ( j = i -1 ; j >= 0 && arr[j] > key ; j--) {
                arr[j + 1 ] = arr[j]; // đổi chỗ
            }
            arr[j + 1 ] = key;
        }
        return arr;
    }
}

