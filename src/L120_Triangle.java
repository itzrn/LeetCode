package src;

/**
 * Given a triangle array, return the minimum path sum from top to bottom.
 *
 * For each step, you may move to an adjacent number of the row below. More formally,
 * if you are on index i on the current row, you may move to either index i or index i + 1 on the next row.
 *
 *
 *
 * Example 1:
 *
 * Input: triangle = [[2],[3,4],[6,5,7],[4,1,8,3]]
 * Output: 11
 * Explanation: The triangle looks like:
 *    2
 *   3 4
 *  6 5 7
 * 4 1 8 3
 * The minimum path sum from top to bottom is 2 + 3 + 5 + 1 = 11 (underlined above).
 * Example 2:
 *
 * Input: triangle = [[-10]]
 * Output: -10
 *
 *
 * Constraints:
 *
 * 1 <= triangle.length <= 200
 * triangle[0].length == 1
 * triangle[i].length == triangle[i - 1].length + 1
 * -104 <= triangle[i][j] <= 104
 *
 *
 * Follow up: Could you do this using only O(n) extra space, where n is the total number of rows in the triangle?
 */

import java.util.Arrays;
import java.util.List;

public class L120_Triangle {
    public int minimumTotal(List<List<Integer>> triangle) {
        int[] dp = new int[triangle.size()];
        Arrays.fill(dp, Integer.MAX_VALUE); // filled dp with Integer.MAX_VALUE
        return recursion(triangle, dp, 0, 0, 0);
    }

    // rowIndex indicates the current row, and the columnIndex indicates the current index of the current row, dir with dp is used to optimize the solution
    // here dir means the direction, if we are moving toward left then only we have to use the dp else we have to recursively follow the dfs, but still doing this only 1 recursion gets extra
    public int recursion(List<List<Integer>> list, int[] dp, int rowIndex, int columnIndex, int dir){
        if(rowIndex == list.size()-1){ // base case
            return dp[rowIndex] = list.get(rowIndex).get(columnIndex);
        }

        // here dp is getting update, even dp is dynamic, dir states that we are at the right or left subtree of the root
        if(dp[rowIndex] != Integer.MAX_VALUE && dir == 0){ // using dp
            return dp[rowIndex];
        }

        // here we are finding the min value among left and right sub-array, adding that min value to the root and assuming that this min value is the min for particular root and entire row
        return dp[rowIndex] = list.get(rowIndex).get(columnIndex) + Math.min(recursion(list, dp, rowIndex+1, columnIndex, 0), recursion(list, dp, rowIndex+1, columnIndex+1, 1));
    }
}
