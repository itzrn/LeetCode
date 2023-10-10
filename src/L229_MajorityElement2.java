package src;

/**
 * Given an integer array of size n, find all elements that appear more than ⌊ n/3 ⌋ times.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [3,2,3]
 * Output: [3]
 * Example 2:
 *
 * Input: nums = [1]
 * Output: [1]
 * Example 3:
 *
 * Input: nums = [1,2]
 * Output: [1,2]
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 5 * 104
 * -109 <= nums[i] <= 109
 *
 *
 * Follow up: Could you solve the problem in linear time and in O(1) space?
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

public class L229_MajorityElement2 {
    public List<Integer> majorityElement(int[] nums) {
        int n = nums.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i : nums){
            map.put(i, map.getOrDefault(i, 0)+1);
        }

        List<Integer> list = new ArrayList<>();
        Set<Integer> set = map.keySet();
        Integer[] arr = set.toArray(new Integer[0]);

        for (Integer integer : arr) {
            if (map.get(integer) > (n / 3)) {
                list.add(integer);
            } else {
                map.remove(integer);
            }
        }

        return list;
    }
}
