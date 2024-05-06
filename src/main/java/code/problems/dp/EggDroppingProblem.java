package code.problems.dp;

public class EggDroppingProblem {
    public static void main(String[] args) {
        System.out.println(minTrail(1, 2));
        System.out.println(minTrail(2, 6));


        System.out.println(minTrailDp(1, 2));
        System.out.println(minTrailDp(2, 6));
    }
    static int minTrail(int egg, int floor){
        // base case
        if (egg == 1 || floor <= 1)
            return floor;
        int minTrail = Integer.MAX_VALUE;
        for (int i = 1; i <= floor; i++) {
            int maxPos = Math.max(
                    minTrail(egg-1, i-1) //if egg break
                    ,minTrail(egg, floor-i)); // if egg doesn't break
            minTrail = Math.min(maxPos, minTrail);
        }
        return 1+ // for current attempt
                minTrail;
    }

    static int minTrailDp(int egg, int floor){
        int[][] dp =  new int[egg+1][floor+1];

        // for egg 1
        for (int j = 0; j <= floor; j++) {
            dp[1][j] = j;
        }

        // if floor 1
        for (int i = 0; i <= egg; i++) {
            dp[i][0] = 0;
            dp[i][1] = 1;
        }
        for (int i = 2; i <= egg; i++) {
            for (int j = 2; j <= floor; j++) {
                // check if floor < egg, already computed
                if (i > j)
                    dp[i][j] =  dp[i-1][j];
                else{
                    dp[i][j] = Integer.MAX_VALUE;
                    for (int x = 1; x <= j; x++) { // x = floor
                        int currTrail = Math.max(
                                dp[i-1][x-1], // egg break
                                dp[i][j-x] // doesn't break
                        );
                        dp[i][j] = Math.min(dp[i][j], 1+currTrail);
                    }
                }
            }
        }
        return dp[egg][floor];
    }
}