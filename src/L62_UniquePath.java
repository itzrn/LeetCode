package src;

/**
 * There is a robot on an m x n grid. The robot is initially located at the top-left corner (i.e., grid[0][0]).
 * The robot tries to move to the bottom-right corner (i.e., grid[m - 1][n - 1]). The robot can only move either down or right at any point in time.
 *
 * Given the two integers m and n, return the number of possible unique paths that the robot can take to reach the bottom-right corner.
 *
 * The test cases are generated so that the answer will be less than or equal to 2 * 109.
 */

public class L62_UniquePath {
    public int uniquePaths(int m, int n) {
        // dfs will be very costly, so we will use dp to store some value so that using dfs we wont need to repeat some values
        int[][] dp = new int[m][n];

        for(int i=0;i<m;i++){ // making all the element of 1st row 1, as we know from any of these elements we can reach to (1,1) in 1 way
            dp[i][0] = 1;
        }
        for(int i = 0;i<n;i++){  // making all the element of 1 column 1, as we know from any of these elements we can reach to (1,1) in 1 way
            dp[0][i] = 1;
        }
        for(int i = 1;i<m;i++){
            for(int j = 1;j<n;j++){
                dp[i][j] = dp[i-1][j] + dp[i][j-1];  // as we can move bottom or right, so to reach to any particular
                // gird in the matrix is equal to the num of the number of ways from UP and LEFT point can reach to (1,1)
            }
        }

        return dp[m-1][n-1];
    }
}

/*
    7 * 3  this is the dp matrix of 7 * 3
    1 1 1
    1 2 3
    1 3 6
    1 4 10
    1 5 15
    1 6 21
    1 7 28
 */
