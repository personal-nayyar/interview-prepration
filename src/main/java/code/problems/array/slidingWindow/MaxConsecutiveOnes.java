package code.problems.array.slidingWindow;

/**
 https://leetcode.com/problems/max-consecutive-ones-iii/description/
 */
public class MaxConsecutiveOnes {
    static int maxLengthConsecutiveOnes(int[] arr, int k){
        int n =  arr.length;
        int zero = 0, st=0, end=0, maxLen=0;
        while (end<n){
            if (arr[end] == 0)
                zero++;
            while (zero > k){
                if (arr[st] == 0)
                    zero--;
                st++;
            }
            maxLen =  Math.max(maxLen, end-st+1);
            end++;
        }
        return maxLen;
    }
}
