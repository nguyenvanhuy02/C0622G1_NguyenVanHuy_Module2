package ss3_array.exercise;

import java.util.Scanner;

public class CountCharactersChain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count = 0;
        String chain = "hihihihahaha";
        char charOne = scanner.nextLine().charAt(0);
        for (int i = 0; i < chain.length() ; i++) {
            if (charOne == chain.charAt(i)) {
                count++;
            }
        }
        System.out.println(count);
    }
}
