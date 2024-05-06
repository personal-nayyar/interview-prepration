package code.problems.array;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class RelativeSorting {
    public static void main(String[] args){

        int[] arr1 = {2, 1, 2, 5, 7, 1, 9, 3, 6, 8, 8};
        int[] arr2 = {2, 1, 8, 3};
        sortRelative(arr1, arr2);
        System.out.println(Arrays.toString(arr1));
    }
    static void sortRelative(int[] arr1, int[] arr2){
        Map<Integer, Integer> freqMap = new HashMap<>();
        for (int el: arr1){
            freqMap.put(el, freqMap.getOrDefault(el, 0)+1);
        }
        final int[] i = new int[]{0};
        for (int el: arr2){
            if (freqMap.containsKey(el)){
                int freq = freqMap.get(el);
                while (freq > 0){
                    arr1[i[0]++] =  el;
                    freq--;
                }
                freqMap.remove(el);
            }
        }

        freqMap.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .forEach(entry -> {
                    int key =  entry.getKey();
                    int freq =  entry.getValue();
                    while (freq > 0){
                        arr1[i[0]++] = key;
                        freq--;
                    }
                });
    }
}
