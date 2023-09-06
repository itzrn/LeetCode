package src;

/**
 * You are a professional robber planning to rob houses along a street. Each house has a certain amount of money
 * stashed, the only constraint stopping you from robbing each of them is that adjacent houses have security
 * systems connected and it will automatically contact the police if two adjacent houses were broken into on the same night.
 *
 * Given an integer array nums representing the amount of money of each house, return the maximum amount of
 * money you can rob tonight without alerting the police.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [1,2,3,1]
 * Output: 4
 * Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).
 * Total amount you can rob = 1 + 3 = 4.
 * Example 2:
 *
 * Input: nums = [2,7,9,3,1]
 * Output: 12
 * Explanation: Rob house 1 (money = 2), rob house 3 (money = 9) and rob house 5 (money = 1).
 * Total amount you can rob = 2 + 9 + 1 = 12.
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 100
 * 0 <= nums[i] <= 400
 */

public class L198_HouseRobber {
    public int rob(int[] nums) {
        if(nums.length == 1){ // base case
            return nums[0];
        }
        int i = 0;
        while(i<nums.length && nums[i]==0){ // this is calculating if all the values of array is 0
            i++;
        }
        if(i == nums.length){
            return 0;
        }

        int[] dp = new int[nums.length];
        return Math.max(recursion(nums, dp, 0), recursion(nums, dp, 1));
        // doing recursion for index 0 and 1, bcz starting from 1 we are not counting the money so doing for both 0 and 1
    }

    public int recursion(int[] arr, int[] dp, int start){
        if(start+2 >= arr.length){ // base case, to not go out of bound
            return arr[start];
        }

        if(dp[start] > arr[start]){ // using dp, so not calculate for already visited index
            return dp[start];
        }
        int max = 0; // keeping max, to calculate the max value among all i for a recursion
        // is starting from start+2 to avoid police, according to que
        for(int i = start+2;i<arr.length;i++){ // this for loop making graph structure, to calculate for all possibilities
            int temp = recursion(arr, dp, i);
            dp[start] = Math.max(dp[start], arr[start]+temp); // dp is storing the max value of already visited index
            if(dp[start] > max){
                max = dp[start];
            }
        }
        return max;
    }
}
