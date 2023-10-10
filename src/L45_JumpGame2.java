package src;

/**
 * You are given a 0-indexed array of integers nums of length n. You are initially positioned at nums[0].
 *
 * Each element nums[i] represents the maximum length of a forward jump from index i. In other words, if you are at
 * nums[i], you can jump to any nums[i + j] where:
 *
 * 0 <= j <= nums[i] and
 * i + j < n
 * Return the minimum number of jumps to reach nums[n - 1]. The test cases are generated such that you can reach nums[n - 1].
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [2,3,1,1,4]
 * Output: 2
 * Explanation: The minimum number of jumps to reach the last index is 2. Jump 1 step from index 0 to 1, then 3 steps to the last index.
 * Example 2:
 *
 * Input: nums = [2,3,0,1,4]
 * Output: 2
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 104
 * 0 <= nums[i] <= 1000
 * It's guaranteed that you can reach nums[n - 1].
 */

import java.util.Arrays;

public class L45_JumpGame2 {

    // need to be  more optimize
    public int jump(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, Integer.MAX_VALUE); // filling with max value
        return recursion(nums, 0, dp)-1;
    }

    public int recursion(int[] arr, int index, int[] dp){
        if(index == arr.length-1){ // iif its reach at its destination return 1
            return 1;
        }

        if(index >= arr.length || arr[index] == 0){ // when arr gets out of bound, or arr[index] == 0 mean there is no more way from here
            return 0;
        }

        if(dp[index] != Integer.MAX_VALUE){ // if already visited place then return dp[index]+1 as we are jumping back
            return dp[index]+1;
        }

        for(int i = arr[index];i>0;i--){// creating graph for the problem
            int a = recursion(arr, index+i, dp);
            if(a != 0){
                dp[index] = Math.min(dp[index], a);
            }
        }

        if(dp[index] == Integer.MAX_VALUE){ // if this condition gets true means, there is no possible way exist from here
            return 0;
        }

        return dp[index]+1; // while backtracking increasing the jump
    }
}
