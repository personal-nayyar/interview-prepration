package code.problems.dp;

public class RegularExpressionMatch {
    static boolean match(String text, String  pat){
        boolean[][] dp =  new boolean[text.length()+1][pat.length()+1];
        dp[0][0] = true;
        // deal with * 
        for (int j = 1; j <= pat.length(); j++) {
            if (pat.charAt(j-1) == '*') // match before this char
                dp[0][j] = dp[0][j-2];
        }

        // for remaining char
        for (int i = 1; i <= text.length(); i++) {
            for (int j = 1; j <= pat.length() ; j++) {
                if (pat.charAt(j-1) == '.' || pat.charAt(j-1) == text.charAt(i-1))
                    dp[i][j] =  dp[i-1][j-1];
                if (pat.charAt(j-1) == '*'){
                    if (pat.charAt(j-2) != '.' && pat.charAt(j-2) != text.charAt(i-1))
                        dp[i][j] = dp[i][j-2];
                    else
                        dp[i][j] = dp[i-1][j] //in this case, a* counts as multiple a
                                 || dp[i][j-1] // in this case, a* counts as single a
                                 || dp[i][j-2]; // in this case, a* counts as empty
                }
            }
        }
        return dp[text.length()][pat.length()];
    }
}
