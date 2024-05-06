package code.problems.array;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class SubArrayWithTargetSum {
    static int[] subArrayWithGivenSum(int[] arr, int target){
        int start =0, end =0;
        int currSum = 0;
        while(end < arr.length){
            while(start< arr.length && currSum > target)
                currSum -= arr[start++];
            if (currSum == target)
                return new int[]{start,end};
            currSum += arr[end++];
        }
        return new int[]{-1,-1};
    }

    static int[] subArrayWithGivenSum2(int[] arr, int target){
        Map<Integer, Integer> prefixSum =  new HashMap<>(); // to store sum 0 to i
        int currSum = 0;
        for (int i = 0; i < arr.length; i++) {
            currSum += arr[i];
            if (prefixSum.containsKey(currSum-target))
                return new int[]{prefixSum.get(currSum-target)+1, i};
            prefixSum.put(currSum, i);
        }
        return new int[]{-1,-1};
    }
}

class LargestSubArrayWithGivenSum{
    static int findLargestSubArrayWithGivenSum(int[] arr, int target){
        Map<Integer, Integer> prefixSum =  new HashMap<>();
        int currSum = 0, maxLen = 1;
        for (int i = 0; i < arr.length; i++) {
            currSum += arr[i];
            if (prefixSum.containsKey(currSum-target))
                    maxLen = Math.max(maxLen, i-prefixSum.get(currSum-target)+1);
            prefixSum.put(currSum, i);
        }
        return maxLen;
    }
}

class LargestSubArrayWithSumClosestToZero{
    static int[] findLargestSubArrayWithSumClosestToZero(int[] arr){
        Map<Integer, Integer> prefixSum =  new HashMap<>();
        int currSum = 0, maxLen = 1;
        for (int i = 0; i < arr.length; i++) {
            currSum += arr[i];
            if (prefixSum.containsKey(currSum))
                    return new int[]{prefixSum.get(currSum)+1, i};
            prefixSum.put(currSum, i);
        }

        // sort by key
        List<Map.Entry<Integer, Integer>> sortedEntries =  prefixSum.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .toList();

        // find two consecutive entry with min difference
        int minDiff =  Integer.MAX_VALUE;
        int[] pair = new int[]{-1,-1};
        for (int i = 1; i < sortedEntries.size(); i++) {
            int diff = sortedEntries.get(i).getKey() - sortedEntries.get(i-1).getKey();
            if (diff < minDiff){
                minDiff =  diff;
                pair =  new int[]{sortedEntries.get(i).getValue(), sortedEntries.get(i-1).getValue()};
            }
        }
        return pair;
    }
}
