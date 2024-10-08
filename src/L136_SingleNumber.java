package src;

import java.util.Arrays;

/**
 * Given a non-empty array of integers nums, every element appears twice except for one. Find that single one.
 * You must implement a solution with a linear runtime complexity and use only constant extra space.
 *
 * [4,1,2,1,2]
 * on sort -> [1,1,2,2,4]
 */

public class L136_SingleNumber {
    public int singleNumber(int[] nums) {
        Arrays.sort(nums);  // sorting array means every duplicate element will get back to back position in the array
        for(int i = 0;i<nums.length-2;i=i+2){
            if(nums[i]!=nums[i+1]){ // therefore, every element at i will be equal to element at i+1, if not equal means that particular element is appearing single time in the array
                return nums[i];
            }
        }
        return nums[nums.length-1];
    }


    public int singleNumber2(int[] nums) {
        /*
        n ^ 0 = n -> that's why taking res initial as 0
            a ^ b = 0 if a is equal to b
                1^1 = 0
                0^0 = 0
                1^0 = 1
                0^1 = 1

            if a^b = c then c^a = b or c^b = a
        */
        int res = 0;
        for(int i:nums){
            res ^= i;
            System.out.println(res);
        }

        return res;
    }
}
