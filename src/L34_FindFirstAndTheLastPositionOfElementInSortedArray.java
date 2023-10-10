package src;

/**
 * Given an array of integers nums sorted in non-decreasing order, find the starting and ending position of a given target value.
 *
 * If target is not found in the array, return [-1, -1].
 *
 * You must write an algorithm with O(log n) runtime complexity.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [5,7,7,8,8,10], target = 8
 * Output: [3,4]
 * Example 2:
 *
 * Input: nums = [5,7,7,8,8,10], target = 6
 * Output: [-1,-1]
 * Example 3:
 *
 * Input: nums = [], target = 0
 * Output: [-1,-1]
 *
 *
 * Constraints:
 *
 * 0 <= nums.length <= 105
 * -109 <= nums[i] <= 109
 * nums is a non-decreasing array.
 * -109 <= target <= 109
 */

public class L34_FindFirstAndTheLastPositionOfElementInSortedArray {
    public int[] searchRange(int[] nums, int target) {
        int[] ans = new int[2];
        ans[0] = ans[1] = -1;
        binarySearch(nums, target, 0, nums.length-1, ans);
        return ans;
    }

    public void binarySearch(int[] arr, int target, int low, int high, int[] ans){ // this is the binary search
        if(low>high){
            return;
        }

        int mid = low + (high - low)/2;

        if(arr[mid] == target){ // these are the conditions, where we have to catch and try to fill the as lower index as possible in ans[0] and higher in ans[1]
            if(ans[1] == -1 && ans[0] == -1){
                ans[1] = ans[0] = mid;
            }else if(ans[1] == -1 || ans[1]<mid){
                ans[1] = mid;
            }else if(ans[0] == -1 || ans[0]>mid){
                ans[0] = mid;
            }
        }

        if(arr[mid]<=target){ // <=, bcz there is the chance of having repeating elements, which can be at tha higher index in the 2nd half
            binarySearch(arr, target, mid+1, high, ans);
        }

        if(arr[mid] >= target){ // >=, bcz there is the chance of having repeating elements, which can be at the lower index in the 1st half
            binarySearch(arr, target, low, mid-1, ans);
        }
    }
}
