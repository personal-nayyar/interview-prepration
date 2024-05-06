package code.problems.array.twoPointer;

import java.lang.reflect.Array;
import java.util.Arrays;

public class maxWaterCollect {
    public static void main(String[] args) {
        System.out.println(maxWater(new int[]{1,1}));
        System.out.println(maxWater(new int[]{1,8,6,2,5,4,8,3,7}));
    }
    static int maxWater(int[] arr){
        int n = arr.length;
        if (n == 1)
            return 0;
        int[] lMax = new int[n]; lMax[0] = arr[0];
        int[] rMax = new int[n]; rMax[n-1] = arr[n-1];

        // build lMax
        for (int i = 1; i < n; i++) {
            lMax[i] = Math.max(lMax[i-1], arr[i]);
        }

        // build lMax
        for (int i = n-2; i >=0; i--) {
            rMax[i] = Math.max(rMax[i+1], arr[i]);
        }

        int maxCollect = 0, curr = 0;
        for (int i = 0, j= n-1; i < j;) {
            curr = Math.min(lMax[i], rMax[j]) * (j-i);
            maxCollect =  Math.max(curr, maxCollect);
            if (arr[i] < arr[j])
                i++;
            else
                j--;
        }
        return maxCollect;
    }
}
