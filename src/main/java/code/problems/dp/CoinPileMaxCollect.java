package code.problems.dp;

import java.util.List;

public class CoinPileMaxCollect {
    static int maxCollect(List<List<Integer>> piles, int k){
        return maxCollectUtil(piles, 0, k);
    }

    static int maxCollectUtil(List<List<Integer>> piles, int pileIndex, int k){
        if (pileIndex == piles.size())
            return 0;
        // collect 0 from current pile
        int bestCollect = maxCollectUtil(piles, pileIndex+1, k);
        // collect i from current pile
        int pickedAmount = 0;
        for (int i = 1; i <= Math.min(k, piles.get(pileIndex).size()); i++) {
            pickedAmount += piles.get(pileIndex).get(i-1);
            bestCollect += Math.max(bestCollect, pickedAmount+maxCollectUtil(piles, pileIndex, k-i));
        }
        return bestCollect;
    }

    static int maxCollectDp(List<List<Integer>> piles, int k){
        int[][] dp = new int[piles.size()][k+1];
        return computeMax(0, piles, k, dp);
    }

    static int computeMax(int pileIndex, List<List<Integer>> piles, int k, int[][] dp){
        if(pileIndex == piles.size() || k==0)
            return 0;

        if(dp[pileIndex][k] != -1)
            return dp[pileIndex][k];

        int bestCollect = computeMax(pileIndex+1, piles, k, dp); //don't pick any from the current pile
        int pickAmount = 0;
        for (int i = 0; i < Math.min(k, piles.get(pileIndex).size()); i++) { // pick i+1 coins from current pile
            pickAmount += piles.get(pileIndex).get(i);
            bestCollect = Math.max(bestCollect, pickAmount+computeMax(pileIndex+1, piles, k-(i+1), dp));
        }
        return dp[pileIndex][k] = bestCollect;
    }
}
