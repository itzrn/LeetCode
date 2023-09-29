package src;

/**
 * Given an array of positive integers nums and a positive integer target, return the minimal length of a
 * subarray
 *  whose sum is greater than or equal to target. If there is no such subarray, return 0 instead.
 *
 *
 *
 * Example 1:
 *
 * Input: target = 7, nums = [2,3,1,2,4,3]
 * Output: 2
 * Explanation: The subarray [4,3] has the minimal length under the problem constraint.
 * Example 2:
 *
 * Input: target = 4, nums = [1,4,4]
 * Output: 1
 * Example 3:
 *
 * Input: target = 11, nums = [1,1,1,1,1,1,1,1]
 * Output: 0
 *
 *
 * Constraints:
 *
 * 1 <= target <= 109
 * 1 <= nums.length <= 105
 * 1 <= nums[i] <= 104
 *
 *
 * Follow up: If you have figured out the O(n) solution, try coding another solution of which the time complexity is O(n log(n)).
 */

public class L209_MinimumSizeSubArraySum {

    // using sliding window concept or two pointer concept
    public int minSubArrayLen(int target, int[] nums) {
        int min = Integer.MAX_VALUE;
        int sum = 0;

        for(int i = 0, j = 0;j<nums.length ; j++){ // this loop is increasing the size of sliding window
            sum += nums[j];
            while(sum >= target){ // this loop is decreasing the size of sliding window
                min = Math.min(min, j-i+1);
                sum -= nums[i]; // removing that element which is need to remove after increasing the sliding window
                i++;
            }
        }

        return (min != Integer.MAX_VALUE) ? min : 0;
        // if the ternary condition gets false, mean the sum of all the element of array is less than the target value.
    }
}
