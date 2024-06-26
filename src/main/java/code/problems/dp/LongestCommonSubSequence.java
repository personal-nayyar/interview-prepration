package code.problems.dp;

public class LongestCommonSubSequence {
    public static void main(String[] args) {
        System.out.println(findLongestCommonSubSequence("abcdxyz","xyzabcd"));
        System.out.println(findLongestCommonSubSequence("intention", "execution"));
    }
    static int findLongestCommonSubSequence(String s1, String s2){
        int[][] dp = new int[s1.length()+1][s2.length()+1];
        // base cases
        if (s1.isEmpty() || s2.isEmpty())
            return 0;

        // s2 empty
        for (int i = 0; i <= s1.length(); i++) {
            dp[i][0] = 0;
        }

        // s1 empty
        for (int j = 0; j <= s2.length(); j++) {
            dp[0][j] = 0;
        }

        for (int i = 1; i <= s1.length(); i++) {
            for (int j = 1; j <= s2.length(); j++) {
                if (s1.charAt(i-1) == s2.charAt(j-1))
                    dp[i][j] = 1+dp[i-1][j-1];
                else
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
            }
        }
        return dp[s1.length()][s2.length()];
    }
}
