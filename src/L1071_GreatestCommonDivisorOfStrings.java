package src;

/**
 * For two strings s and t, we say "t divides s" if and only if s = t + ... + t (i.e., t is concatenated with itself one or more times).
 *
 * Given two strings str1 and str2, return the largest string x such that x divides both str1 and str2.
 *
 *
 *
 * Example 1:
 *
 * Input: str1 = "ABCABC", str2 = "ABC"
 * Output: "ABC"
 * Example 2:
 *
 * Input: str1 = "ABABAB", str2 = "ABAB"
 * Output: "AB"
 * Example 3:
 *
 * Input: str1 = "LEET", str2 = "CODE"
 * Output: ""
 *
 *
 * Constraints:
 *
 * 1 <= str1.length, str2.length <= 1000
 * str1 and str2 consist of English uppercase letters.
 */

public class L1071_GreatestCommonDivisorOfStrings {
    public String gcdOfStrings(String str1, String str2) { // this is the way to find the gcd of two string
        String a = str1 + str2;
        String b = str2 + str1;
        if(!a.equals(b)){
            return "";
        }

        return str1.substring(0, gcd(str1.length(), str2.length()));
    }

    public int gcd(int x, int y) { // this is the way to find the gcd of any two number
        if (y == 0) {
            return x;
        } else {
            return gcd(y, x % y);
        }
    }
}
