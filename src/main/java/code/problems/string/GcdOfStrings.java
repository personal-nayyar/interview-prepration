package code.problems.string;

/**
 https://leetcode.com/problems/greatest-common-divisor-of-strings/description/?envType=study-plan-v2&envId=leetcode-75
 */

public class GcdOfStrings {
    public static void main(String[] args) {
        String str1 = "ABCABC";
        String str2 = "ABCD";
        System.out.println(gcdOfString(str1, str2));
        System.out.println(gcdOfStrings(str1, str2));
    }

    static String gcdOfString(String str1, String str2) {
        // Assumption str1 len > str2 len
        if (str1.length() < str2.length())
            return gcdOfString(str2, str1);
        if (str1.equals(str2))
            return str1;
        if (str1.indexOf(str2) == 0)
            return gcdOfStrings(str2, str1.substring(str2.length()));
        return "";
    }

    static String gcdOfStrings(String str1, String str2) {
        if (!(str1 + str2).equals(str2 + str1)) {
            return "";
        }
        int gcd = getGcd(str1.length(), str2.length());
        return str1.substring(0, gcd);
    }

    private static int getGcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return getGcd(b, a % b); // if b does not divide a evenly, then the remainder is the GCD
    }
}
