package code.problems.array;


import static code.problems.utils.Utils.swap;

public class SmallestPositiveMissing {

    public static void main(String[] args) {
        Integer[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, -1, -2, -3, -4, -5, -6, -7, -8, -9, -10};
        System.out.println(findSmallestPositiveMissing(arr));

        arr = new Integer[]{2, 3, -7, 6, 8, 1, -10, 15};
        System.out.println(findSmallestPositiveMissing(arr));
    }
    static int findSmallestPositiveMissing(Integer[] arr){
        int i=0, n = arr.length;
        while (i< n){
            int correct =  arr[i]-1;
            if (arr[i] > 0 && arr[i] <=n  // to check range from 1 to N only for cycle sort
                    && arr[i] != arr[correct]){
                swap(arr, i, correct);
            }else{
                i++;
            }
        }

        for (int j = 0; j < n; j++) {
            if (arr[j] != j+1)
                return j+1;
        }
        return n+1;
    }

    static void cycleSort(Integer[] arr){
        int i = 0;
        while (i < arr.length){
            int correctIndex =  arr[i]-1;
            if (arr[i] != arr[correctIndex]){
                swap(arr, i, correctIndex);
            }else{
                i++;
            }
        }
    }
}
