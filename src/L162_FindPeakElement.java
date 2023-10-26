package src;

/**
 * A peak element is an element that is strictly greater than its neighbors.
 *
 * Given a 0-indexed integer array nums, find a peak element, and return its index. If the array contains multiple peaks, return the index to any of the peaks.
 *
 * You may imagine that nums[-1] = nums[n] = -∞. In other words, an element is always considered to be strictly greater than a neighbor that is outside the array.
 *
 * You must write an algorithm that runs in O(log n) time.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [1,2,3,1]
 * Output: 2
 * Explanation: 3 is a peak element and your function should return the index number 2.
 * Example 2:
 *
 * Input: nums = [1,2,1,3,5,6,4]
 * Output: 5
 * Explanation: Your function can return either index number 1 where the peak element is 2, or index number 5 where the peak element is 6.
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 1000
 * -231 <= nums[i] <= 231 - 1
 * nums[i] != nums[i + 1] for all valid i.
 */

public class L162_FindPeakElement {
    public int findPeakElement(int[] nums) {
        if(nums.length == 1){
            return 0;
        }
        for(int i = 0;i<nums.length;i++){
            if(i == 0 && nums[0]>nums[1]){
                return 0;
            }else if(i == nums.length-1 && nums[nums.length-1]>nums[nums.length-2]){
                return nums.length-1;
            }else if(i != 0 && i != nums.length-1){
                if(nums[i]>nums[i-1] && nums[i] > nums[i+1]){
                    return i;
                }
            }
        }

        return -1;
    }


    // using binary search
    public int findPeakElement2(int[] nums) {
        return binarySearch(nums, 0, nums.length-1);
    }

    public int binarySearch(int[] arr, int low, int high){
        if(low>high){
            return -1;
        }

        int mid = low + (high - low)/2;

        if((mid == 0 || arr[mid] > arr[mid-1]) && (mid == arr.length-1 || arr[mid] > arr[mid+1])){
            return mid;
        }

        if((mid == 0 || arr[mid] > arr[mid - 1]) && arr[mid] < arr[mid + 1]){
            return binarySearch(arr, mid+1, high);
        }

        return binarySearch(arr, low, mid-1);
    }
}
