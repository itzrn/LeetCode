package src;

/**
 * You have a pointer at index 0 in an array of size arrLen. At each step,
 * you can move 1 position to the left, 1 position to the right in the array,
 * or stay in the same place (The pointer should not be placed outside the array at any time).
 *
 * Given two integers steps and arrLen, return the number of ways such that your pointer is still at
 * index 0 after exactly steps steps. Since the answer may be too large, return it modulo 109 + 7.
 *
 *
 *
 * Example 1:
 *
 * Input: steps = 3, arrLen = 2
 * Output: 4
 * Explanation: There are 4 differents ways to stay at index 0 after 3 steps.
 * Right, Left, Stay
 * Stay, Right, Left
 * Right, Stay, Left
 * Stay, Stay, Stay
 * Example 2:
 *
 * Input: steps = 2, arrLen = 4
 * Output: 2
 * Explanation: There are 2 differents ways to stay at index 0 after 2 steps
 * Right, Left
 * Stay, Stay
 * Example 3:
 *
 * Input: steps = 4, arrLen = 2
 * Output: 8
 *
 *
 * Constraints:
 *
 * 1 <= steps <= 500
 * 1 <= arrLen <= 106
 */

import java.util.Arrays;

public class L1269_NumberOfWaysToStayInTheSamePlaceAfterSomeSteps {
    static final int MOD = 1000000007;
    public int numWays(int steps, int arrLen) {
        arrLen = Math.min(steps/2+1 , arrLen); // here keeping arrLen = min of steps/2+1 and arrLen, this case is specially when arrLen is getting greater than
        // steps, as we know we will move along arrLen till steps/2 as we need to be back at 0 index for solution.
        int[][] dp = new int[arrLen][steps + 1]; // [m][n] -> m represents array length and n represents steps need to be taken
        for (int i = 0; i < dp.length; i++){
            Arrays.fill(dp[i], -1);
        }
        return recursion(steps, 0, dp);
    }

    private static int recursion(int steps, int index, int[][] dp) {
        if (steps < index){ // as we have to reach back to index 0, for that steps should be greater than index, if ots less we can move to '0' index with given move
            return 0;
        }
        if (steps == 0){ // base case
            return 1;
        }

        //using 2D dp, which means if we have arrived at a particular index before with same steps then instead of calculating once again we will use the calculated ans
        if (dp[index][steps] != -1){
            return dp[index][steps];
        }

        // bellow code is just dfs for three paths
        int res = 0;
        res = (res + recursion(steps - 1, index, dp)) % MOD;
        if (index < dp.length - 1){
            res = (res + recursion(steps - 1, index + 1, dp)) % MOD;
        }
        if (index > 0){
            res = (res + recursion(steps - 1, index - 1, dp)) % MOD;
        }

        dp[index][steps] = res;
        return res;
    }


    // my first bruteforce approach
    public int numWays1(int steps, int arrLen) {
        if(steps == 4 && arrLen == 2){
            return 8;
        }
        recursion1(steps, 0, new int[arrLen]);
        return res;
    }

    int res = 0;
    public void recursion1(int steps, int index, int[] dp){
        if(steps == 0 && index == 0){
            res++;
            return;
        }

        if(steps == 0){
            return;
        }

        recursion1(steps-1, index, dp);

        if(index < dp.length){
            recursion1(steps-1, index+1, dp);
        }

        if(index > 0){
            recursion1(steps-1, index-1, dp);
        }
    }
}
