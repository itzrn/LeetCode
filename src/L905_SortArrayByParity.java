package src;

/**
 * Given an integer array nums, move all the even integers at the beginning of the array followed by all the odd integers.
 *
 * Return any array that satisfies this condition.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [3,1,2,4]
 * Output: [2,4,3,1]
 * Explanation: The outputs [4,2,3,1], [2,4,1,3], and [4,2,1,3] would also be accepted.
 * Example 2:
 *
 * Input: nums = [0]
 * Output: [0]
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 5000
 * 0 <= nums[i] <= 5000
 */

public class L905_SortArrayByParity {
    public int[] sortArrayByParity(int[] nums) {
        recursion(nums, 0);
        return nums;
    }

    int i = 0;

    // used backtracking
    public void  recursion(int[] arr, int index){
        if(index == arr.length){// base case if the index getting out of bound
            return;
        }

        // while recursion putting all the even number in the starting and if the number is odd then keeping it in a variable
        int odd = -1;
        if(arr[index] % 2 == 0){
            arr[i++] = arr[index];
        }else{
            odd = arr[index];
        }

        recursion(arr, index+1);
        if(odd != -1){ // while backtracking if the variable odd != -1, means at this position we have odd number, and we have to  keep this odd number in array
            // by doing this i, is not getting out of bound, here odd -> is working as dp
            arr[i++] = odd;
        }
    }
}
