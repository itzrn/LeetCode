package src;

/**
 * There is an m x n grid with a ball. The ball is initially at the position [startRow, startColumn].
 * You are allowed to move the ball to one of the four adjacent cells in the grid (possibly out of the grid crossing the grid boundary).
 * You can apply at most maxMove moves to the ball.
 *
 * Given the five integers m, n, maxMove, startRow, startColumn, return the number of paths to move the ball out of the grid boundary.
 * Since the answer can be very large, return it modulo 109 + 7.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: m = 2, n = 2, maxMove = 2, startRow = 0, startColumn = 0
 * Output: 6
 * Example 2:
 *
 *
 * Input: m = 1, n = 3, maxMove = 3, startRow = 0, startColumn = 1
 * Output: 12
 *
 *
 * Constraints:
 *
 * 1 <= m, n <= 50
 * 0 <= maxMove <= 50
 * 0 <= startRow < m
 * 0 <= startColumn < n
 */

import java.util.Arrays;

public class L576_OutOfBoundaryPaths {
    public int findPaths(int m, int n, int move, int x, int y) {
        int[][][] dp = new int[m][n][move+1];
        for(int[][] i: dp){
            for(int[] j: i){
                Arrays.fill(j, -1);
            }
        }

        return recursion(x, y, move, m, n, dp);
    }

    int mod = 1000000007;
    public int recursion(int x, int y, int move, int m, int n, int[][][] dp){ // it is a simple dfs with 3D dp, already reached at a grid with move remaining not to explore again
        if(x == m || y == n || x == -1 || y == -1){
            return 1;
        }

        if(move == 0){
            return 0;
        }

        if(dp[x][y][move] != -1){
            return dp[x][y][move];
        }
        //                        left                                           up                                                    right                                          bottom
        return dp[x][y][move] = ((recursion(x-1, y, move-1, m, n, dp) + recursion(x, y-1, move-1, m, n, dp))%mod + (recursion(x+1, y, move-1, m, n, dp) + recursion(x, y+1, move-1, m, n, dp))%mod)%mod;
    }
}
