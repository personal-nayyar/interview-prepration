package code.problems.dp;

public class CoinChangeProblem {
    static int minCoin(int[] coins, int target){
        int n =  coins.length;
        int[][] dp = new int[n+1][target+1];

        // if target = 0
        for (int i = 0; i <= n; i++) {
            dp[i][0] = 0;
        }

        // coin 0
        for (int j = 0; j <= target; j++) {
            dp[0][j] = 0;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= target; j++) {
                if (coins[i] > j) // can't include this coin
                    dp[i][j] = dp[i-1][j];
                else{
                    dp[i][j] = Math.min(
                            1+ // to include current coin
                                dp[i][j-coins[i-1]],// include this coin
                            dp[i-1][j]// not include this coin
                    );
                }
            }
        }
        return dp[n][target];
    }
}

