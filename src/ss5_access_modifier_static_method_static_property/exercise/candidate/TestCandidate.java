package ss5_access_modifier_static_method_static_property.exercise.candidate;


import java.util.Arrays;
import java.util.Scanner;

public class TestCandidate {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập số lượng học sinh: ");
        int n = Integer.parseInt(scanner.nextLine());
        int m = n+1;

        Candidate[] candidates = new Candidate[n];

        while (n > 0){
            System.out.println("Học sinh thứ " + (m-n));
            System.out.print("Nhập mã: ");
            int code = Integer.parseInt(scanner.nextLine());
            System.out.print("nhập tên: ");
            String name = scanner.nextLine();
            System.out.print("Nhập ngày tháng năm sinh: ");
            String  dateOfBirth = scanner.nextLine();
            System.out.print("Nhập điểm toán: ");
            int math = Integer.parseInt(scanner.nextLine());
            System.out.print("Nhập điểm Văn:");
            int literature = Integer.parseInt(scanner.nextLine());
            System.out.print("nhập điểm anh: ");
            int english = Integer.parseInt(scanner.nextLine());


            Candidate candidate = new Candidate(code,name,dateOfBirth,math,literature,english);
            candidates[n-1]= candidate;
            n--;

        }
        //Hiển thị các học sinh :
//        for (Candidate showcandidate : candidates){
//            System.out.println(showcandidate);
//        }



        //Hiển thị các phần tử trong mảng :
//        System.out.println(Arrays.toString(candidates));


        // Hiển thị các học sinh có tổng điểm trên 15
        for (int i = 0; i < candidates.length ; i++) {
            if (candidates[i].getTottal() > 15 ){
                System.out.println("Những học sinh có tổng điểm trên 15 : " + candidates[i]);
            }
        }

        }







}
