package src;

/**
 * Given a binary array nums and an integer goal, return the number of non-empty subarrays with a sum goal.
 *
 * A subarray is a contiguous part of the array.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [1,0,1,0,1], goal = 2
 * Output: 4
 * Explanation: The 4 subarrays are bolded and underlined below:
 * [1,0,1,0,1]
 * [1,0,1,0,1]
 * [1,0,1,0,1]
 * [1,0,1,0,1]
 * Example 2:
 *
 * Input: nums = [0,0,0,0,0], goal = 0
 * Output: 15
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 3 * 104
 * nums[i] is either 0 or 1.
 * 0 <= goal <= nums.length
 */

import java.util.HashMap;

public class L930_BinarySubarrayWithSum {
    public int numSubarraysWithSum(int[] nums, int goal) {
        HashMap<Integer, Integer> map = new HashMap<>(); // here the key is sum and value is count
        map.put(0,1);
        int sum = 0;
        int count = 0;

        for(int i = 0;i<nums.length;i++){ // calculating the sum fom index '0' to index n, and then looking back for the number of particular difference present to achieve goal
            sum += nums[i];
            int diff = sum - goal; // this is the difference which is need to subtract from the sum to achieve the goal

            count += map.getOrDefault(diff, 0); // if that particular difference is present then adding the value of that difference from tha map else adding '0'
            map.put(sum, map.getOrDefault(sum, 0) + 1); // at every step keeping the record of the sum, that how many times this particular sum achieved while iterating
        }

        return count;
    }
}
