package ss13_searching_algorithms.exercise.binary_search.model;

public class BinarySearch {
    public static int binarySearch(int[]array , int k , int left , int right){
        if (right >= left){
            int mid = (right + left)/2;

            if (k==array[mid]){
                return mid;
            }
            if (k > array[mid]){
                return binarySearch(array,k,mid + 1,right);
            }
            if (k < array[mid]){
                return binarySearch(array,k,left,mid-1);
            }
        }
        return -1;
    }
}
