package code.problems.string.slidingWindow;

import java.util.HashMap;
import java.util.Map;

/**
 Input: String="araaci", K=2
 Output: 4
 Explanation: The longest substring with no more than '2' di
 stinct characters is "araa".
 */
public class LongestSubStringAtmostKDistintCharacter {

    static int[] longestSubStringWithKDistinctChar(char[] chars, int k){
        Map<Character, Integer> freqMap = new HashMap<>();
        int wSt = 0,  maxLen =  0;
        for (int i = 0; i < chars.length; i++) {
            freqMap.put(chars[i], freqMap.getOrDefault(chars[i], 0)+1);

            // if reach to more than k dis char, try removing element from start
            while(freqMap.size() >= k){
                int freq = freqMap.get(chars[wSt]);
                freq--;
                if (freq == 0) //need to remove this character from map
                    freqMap.remove(chars[wSt]);
                wSt++;
            }
            maxLen = Math.max(maxLen, i-wSt+1);
        }
        return new int[]{wSt, wSt+maxLen};
    }
}
