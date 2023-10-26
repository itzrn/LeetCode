package src;

/**
 * Given an array of unique integers, arr, where each integer arr[i] is strictly greater than 1.
 *
 * We make a binary tree using these integers, and each number may be used for any number of times.
 * Each non-leaf node's value should be equal to the product of the values of its children.
 *
 * Return the number of binary trees we can make. The answer may be too large so return the answer modulo 109 + 7.
 *
 *
 *
 * Example 1:
 *
 * Input: arr = [2,4]
 * Output: 3
 * Explanation: We can make these trees: [2], [4], [4, 2, 2]
 * Example 2:
 *
 * Input: arr = [2,4,5,10]
 * Output: 7
 * Explanation: We can make these trees: [2], [4], [5], [10], [4, 2, 2], [10, 2, 5], [10, 5, 2].
 *
 *
 * Constraints:
 *
 * 1 <= arr.length <= 1000
 * 2 <= arr[i] <= 109
 * All the values of arr are unique.
 */

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class L823_BinaryTreesWithFactors {
    public int numFactoredBinaryTrees(int[] arr) {
        Arrays.sort(arr);

        // used map to reduce the time of search
        Map<Integer, Long> dp = new HashMap<>();// this is used already counted ways for smaller elements, so to find bigger elements ways
        dp.put(arr[0],1L);
        int mod = (int)1e9+7;
        long res_count = 1L;


        for(int i = 1;i<arr.length; i++){ // iterating from '1' bcz the smallest element can not be further broken
            long count = 0; // count can be very long, so used long data type
            for(int j = 0; j<i; j++){
                if(arr[i] % arr[j] == 0){
                    count += dp.get(arr[j]) * dp.getOrDefault(arr[i]/arr[j] ,0L);
                }
            }

            dp.put(arr[i], count + 1);
            res_count += count+1;
        }

        return (int)(res_count % mod); // this is the way to type cast the long value to int, first make the long value in the range of int and then type cast to int
    }
}
