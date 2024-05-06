package code.problems.dp;

import java.util.Collections;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LongestConsecutiveSubSequence {
    static int findLongestConsecutiveSubSequence(int[] arr){
        Set<Integer> lookup = new HashSet<>();
        for (int el: arr)
            lookup.add(el);

        int lcs = 1;
        for (int el: arr){
            if (!lookup.contains(el-1)){ // can this be start of seq
                int cnt = 1;
                while (lookup.contains(el+cnt))
                    cnt++;
                lcs = Math.max(lcs,cnt);
            }
        }
        return lcs;
    }
}
