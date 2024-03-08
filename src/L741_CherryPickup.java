package src;

public class L741_CherryPickup {
    public int cherryPickup(int[][] grid) {
        int n = grid.length;
        return Math.max(0, recursion(grid, 0, 0, 0, 0, n, new Integer[n][n][n][n]));
    }

    public int recursion(int[][] arr, int x1, int y1, int x2, int y2, int n, Integer[][][][] dp){
        if(x1 >= n || y1 >= n || x2 >= n || y2 == n || arr[x1][y1] == -1 || arr[x2][y2] == -1){
            return Integer.MIN_VALUE;
        }

        if(dp[x1][y1][x2][y2] != null){
            return dp[x1][y1][x2][y2];
        }

        if(x1 == n-1 && y1 == n-1){
            return arr[x1][y1];
        }

        if(x2 == n-1 && y2 == n-1){
            return arr[x2][y2];
        }

        int cherry = 0;
        if(x1 == x2 && y1 == y2){
            cherry += arr[x1][y1];
        }else{
            cherry += arr[x1][y1] + arr[x2][y2];
        }

        int a = recursion(arr, x1, y1+1, x2, y2+1, n, dp);
        int b = recursion(arr, x1+1, y1, x2, y2+1, n, dp);
        int c = recursion(arr, x1+1, y1, x2+1, y2, n, dp);
        int d = recursion(arr, x1, y1+1, x2+1, y2, n, dp);

        return dp[x1][y1][x2][y2] = cherry + Math.max(a, Math.max(b, Math.max(c, d)));
    }
}
