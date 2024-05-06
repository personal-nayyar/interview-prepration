package code.problems.array;

public class StockBuySell {
    public static void main(String[] args) {
        int[] arr = {7, 1, 5, 3, 6, 1};
        System.out.println(maxProfitSingleTransaction(arr));
        System.out.println(maxProfitMultiTransaction(arr));
        System.out.println(maxProfitMultiTransaction2(arr));
    }
    static int maxProfitSingleTransaction(int[] arr){
        int min = Integer.MAX_VALUE;
        int maxProfit = Integer.MIN_VALUE;
        for (int j : arr) {
            min = Math.min(min, j);
            maxProfit = Math.max(maxProfit, j - min);
        }
        return maxProfit;
    }

    static int maxProfitMultiTransaction(int[] arr){
        int maxProfit = 0;
        for (int i = 0; i < arr.length; i++) {
            int j = i;
            while(j< arr.length-1 && arr[j] < arr[j+1])
                j++;
            maxProfit += arr[j]- arr[i];
            i = j;
        }
        return maxProfit;
    }

    static int maxProfitMultiTransaction2(int[] arr){
        int maxProfit = 0;
        for (int i = 1; i < arr.length; i++) {
            maxProfit+= Math.max(arr[i] - arr[i - 1], 0);
        }
        return maxProfit;
    }
}
