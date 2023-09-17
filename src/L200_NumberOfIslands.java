package src;

/**
 * Given an m x n 2D binary grid grid which represents a map of '1's (land) and '0's (water), return the number of islands.
 *
 * An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically.
 * You may assume all four edges of the grid are all surrounded by water.
 *
 *
 *
 * Example 1:
 *
 * Input: grid = [
 *   ["1","1","1","1","0"],
 *   ["1","1","0","1","0"],
 *   ["1","1","0","0","0"],
 *   ["0","0","0","0","0"]
 * ]
 * Output: 1
 * Example 2:
 *
 * Input: grid = [
 *   ["1","1","0","0","0"],
 *   ["1","1","0","0","0"],
 *   ["0","0","1","0","0"],
 *   ["0","0","0","1","1"]
 * ]
 * Output: 3
 *
 *
 * Constraints:
 *
 * m == grid.length
 * n == grid[i].length
 * 1 <= m, n <= 300
 * grid[i][j] is '0' or '1'.
 */

public class L200_NumberOfIslands {
    public int numIslands(char[][] grid) {
        int count = 0;
        for(int i = 0; i<grid.length; i++){
            for(int j = 0; j<grid[i].length; j++){
                // this loop is basically going all the starting pint of island, and giving that point to recursion to
                // make all the '1' to '0' and then we count that particular island

                // the need to make all '1' to '0' of an island, so that island won't get count many times
                if(grid[i][j] == '1'){
                    recursion(grid, i, j);
                    count++;
                }
            }
        }

        return count;
    }

    public void recursion(char[][] arr, int x, int y){ // this recursion is basically going to an island, and converting all the '1' to '0'
        if(x < 0 || y < 0 || x == arr.length || y == arr[x].length || arr[x][y] == '0'){
            return;
        }

        arr[x][y] = '0';
        recursion(arr, x+1, y);
        recursion(arr, x, y+1);
        recursion(arr, x-1, y);
        recursion(arr, x, y-1);
    }
}
