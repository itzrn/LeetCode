package src;

/**
 * You are given four integers sx, sy, fx, fy, and a non-negative integer t.
 *
 * In an infinite 2D grid, you start at the cell (sx, sy). Each second, you must move to any of its adjacent cells.
 *
 * Return true if you can reach cell (fx, fy) after exactly t seconds, or false otherwise.
 *
 * A cell's adjacent cells are the 8 cells around it that share at least one corner with it. You can visit the same cell several times.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: sx = 2, sy = 4, fx = 7, fy = 7, t = 6
 * Output: true
 * Explanation: Starting at cell (2, 4), we can reach cell (7, 7) in exactly 6 seconds by going through the cells depicted in the picture above.
 * Example 2:
 *
 *
 * Input: sx = 3, sy = 1, fx = 7, fy = 3, t = 3
 * Output: false
 * Explanation: Starting at cell (3, 1), it takes at least 4 seconds to reach cell (7, 3) by going through the cells depicted in the picture above.
 * Hence, we cannot reach cell (7, 3) at the third second.
 *
 *
 * Constraints:
 *
 * 1 <= sx, sy, fx, fy <= 109
 * 0 <= t <= 109
 */

/*
approach->
   we will first calculate the minimum time to reach the end cell.
   and then calculate the min time ti reach the end cell
   if t>=min time means we can reach the end cell in given time
   else we can not reach
 */

public class L2849_DetermineIfACellIsReachableAtAGivenTime {
    public boolean isReachableAtTime(int sx, int sy, int fx, int fy, int t) {
        int xDist = Math.abs(sx - fx); // total distance need to travel in x direction
        int yDist = Math.abs(sy - fy); // total distance need to travel in y direction

        if (xDist == 0 && yDist == 0 && t==1) { // the base case which is need to put.
            return false;
        }

        int min = Math.max(xDist, yDist); // calculating the min time to reach from start to end
        return min<=t;
    }
}