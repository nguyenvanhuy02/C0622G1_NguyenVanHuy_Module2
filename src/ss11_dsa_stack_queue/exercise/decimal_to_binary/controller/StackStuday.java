package ss11_dsa_stack_queue.exercise.decimal_to_binary.controller;

import java.util.Scanner;
import java.util.Stack;

public class StackStuday {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Stack<Integer> integerStack = new Stack<>();
        System.out.print("Người dùng nhập số chuyển đổi từ hệ thập phân sang hệ nhị phân : ");
        int number = Integer.parseInt(scanner.nextLine());

        while (number !=0){
            integerStack.push(number % 2);
            number /= 2;
        }

        while (!integerStack.isEmpty()){
            System.out.print(integerStack.pop());
        }
    }
}
