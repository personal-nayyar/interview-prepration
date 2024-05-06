package code.problems.dp;

import java.util.Arrays;

public class LongestIncresingSubSequence {
    static int findLongestIncresingSubSequence(int[] arr){
        int n = arr.length;
        int[] lis =  new int[n];
        Arrays.fill(lis, 1);

        for (int i = 1; i < n; i++) {
            for (int j = i-1; j >=0 ; j--) {
                if (arr[j] < arr[i])
                    lis[i] = Math.max(lis[i], lis[j]+1);
            }
        }
        return Arrays.stream(lis).max().getAsInt();
    }
}
