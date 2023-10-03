package src;

/**
 * Given an unsorted integer array nums, return the smallest missing positive integer.
 *
 * You must implement an algorithm that runs in O(n) time and uses O(1) auxiliary space.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [1,2,0]
 * Output: 3
 * Explanation: The numbers in the range [1,2] are all in the array.
 * Example 2:
 *
 * Input: nums = [3,4,-1,1]
 * Output: 2
 * Explanation: 1 is in the array but 2 is missing.
 * Example 3:
 *
 * Input: nums = [7,8,9,11,12]
 * Output: 1
 * Explanation: The smallest positive integer 1 is missing.
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 105
 * -231 <= nums[i] <= 231 - 1
 */

import java.util.Arrays;

public class L41_FirstMissingPositive {
    public int firstMissingPositive(int[] nums) {
        Arrays.sort(nums); // fist sorting the array
        int index = binarySearch(nums, 0, nums.length-1, 1); // then searching the index of 1
        if(index == -1){ // if 1 is not present in the nums, means the first +ve element not present in the array is 1
            return 1; // so return 1
        }

        // now in the remaining array, search where the difference between any two element is greater than 1, means a +ve number is missing

        int i = index+1;
        for(;i<nums.length;i++){
            if(nums[i]-nums[i-1] > 1){
                return nums[i-1] + 1; // so return the next +ve number, till where the continuity maintained
            }
        }

        return nums[i-1]+1;
    }

    public int binarySearch(int[] arr, int low, int high, int target){
        if(low>high){
            return -1;
        }

        int mid = low + (high-low)/2;

        if(arr[mid] == target){
            return mid;
        }

        if(target < arr[mid]){
            return binarySearch(arr, low, mid-1, target);
        }

        return binarySearch(arr, mid+1, high, target);
    }
}
