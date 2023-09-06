package src;

/**
 * There is an integer array nums sorted in ascending order (with distinct values).
 *
 * Prior to being passed to your function, nums is possibly rotated at an unknown pivot index k (1 <= k < nums.length)
 * such that the resulting array is [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]] (0-indexed).
 * For example, [0,1,2,4,5,6,7] might be rotated at pivot index 3 and become [4,5,6,7,0,1,2].
 *
 * Given the array nums after the possible rotation and an integer target, return the index of target if it is in nums, or -1 if it is not in nums.
 *
 * You must write an algorithm with O(log n) runtime complexity.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [4,5,6,7,0,1,2], target = 0
 * Output: 4
 * Example 2:
 *
 * Input: nums = [4,5,6,7,0,1,2], target = 3
 * Output: -1
 * Example 3:
 *
 * Input: nums = [1], target = 0
 * Output: -1
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 5000
 * -104 <= nums[i] <= 104
 * All values of nums are unique.
 * nums is an ascending array that is possibly rotated.
 * -104 <= target <= 104
 */

public class L33_SearchInRotatedSortedArray {
    public int search(int[] nums, int target) {
        int minIndex = findMinRecursion(nums,0,nums.length-1);
        return binarySearch(nums, minIndex-nums.length, (minIndex-1)%nums.length, target);
    }

    // after finding the min value index, we are doing the -ve indexing, and applying binary search on it
    public int binarySearch(int[] arr, int start, int end, int target){
        if(start>end){
            return -1;
        }
        int mid = start + (end-start)/2;
        if(arr[(mid+arr.length) % arr.length] == target){
            return (mid+arr.length) % arr.length;
        }

        if(target<arr[(mid+arr.length) % arr.length]){
            return binarySearch(arr, start, mid-1, target);
        }

        return binarySearch(arr,mid+1,end,target);
    }

    // this finding the min value index in the array
    public int findMinRecursion(int[] arr, int start, int end){
        if(end == start){
            return start;
        }

        int mid = start + (end-start)/2;

        if(arr[mid] >= arr[start] && arr[mid] > arr[end]){
            return findMinRecursion(arr, mid+1,end);
        }else if(arr[mid] == arr[start] && arr[mid] < arr[end]){
            return findMinRecursion(arr,start,mid);
        }else{
            return findMinRecursion(arr,start,mid);
        }
    }
}
