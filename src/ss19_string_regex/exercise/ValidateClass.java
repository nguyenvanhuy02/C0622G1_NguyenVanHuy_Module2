package ss19_string_regex.exercise;

import java.util.Scanner;
import java.util.regex.Pattern;

public class ValidateClass {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String regex = "[CAP][0-9]{4}[GHIKLM]";
         while (true) {
            try {
                System.out.println("Người dùng nhập tên lớp '(C|A|P)XXXX(G,H,I,K,L,M)' - X là số:");
                String nameClass = scanner.nextLine();
                if (!(Pattern.compile(regex).matcher(nameClass).find())) {
                    throw new CheckException("Tên lớp của bạn không hợp lệ vui lòng nhập lại!");
                }else {
                    System.out.println("Tên bạn hợp lệ!");
                }
                break;
            } catch (CheckException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
