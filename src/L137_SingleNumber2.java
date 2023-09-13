package src;

/**
 * Given an integer array nums where every element appears three times except for one, which appears exactly once. Find the single element and return it.
 *
 * You must implement a solution with a linear runtime complexity and use only constant extra space.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [2,2,3,2]
 * Output: 3
 * Example 2:
 *
 * Input: nums = [0,1,0,1,0,1,99]
 * Output: 99
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 3 * 104
 * -231 <= nums[i] <= 231 - 1
 * Each element in nums appears exactly three times except for one element which appears once.
 */

import java.util.Arrays;

public class L137_SingleNumber2 {

    public int singleNumber(int[] nums) {
        if(nums.length == 1){
            return nums[0];
        }
        Arrays.sort(nums); // sorting bcz, all the number which are same will get placed back to back
        int i = 0;
        for(;i+2<nums.length;){ // i+2 < nums.length, as using 3 size sliding window, so to overcome any index out of bound
            if(nums[i] != nums[i+1]){
                return nums[i];
            }
            i += 3;
        }

        return nums[i]; // if the program get return here means, that single number is at the end of the array
    }
}
