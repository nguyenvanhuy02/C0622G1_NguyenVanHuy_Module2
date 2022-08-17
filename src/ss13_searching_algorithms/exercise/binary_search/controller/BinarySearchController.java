package ss13_searching_algorithms.exercise.binary_search.controller;

import ss13_searching_algorithms.exercise.binary_search.model.BinarySearch;

import java.util.Arrays;
import java.util.Scanner;

public class BinarySearchController {
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
        System.out.print("Người dùng nhập số muốn kiếm vị trí : ");
        int choice = Integer.parseInt(scanner.nextLine());

        Arrays.sort(array);
        System.out.println( "Mảng đã được sắp xếp: " + Arrays.toString(array));

        System.out.println("Vị trí xuất hiện : " + BinarySearch.binarySearch(array,choice,0,array.length-1));

    }

}
