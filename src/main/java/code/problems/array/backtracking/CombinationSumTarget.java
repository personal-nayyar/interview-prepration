package code.problems.array.backtracking;

import java.util.ArrayList;
import java.util.List;
/**
 https://leetcode.com/problems/combination-sum/description/
 */
public class CombinationSumTarget {

    public static void main(String[] args) {

        int[] candidates = {2, 3, 6, 7};
        int target = 7;
        System.out.println(combinationSum(candidates, target));
    }
    static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        combinationSumUtil(candidates, target, 0, new ArrayList<>(), result);
        return result;
    }

    static void combinationSumUtil(int[] candidates, int target, int index, List<Integer> list, List<List<Integer>> result) {
        if (target == 0) {
            result.add(new ArrayList<>(list));
            return;
        }
        if (target < 0) {
            return;
        }
        for (int i = index; i < candidates.length; i++) {
            list.add(candidates[i]); // include current element in combination
            combinationSumUtil(candidates, target - candidates[i], i, list, result);
            list.remove(list.size() - 1); // backtracking, exclude current element
        }
    }

    static void combinationsUtil(Integer[] arr, int target, int index, List<Integer> list, List<List<Integer>> result){
        if(target == 0){
            result.add(new ArrayList<>(list));
            return;
        }
        if(target < 0 || index >= arr.length)
            return;
        list.add(arr[index]); // include current element to combination
        combinationsUtil(arr, target-arr[index], index, list, result);
        list.remove(list.size()-1); // exclude current element from combination
        combinationsUtil(arr, target, index+1, list, result);
    }
}
