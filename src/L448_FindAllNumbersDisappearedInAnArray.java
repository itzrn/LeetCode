package src;

/**
 * Given an array nums of n integers where nums[i] is in the range [1, n], return an array of all the integers in the range [1, n] that do not appear in nums.
 *
 *
 * Example 1:
 *
 * Input: nums = [4,3,2,7,8,2,3,1]
 * Output: [5,6]
 * Example 2:
 *
 * Input: nums = [1,1]
 * Output: [2]
 *
 *
 * Constraints:
 *
 * n == nums.length
 * 1 <= n <= 105
 * 1 <= nums[i] <= n
 *
 *
 * Follow up: Could you do it without extra space and in O(n) runtime? You may assume the returned list does not count as extra space.
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class L448_FindAllNumbersDisappearedInAnArray {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        Arrays.sort(nums);
        List<Integer> list = new ArrayList<>();
        if(nums[0] != 1){
            int a = 1;
            while(a<nums[0]){
                list.add(a);
                a++;
            }
        }

        for(int i = 1; i<nums.length; i++){
            if(nums[i]-nums[i-1] > 1){
                int a = nums[i-1]+1;
                while(a<nums[i]){
                    list.add(a);
                    a++;
                }
            }
        }

        if(nums[nums.length-1] != nums.length){
            int a = nums[nums.length-1]+1;
            while(a<=nums.length){
                list.add(a);
                a++;
            }
        }

        return list;
    }
}
