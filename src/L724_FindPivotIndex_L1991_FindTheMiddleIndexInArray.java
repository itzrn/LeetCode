package src;

/**
 * Given an array of integers nums, calculate the pivot index of this array.
 *
 * The pivot index is the index where the sum of all the numbers strictly to the left of the index
 * is equal to the sum of all the numbers strictly to the index's right.
 *
 * If the index is on the left edge of the array, then the left sum is 0 because there are no elements to the left.
 * This also applies to the right edge of the array.
 *
 * Return the leftmost pivot index. If no such index exists, return -1.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [1,7,3,6,5,6]
 * Output: 3
 * Explanation:
 * The pivot index is 3.
 * Left sum = nums[0] + nums[1] + nums[2] = 1 + 7 + 3 = 11
 * Right sum = nums[4] + nums[5] = 5 + 6 = 11
 * Example 2:
 *
 * Input: nums = [1,2,3]
 * Output: -1
 * Explanation:
 * There is no index that satisfies the conditions in the problem statement.
 * Example 3:
 *
 * Input: nums = [2,1,-1]
 * Output: 0
 * Explanation:
 * The pivot index is 0.
 * Left sum = 0 (no elements to the left of index 0)
 * Right sum = nums[1] + nums[2] = 1 + -1 = 0
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 104
 * -1000 <= nums[i] <= 1000
 */

public class L724_FindPivotIndex_L1991_FindTheMiddleIndexInArray {
    public int pivotIndex(int[] nums) {
        if(nums.length == 1){ // this is the base case when the array length is 1, then index '0' is only pivot
            return 0;
        }
        int sum = 0;
        for(int i = 1;i<nums.length; i++){ // doing sum from index 1 to last, which will be the rightSum whe the pivot is index '0' and at this time leftSum = 0
            sum += nums[i];
        }
        int leftSum = 0;
        int rightSum = sum; // initially keeping rightSum = sum, bcz we have to find lefMost pivot, as there can be many pivot

        int i = 1;
        for(;i<nums.length;i++){ // at 'i' -> assuming pivot is 'i-1'
            if(leftSum == rightSum){ // this condition gets true means the pivot is 'i-1'
                return i-1;
            }

            // doing bellow operation, keeping in mind pivot won't come in either of rightSum or leftSum
            leftSum += nums[i-1]; // every time adding pivot value
            rightSum -= nums[i]; // every time subtracting pivot value
        }

        if(leftSum == rightSum){ // this condition is for when pivot is the last index
            return i-1;
        }

        return -1; // returns -1, means we didn't get any pivot throughout the array
    }
}
