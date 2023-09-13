package src;

/**
 * Given an integer array nums, in which exactly two elements appear only once and all the other elements
 * appear exactly twice. Find the two elements that appear only once. You can return the answer in any order.
 *
 * You must write an algorithm that runs in linear runtime complexity and uses only constant extra space.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [1,2,1,3,2,5]
 * Output: [3,5]
 * Explanation:  [5, 3] is also a valid answer.
 * Example 2:
 *
 * Input: nums = [-1,0]
 * Output: [-1,0]
 * Example 3:
 *
 * Input: nums = [0,1]
 * Output: [1,0]
 *
 *
 * Constraints:
 *
 * 2 <= nums.length <= 3 * 104
 * -231 <= nums[i] <= 231 - 1
 * Each integer in nums will appear twice, only two integers will appear once.
 */

import java.util.Arrays;

public class L260_SingleNumber3 {
    // same approach as L137
    public int[] singleNumber(int[] nums) {
        Arrays.sort(nums);
        int[] res = new int[2];
        res[0] = res[1] = -1;

        int i = 0;
        for(;i+1<nums.length;){
            if(nums[i] != nums[i+1]){
                if(res[0] == -1){
                    res[0] = nums[i];
                }else{
                    res[1] = nums[i];
                    return res;
                }
                i++;
            }else{
                i += 2;
            }
        }
        res[1] = nums[i];

        return res;
    }
}
