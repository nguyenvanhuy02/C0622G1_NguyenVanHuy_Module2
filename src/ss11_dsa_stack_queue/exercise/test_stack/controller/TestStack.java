package ss11_dsa_stack_queue.exercise.test_stack.controller;

import java.util.Scanner;
import java.util.Stack;

public class TestStack {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Người dùng nhập: ");
        String a = scanner.nextLine();
        System.out.println(checkBracket(a));
    }
    static boolean checkBracket(String a) {
        Stack<Character> brackets = new Stack<>();
        char sym;
        for (int i = 0; i < a.length(); i++) {
            sym = a.charAt(i);
            if (a.charAt(i) == '(') {
                brackets.push(sym);
            }
            if (sym == ')') {
                if (brackets.isEmpty()) {
                    return false;
                } else if (brackets.pop() != '(') {
                    return false;
                }
            }
        }
        return brackets.isEmpty();
    }
}