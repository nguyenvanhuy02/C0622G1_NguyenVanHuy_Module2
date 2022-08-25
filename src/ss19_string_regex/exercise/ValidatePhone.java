package ss19_string_regex.exercise;

import java.util.Scanner;
import java.util.regex.Pattern;

public class ValidatePhone {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String regex ="[(][0-9]{2}[)]-[(]0[0-9]{9}[)]";
        while (true){
            try {
                System.out.print("Vui lòng nhập số điện thoại (xx)-(0xxxxxxxxx): ");
                String phone = scanner.nextLine();
                if (!(phone.matches(regex))){
                    throw new CheckException("Số điện thoại bạn nhập sai vui lòng nhập lại!");
                }else {
                    System.out.println("Số điện thoại hợp lệ!");
                }
                break;
            }catch (CheckException e){
                System.out.println(e.getMessage());
            }
        }
    }
}
