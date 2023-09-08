package src;

/**
 * You are given an integer array cost where cost[i] is the cost of ith step on a staircase.
 * Once you pay the cost, you can either climb one or two steps.
 *
 * You can either start from the step with index 0, or the step with index 1.
 *
 * Return the minimum cost to reach the top of the floor.
 *
 *
 *
 * Example 1:
 *
 * Input: cost = [10,15,20]
 * Output: 15
 * Explanation: You will start at index 1.
 * - Pay 15 and climb two steps to reach the top.
 * The total cost is 15.
 * Example 2:
 *
 * Input: cost = [1,100,1,1,1,100,1,1,100,1]
 * Output: 6
 * Explanation: You will start at index 0.
 * - Pay 1 and climb two steps to reach index 2.
 * - Pay 1 and climb two steps to reach index 4.
 * - Pay 1 and climb two steps to reach index 6.
 * - Pay 1 and climb one step to reach index 7.
 * - Pay 1 and climb two steps to reach index 9.
 * - Pay 1 and climb one step to reach the top.
 * The total cost is 6.
 *
 *
 * Constraints:
 *
 * 2 <= cost.length <= 1000
 * 0 <= cost[i] <= 999
 */

import java.util.Arrays;

public class L746_MinCostClimbingStairs {

    public int minCostClimbingStairs(int[] cost) {
        if(cost.length == 2){ // base case 1
            return Math.min(cost[0], cost[1]);
        }else if(cost.length == 3){ // base case 2
            return Math.min(cost[1], cost[0] + cost[2]);
        }

        int[] dp = new int[cost.length];
        Arrays.fill(dp, -1); // this is the way to fill the array with a number
        // filling dp array with -1, which indicates we didn't reach that stair, so we have to first calculate the previous stairs cost

        return Math.min(recursion(cost, dp, cost.length-1), dp[cost.length-2]);
        // as we can start from stair -> arr.length-1 or index -> arr.length-2, so returning min of those two index
    }

    public int recursion(int[] arr, int[] dp, int index){
        // this function is like (index -> arr.length-1)bottom to (index -> 0)top while recursion and top to bottom to top while back tracking
        // so, if we see w.r.t recursion, it's moving from index -> arr.length - 1 to index -> 0 and then from index -> 0 to arr.length - 1
        // if we see w.r.t dp, dp is getting fill from index -> 0 to arr.length - 1(while back tracking) so we say top to bottom dp

        if(index == 0 || index == 1){ // this indicates that we reached at the top
            // why considering index = 1 also as the top?, bcz if index = 1 have the low cost to reach at the top then why we should increase the cost
            // from moving 1 step to index = 0 then top instead of directly taking 2 step to the top
            return arr[index];
        }
        if(dp[index] != -1){ // if this condition gets true, means we already reached to the stair, and the min cost from this stair to top is dp[index]
            return dp[index];
        }

        int oneStep = recursion(arr, dp, index-1);
        int twoStep = recursion(arr, dp, index-2);
        // above two lines are like, tree generating lines

        dp[index] = arr[index] + Math.min(oneStep, twoStep); // storing the min cost while back tracking, so if in future we reach the same index
        // instead of exploring that index we can directly use the already calculated calue

        return dp[index]; //returning the min cost
    }
}
