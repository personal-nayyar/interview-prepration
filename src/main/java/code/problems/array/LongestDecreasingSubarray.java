package code.problems.array;

public class LongestDecreasingSubarray {
    public static int[] findLongestDecreasingSubarray(int[] nums) {
        int maxLength = 1;
        int currentLength = 1;
        int endIndex = 0;
        int maxEndIndex = 0;
        
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < nums[i - 1]) {
                currentLength++;
                if (currentLength > maxLength) {
                    maxLength = currentLength;
                    endIndex = i;
                }
            } else {
                currentLength = 1;
            }
        }
        
        int[] result = new int[maxLength];
        for (int i = maxLength - 1; i >= 0; i--) {
            result[i] = nums[endIndex--];
        }
        return result;
    }
    
    public static void main(String[] args) {
        int[] nums = {5, 4, 3, 2, 1, 6, 7, 8, 9};
        int[] longestDecreasingSubarray = findLongestDecreasingSubarray(nums);
        System.out.println("Longest decreasing subarray:");
        for (int num : longestDecreasingSubarray) {
            System.out.print(num + " ");
        }
    }
}
