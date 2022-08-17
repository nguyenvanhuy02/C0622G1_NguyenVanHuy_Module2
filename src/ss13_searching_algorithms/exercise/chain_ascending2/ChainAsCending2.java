package ss13_searching_algorithms.exercise.chain_ascending2;

import java.util.Scanner;

public class ChainAsCending2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Người dùng nhập vào: ");
        String string = scanner.nextLine();
        System.out.println(chain(string));
    }

    public static String chain(String str) {
        String chains = "";
        String result = "";

        for (int i = 0; i < str.length() - 1; i++) {
            chains += str.charAt(i);
            for (int j = i + 1; j < str.length(); j++) {
                if (str.charAt(j) > str.charAt(i)) {
                    chains += str.charAt(j);
                    i = j;
                } else {
                    i = j-1;
                    break;
                }
            }
            result = chains.length() > result.length() ? chains : result;
            chains = "";
        }
        return result;
    }
}
