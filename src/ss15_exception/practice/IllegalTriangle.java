package ss15_exception.practice;

import java.util.Scanner;

public class IllegalTriangle {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double edge1 = 0;
        double edge2 = 0;
        double edge3 = 0;

        while (true) {
            try {
                System.out.println("Nhập độ dài cạnh thứ nhất của tam giác: ");
                edge1 = Double.parseDouble(scanner.nextLine());
                if (edge1 < 0) {
                    throw new TriangleException("Bạn nhập độ dài cạnh không hợp lệ");
                }
                System.out.println("Nhập độ dài cạnh thứ hai của tam giác: ");
                edge2 = Double.parseDouble(scanner.nextLine());
                if (edge2 < 0) {
                    throw new TriangleException("Bạn nhập độ dài cạnh không hợp lệ");
                }
                System.out.println("Nhập độ dài cạnh thứ ba của tam giác: ");
                edge3 = Double.parseDouble(scanner.nextLine());
                if (edge3 < 0) {
                    throw new TriangleException("Bạn nhập độ dài cạnh không hợp lệ");
                }
                if ((edge1 + edge2) <= edge3 || (edge1 + edge3) <= edge2 || (edge2 + edge3) <= edge1) {
                    throw new TriangleException("Tổng hai cạnh bất kì phải lớn hơn cạnh còn lại");
                }
                break;
            } catch (NumberFormatException e) {
                System.out.println("Bạn nhập vào không hợp lệ. Vui lòng nhập số!");
            } catch (TriangleException e) {
                System.out.println(e.getMessage());
            } catch (Exception e) {
                System.out.println("Bạn nhập không hợp lệ");
            }
        }

        System.out.println("Độ dài ba lần lượt là: " + edge1 + ", " + edge2 + ", " + edge3);
    }
}
