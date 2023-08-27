package src;

/**
 * An ugly number is a positive integer whose prime factors are limited to 2, 3, and 5.
 *
 * Given an integer n, return true if n is an ugly number.
 *
 *
 *
 * Example 1:
 *
 * Input: n = 6
 * Output: true
 * Explanation: 6 = 2 × 3
 * Example 2:
 *
 * Input: n = 1
 * Output: true
 * Explanation: 1 has no prime factors, therefore all of its prime factors are limited to 2, 3, and 5.
 * Example 3:
 *
 * Input: n = 14
 * Output: false
 * Explanation: 14 is not ugly since it includes the prime factor 7.
 *
 *
 * Constraints:
 *
 * -231 <= n <= 231 - 1
 */
public class L263_UglyNumber {
    public boolean isUgly(int n) {
        if(n < 1){
            return false;
        }
        int[] arr = {2,3,5};
        for(int i = 0;i<arr.length;i++){
            n = keepDividingWhenDivisible(n, arr[i]);
        } // after the completion of disability by 2,3 and 5, if n == 1 means there is no more prime factor available with n
        // and if n!=1 means n is left with prime factors other than 2,3 and 5
        return n == 1;
    }

    public int keepDividingWhenDivisible(int n, int m){  // dividing the number until it's divisible by 2,3 and 5
        while(n % m == 0){
            n /= m;
        }
        return n;
    }
}
