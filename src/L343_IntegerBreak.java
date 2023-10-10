package src;

/**
 * Given an integer n, break it into the sum of k positive integers, where k >= 2, and maximize the product of those integers.
 *
 * Return the maximum product you can get.
 *
 *
 *
 * Example 1:
 *
 * Input: n = 2
 * Output: 1
 * Explanation: 2 = 1 + 1, 1 × 1 = 1.
 * Example 2:
 *
 * Input: n = 10
 * Output: 36
 * Explanation: 10 = 3 + 3 + 4, 3 × 3 × 4 = 36.
 *
 *
 * Constraints:
 *
 * 2 <= n <= 58
 */

public class L343_IntegerBreak {
    public int integerBreak(int n) {
        if(n == 2 || n == 3){ // this is the bas e case if n == 2 || n == 3 the return n-1
            return n-1;
        }
        int[]dp = new int[n+1]; // creating n+1 length array, so to store the max value of n and already visited integer
        if(dp[n]!=0){
            return dp[n];
        }
        return recursion(n, dp);
    }

    public int recursion(int n, int[] dp){
        if(n == 2 || n == 3){ // for recursion the base case will become this, take the example 9 -> 3*3*3 -> 27, if instead of three we give 2 then the product will get less
            return n;
        }

        if(dp[n] != 0){
            return dp[n];
        }

        for(int i = 2; i<=n/2; i++){ // just a simple graph implementation till n/2
            // why n/2?
            // let's take an example 6
            // 6 -> 1,5 2,4  3,3  4,2  5,1 these will the first layer node creation, but we can se 4,2 or 2,4 is same as the product will be same. Same with 1,5
            // why starting from 2?
            // bcz 1 is not there in the constraint and can not be break into two +ve integer
            // and recursion will not let n to become 1 -> this is need to keep in mind
            dp[n] = Math.max(dp[n], recursion(i, dp) * recursion(n-i, dp));
        }

        return dp[n]; // returning the max
    }
}
