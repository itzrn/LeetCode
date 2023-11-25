package src;

/**
 * Given a 2D integer array nums, return all elements of nums in diagonal order as shown in the below images.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: nums = [[1,2,3],[4,5,6],[7,8,9]]
 * Output: [1,4,2,7,5,3,8,6,9]
 * Example 2:
 *
 *
 * Input: nums = [[1,2,3,4,5],[6,7],[8],[9,10,11],[12,13,14,15,16]]
 * Output: [1,6,2,8,7,3,9,4,12,10,5,13,11,14,15,16]
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 105
 * 1 <= nums[i].length <= 105
 * 1 <= sum(nums[i].length) <= 105
 * 1 <= nums[i][j] <= 105
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class L1424_DiagonalTraverse2 {

    // same as L498
    public int[] findDiagonalOrder(List<List<Integer>> nums) {
        int n=nums.size();
        Map<Integer,List<Integer>> map=new HashMap<>();
        int c=0;
        for(int i=n-1;i>=0;i--){
            for(int j=0;j<nums.get(i).size();j++){
                if(!map.containsKey(i+j)) map.put(i+j,new ArrayList<>());
                map.get(i+j).add(nums.get(i).get(j));
                c++;
            }
        }
        int[] ans =new int[c];
        int i=0,num=0;
        while(map.containsKey(num)){
            for(int k:map.get(num)){
                ans[i++]=k;
            }
            num++;
        }
        return ans;
    }
}
