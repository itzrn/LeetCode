package src;

/**
 * You are climbing a staircase. It takes n steps to reach the top.
 *
 * Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
 *
 *
 *
 * Example 1:
 *
 * Input: n = 2
 * Output: 2
 * Explanation: There are two ways to climb to the top.
 * 1. 1 step + 1 step
 * 2. 2 steps
 * Example 2:
 *
 * Input: n = 3
 * Output: 3
 * Explanation: There are three ways to climb to the top.
 * 1. 1 step + 1 step + 1 step
 * 2. 1 step + 2 steps
 * 3. 2 steps + 1 step
 *
 *
 * Constraints:
 *
 * 1 <= n <= 45
 */

public class L70_ClimbingStairs {
    public int climbStairs(int n) {
        int[] dp = new int[n];
        return recursiveDp(dp,n-1);
    }

    public int recursiveDp(int[] dp, int n){ // using top-down dp, means instead of climbing up the stairs, climbing down the stairs
        if(n < -1){ // base case
            return 0;
        }
        if(n == -1){ // if n becomes -1 means we reached at the top of the stairs
            return 1;
        }
        if(dp[n] > 0){ // dp is used to store the number of ways to reach at the top from stair n, so if in future we reach at this point, already visited point
            // we won't go in any further recursion, instead we calculate it in O(1)
            return dp[n];
        }

        int oneStep = recursiveDp(dp, n-1); // moving one step
        int twoStep = recursiveDp(dp, n-2); // moving two steps

        dp[n] = oneStep + twoStep; // storing ways to reach at the top from stair n

        return dp[n]; // returning dp[n], bcz we want the ways to reach at the top when we ar the starting stairs
    }
}
