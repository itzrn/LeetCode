package src;

public class L63_UniquePathTwo {

    // this is iterative approach
    public int uniquePathWithObstacles1(int[][] obstacleGrid){ // this is the grid method
        int xlen = obstacleGrid.length;  // number of rows
        int ylen = obstacleGrid[0].length;  // number of columns
        for(int i = 0;i<xlen;i++){  // doing 1 at (i,0)
            if(obstacleGrid[i][0] == 1){ // if obstacle comes in between then means we can not follow that column, and the index's after this index should be 0.
                obstacleGrid[i][0] = 0;  // even if the obstacle come that has to be zero
                for(int j = i+1;j<xlen;j++){
                    obstacleGrid[j][0] = 0;
                }
                break;
            }
            obstacleGrid[i][0] = 1;
        }

        for(int i = 1;i<ylen;i++){  // if obstacle comes in between then means we can not follow that row, and the index's after this index should be 0.
            if(obstacleGrid[0][i] == 1){ // even if the obstacle come that has to be zero
                obstacleGrid[0][i] = 0;
                for(int j = i+1;j<ylen;j++){
                    obstacleGrid[0][j] = 0;
                }
                break;
            }
            obstacleGrid[0][i] = 1;
        }

        for (int i = 1;i<xlen;i++){
            for (int j = 1;j<ylen;j++){  // reading all the index of 2D grid
                if(obstacleGrid[i][j] == 1){ // wherever, obstacle comes, putting 0 and continuing the process
                    obstacleGrid[i][j] = 0;
                }else {
                    obstacleGrid[i][j] = obstacleGrid[i][j - 1] + obstacleGrid[i - 1][j];
                }
            }
        }

        return obstacleGrid[xlen-1][ylen-1];
    }



    // this is the dfs method, but it is not optimal solution, in leet-code u can go till 30 testcases on other it will show LTE
    public int uniquePathsWithObstacles2(int[][] obstacleGrid) {
        int xlen = obstacleGrid.length;
        int ylen = obstacleGrid[0].length;
        if(obstacleGrid[xlen-1][ylen-1] == 1){
            return 0;
        }
        return path(obstacleGrid,0,0,xlen, ylen);
    }
    public int path(int[][] arr, int x, int y, int xlen, int ylen){
        if(x == xlen-1 && y == ylen-1){
            return 1;
        }
        if(x>=xlen || y>=ylen){
            return 0;
        }
        if(arr[x][y] == 1 ){
            return 0;
        }

        int bottom = path(arr, x+1,y, xlen, ylen);
        int right = path(arr,x,y+1, xlen, ylen);

        return bottom + right;
    }


    // this is dfs + dp, which is optimal
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if(obstacleGrid[0][0] == 1 || obstacleGrid[obstacleGrid.length-1][obstacleGrid[0].length-1] == 1){
            return 0;
        }

        for(int i = 0;i<obstacleGrid.length; i++){ // doing every 1 as -1, for our further process, -1 will be the obstacles
            for(int j = 0;j<obstacleGrid[i].length;j++){
                if(obstacleGrid[i][j] == 1){
                    obstacleGrid[i][j] = -1;
                }
            }
        }

        return recursiveDp(obstacleGrid, 0, 0, obstacleGrid.length-1,obstacleGrid[0].length-1);
    }

    public int recursiveDp(int[][] dp, int x, int y, int m, int n){
        if( x > m || y > n){
            return 0;
        }
        if(x == m && y == n){
            dp[x][y] = 1;
            return dp[x][y];
        }
        if(dp[x][y] == -1){
            return 0;
        }
        if(dp[x][y] != 0){
            return dp[x][y];
        }
        int a = recursiveDp(dp, x, y+1, m, n);
        int b = recursiveDp(dp, x+1, y, m, n);

        dp[x][y] = a + b;

        // dp[x][y] = recursiveDp(dp,x,y+1,m,n) + recursiveDp(dp,x+1,y,m,n);
        return dp[x][y];
    }
}
