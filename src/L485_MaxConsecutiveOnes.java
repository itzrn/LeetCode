package src;

/**
 * Given a binary array nums, return the maximum number of consecutive 1's in the array.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [1,1,0,1,1,1]
 * Output: 3
 * Explanation: The first two digits or the last three digits are consecutive 1s. The maximum number of consecutive 1s is 3.
 * Example 2:
 *
 * Input: nums = [1,0,1,1,0,1]
 * Output: 2
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 105
 * nums[i] is either 0 or 1.
 */

public class L485_MaxConsecutiveOnes {
    public int findMaxConsecutiveOnes(int[] nums) {
        int count = 0;
        int max = 0;
        for(int i = 0 ;i<nums.length;i++){
            if(nums[i] == 1){
                count++;
            }
            else{ // as soon we get zero, we will do the count = 0;, which means the break of consecutive once
                count  = 0;
            }
            max = Math.max(max,count); // finding max at every iteration
        }
        return max;
    }
}
