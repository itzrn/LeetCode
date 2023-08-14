package src;

import java.util.HashMap;

/**
 * You are given a 0-indexed integer array nums. You have to partition the array into one or more contiguous subarrays.
 *
 * We call a partition of the array valid if each of the obtained subarrays satisfies one of the following conditions:
 *
 *     The subarray consists of exactly 2 equal elements. For example, the subarray [2,2] is good.
 *     The subarray consists of exactly 3 equal elements. For example, the subarray [4,4,4] is good.
 *     The subarray consists of exactly 3 consecutive increasing elements, that is, the difference between adjacent
 *     elements is 1. For example, the subarray [3,4,5] is good, but the subarray [1,3,5] is not.
 *
 * Return true if the array has at least one valid partition. Otherwise, return false.
 *
 * Example 1:
 *
 * Input: nums = [4,4,4,5,6]
 * Output: true
 * Explanation: The array can be partitioned into the subarrays [4,4] and [4,5,6].
 * This partition is valid, so we return true.
 *
 * Example 2:
 *
 * Input: nums = [1,1,1,2]
 * Output: false
 * Explanation: There is no valid partition for this array.
 */

public class L2369_CheckIfThereIsAValidPartitionForThisArray {
    public boolean validPartition(int[] nums) {
        return dfs(nums, 0);
    }

    HashMap<Integer, Boolean> dp = new HashMap<>(); // keeping the record of every index, that using this index did we got the partition or not
    // use of keeping record is imp here bcz, let if we reach to the index which is already visited then we can use the ans of that index, intead of traversing again for the solution of that particular index.
    public boolean dfs(int[] nums, int i){
        if(i == nums.length){ // base case, bcz if the length gets equal to nums.length means, that our array got partitioned properly
            return true;
        }
        if(dp.containsKey(i)){ // using the recoded ans, so we no need to traverse again for this particular index
            return dp.get(i);
        }

        boolean check = false; // initially we assuming we didin't get the partition at the index i
        if(i<nums.length - 1 && nums[i] == nums[i+1]){ // if this is true then bellow any one of it will true
            check = check || dfs(nums, i+2);
        }
        if(i<nums.length-2 && nums[i]== nums[i+1] && nums[i] == nums[i+2]){ // if this is true, down condition can not be true
            check |= dfs(nums, i+3);
        }
        if(i<nums.length-2  && nums[i] == nums[i+1] - 1 && nums[i] == nums[i+2]-2){ // if this is true then above condition canot be tru
            check |= dfs(nums,i+3);
        }

        dp.put(i, check); // after getting the result for any index keeping safe so to use in the future

        return check; // returning the ans, will partition be possible at this index or not
    }
}
