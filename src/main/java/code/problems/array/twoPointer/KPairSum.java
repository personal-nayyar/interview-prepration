package code.problems.array.twoPointer;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/max-number-of-k-sum-pairs/description/?envType=study-plan-v2&envId=leetcode-75
 */
public class KPairSum {
    public static void main(String[] args) {
        System.out.println(maxOperations(new int[]{1,2,3,4}, 5));
        System.out.println(maxOperations(new int[]{3,1,3,4,3}, 6));
    }
    static int maxOperations(int[] arr, int k){
        Arrays.sort(arr);
        int cnt = 0;
        for (int i = 0, j= arr.length-1; i < j;) {
            if (arr[i]+arr[j] == k){
                cnt++;
                i++;
                j--;
            }else if (arr[i]+arr[j] < k){
                i++;
            }else
                j--;
        }
        return cnt;
    }
}
