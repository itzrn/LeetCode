package src;

/**
 * On a 2D plane, there are n points with integer coordinates points[i] = [xi, yi].
 * Return the minimum time in seconds to visit all the points in the order given by points.
 *
 * You can move according to these rules:
 *
 * In 1 second, you can either:
 * move vertically by one unit,
 * move horizontally by one unit, or
 * move diagonally sqrt(2) units (in other words, move one unit vertically then one unit horizontally in 1 second).
 * You have to visit the points in the same order as they appear in the array.
 * You are allowed to pass through points that appear later in the order, but these do not count as visits.
 *
 *
 * Example 1:
 *
 *
 * Input: points = [[1,1],[3,4],[-1,0]]
 * Output: 7
 * Explanation: One optimal path is [1,1] -> [2,2] -> [3,3] -> [3,4] -> [2,3] -> [1,2] -> [0,1] -> [-1,0]
 * Time from [1,1] to [3,4] = 3 seconds
 * Time from [3,4] to [-1,0] = 4 seconds
 * Total time = 7 seconds
 * Example 2:
 *
 * Input: points = [[3,2],[-2,2]]
 * Output: 5
 *
 *
 * Constraints:
 *
 * points.length == n
 * 1 <= n <= 100
 * points[i].length == 2
 * -1000 <= points[i][0], points[i][1] <= 1000
 */

public class L1266_MinimumTimeVisitingAllPoints {
    public int minTimeToVisitAllPoints(int[][] points) {
        int count = 0;
        for(int i = 1; i<points.length; i++){
            int[] a = points[i-1];
            int[] b = points[i];

            if(a[0] == b[0]){ // this conditions says that the point 'a' and 'b' lies on same vertical point
                count += Math.abs(a[1] - b[1]);
            }else if(a[1] == b[1]){ // this condition says that the point 'a' and 'b' lies on same horizontal line
                count += Math.abs(a[0] - b[0]);
            }else { // this condition says that point 'a' and 'b' lines on a line which is neither vertical nor horizontal
                // if we talk about one single grid in that we can move diagonally in 1 sec
                // here two time wil get add if possible
                // time1 -> time to make those two point to come in a proper diagonal
                // time2 -> time to travel the diagonal

                // calculating diff1 and diff2 to calculate time1 and time2
                int diff1 = Math.abs(a[0] - b[0]);
                int diff2 = Math.abs(a[1] - b[1]);
                count += Math.abs(diff1 - diff2);// if two point are not at their proper diagonal, then that time is getting add which is moving straight, else if its already at its proper diagonal then it will add '0'
                count += Math.min(diff1, diff2);// after coming at proper diagonal, now adding the diagonal difference time travel
            }

        }

        return count;
    }
}
