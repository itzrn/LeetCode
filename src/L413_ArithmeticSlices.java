package src;

/**
 * An integer array is called arithmetic if it consists of at least three elements and if the difference between any two consecutive elements is the same.
 *
 * For example, [1,3,5,7,9], [7,7,7,7], and [3,-1,-5,-9] are arithmetic sequences.
 * Given an integer array nums, return the number of arithmetic subarrays of nums.
 *
 * A subarray is a contiguous subsequence of the array.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [1,2,3,4]
 * Output: 3
 * Explanation: We have 3 arithmetic slices in nums: [1, 2, 3], [2, 3, 4] and [1,2,3,4] itself.
 * Example 2:
 *
 * Input: nums = [1]
 * Output: 0
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 5000
 * -1000 <= nums[i] <= 1000
 */

public class L413_ArithmeticSlices {
    public int numberOfArithmeticSlices(int[] nums) {
        if(nums.length < 3){ // base case according to the given condition, that at least 3 elements need them to be in a sequence
            return 0;
        }

        int[] dp = new int[nums.length];
        int sum = 0;
        int diff = nums[nums.length-1] - nums[nums.length-2];
        for(int i = nums.length-3; i>=0 ;i--){
            if(diff != nums[i+1] - nums[i]){ // when this condition get true means, the subarray with common difference is changed so need to change the difference to change the subarray
                diff = nums[i+1] - nums[i];
                continue;
            }

            dp[i] = 1+dp[i+1]; // using top down dp
            // if a sequence is AP having 3 elements then possible subarray is 1
            // and if we add an element to the subarray which have same common difference then 1 subarray will get increase what it previously had
            sum += dp[i]; // side by side counting up all the subarrays possible
        }

        return sum;
    }
}
