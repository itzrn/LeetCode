package src;

/**
 * Given an array of intervals where intervals[i] = [starti, endi], merge all overlapping intervals,
 * and return an array of the non-overlapping intervals that cover all the intervals in the input.
 *
 *
 *
 * Example 1:
 *
 * Input: intervals = [[1,3],[2,6],[8,10],[15,18]]
 * Output: [[1,6],[8,10],[15,18]]
 * Explanation: Since intervals [1,3] and [2,6] overlap, merge them into [1,6].
 * Example 2:
 *
 * Input: intervals = [[1,4],[4,5]]
 * Output: [[1,5]]
 * Explanation: Intervals [1,4] and [4,5] are considered overlapping.
 *
 *
 * Constraints:
 *
 * 1 <= intervals.length <= 104
 * intervals[i].length == 2
 * 0 <= starti <= endi <= 104
 */

import java.util.Arrays;
import java.util.LinkedList;

public class L56_MergeIntervals {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]); // sorting 2D array on the basis of index 0
        LinkedList<int[]> res = new LinkedList<>();
        res.add(intervals[0]); //keeping intervals[0] in res, bcz this interval will have its start time lowest among all

        // iterating to every other intervals
        for(int i = 1; i<intervals.length;i++){ // here two case will arise
            if(res.getLast()[1]>=intervals[i][0] && res.getLast()[1]<=intervals[i][1]){ // case 1-> this case merge any number of overlapped intervals
                res.getLast()[1] = intervals[i][1];
            }else if(res.getLast()[1] < intervals[i][0]){
                // case 2-> this case identify un-overlapped interval, and add that interval to res, then go for following overlapped intervals
                res.add(intervals[i]);
            }
        }

        return res.toArray(new int[res.size()][2]); // this is the way to convert LinkedList of array to 2D array
        // we can aso use 'List<int[]> res = new ArrayList<>()'
    }
}
