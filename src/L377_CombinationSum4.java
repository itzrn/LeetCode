package src;

/**
 * Given an array of distinct integers nums and a target integer target, return the number of
 * possible combinations that add up to target.
 *
 * The test cases are generated so that the answer can fit in a 32-bit integer.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [1,2,3], target = 4
 * Output: 7
 * Explanation:
 * The possible combination ways are:
 * (1, 1, 1, 1)
 * (1, 1, 2)
 * (1, 2, 1)
 * (1, 3)
 * (2, 1, 1)
 * (2, 2)
 * (3, 1)
 * Note that different sequences are counted as different combinations.
 * Example 2:
 *
 * Input: nums = [9], target = 3
 * Output: 0
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 200
 * 1 <= nums[i] <= 1000
 * All the elements of nums are unique.
 * 1 <= target <= 1000
 *
 *
 * Follow up: What if negative numbers are allowed in the given array? How does it change the problem? What
 * limitation we need to add to the question to allow negative numbers?
 */

import java.util.HashMap;
public class L377_CombinationSum4 {

    public int combinationSum4(int[] nums, int target) {
        HashMap<Integer, Integer> dp = new HashMap<>(); // this map is keeping 'sum' as key 'count' as value
        return recursion(nums, dp, target,0);
    }

    public int recursion(int[] arr, HashMap<Integer, Integer> dp, int target, int sum){
        if(sum == target){
            return 1;
        }
        if(dp.getOrDefault(sum,-1) != -1){
            // why returning -1 as default, bcz it can be the situation that sum could not reach to target
            // so for that particular sum, we need to keep that sum count as 0
            // if as default value is returning -1, means that we didn't reach to that sum in the past, and we have to explore the graph of that sum

            return dp.get(sum);
        }
        if(sum > target){
            return 0; // this condition gets true, means for this sum, target is not possible
        }

        int count = 0; // counting number of combination possible for a sum to reach target
        for(int i = 0;i<arr.length;i++){ // this is creating graph for every index in arr
            count +=  recursion(arr, dp, target, sum + arr[i]);
        }

        dp.put(sum, dp.getOrDefault(sum,0)+count); // keeping the (sum, count) pair,
        // which identifies, whenever this sum arrive there will be only 'count' possible combination to reach target
        return count;
    }
}
