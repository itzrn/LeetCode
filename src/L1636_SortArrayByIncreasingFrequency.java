package src;

/**
 * Given an array of integers nums, sort the array in increasing order based on the frequency of the values.
 * If multiple values have the same frequency, sort them in decreasing order.
 *
 * Return the sorted array.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [1,1,2,2,2,3]
 * Output: [3,1,1,2,2,2]
 * Explanation: '3' has a frequency of 1, '1' has a frequency of 2, and '2' has a frequency of 3.
 * Example 2:
 *
 * Input: nums = [2,3,1,3,2]
 * Output: [1,3,3,2,2]
 * Explanation: '2' and '3' both have a frequency of 2, so they are sorted in decreasing order.
 * Example 3:
 *
 * Input: nums = [-1,1,-6,4,5,-6,1,4,1]
 * Output: [5,-1,4,4,-6,-6,1,1,1]
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 100
 * -100 <= nums[i] <= 100
 */

import java.util.*;

public class L1636_SortArrayByIncreasingFrequency {
    public int[] frequencySort(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i:nums){
            map.put(i, map.getOrDefault(i, 0)+1);
        }

        List<Integer> list = new ArrayList<>(map.keySet());
        list.sort((a, b) -> { // or collections.sort()
            if (map.get(a) == map.get(b)) {
                return b - a; // this is going to sort the keySet in descending order
            }

            return map.get(a) - map.get(b); // this is going to sort the keySet in ascending order of its frequency
        });


        int[] res = new int[nums.length];
        int idx = 0;
        for(int n:list){
            for(int i=0;i<map.get(n);i++){
                res[idx] = n;
                idx++;
            }
        }
        return res;
    }
}
