package src;

/**
 * Given an integer array nums, return the length of the longest strictly increasing
 * subsequence
 * .
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [10,9,2,5,3,7,101,18]
 * Output: 4
 * Explanation: The longest increasing subsequence is [2,3,7,101], therefore the length is 4.
 * Example 2:
 *
 * Input: nums = [0,1,0,3,2,3]
 * Output: 4
 * Example 3:
 *
 * Input: nums = [7,7,7,7,7,7,7]
 * Output: 1
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 2500
 * -104 <= nums[i] <= 104
 *
 *
 * Follow up: Can you come up with an algorithm that runs in O(n log(n)) time complexity?
 */

import java.util.Arrays;

public class L300_LongestIncreasingSubsequence {

    // this method is iterative dp
    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1); // filling dp with '1', bcz every element is the longest increasing subsequence in itself

        for(int i = nums.length-1; i>=0; i--){ // this takes O(N^2)
            for(int j = i+1; j< nums.length; j++){
                if(nums[i] < nums[j]){
                    dp[i] = Math.max(dp[i], 1 + dp[j]);
                }
            }
        }

        int max = 0;
        for(int i : dp){ // picking out the max of dp
            if(i > max){
                max = i;
            }
        }

        return max;
    }
}
