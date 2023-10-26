package src;

/**
 * A permutation of an array of integers is an arrangement of its members into a sequence or linear order.
 *
 * For example, for arr = [1,2,3], the following are all the permutations of arr: [1,2,3], [1,3,2], [2, 1, 3], [2, 3, 1], [3,1,2], [3,2,1].
 * The next permutation of an array of integers is the next lexicographically greater permutation of its integer. More formally,
 * if all the permutations of the array are sorted in one container according to their lexicographical order,
 * then the next permutation of that array is the permutation that follows it in the sorted container.
 * If such arrangement is not possible, the array must be rearranged as the lowest possible order (i.e., sorted in ascending order).
 *
 * For example, the next permutation of arr = [1,2,3] is [1,3,2].
 * Similarly, the next permutation of arr = [2,3,1] is [3,1,2].
 * While the next permutation of arr = [3,2,1] is [1,2,3] because [3,2,1] does not have a lexicographical larger rearrangement.
 * Given an array of integers nums, find the next permutation of nums.
 *
 * The replacement must be in place and use only constant extra memory.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [1,2,3]
 * Output: [1,3,2]
 * Example 2:
 *
 * Input: nums = [3,2,1]
 * Output: [1,2,3]
 * Example 3:
 *
 * Input: nums = [1,1,5]
 * Output: [1,5,1]
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 100
 * 0 <= nums[i] <= 100
 */

public class L31_NextPermutation {
    public void nextPermutation(int[] nums) {
        if(nums.length == 1){
            return;
        }

        int index1 = -1;
        // step 1: to find index1
        for(int i = nums.length-2;i>=0;i--){
            if(nums[i]<nums[i+1]){
                index1 = i;
                break;
            }
        }

        if(index1 == -1){ // means array is at its biggest value
            reverse(nums, 0); // just sort the array or reverse to get the solution
            return;
        }

        int index2 = -1;
        // step 2: find index2
        for(int i = nums.length-1; i>=0;i--){
            if(nums[i] > nums[index1]){
                index2 = i;
                break;
            }
        }

        // step 3: swap the value of index1 and index2
        nums[index1] = nums[index1] + nums[index2];
        nums[index2] = nums[index1] - nums[index2];
        nums[index1] = nums[index1] - nums[index2];

        // step 4: reverse all the value present after index1
        reverse(nums, index1+1);
    }

    void reverse(int[] nums,int start){ // this is used to reverse some part of array
        int i=start;
        int j=nums.length-1;
        while(i<j){
            nums[i] = nums[i] + nums[j];
            nums[j] = nums[i] - nums[j];
            nums[i] = nums[i] - nums[j];
            i++;
            j--;
        }
    }
}
