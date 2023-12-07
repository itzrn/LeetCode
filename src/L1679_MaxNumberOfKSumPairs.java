package src;

/**
 * You are given an integer array nums and an integer k.
 *
 * In one operation, you can pick two numbers from the array whose sum equals k and remove them from the array.
 *
 * Return the maximum number of operations you can perform on the array.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [1,2,3,4], k = 5
 * Output: 2
 * Explanation: Starting with nums = [1,2,3,4]:
 * - Remove numbers 1 and 4, then nums = [2,3]
 * - Remove numbers 2 and 3, then nums = []
 * There are no more pairs that sum up to 5, hence a total of 2 operations.
 * Example 2:
 *
 * Input: nums = [3,1,3,4,3], k = 6
 * Output: 1
 * Explanation: Starting with nums = [3,1,3,4,3]:
 * - Remove the first two 3's, then nums = [1,4,3]
 * There are no more pairs that sum up to 6, hence a total of 1 operation.
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 105
 * 1 <= nums[i] <= 109
 * 1 <= k <= 109
 */

import java.util.Arrays;

public class L1679_MaxNumberOfKSumPairs {
    public int maxOperations(int[] arr, int k) {
        Arrays.sort(arr);
        int left = 0;
        int right = arr.length-1;
        int count = 0;

        while(left < right){ // using two pointer method
            if(arr[left] + arr[right] == k){ // if this condition is true need to increase the count
                count++;
                left++;
                right--;
            }else if(arr[left] + arr[right] < k){ // if this condition is true means we need to increase the smallest part of the two pair
                left++;
            }else{ // this condition is -> arr[left] + arr[right] > k, means out pair sum is greater than k and need to reduce the bigger part of the pair
                right--;
            }
        }

        return count;
    }
}
