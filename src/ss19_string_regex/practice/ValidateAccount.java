package ss19_string_regex.practice;

public class ValidateAccount {
    public static void main(String[] args) {
        String regex = "[_a-z0-9]{6,}";
        System.out.println("123abc_".matches(regex));
    }
}
