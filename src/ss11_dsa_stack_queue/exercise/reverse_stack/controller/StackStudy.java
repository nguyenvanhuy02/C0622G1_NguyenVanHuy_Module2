package ss11_dsa_stack_queue.exercise.reverse_stack.controller;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class StackStudy {
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

        Stack<Integer> integerStack = new Stack<>();

        for (int i = 0; i < array.length ; i++) {
            integerStack.push(array[i]);
        }
        System.out.println("Mảng ban đầu : " + integerStack);
        for (int i = 0; i < array.length ; i++) {
            array[i] = integerStack.pop();
        }
        System.out.println("Đảo ngược phần tử trong mảng " + Arrays.toString(array));
    }
}
