package code.problems.array;

/**
 https://leetcode.com/problems/can-place-flowers/description/?envType=study-plan-v2&envId=leetcode-75
 */
public class CanPlaceFlowers {
    static boolean canPlaceFlowers(int[] flowerbed, int n){
        if(n == 0)
            return true;
        if (flowerbed.length < n)
            return false;
        for (int i = 0; i < flowerbed.length; i++) {
            boolean prev = false, next = false;
            if (flowerbed[i] == 0){ // empty slot
                prev =  i == 0 || flowerbed[i - 1] == 0;
                next = i == flowerbed.length - 1 || flowerbed[i + 1] == 0;
                if (prev && next){
                    n--;
                    if (n == 0)
                        return true;
                    flowerbed[i] = 1;
                }
            }
        }
        return false;
    }
}
