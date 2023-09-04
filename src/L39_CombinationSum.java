package src;

/**
 * Given an array of distinct integers candidates and a target integer target, return a list of all unique combinations of candidates where the chosen numbers sum to target. You may return the combinations in any order.
 *
 * The same number may be chosen from candidates an unlimited number of times. Two combinations are unique if the
 * frequency
 *  of at least one of the chosen numbers is different.
 *
 * The test cases are generated such that the number of unique combinations that sum up to target is less than 150 combinations for the given input.
 *
 *
 *
 * Example 1:
 *
 * Input: candidates = [2,3,6,7], target = 7
 * Output: [[2,2,3],[7]]
 * Explanation:
 * 2 and 3 are candidates, and 2 + 2 + 3 = 7. Note that 2 can be used multiple times.
 * 7 is a candidate, and 7 = 7.
 * These are the only two combinations.
 * Example 2:
 *
 * Input: candidates = [2,3,5], target = 8
 * Output: [[2,2,2,2],[2,3,3],[3,5]]
 * Example 3:
 *
 * Input: candidates = [2], target = 1
 * Output: []
 *
 *
 * Constraints:
 *
 * 1 <= candidates.length <= 30
 * 2 <= candidates[i] <= 40
 * All elements of candidates are distinct.
 * 1 <= target <= 40
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class L39_CombinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates); // sorting the array, so to increase the sum to target, in ascending order
        recursion(candidates, target, 0); // this is the call for recursion method
        return res;
    }

    List<List<Integer>> res = new ArrayList<>(); // this will store the final result, which is the list of list
    List<Integer> list = new ArrayList<>(); // this store one combination and the copy of itself to res, and empty while backtracking itself for another combination
    public void recursion(int[] candidates, int target, int start){ // start is used
        if(target == 0){ // this is the base case
            res.add(new ArrayList<>(list));
            return;
        }

        if(target<0){
            return;
        }

        for(int i = start ;i<candidates.length;i++){
            if(target-candidates[i] < 0){ // as we have sorted array, if at this position target-candidates[i]<0 means for upcoming i+1,i+2.... target-candidates[i] < 0
                // so to have better time complexity we are returning here
                return;
            }
            list.add(candidates[i]);
            recursion(candidates, target-candidates[i], i); // recursive call
            list.remove(list.size()-1);
        }
    }
}
