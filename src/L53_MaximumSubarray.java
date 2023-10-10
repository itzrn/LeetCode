package src;

import java.util.Arrays;

/**
 * Given an integer array nums, find the
 * subarray
 *  with the largest sum, and return its sum.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
 * Output: 6
 * Explanation: The subarray [4,-1,2,1] has the largest sum 6.
 * Example 2:
 *
 * Input: nums = [1]
 * Output: 1
 * Explanation: The subarray [1] has the largest sum 1.
 * Example 3:
 *
 * Input: nums = [5,4,-1,7,8]
 * Output: 23
 * Explanation: The subarray [5,4,-1,7,8] has the largest sum 23.
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 105
 * -104 <= nums[i] <= 104
 */

public class L53_MaximumSubarray {
    // this algo is with best time complexity, we can do this in one pass, as recursion uses two pass(recursion, backtracking) which takes lots of time
    public int maxSubArray(int[] nums) {
        int max = nums[nums.length-1]; // assuming the max sum subarray is only the last index(subarry can just only be one index)
        for(int i = nums.length-2;i>=0;i--){ // iterating from last second index to index o
            nums[i] = Math.max(nums[i], nums[i]+nums[i+1]); // this calculates the max value for index, like if index itself is grater than after summing itself with
            // following subarray then the max value for that particular index gets itself, else the sum with the following subarray
            max = Math.max(nums[i], max);
        }

        return max;
    }

    // this takes 17 ms
    public int maxSubArray2(int[] nums) {
        int a = recursion1(nums, 0);
        return max;
    }
    int max = Integer.MIN_VALUE;
    public int recursion1(int[] arr, int index){
        if(index == arr.length-1){
            max = Math.max(arr[index], max);
            return arr[index];
        }

        int temp = recursion1(arr, index+1);
        arr[index] = Math.max(arr[index], arr[index]+arr[index+1]);
        max = Math.max(arr[index], max);

        return arr[index];
    }


    // this takes 19 ms
    public int maxSubArray3(int[] nums) {
        int[]dp = new int[nums.length];
        Arrays.fill(dp, Integer.MIN_VALUE);
        dp[nums.length-1] = nums[nums.length-1];
        int a = recursion2(nums, dp, 0);
        return max1;
    }
    int max1 = Integer.MIN_VALUE;
    public int recursion2(int[] arr, int[] dp, int index){
        if(dp[index] != Integer.MIN_VALUE){
            max1 = Math.max(dp[index], max);
            return dp[index];
        }

        int temp = recursion2(arr, dp, index+1);
        dp[index] = Math.max(arr[index], arr[index]+dp[index+1]);
        max1 = Math.max(dp[index], max1);

        return dp[index];
    }
}
