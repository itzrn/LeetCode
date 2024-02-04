package src;

/**
 * You are given an integer array nums of size n and a positive integer k.
 *
 * Divide the array into one or more arrays of size 3 satisfying the following conditions:
 *
 * Each element of nums should be in exactly one array.
 * The difference between any two elements in one array is less than or equal to k.
 * Return a 2D array containing all the arrays. If it is impossible to satisfy the conditions, return an empty array.
 * And if there are multiple answers, return any of them.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [1,3,4,8,7,9,3,5,1], k = 2
 * Output: [[1,1,3],[3,4,5],[7,8,9]]
 * Explanation: We can divide the array into the following arrays: [1,1,3], [3,4,5] and [7,8,9].
 * The difference between any two elements in each array is less than or equal to 2.
 * Note that the order of elements is not important.
 * Example 2:
 *
 * Input: nums = [1,3,3,2,7,3], k = 3
 * Output: []
 * Explanation: It is not possible to divide the array satisfying all the conditions.
 *
 *
 * Constraints:
 *
 * n == nums.length
 * 1 <= n <= 105
 * n is a multiple of 3.
 * 1 <= nums[i] <= 105
 * 1 <= k <= 105
 */

import java.util.Arrays;

public class L2966_DivideArrayIntoArraysWithMaxDifference {
    public int[][] divideArray(int[] nums, int k) {
        Arrays.sort(nums);
        int n = nums.length;
        int[][] ans = new int[n/3][3];

        for(int i = 0, j = 0; i<n; i+=3, j++){
            if(nums[i+2]-nums[i+1] > k || nums[i+1]-nums[i] > k || nums[i+2]-nums[i] > k){ // if any of the case gets true means there is no possibility to get the difference less than k
                return new int[][]{}; // this is the way to return an empty 2D array
            }

            // filling the valid pairs to the array
            ans[j][0] = nums[i];
            ans[j][1] = nums[i+1];
            ans[j][2] = nums[i+2];
        }

        return ans;
    }
}
