package src;

/**
 * You are given an integer array nums. You are initially positioned at the array's first index,
 * and each element in the array represents your maximum jump length at that position.
 *
 * Return true if you can reach the last index, or false otherwise.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [2,3,1,1,4]
 * Output: true
 * Explanation: Jump 1 step from index 0 to 1, then 3 steps to the last index.
 * Example 2:
 *
 * Input: nums = [3,2,1,0,4]
 * Output: false
 * Explanation: You will always arrive at index 3 no matter what. Its maximum jump length is 0, which makes it impossible to reach the last index.
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 104
 * 0 <= nums[i] <= 105
 */

import java.util.Arrays;

// need to optimize
public class L55_JumpGame {
    public boolean canJump(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp,-1);
        // filling the dp with -1,bcz 0 will represent that from here no possible way is and 1 will represent there is no need to explore more
        // using this way you can reach the destination

        return recursion(nums, 0, dp) == 1; // returning 1 at the end will represent that there is at-least one way to reach destination
    }

    public int recursion(int[] arr, int index, int[] dp){
        if(index >= arr.length){ // base case if the index getting out of bound
            return 0;
        }

        if(index == arr.length-1){ // when we reach to destination, return 1
            dp[index] = 1;
            return 1;
        }

        if(arr[index] == 0){ // this case represent when arr[index] contains 0, means from this particular index we can not move anymore and need to find another way
            dp[index] = 0;
            return 0;
        }

        if(dp[index] != -1){ // using dp
            return dp[index];
        }

        for(int i = arr[index]; i>0; i--){ // responsible for creating the graph
            dp[index] = recursion(arr, index+i, dp);
            if(dp[index] == 1){
                break;
            }
        }

        return dp[index];
    }
}
