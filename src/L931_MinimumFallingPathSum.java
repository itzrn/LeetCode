package src;

/**
 * Given an n x n array of integers matrix, return the minimum sum of any falling path through matrix.
 *
 * A falling path starts at any element in the first row and chooses the element in the next row
 * that is either directly below or diagonally left/right. Specifically, the next element from position (row, col)
 * will be (row + 1, col - 1), (row + 1, col), or (row + 1, col + 1).
 *
 *
 *
 * Example 1:
 *
 *
 * Input: matrix = [[2,1,3],[6,5,4],[7,8,9]]
 * Output: 13
 * Explanation: There are two falling paths with a minimum sum as shown.
 * Example 2:
 *
 *
 * Input: matrix = [[-19,57],[-40,-5]]
 * Output: -59
 * Explanation: The falling path with a minimum sum is shown.
 *
 *
 * Constraints:
 *
 * n == matrix.length == matrix[i].length
 * 1 <= n <= 100
 * -100 <= matrix[i][j] <= 100
 */

import java.util.Arrays;
public class L931_MinimumFallingPathSum {
    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        int[][] dp = new int[n][n];
        for(int i = 0; i<n; i++){ // creating dp with its default value -101
            Arrays.fill(dp[i], -101);
        }

        int ans = Integer.MAX_VALUE;
        for(int i = 0; i<n; i++){ // finding out the best minimum sum
            ans = Math.min(ans, recursion(matrix, 0, i, n, dp));
        }

        return ans;
    }

    // simple dfs with dp
    public int recursion(int[][] arr, int x, int y, int n, int[][] dp){
        if(y == -1 || y== n){ // base case to avoid index of bound
            return Integer.MAX_VALUE;
        }

        if(x == n-1){
            return arr[x][y];
        }

        if(dp[x][y] != -101){// use of dp
            return dp[x][y];
        }

        // getting the minimum sum
        return dp[x][y] = arr[x][y] + Math.min(recursion(arr, x+1, y-1, n, dp), Math.min(recursion(arr, x+1, y, n, dp), recursion(arr, x+1, y+1, n, dp)));
    }
}
