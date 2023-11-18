package src;

/**
 * There is an integer array nums that consists of n unique elements, but you have forgotten it. However, you do remember every pair of adjacent elements in nums.
 *
 * You are given a 2D integer array adjacentPairs of size n - 1 where each adjacentPairs[i] = [ui, vi] indicates that the elements ui and vi are adjacent in nums.
 *
 * It is guaranteed that every adjacent pair of elements nums[i] and nums[i+1] will exist in adjacentPairs, either as [nums[i], nums[i+1]] or [nums[i+1], nums[i]]. The pairs can appear in any order.
 *
 * Return the original array nums. If there are multiple solutions, return any of them.
 *
 *
 *
 * Example 1:
 *
 * Input: adjacentPairs = [[2,1],[3,4],[3,2]]
 * Output: [1,2,3,4]
 * Explanation: This array has all its adjacent pairs in adjacentPairs.
 * Notice that adjacentPairs[i] may not be in left-to-right order.
 * Example 2:
 *
 * Input: adjacentPairs = [[4,-2],[1,4],[-3,1]]
 * Output: [-2,4,1,-3]
 * Explanation: There can be negative numbers.
 * Another solution is [-3,1,4,-2], which would also be accepted.
 * Example 3:
 *
 * Input: adjacentPairs = [[100000,-100000]]
 * Output: [100000,-100000]
 *
 *
 * Constraints:
 *
 * nums.length == n
 * adjacentPairs.length == n - 1
 * adjacentPairs[i].length == 2
 * 2 <= n <= 105
 * -105 <= nums[i], ui, vi <= 105
 * There exists some nums that has adjacentPairs as its pairs.
 */

import java.util.HashMap;
import java.util.Map;

public class L1743_RestoreTheArrayFromAdjacentPairs {
    public int[] restoreArray(int[][] arr2D) {
        Map<Integer, int[]> map = new HashMap<>();

        for(int[] i: arr2D){ // making the map, here value is an array of size 2, which implies the right and left neighbour of key
            if(!map.containsKey(i[0])){
                map.put(i[0], new int[]{i[1], Integer.MIN_VALUE});
            }else{
                map.get(i[0])[1] = i[1];
            }

            if(!map.containsKey(i[1])){
                map.put(i[1], new int[]{i[0], Integer.MIN_VALUE});
            }else{
                map.get(i[1])[1] = i[0];
            }
        }


        int[] res = new int[arr2D.length+1];
        for(int i:map.keySet()){ // now searching a key who is having only one neighbour,(having one neighbour means that the resultant array is starting or ending with the particular key)
            // so this is the reason, we can have 2 answer
            if(map.get(i)[1] == Integer.MIN_VALUE){
                res[0] = i;
                res[1] = map.get(i)[0];
                break;
            }
        }

        for(int i = 1;i<res.length-1;i++){ // now doing the search for every key and its neighbour(in short doing dfs)
            if(map.get(res[i])[0] == res[i-1]){
                res[i+1] = map.get(res[i])[1];
            }else{
                res[i+1] = map.get(res[i])[0];
            }
        }

        return res;
    }
}
