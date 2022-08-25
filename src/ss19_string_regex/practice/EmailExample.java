package ss19_string_regex.practice;


public class EmailExample {
    public static void main(String[] args) {
        String regex = "[A-Za-z0-9]+[A-Za-z0-9]*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)";
        System.out.println("maohuy123312@gmail.com".matches(regex));
    }


}
