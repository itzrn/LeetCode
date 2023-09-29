package src;

/**
 * An array is monotonic if it is either monotone increasing or monotone decreasing.
 *
 * An array nums is monotone increasing if for all i <= j, nums[i] <= nums[j]. An array nums is monotone decreasing if for all i <= j, nums[i] >= nums[j].
 *
 * Given an integer array nums, return true if the given array is monotonic, or false otherwise.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [1,2,2,3]
 * Output: true
 * Example 2:
 *
 * Input: nums = [6,5,4,4]
 * Output: true
 * Example 3:
 *
 * Input: nums = [1,3,2]
 * Output: false
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 105
 * -105 <= nums[i] <= 105
 */

public class L896_MonotonicArray {
    public boolean isMonotonic(int[] nums) {
        boolean isIncreasing = true;  // Indicates if the array is increasing
        boolean isDecreasing = true;  // Indicates if the array is decreasing

        // Check if the array is either increasing or non-increasing
        for (int i = 1; i < nums.length; i++) {
            // Check increasing condition.
            if (nums[i] < nums[i - 1])
                isIncreasing = false;

                // Check decreasing condition.
            else if (nums[i] > nums[i - 1])
                isDecreasing = false;

            // If it is neither increasing nor decreasing then don't continue the loop
            if (!isIncreasing && !isDecreasing)
                break;
        }

        return isIncreasing || isDecreasing;  // Return true if either condition is met
    }
}
