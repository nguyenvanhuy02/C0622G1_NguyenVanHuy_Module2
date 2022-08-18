package ss14_sort.exercise.insertion_sort;

public class SetInsertionSort {
    public static void insertonSort(int[]array){
        for (int i = 1; i < array.length ; i++) {
            int key = array[i];
            int j;
            for ( j = i -1 ; j >= 0 && array[j] > key ; j--) {
                array[j + 1 ] = array[j];
            }
            array[j + 1 ] = key;
        }
    }
}
