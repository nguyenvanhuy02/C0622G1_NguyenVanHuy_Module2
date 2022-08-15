package ss11_dsa_stack_queue.exercise.test_palindrome.controller;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class Palindrome {
    public static void main(String[] args) {
        Stack<String> stringStack = new Stack<>();
        Queue<String> stringQueue = new LinkedList<>();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Nhập chuỗi kiểm tra Palindrome : ");
        String str = scanner.nextLine();
        int count = 0;

        for (int i = 0; i < str.length(); i++) {
            stringStack.push(String.valueOf(str.charAt(i)));
            stringQueue.add(String.valueOf(str.charAt(i)));
        }

        for (int i = 0; i < str.length(); i++) {
            if (!(stringStack.pop().equalsIgnoreCase(stringQueue.poll()))) {
                System.out.println("Không phải chuỗi Palindrome ");
                return;
            }
        }
        System.out.println("Là chuỗi Palindrome ");

    }
}
