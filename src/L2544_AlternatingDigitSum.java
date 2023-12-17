package src;

/**
 * You are given a positive integer n. Each digit of n has a sign according to the following rules:
 *
 * The most significant digit is assigned a positive sign.
 * Each other digit has an opposite sign to its adjacent digits.
 * Return the sum of all digits with their corresponding sign.
 *
 *
 *
 * Example 1:
 *
 * Input: n = 521
 * Output: 4
 * Explanation: (+5) + (-2) + (+1) = 4.
 * Example 2:
 *
 * Input: n = 111
 * Output: 1
 * Explanation: (+1) + (-1) + (+1) = 1.
 * Example 3:
 *
 * Input: n = 886996
 * Output: 0
 * Explanation: (+8) + (-8) + (+6) + (-9) + (+9) + (-6) = 0.
 *
 *
 * Constraints:
 *
 * 1 <= n <= 109
 */

public class L2544_AlternatingDigitSum {
    public int alternateDigitSum(int n) {
        int a = recursion(n);

        return ans;
    }

    int ans = 0;
    public int recursion(int n){ // returning 1 or -1, is to identify the number is need to be added or subtracted
        if(n == 0){
            return 1;
        }

        int temp = n%10; // on the basis of return +ve or -ve, temp will add or get subtract in ans
        if(recursion(n/10) == 1){
            ans += temp;
            return -1;
        }

        ans -= temp;
        return 1;
    }
}
