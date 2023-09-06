package src;

/**
 * Suppose an array of length n sorted in ascending order is rotated between 1 and n times. For example, the array nums = [0,1,2,4,5,6,7] might become:
 *
 * [4,5,6,7,0,1,2] if it was rotated 4 times.
 * [0,1,2,4,5,6,7] if it was rotated 7 times.
 * Notice that rotating an array [a[0], a[1], a[2], ..., a[n-1]] 1 time results in the array [a[n-1], a[0], a[1], a[2], ..., a[n-2]].
 *
 * Given the sorted rotated array nums of unique elements, return the minimum element of this array.
 *
 * You must write an algorithm that runs in O(log n) time.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [3,4,5,1,2]
 * Output: 1
 * Explanation: The original array was [1,2,3,4,5] rotated 3 times.
 * Example 2:
 *
 * Input: nums = [4,5,6,7,0,1,2]
 * Output: 0
 * Explanation: The original array was [0,1,2,4,5,6,7] and it was rotated 4 times.
 * Example 3:
 *
 * Input: nums = [11,13,15,17]
 * Output: 11
 * Explanation: The original array was [11,13,15,17] and it was rotated 4 times.
 *
 *
 * Constraints:
 *
 * n == nums.length
 * 1 <= n <= 5000
 * -5000 <= nums[i] <= 5000
 * All the integers of nums are unique.
 * nums is sorted and rotated between 1 and n times.
 */

public class L153_FindMinimumInRotatedSortedArray {
    public int findMin(int[] nums) {
        return nums[findMinRecursion(nums,0,nums.length-1)];
    }

    // this can even sort the array, which is rotated in ascending order and have duplicate values

    // as we know, array is sorted, but it is rotated
    public int findMinRecursion(int[] arr, int start, int end){ // here start -> 0, end -> arr.length-1
        if(end == start){ //base case, when this condition gets true, there is no more elements to check, as our recursion bring us to lowest element
            return start;
        }

        int mid = start + (end-start)/2;

        // here 3 conditions are only possible
        if(arr[mid] >= arr[start] && arr[mid] > arr[end]){ // condition 1, its obvious when this condition gets true, the right subArray will contain the smallest value which ranges[mid+1,end]
        // why we choose right only?
        // as we know the array is sorted and rotated(ascending) and whenever we move one step right to the smallest value we will get big value and when we move one step left to the smallest value
        // we will get bigger value even big than when we move in right from the smallest value, so we choose right array
            // here case can be like -> 5,6,4
            return findMinRecursion(arr, mid+1,end);
        }else if(arr[mid] == arr[start] && arr[mid] < arr[end]){ // condition 2, going to right subArray containing start index
            // here arr[mid] == arr[start] is solving the condition when start = mid
            // why containing start and mid-index-> basically this is solving the condition 6,6,7(start,mid,end -> index) in the bellow array(this case arise at some point)
            //{2,3,4,5,6,7,0,1}
            return findMinRecursion(arr,start,mid);
        }else{ // arr[mid] > arr[start] && arr[mid] < arr[end] -> condition 3, this condition is when arr[mid] is strictly smaller arr[end] and bigger than arr[start]
            // its obvious when we move to right we will get greater value than arr[mid], so why we go in right, instead we will go in left subArray
            // containing mid, bcz it can be possible mid-value is only small or in the left subArray
            // case can be like 0,1,2 -> these are value of array
            return findMinRecursion(arr,start,mid);
        }
    }
}
