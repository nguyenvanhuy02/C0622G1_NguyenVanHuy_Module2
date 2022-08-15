package ss11_dsa_stack_queue.exercise.reverse_stack.controller;

import java.util.Scanner;
import java.util.Stack;

public class StackStudy2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Stack<String> wStack = new Stack<>();
        System.out.println("Nhập chuỗi vào  : ");
        String string = scanner.nextLine();

        String mWord = "";

        for (int i = 0; i < string.length() ; i++) {
            wStack.push(String.valueOf(string.charAt(i)));
        }

        for (int i = 0; i < string.length() ; i++) {
            mWord += wStack.pop();
        }
        System.out.println(mWord);
    }

}
