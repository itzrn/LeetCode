package src;

/**
 * You are given an m x n integer array grid where grid[i][j] could be:
 *
 * 1 representing the starting square. There is exactly one starting square.
 * 2 representing the ending square. There is exactly one ending square.
 * 0 representing empty squares we can walk over.
 * -1 representing obstacles that we cannot walk over.
 * Return the number of 4-directional walks from the starting square to the ending square, that walk over every non-obstacle square exactly once.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: grid = [[1,0,0,0],[0,0,0,0],[0,0,2,-1]]
 * Output: 2
 * Explanation: We have the following two paths:
 * 1. (0,0),(0,1),(0,2),(0,3),(1,3),(1,2),(1,1),(1,0),(2,0),(2,1),(2,2)
 * 2. (0,0),(1,0),(2,0),(2,1),(1,1),(0,1),(0,2),(0,3),(1,3),(1,2),(2,2)
 * Example 2:
 *
 *
 * Input: grid = [[1,0,0,0],[0,0,0,0],[0,0,0,2]]
 * Output: 4
 * Explanation: We have the following four paths:
 * 1. (0,0),(0,1),(0,2),(0,3),(1,3),(1,2),(1,1),(1,0),(2,0),(2,1),(2,2),(2,3)
 * 2. (0,0),(0,1),(1,1),(1,0),(2,0),(2,1),(2,2),(1,2),(0,2),(0,3),(1,3),(2,3)
 * 3. (0,0),(1,0),(2,0),(2,1),(2,2),(1,2),(1,1),(0,1),(0,2),(0,3),(1,3),(2,3)
 * 4. (0,0),(1,0),(2,0),(2,1),(1,1),(0,1),(0,2),(0,3),(1,3),(1,2),(2,2),(2,3)
 * Example 3:
 *
 *
 * Input: grid = [[0,1],[2,0]]
 * Output: 0
 * Explanation: There is no path that walks over every empty square exactly once.
 * Note that the starting and ending square can be anywhere in the grid.
 *
 *
 * Constraints:
 *
 * m == grid.length
 * n == grid[i].length
 * 1 <= m, n <= 20
 * 1 <= m * n <= 20
 * -1 <= grid[i][j] <= 2
 * There is exactly one starting cell and one ending cell.
 */

public class L980_UniquePath3 {
    public int uniquePathsIII(int[][] grid) {
        int zeros = 0;
        int startx = 0;
        int starty = 0;

        for(int i = 0; i<grid.length;i++){ // here we are finding the starting point of robot
            for(int j = 0;j<grid[i].length; j++){
                if(grid[i][j] == 0){
                    zeros++; // count the number of zeros, which tell the number of grid is need to get cover from starting point to end point
                }
                if(grid[i][j] == 1){
                    startx = i;
                    starty = j;
                }
            }
        }

        return recursion(grid, startx, starty, zeros);
    }


    public int recursion(int[][] grid, int x, int y, int zeros){ // this recursion is a proper dfs
        if(x<0 || y<0 || x>=grid.length || y >= grid[0].length || grid[x][y] == -1){ // base cases where we have to return '0'
            return 0;
        }

        if(grid[x][y] == 2){
            return zeros == -1 ? 1 : 0; // when count of zero becomes -1 then we are returning 1, why?
            // bcz to reach the destination grid we have to move number of zeros + 1 times
        }

        grid[x][y] = -1;
        zeros--;


        int a = recursion(grid, x+1, y, zeros); // a gives the path possible, if we start from right side
        int b = recursion(grid, x, y+1, zeros); // b gives the path possible, if we start from up grid of the starting point
        int c = recursion(grid, x-1, y, zeros); // c gives the path possible, if we start from left side
        int d = recursion(grid, x, y-1, zeros); // d gives the path possible, if we start from  down grid of the starting point

        grid[x][y] = 0; // while backtracking putting '0' where we have kept '-1'
//        zeros++ // and one more thing is need to keep in mind, while backtrack we have to increase the number of zeros, which get help in finding the other paths
        // but, no need to increase the number of zeros, bcz while backtracking behind the scene number of zeros getting increase

        return a + b + c + d;
    }
}
