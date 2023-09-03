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

    // this gives TLE in LeetCode
    // this is not efficient bcz of the overlapping recursive calls
    public int uniquePaths2(int m, int n) { // this is proper dfs, here we are not working on any grid, here we are working on numbers oonly
        if(m == 1 && n ==1){
            return 1;
        }
        return 1 + count(m,n);
    }

    public int count(int m, int n){
        if(m == 1 && n ==1){
            return 1;
        }

        if((m == 1 && n>1) || n == 1 && m > 1){
            return 0;
        }

        return  1 + count(m-1,n) + count(m,n-1);
    }

    // best solution
    public int uniquePaths3(int m, int n) {
        int[][] dp = new int[m+1][n+1]; // making the dp array size of (m+1, n+1), bcz we have to calculate the number of unique path for (m,n) as index
        return recursiveDp(dp, m, n);
    }
    /*
    let m=3,n=7
    dp ->
        0  0  0  0  0  0   0   0 -> this line is doing padding, so not to go out of bound, and even the left most column is also doing the same
        0  1  1  1  1  1   1   1
        0  1  2  3  4  5   6   7
        0  1  3  6 10  15  21  28

        intuition ->
        we will start from 3,7 and do dfs
        while doing back track we will calculate the unique path to reach from 1,1 to m.n and store that number of unique path at m,n
        this storing of unique path help to not go in already went recursion
    */

    public int recursiveDp(int[][] dp, int m, int n){
        if(m == 0 || n == 0){ // this case only works when m=0, n=0
            return 0;
        }

        if(m == 1 && n == 1){ // base case
            return 1;
        }

        if(dp[m][n]>0){ // when this condition is true means, we need not go in the particular recursion else return the value of dp[m][n]
            return dp[m][n];
        }

        dp[m][n] = recursiveDp(dp,m-1,n) + recursiveDp(dp,m,n-1); // calculating the number of unique path, when starting from 1,1 to m,n
        return dp[m][n]; // returning the unique path for m,n staring from 1,1
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
