package code.problems.array.hashing;

import java.util.Arrays;

/**
 *https://leetcode.com/problems/increasing-triplet-subsequence/description/?envType=study-plan-v2&envId=leetcode-75
 */
public class IncreasingTripletSubSequence {
    public static void main(String[] args) {
//        System.out.println(increasingTriplet2(new int[]{1,2,3,4,5}));
//        System.out.println(increasingTriplet2(new int[]{5,4,3,2,1}));
//        System.out.println(increasingTriplet2(new int[]{2,1,5,0,4,6}));
        System.out.println(increasingTriplet2(new int[]{20,100,10,12,5,13}));
    }
   /*
   Example 1:

Input: nums = [1,2,3,4,5]
Output: true
Explanation: Any triplet where i < j < k is valid.
Example 2:

Input: nums = [5,4,3,2,1]

Output: false
Explanation: No triplet exists.
Example 3:

Input: nums = [2,1,5,0,4,6]
              [2,1,1,0,0,0]
              [6,6,6,6,6,6]
              [f,f,t]
Output: true
Explanation: The triplet (3, 4, 5) is valid because nums[3] == 0 < nums[4] == 4 < nums[5] == 6.
    */

    public static boolean increasingTriplet(int[] nums){
        int[] lis = new int[nums.length];
        Arrays.fill(lis, 1);
        for (int i = 1; i < nums.length; i++) {
            for (int j = i-1; j >=0 ; j--) {
                if (nums[i] > nums[j])
                    lis[i] = Math.max(lis[i], lis[j]+1);
            }
        }
        return Arrays.stream(lis).anyMatch(l -> l >=3);
    }

    public static boolean increasingTriplet3(int[] nums){
        int n =  nums.length;
        if (n < 3)
            return false;
        int[] lMin = new int[n]; lMin[0] = nums[0];
        int[] rMax = new int[n]; rMax[n-1] = nums[n-1];
        for (int i = 1; i < n; i++) {
            lMin[i] = Math.min(lMin[i], nums[i]);
        }
        for (int j = n-2; j >=0 ; j--) {
            rMax[j] = Math.max(rMax[j], nums[j]);
        }

        for (int i = 0; i < n; i++) {
            if (lMin[i] < nums[i] && nums[i] < rMax[i])
                return true;
        }
        return false;
    }
    public static boolean increasingTriplet2(int[] nums) {
        if (nums == null || nums.length < 3) {
            return false;
        }
        int a = Integer.MAX_VALUE; // lMin
        int b = Integer.MAX_VALUE; // mid, having b ensures there's also an a<b that comes before b

        for (int num : nums) { // rMax
            if (num <= a) {
                a = num;
            } else if (num <= b) {
                b = num;
            } else {  // rMax
                return true;
            }
        }
        return false;
    }
}