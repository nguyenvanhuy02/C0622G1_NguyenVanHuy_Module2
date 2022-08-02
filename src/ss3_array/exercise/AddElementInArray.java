package ss3_array.exercise;

import java.util.Arrays;
import java.util.Scanner;

public class AddElementInArray {
    public static void main(String[] args) {
        int[] number = {1,2,3,4,5,6,7,8,9,10};
        Scanner scanner = new Scanner(System.in);
        System.out.print("Số muôn thêm: ");
        int numberAdd = scanner.nextInt();
        System.out.print("Vị trí muốn thêm: ");
        int indexAdd = scanner.nextInt();

        for (int i = number.length -1 ; i > indexAdd ; i--) {
            number[i]=number[i-1];
        }
        number[indexAdd]=numberAdd;
        System.out.println(Arrays.toString(number));
    }
}
