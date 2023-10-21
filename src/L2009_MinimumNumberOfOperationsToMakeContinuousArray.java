package src;

/**
 * You are given an integer array nums. In one operation, you can replace any element in nums with any integer.
 *
 * nums is considered continuous if both of the following conditions are fulfilled:
 *
 * All elements in nums are unique.
 * The difference between the maximum element and the minimum element in nums equals nums.length - 1.
 * For example, nums = [4, 2, 5, 3] is continuous, but nums = [1, 2, 3, 5, 6] is not continuous.
 *
 * Return the minimum number of operations to make nums continuous.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [4,2,5,3]
 * Output: 0
 * Explanation: nums is already continuous.
 * Example 2:
 *
 * Input: nums = [1,2,3,5,6]
 * Output: 1
 * Explanation: One possible solution is to change the last element to 4.
 * The resulting array is [1,2,3,5,4], which is continuous.
 * Example 3:
 *
 * Input: nums = [1,10,100,1000]
 * Output: 3
 * Explanation: One possible solution is to:
 * - Change the second element to 2.
 * - Change the third element to 3.
 * - Change the fourth element to 4.
 * The resulting array is [1,2,3,4], which is continuous.
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 105
 * 1 <= nums[i] <= 109
 */

import java.util.HashSet;
import java.util.Set;

public class L2009_MinimumNumberOfOperationsToMakeContinuousArray {

    // this is the brut force solution -> O(n^2) , this is coming TLE in leetcode
    public int minOperations1(int[] nums) {
        int result = Integer.MAX_VALUE; // taking result as Integer.MAX_VALUE, to find the minimum possible operations

        for(int i = 0;i<nums.length;i++){
            int low = nums[i]; // making every element as the starting element of the resultant array
            int high = low+nums.length-1; // according to 'low' making high value of the resultant array
            // above two lines is bcz to fulfill the two given conditions for array to be continuous


            Set<Integer> set = new HashSet<>(); // this is used to keep unique elements
            int operation = 0;
            for(int j = 0;j<nums.length;j++){ // now for every low and high, checking the whole array is continuous or not
                if(nums[j] < low || nums[j] > high || set.contains(nums[j])){ // finding the number of operations to be performed, taking low and high of an array and continuous
                    operation++;
                }else{
                    set.add(nums[j]);
                }
            }

            result = Math.min(result, operation); // taking the min number rof operations  needed
        }

        return result;
    }
}
