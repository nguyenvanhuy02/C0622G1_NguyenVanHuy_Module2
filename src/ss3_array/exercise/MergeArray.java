package ss3_array.exercise;

import java.util.Arrays;

public class MergeArray {
    public static void main(String[] args) {
        int[] arrayOne = {1, 2, 3, 4, 5};
        int[] arrayTwo = {6, 10, 7, 8, 9};
        int[] arrayTh = new int[arrayOne.length + arrayTwo.length];

        for (int i = 0; i < arrayOne.length; i++) {
            arrayTh[i] = arrayOne[i];
        }
        for (int j = 0; j < arrayTwo.length; j++) {
            arrayTh[arrayOne.length + j] = arrayTwo[j];
        }
        System.out.println(Arrays.toString(arrayTh));

    }
}
