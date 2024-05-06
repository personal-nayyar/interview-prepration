package code.problems.string;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class LongestNonReapingString {
    public static void main(String[] args) {
        System.out.println(lengthLongestNonReapingString("abba"));
        System.out.println(lengthNonRepeatingSubString("abba"));
    }
    static int lengthLongestNonReapingString(String s){
        char[] chars = s.toCharArray();
        Map<Character, Integer> lastIndexOf = new HashMap<>();
        lastIndexOf.put(chars[0], 0);
        int st = 0, maxLen = 1;
        for (int i = 1; i < chars.length; i++) {
            char key = chars[i];
            if (lastIndexOf.containsKey(key) && st <= lastIndexOf.get(key)){
                maxLen = Math.max(maxLen, i- st);
                st = lastIndexOf.get(key)+1;
            }
            lastIndexOf.put(key, i);
        }
        return maxLen;
    }

    static int lengthNonRepeatingSubString(String str){

        int start = 0, maxLen = 1;
        int[] lastIndexOf = new int[26];
        Arrays.fill(lastIndexOf, -1);

        // Move end of current window
        for (int i = 0; i < str.length(); i++) {

            // Find the last index of str[i]
            // Update start (starting index of current window)
            // as maximum of current value of start and last index of i plus 1
            start = Math.max(start, lastIndexOf[str.charAt(i)-'a'+1] + 1);
            // abba
            // lastIndexOf['a'] = 0, start = 0
            // lastIndexOf['b'] = 1, start = 0
            // lastIndexOf['b'] = 2, start = 2
            // lastIndexOf['a'] = 3, start = 2

            // Update result if we get a larger window
            maxLen = Math.max(maxLen, i - start + 1);

            // Update last index of j.
            lastIndexOf[str.charAt(i)-'a'+1] = i;
        }
        return maxLen;
    }
}
