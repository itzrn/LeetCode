package src;

/**
 * The Fibonacci numbers, commonly denoted F(n) form a sequence, called the Fibonacci sequence,
 * such that each number is the sum of the two preceding ones, starting from 0 and 1. That is,
 *
 * F(0) = 0, F(1) = 1
 * F(n) = F(n - 1) + F(n - 2), for n > 1.
 * Given n, calculate F(n).
 *
 *
 *
 * Example 1:
 *
 * Input: n = 2
 * Output: 1
 * Explanation: F(2) = F(1) + F(0) = 1 + 0 = 1.
 * Example 2:
 *
 * Input: n = 3
 * Output: 2
 * Explanation: F(3) = F(2) + F(1) = 1 + 1 = 2.
 * Example 3:
 *
 * Input: n = 4
 * Output: 3
 * Explanation: F(4) = F(3) + F(2) = 2 + 1 = 3.
 *
 *
 * Constraints:
 *
 * 0 <= n <= 30
 */

public class L509_FibonacciNumber {

    public int fib(int n) {
        if(n == 0){ // base case 1
            return 0;
        }else if(n==1){ // base case 2
            return 1;
        }

        int[] dp = new int[n+1]; // making dp of size n+1, bcz we have to find fib of n,
        // means we have to reach till n number, so to store the fib(n) we need n+1 size dp
        dp[0] = 0; // initial condition 1
        dp[1] = 1; // initial condition 2
        return recursionDp(dp)[n];
    }

    public int[] recursionDp(int[] dp){ // using dp method
        for(int i = 2;i<dp.length;i++){ // storing the previously calculated fib, using which we are calculating fib(i)
            dp[i] = dp[i-1]+dp[i-2];
        }
        return dp;
    }
}
