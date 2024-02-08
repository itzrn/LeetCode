package src;

/**
 * Given an integer n, return the least number of perfect square numbers that sum to n.
 *
 * A perfect square is an integer that is the square of an integer; in other words, it is the product of some integer
 * with itself. For example, 1, 4, 9, and 16 are perfect squares while 3 and 11 are not.
 *
 *
 *
 * Example 1:
 *
 * Input: n = 12
 * Output: 3
 * Explanation: 12 = 4 + 4 + 4.
 * Example 2:
 *
 * Input: n = 13
 * Output: 2
 * Explanation: 13 = 4 + 9.
 *
 *
 * Constraints:
 *
 * 1 <= n <= 104
 */

public class L279_PerfectSquare {
    public int numSquares(int n) {
        Integer[] dp = new Integer[n+1];
        return recursion(n,dp);
    }
    public int recursion(int n, Integer[] dp){ // normal dfs
        if(n == 0){
            return 0;
        }

        if(dp[n] != null){
            return dp[n];
        }

        int min= Integer.MAX_VALUE;

        // here we are using top - down dp, as we can see dp starts to fill from n then at last index 0 of dp gets fill
        for(int i=1; i*i<=n; i++){
            min = Math.min(min, 1 + recursion(n - i*i, dp));
        }

        return dp[n] = min;
    }
}
