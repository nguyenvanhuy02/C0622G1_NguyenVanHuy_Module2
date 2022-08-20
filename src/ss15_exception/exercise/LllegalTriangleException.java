package ss15_exception.exercise;

import java.util.Scanner;

public class LllegalTriangleException {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double a =0;
        double b =0;
        double c =0;
        while (true){
            try {
                System.out.print("Nhập cạnh a của tam giác: ");
                a = Double.parseDouble(scanner.nextLine());
                if(a<0){
                    throw new TriangleException("Cạnh nhập vào phải lớn > 0 , vui lòng bạn nhập lại");
                }
                break;
            }catch (NumberFormatException e ){
                System.out.println("Số bạn nhập không phù hợp vui lòng nhập lại!");
            }catch (TriangleException p){
                System.out.println(p.getMessage());
            }
        }
        while (true){
            try {
                System.out.print("Nhập cạnh b của tam giác: ");
                b = Double.parseDouble(scanner.nextLine());
                if(b<0){
                    throw new TriangleException("Cạnh nhập vào phải lớn > 0 , vui lòng bạn nhập lại");
                }
                break;
            }catch (NumberFormatException e ){
                System.out.println("Số bạn nhập không phù hợp vui lòng nhập lại!");
            }catch (TriangleException p){
                System.out.println(p.getMessage());
            }
        }
        while (true){
            try {
                System.out.print("Nhập cạnh c của tam giác: ");
                c = Double.parseDouble(scanner.nextLine());
                if(c<0){
                    throw new TriangleException("Cạnh nhập vào phải lớn > 0 , vui lòng bạn nhập lại");
                }
                break;
            }catch (NumberFormatException e ){
                System.out.println("Số bạn nhập không phù hợp vui lòng nhập lại!");
            }catch (TriangleException p){
                System.out.println(p.getMessage());
            }
        }

        if ((a + b) < c || (a + c) < b || (b + c) < a){
            try {
                throw new SumTrianghleException("Tổng 2 số phải lớn hơn số còn lại , vui lòng bạn nhập lại!");
            }catch (SumTrianghleException e){
                System.out.println(e.getMessage());
            }
        }else {
            System.out.println("Cạnh a: " + a);
            System.out.println("Cạnh b: " + b);
            System.out.println("Cạnh c: " + c);
        }
    }
}
