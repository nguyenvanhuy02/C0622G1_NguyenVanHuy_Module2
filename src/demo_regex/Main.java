package demo_regex;

import java.util.*;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        String regexDate =  "^([0-2][0-9]||3[0-1])/(0[0-9]||1[0-2])/([0-9][0-9])?[0-9][0-9]$";
        Scanner sc = new Scanner(System.in);

        String date = sc.nextLine();
        if(Pattern.matches(regexDate, date)) {
            System.out.println("nhap dung");
        } else {
            System.out.println("Nhap sai");
        }

    }
}
