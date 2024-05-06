package code.problems.mix;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class generateBinary {

    public static void main(String[] args) {
        System.out.println(generateBinary(3));
    }
    static List<String> generateBinary(int n){
        int[] arr =  new int[n];
        List<String> allBinary  = new ArrayList<>();
        generateBinaryUtil(arr, 0, allBinary);
        return allBinary;
    }
    
    static void generateBinaryUtil(int[] arr, int i, List<String> binary) {
        if(i >= arr.length){
            binary.add(Arrays.toString(arr));
            return;
        }
        arr[i] = 0;
        generateBinaryUtil(arr, i + 1, binary);
        arr[i] = 1;
        generateBinaryUtil(arr, i + 1, binary);
    }
}
