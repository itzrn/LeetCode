package src;

/**
 * You are given a 0-indexed 2D array variables where variables[i] = [ai, bi, ci, mi], and an integer target.
 *
 * An index i is good if the following formula holds:
 *
 * 0 <= i < variables.length
 * ((aibi % 10)ci) % mi == target
 * Return an array consisting of good indices in any order.
 *
 *
 *
 * Example 1:
 *
 * Input: variables = [[2,3,3,10],[3,3,3,1],[6,1,1,4]], target = 2
 * Output: [0,2]
 * Explanation: For each index i in the variables array:
 * 1) For the index 0, variables[0] = [2,3,3,10], (23 % 10)3 % 10 = 2.
 * 2) For the index 1, variables[1] = [3,3,3,1], (33 % 10)3 % 1 = 0.
 * 3) For the index 2, variables[2] = [6,1,1,4], (61 % 10)1 % 4 = 2.
 * Therefore we return [0,2] as the answer.
 * Example 2:
 *
 * Input: variables = [[39,3,1000,1000]], target = 17
 * Output: []
 * Explanation: For each index i in the variables array:
 * 1) For the index 0, variables[0] = [39,3,1000,1000], (393 % 10)1000 % 1000 = 1.
 * Therefore we return [] as the answer.
 *
 *
 * Constraints:
 *
 * 1 <= variables.length <= 100
 * variables[i] == [ai, bi, ci, mi]
 * 1 <= ai, bi, ci, mi <= 103
 * 0 <= target <= 103
 */

import java.util.ArrayList;
import java.util.List;

public class L2961_DoubleModularExponentiation {
    public int power(int a, int b,int mod){
        int res = 1;
        for(int i=1; i<=b; i++){
            res *= a;
            res%=mod;
        }
        return res;
    }

    public List<Integer> getGoodIndices(int[][] variables, int target) {
        List<Integer> res = new ArrayList<>();

        for(int i=0; i<variables.length; i++){
            int[] arr = variables[i];
            int pow = power(arr[0],arr[1],10);
            pow = power(pow, arr[2], arr[3]);

            if(pow == target){
                res.add(i);
            }
        }
        return res;
    }
}
