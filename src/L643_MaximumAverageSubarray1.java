package src;

/**
 * You are given an integer array nums consisting of n elements, and an integer k.
 *
 * Find a contiguous subarray whose length is equal to k that has the maximum average value and return this value.
 * Any answer with a calculation error less than 10-5 will be accepted.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [1,12,-5,-6,50,3], k = 4
 * Output: 12.75000
 * Explanation: Maximum average is (12 - 5 - 6 + 50) / 4 = 51 / 4 = 12.75
 * Example 2:
 *
 * Input: nums = [5], k = 1
 * Output: 5.00000
 *
 *
 * Constraints:
 *
 * n == nums.length
 * 1 <= k <= n <= 105
 * -104 <= nums[i] <= 104
 */

public class L643_MaximumAverageSubarray1 {

    // Sliding window problem
    public double findMaxAverage(int[] nums, int k) {
        int sum = 0;
        double avg = -10000.0; // taking min avg, as avg can be negative
        for(int i = 0 ;i<k;i++){// taking avg of first k element
            sum += nums[i];
        }

        avg = Math.max(avg, (double)sum/k);

        int left = 0;
        int right = k;

        for(;right<nums.length;){// using sliding window of k elements -> size of sliding window is fix
            sum += nums[right]; // as adding an element to sum from end
            sum -= nums[left]; // at the same time removing an element from starting, so as maintain the size of sliding window
            avg = Math.max(avg, (double)sum/k);// finding the max avg through the array
            left++;
            right++;
        }

        return avg;
    }
}
