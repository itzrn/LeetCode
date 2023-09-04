package src;

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
