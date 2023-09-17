package src;

/**
 * Given an integer array nums of unique elements, return all possible
 * subsets
 *  (the power set).
 *
 * The solution set must not contain duplicate subsets. Return the solution in any order.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [1,2,3]
 * Output: [[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
 * Example 2:
 *
 * Input: nums = [0]
 * Output: [[],[0]]
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 10
 * -10 <= nums[i] <= 10
 * All the numbers of nums are unique.
 */

import java.util.ArrayList;
import java.util.List;

public class L78_Subsets {
    // it's just like permutation1, where we have to make the possible combination sets
    public List<List<Integer>> subsets(int[] nums) {
        recursion(nums, 0);
        return ans;
    }

    List<List<Integer>> ans = new ArrayList<>();
    List<Integer> list = new ArrayList<>();
    public void recursion(int[] arr, int index){
        if(list.size() > arr.length){
            return;
        }
        ans.add(new ArrayList<>(list)); // adding every possible subset

        for(int i = index; i<arr.length; i++){ // responsible for making graph
            list.add(arr[i]);
            recursion(arr, i+1);
            list.remove(list.size()-1); // while back tracking removing the last element, to go for other combinations
        }
    }
}
