package src;

/**
 * You are given a sorted array consisting of only integers where every element appears exactly twice, except for one element which appears exactly once.
 *
 * Return the single element that appears only once.
 *
 * Your solution must run in O(log n) time and O(1) space.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [1,1,2,3,3,4,4,8,8]
 * Output: 2
 * Example 2:
 *
 * Input: nums = [3,3,7,7,10,11,11]
 * Output: 10
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 105
 * 0 <= nums[i] <= 105
 */

public class L540_SingleElementInASortedArray {

    // using two pointer concept
    public int singleNonDuplicate(int[] nums) {
        if(nums.length == 1){ // base case
            return nums[0];
        }

        int i = 0;
        int j = nums.length-1;

        while(i<=j){
            if(nums[i] != nums[i+1]){
                return nums[i];
            }
            if(nums[j] != nums[j-1]){
                return nums[j];
            }

            // if above two condition is false, means nums[i] == nums[i+1] && nums[j] == nums[j-1], so just increasing 'i' by 2 and decreasing 'j' by 2
            i += 2;
            j -= 2;
        }

        return -1;
    }
}
