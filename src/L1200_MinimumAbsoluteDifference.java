package src;

/**
 * Given an array of distinct integers arr, find all pairs of elements with the minimum absolute difference of any two elements.
 *
 * Return a list of pairs in ascending order(with respect to pairs), each pair [a, b] follows
 *
 * a, b are from arr
 * a < b
 * b - a equals to the minimum absolute difference of any two elements in arr
 *
 *
 * Example 1:
 *
 * Input: arr = [4,2,1,3]
 * Output: [[1,2],[2,3],[3,4]]
 * Explanation: The minimum absolute difference is 1. List all pairs with difference equal to 1 in ascending order.
 * Example 2:
 *
 * Input: arr = [1,3,6,10,15]
 * Output: [[1,3]]
 * Example 3:
 *
 * Input: arr = [3,8,-10,23,19,-4,-14,27]
 * Output: [[-14,-10],[19,23],[23,27]]
 *
 *
 * Constraints:
 *
 * 2 <= arr.length <= 105
 * -106 <= arr[i] <= 106
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class L1200_MinimumAbsoluteDifference {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        Arrays.sort(arr); // sorting the array, so we can get all the pairs in a sorted manner

        List<List<Integer>> res = new ArrayList<>(); // initializing the resultant list

        int max_diff = arr[1]-arr[0]; // difference between two pair int the starting

        int n = arr.length;
        for(int i = 1; i<n; i++){// iterating through whole array
            List<Integer> list = new ArrayList<>(); // initializing for pair
            int diff = arr[i]-arr[i-1]; // cal calculating the difference

            if(max_diff == diff && arr[i]!= arr[i-1]){ // is this condition gets true, continue adding the pairs
                list.add(arr[i-1]);
                list.add(arr[i]);
                res.add(list);
            }else if(max_diff > diff && arr[i] != arr[i-1]){ // if this condition gets true, clearing the resultant list and adding further upcoming pairs with less difference
                max_diff = diff;
                res.clear();
                list.add(arr[i-1]);
                list.add(arr[i]);
                res.add(list);
            }
        }

        return res;
    }
}
