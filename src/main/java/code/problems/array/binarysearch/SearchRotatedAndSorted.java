package code.problems.array.binarysearch;

import java.util.Arrays;

public class SearchRotatedAndSorted {

    public static void main(String[] args) {
        int[] arr = {4, 5, 6, 7, 0, 1, 2};
        System.out.println(findIndex(arr, 6));
    }
    static int findIndex(int[] arr, int key){
        int pivot = pivotedIndex(arr);
        if (key > arr[0])
            return Arrays.binarySearch(arr, 0, pivot-1, key);
        else
            return Arrays.binarySearch(arr, pivot, arr.length-1, key);
    }

    static int pivotedIndex(int[] arr){
        return pivotedIndexUtil(arr, 0, arr.length-1);
    }
    static int pivotedIndexUtil(int[] arr, int l, int r){
        // base case
        if(l >= r)
            return l;
        int mid =  (l+r)/2;
        if (arr[mid] > arr[mid+1])
            return mid+1;
        if (arr[l] < arr[r]) // already sorted
            return l;
        if (arr[l] < arr[mid]) // left part sorted
            return pivotedIndexUtil(arr, mid+1, r);
        else
            return pivotedIndexUtil(arr, l, mid-1);
    }
}
