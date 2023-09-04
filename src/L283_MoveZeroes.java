package src;

/**
 * Given an integer array nums, move all 0's to the end of it while maintaining the relative order of the non-zero elements.
 *
 * Note that you must do this in-place without making a copy of the array.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [0,1,0,3,12]
 * Output: [1,3,12,0,0]
 * Example 2:
 *
 * Input: nums = [0]
 * Output: [0]
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 104
 * -231 <= nums[i] <= 231 - 1
 *
 *
 * Follow up: Could you minimize the total number of operations done?
 */

public class L283_MoveZeroes {
    public void moveZeroes(int[] nums) {
        if(nums.length == 1){
            return;
        }

        // using two pointer method
        int a = 0;
        int b = 0;
        while(b<nums.length){
            if(nums[b] == 0){ // at pointer b there should not be any zero, if there is zero, then move pointer by 1, so we can reach at pointer b which is not zero
                b++;
            }
            if(nums[a] != 0 && nums[b] != 0){ // if pointer a and b is not zero then move both pointer by 1, bcz we have not to replace the
                a++;
                b++;
            }
            if(b<nums.length && nums[a] == 0 && nums[b] != 0){ // at this condition we have to do the swapping and move both the pointer by 1
                nums[a] = nums[b];
                nums[b] = 0;
                a++;
                b++;
            }
        }
    }
}
