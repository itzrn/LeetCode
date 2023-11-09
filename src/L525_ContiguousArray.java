package src;

/**
 * Given a binary array nums, return the maximum length of a contiguous subarray with an equal number of 0 and 1.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [0,1]
 * Output: 2
 * Explanation: [0, 1] is the longest contiguous subarray with an equal number of 0 and 1.
 * Example 2:
 *
 * Input: nums = [0,1,0]
 * Output: 2
 * Explanation: [0, 1] (or [1, 0]) is a longest contiguous subarray with equal number of 0 and 1.
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 105
 * nums[i] is either 0 or 1.
 */

import java.util.HashMap;
import java.util.Map;


/*
Approach ->
here we will assume 0 as -1, doing this makes the problem simple
like to find the longest subarray whose sum is zero
 */
public class L525_ContiguousArray {
    public int findMaxLength(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        int max = 0;
        map.put(0,-1);

        for(int i = 0; i<arr.length; i++){
            sum += arr[i] == 0?-1:1;

            if(!map.containsKey(sum)){ //putting any sum in map once bcz, as we will move forward in array, the length will increase the thing which we want
                // updating the index og sum will lead to calculate not the greatest subarray
                map.put(sum,i);
                continue;
            }

            max = Math.max(max, i-map.get(sum));
        }

        return max;
    }
}
