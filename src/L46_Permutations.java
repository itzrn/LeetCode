package src;

import java.util.ArrayList;
import java.util.List;

/**
 * Given an array nums of distinct integers, return all the possible permutations. You can return the answer in any order.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [1,2,3]
 * Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
 * Example 2:
 *
 * Input: nums = [0,1]
 * Output: [[0,1],[1,0]]
 * Example 3:
 *
 * Input: nums = [1]
 * Output: [[1]]
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 6
 * -10 <= nums[i] <= 10
 * All the integers of nums are unique.
 */

public class L46_Permutations {
    public List<List<Integer>> permute(int[] nums) {
        recursion(nums);
        return res;
    }

    List<List<Integer>> res = new ArrayList<>();
    List<Integer> list = new ArrayList<>();
    public void recursion(int[] nums){
        if(list.size() == nums.length){ // bas case
            res.add(new ArrayList<>(list));
            return;
        }

        for(int i = 0;i<nums.length;i++){ // this loop is responsible to make graph
            if(list.contains(nums[i])){ // we have not to add any repeated element
                continue;
            }
            list.add(nums[i]);
            recursion(nums);
            list.remove(list.size()-1);
        }
    }
}
