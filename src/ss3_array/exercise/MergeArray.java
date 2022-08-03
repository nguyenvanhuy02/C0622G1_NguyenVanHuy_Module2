package ss3_array.exercise;
import java.util.Arrays;
import java.util.Scanner;

public class MergeArray {
    public static void main(String[] args) {
        int[] array1 = new int[10];
        int[] array2 = new int[5];
        int[] array3 = new int[15];
        Scanner scan = new Scanner(System.in);
        int i = 0;
        int j = 0;
        int c = array1.length + array2.length;

        System.out.println("Input Array1");
        while (i < array1.length) {
            System.out.println("Enter elements " + (i + 1) + ": ");
            array1[i] = scan.nextInt();
            i++;
        }

        System.out.println("Input Array2");
        while (j < array2.length) {
            System.out.println("Enter elements " + (j + 1) + ": ");
            array2[j] = scan.nextInt();
            j++;
        }

        for (i = 0; i < array1.length; i++) {
            array3[i] = array1[i];
        }

        for (int k = 0; k < array2.length ; k++) {
            array3[array1.length + k] = array2[k];
        }

        System.out.println(Arrays.toString(array3));
    }
}

//import java.util.Arrays;
//
//public class MergeArray {
//    public static void main(String[] args) {
//        int[] arrayOne = {1, 2, 3, 4, 5};
//        int[] arrayTwo = {6, 10, 7, 8, 9};
//        int[] arrayTh = new int[arrayOne.length + arrayTwo.length];
//
//        for (int i = 0; i < arrayOne.length; i++) {
//            arrayTh[i] = arrayOne[i];
//        }
//        for (int j = 0; j < arrayTwo.length; j++) {
//            arrayTh[arrayOne.length + j] = arrayTwo[j];
//        }
//        System.out.println(Arrays.toString(arrayTh));
//
//    }
//}
