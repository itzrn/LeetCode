package src;

/**
 * Given a string path, where path[i] = 'N', 'S', 'E' or 'W', each representing moving one unit north, south, east, or west, respectively.
 * You start at the origin (0, 0) on a 2D plane and walk on the path specified by path.
 *
 * Return true if the path crosses itself at any point, that is, if at any time you are on a location you have previously visited. Return false otherwise.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: path = "NES"
 * Output: false
 * Explanation: Notice that the path doesn't cross any point more than once.
 * Example 2:
 *
 *
 * Input: path = "NESWW"
 * Output: true
 * Explanation: Notice that the path visits the origin twice.
 *
 *
 * Constraints:
 *
 * 1 <= path.length <= 104
 * path[i] is either 'N', 'S', 'E', or 'W'.
 */

import java.util.HashSet;
import java.util.Set;

public class L1496_PathCrossing {
    public boolean isPathCrossing(String path) {
        Set<String> set = new HashSet<>();
        int x = 0;
        int y = 0;
        String key = x + "->" + y;
        set.add(key);
        for(char i:path.toCharArray()){
            if(i == 'N'){
                y++;
            }
            else if(i == 'S'){
                y--;
            }
            else if(i == 'E'){
                x++;
            }
            else{
                x--;
            }
            key = x + "->" + y;

            if(set.contains(key)){
                return true;
            }
            set.add(key);
        }
        return false;
    }
}
