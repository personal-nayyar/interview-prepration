package code.problems.string.slidingWindow;

public class SmallestWindowContainPatternSeq {
    static int[] smallestWindow(char[] text, char[] pat){
        int CHAR_COUNTS =  26;
        int[] freqPat = new int[CHAR_COUNTS];
        int[] freqText = new int[CHAR_COUNTS];

        for (char el: pat)
            freqPat[el-'a'+1]++;

        int cnt = 0, wSt = 0, minLength = Integer.MAX_VALUE;
        for (int i = 0; i < text.length; i++) {
            int curr = text[i] - 'a'+1;
            freqText[curr]++;

            // if freqPat[c] >= freqText[c]
            if (freqPat[curr] > freqText[curr])
                cnt++;

            // narrow-down if whole pattern found
            while (cnt == pat.length){
                // freqText[wSt] > freqPat[wst]  => ingore else dec cnt
                if (freqText[wSt-'a'+1] > freqPat[wSt-'a'+1])
                    wSt++;
                else{
                    cnt--;
                    minLength = Math.min(minLength, i-wSt+1);
                }
            }
        }
        return new int[]{wSt, wSt+minLength};
    }
}
