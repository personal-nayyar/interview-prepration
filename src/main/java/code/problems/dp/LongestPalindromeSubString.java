package code.problems.dp;

public class LongestPalindromeSubString {
    static int lengthOfLongestPalindromeSubString(String s){
        int n = s.length();
        boolean[][] dp = new boolean[n][n];

        // for l=1
        int maxLen = 1;
        for (int i = 0; i <= n; i++) {
            dp[i][i] = true;
        }

        // for l=2
        for (int i = 0; i < n-1; i++) {
            if (s.charAt(i) == s.charAt(i+1)){
                dp[i][i+1] = true;
                maxLen = 2;
            }
        }

        // for l>=3
        for (int len = 3; len <= n; len++) {
            for (int i = 0; i <= n-len-1; i++) {
                int j =i+len-1;
                if (s.charAt(i) == s.charAt(j) && dp[i+1][j-1])
                    maxLen =  Math.max(maxLen,len);
            }
        }
        return maxLen;
    }
}
