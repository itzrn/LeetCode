package src;

/**
 * You are given a
 * binary array
 *  nums.
 *
 * We call a
 * subarray
 *  alternating if no two adjacent elements in the subarray have the same value.
 *
 * Return the number of alternating subarrays in nums.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [0,1,1,1]
 *
 * Output: 5
 *
 * Explanation:
 *
 * The following subarrays are alternating: [0], [1], [1], [1], and [0,1].
 *
 * Example 2:
 *
 * Input: nums = [1,0,1,0]
 *
 * Output: 10
 *
 * Explanation:
 *
 * Every subarray of the array is alternating. There are 10 possible subarrays that we can choose.
 *
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 105
 * nums[i] is either 0 or 1.
 */

public class L3101_CountAlternatingSubarray {
    public long countAlternatingSubarrays(int[] nums) {
        int n = nums.length;
        long count = 1;
        int i=0;
        for(int j=1; j<n; j++){
            if(nums[j-1] == nums[j]){
                count += 1;
                i=j;
            }else{
                count += j-i+1;
            }
        }

        return count;
    }
}
