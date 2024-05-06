package code.problems.array.slidingWindow;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.IntStream;

/**
 * https://leetcode.com/problems/maximum-average-subarray-i/description/?envType=study-plan-v2&envId=leetcode-75
 */
public class MaximumSumSubArray {
    public static void main(String[] args) {
//        System.out.println(maxSumSubArrayLengthK(new int[]{1,12,-5,-6,50,3}, 4));
//        System.out.println(maxSumSubArrayLengthK(new int[]{5}, 1));

        System.out.println(vowelCount("weallloveyou", 7));
    }
    static double maxSumSubArrayLengthK(int[] arr, int k){
        double kSum = 0;
        for (int i = 0; i < k; i++) {
            kSum += arr[i];
        }

        double maxSum = kSum;
        for (int i = 0, j= k; j < arr.length; i++,j++) {
            kSum += arr[j]-arr[i];
            maxSum = Math.max(kSum, maxSum);
        }
        return maxSum/k;
    }

    static int vowelCount(String s, int k){
        int cnt = 0;
        Set<Character> vowels = new HashSet<>(Arrays.asList('a','e','i','o','u'));
        for (int i = 0; i < k; i++) {
            if (vowels.contains(s.charAt(i)))
                cnt++;
        }

        int maxCount = cnt;
        for (int i = 0, j =k ; j < s.length() ; i++, j++) {
            System.out.println("cnt:"+cnt);
            if (vowels.contains(s.charAt(i)))
                cnt--;
            if (vowels.contains(s.charAt(j)))
                cnt++;
            maxCount = Math.max(cnt, maxCount);
        }
        return maxCount;
    }
}
