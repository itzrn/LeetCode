package src;

/**
 * You have n dice, and each die has k faces numbered from 1 to k.
 *
 * Given three integers n, k, and target, return the number of possible ways (out of the kn total ways) to roll the dice,
 * so the sum of the face-up numbers equals target. Since the answer may be too large, return it modulo 10^9 + 7.
 *
 *
 *
 * Example 1:
 *
 * Input: n = 1, k = 6, target = 3
 * Output: 1
 * Explanation: You throw one die with 6 faces.
 * There is only one way to get a sum of 3.
 * Example 2:
 *
 * Input: n = 2, k = 6, target = 7
 * Output: 6
 * Explanation: You throw two dice, each with 6 faces.
 * There are 6 ways to get a sum of 7: 1+6, 2+5, 3+4, 4+3, 5+2, 6+1.
 * Example 3:
 *
 * Input: n = 30, k = 30, target = 500
 * Output: 222616187
 * Explanation: The answer must be returned modulo 109 + 7.
 *
 *
 * Constraints:
 *
 * 1 <= n, k <= 30
 * 1 <= target <= 1000
 */

import java.util.Arrays;

public class L1155_NumberOfDiceRollsWithTargetSum {
    public int numRollsToTarget(int n, int k, int target) {

        // this can also be done using Map with key -> n and value -> target left
        int[][] dp = new int[n+1][target+1]; // making 2d dp, this is bcz here we will see the already visited element like nth dice and target left
        for(int[] x: dp){
            Arrays.fill(x, -1); // filling dp with -1, this is to identify already visited element
        }


        return recursion(n, k, target, dp);
    }

    int mod = 1000000007;
    public int recursion(int n, int k, int target, int[][] dp){
        if(n == 0 && target == 0){ // base case to return 1
            return 1;
        }

        if(n == 0 || target <= 0){ // base case to return 0
            return 0;
        }

        if(dp[n][target] != -1){ // if there is already visited, then return that particular dp element
            return dp[n][target];
        }
        int count = 0;

        // this is just like creation of graph, which have some path from root to leaf already visited which stored in dp
        for(int i = 1; i<=k; i++){
            count += recursion(n-1, k, target-i, dp);
            count %= mod;
        }

        return dp[n][target] = count;
    }
}
