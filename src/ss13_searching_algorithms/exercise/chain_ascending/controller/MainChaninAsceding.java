package ss13_searching_algorithms.exercise.chain_ascending.controller;

import java.util.Scanner;

public class MainChaninAsceding {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Người dùng nhập vào: ");
        String string = scanner.nextLine();

        System.out.println(chain(string));
    }
    public static String chain (String str){
        String chains = "";
        String result = "";

        for (int i = 0; i < str.length()-1 ; i++) {
           chains+= str.charAt(i);
           for(int j = i+1; j < str.length(); j++) {
               if(str.charAt(j) > str.charAt(i)){
                   chains+= str.charAt(j);
                   i = j;
               }
           }
           result = chains.length() > result.length() ? chains : result;
           chains = "";
        }
        return result;
    }
}
