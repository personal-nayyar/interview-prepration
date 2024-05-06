package companies.oracle;

/**
 * https://www.geeksforgeeks.org/problems/total-decoding-messages1235/1#
 */
public class TotalDecodingMessage {
    public static void main(String[] args) {
        String s = "226";
        System.out.println(decodeWays(s));
        System.out.println(decodeWaysDp(s));

        s =  "10";
        System.out.println(decodeWays(s));
        System.out.println(decodeWaysDp(s));
    }

    static int decodeWays(String s){
        char[] digits = s.toCharArray();
        int n =  digits.length;
        if (n == 0 || (n == 1 && digits[0] == '0'))
            return 0;
        return decodeUtil(digits, n);
    }

    static int decodeUtil(char[] digits, int n){
        // base condition
        if (n == 0 || n == 1 && digits[0] != '0')
            return 1;

        // for base condition "01123" should return 0
        if (digits[0] == '0')
            return 0;

        // Initialize count
        int count = 0;

        // If the last digit is not 0, then
        // last digit must add to
        // the number of words
        if (digits[n - 1] > '0')
            count = decodeUtil(digits, n - 1);

        // If the last two digits form a number
        // smaller than or equal to 26,
        // then consider last two digits and recur
        if (digits[n - 2] == '1'
                || (digits[n - 2] == '2'
                && digits[n - 1] <= '6'))
            count += decodeUtil(digits, n - 2);

        return count;
    }

    static int decodeWaysDp(String s){
        char[] digits = s.toCharArray();
        int n =  digits.length;
        if (n == 0 || (n == 1 && digits[0] == '0'))
            return 0;
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++){
            if (digits[i - 1] > '0')
                dp[i] = dp[i - 1];
            if (digits[i - 2] == '1'
                    || (digits[i - 2] == '2'
                    && digits[i - 1] <= '6'))
                dp[i] += dp[i - 2];
        }
        return dp[n];
    }

}
