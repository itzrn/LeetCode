package src;

/**
 * Given a collection of numbers, nums, that might contain duplicates, return all possible unique permutations in any order.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [1,1,2]
 * Output:
 * [[1,1,2],
 *  [1,2,1],
 *  [2,1,1]]
 * Example 2:
 *
 * Input: nums = [1,2,3]
 * Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 8
 * -10 <= nums[i] <= 10
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class L47_Permutations2 {
    public List<List<Integer>> permuteUnique(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0;i<nums.length;i++){ // keeping the count of each duplicate number in the map
            map.put(nums[i], map.getOrDefault(nums[i], 0)+1);
        }

        recursion(map, nums.length);
        return res;
    }


    List<List<Integer>> res = new ArrayList<>(); // this is used to store all the combination list
    List<Integer> list = new ArrayList<>(); // this is used to store a combination
    public void recursion(HashMap<Integer, Integer> map, int size){
        if(list.size() == size){
            res.add(new ArrayList<>(list));
            return;
        }

        for(int i : map.keySet()){ // this loop is creating, a graph
            if(map.get(i) != 0){
                list.add(i); // this is used to store a combination
                map.put(i, map.get(i) -1); // this is used to decrease the count by 1 of used number
                recursion(map, size);
                map.put(i, map.get(i)+1); // this is to retrieve the count of a number
                list.remove(list.size() - 1); // removing the last number of a combination, combine other possible combination
            }
        }
    }
}
