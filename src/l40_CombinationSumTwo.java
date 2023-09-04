package src;

/**
 * Given a collection of candidate numbers (candidates) and a target number (target), find all unique combinations in
 * candidates where the candidate numbers sum to target.
 *
 * Each number in candidates may only be used once in the combination.
 *
 * Note: The solution set must not contain duplicate combinations.
 *
 *
 *
 * Example 1:
 *
 * Input: candidates = [10,1,2,7,6,1,5], target = 8
 * Output:
 * [
 * [1,1,6],
 * [1,2,5],
 * [1,7],
 * [2,6]
 * ]
 * Example 2:
 *
 * Input: candidates = [2,5,2,1,2], target = 5
 * Output:
 * [
 * [1,2,2],
 * [5]
 * ]
 *
 *
 * Constraints:
 *
 * 1 <= candidates.length <= 100
 * 1 <= candidates[i] <= 50
 * 1 <= target <= 30
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class l40_CombinationSumTwo {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates); // firstly sorting the array, so to increase the sum to target, in ascending order
        recursion(candidates, target, 0); // this is the call for recursion method
        return res;
    }

    List<List<Integer>> res = new ArrayList<>(); // this will store the final result, which is the list of list
    List<Integer> list = new ArrayList<>(); // this store one combination and the copy of itself to res, and empty while backtracking itself for another combination
    public void recursion(int[] candidates, int target, int start){
        if(target == 0){ // base case
            res.add(new ArrayList<>(list));
            return;
        }

        if(target < 0 || start == candidates.length){ // target < 0 means we can not make any combination with the give element in the list
            // start == candidates.length means index is getting out of bound
            return;
        }

        for(int i = start;i<candidates.length;i++){
            if(i>start && candidates[i] == candidates[i-1]){ // we have sorted the array, so that we won't get any duplicate combination
                continue; // if this condition gets true, means the element at 'i' already have a combination, so not to move forward instead go for next loop
            }
            list.add(candidates[i]); // adding element to amke combination
            recursion(candidates, target-candidates[i], i + 1);  // recursive call
            list.remove(list.size() - 1); // on backtracking removing the last element of the list, and go for another combination
        }
    }
}
