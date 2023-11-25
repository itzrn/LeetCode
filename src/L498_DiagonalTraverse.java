package src;

/**
 * Given an m x n matrix mat, return an array of all the elements of the array in a diagonal order.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: mat = [[1,2,3],[4,5,6],[7,8,9]]
 * Output: [1,2,4,7,5,3,6,8,9]
 * Example 2:
 *
 * Input: mat = [[1,2],[3,4]]
 * Output: [1,2,3,4]
 *
 *
 * Constraints:
 *
 * m == mat.length
 * n == mat[i].length
 * 1 <= m, n <= 104
 * 1 <= m * n <= 104
 * -105 <= mat[i][j] <= 105
 */

import java.util.*;

public class L498_DiagonalTraverse {

    // here we are using i+j method, to cover this type of diagonals
    public int[] findDiagonalOrder(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int[] ans = new int[m*n];
        Map<Integer, List<Integer>> map = new HashMap<>();

        for(int i = 0; i<m; i++){
            for(int j = 0; j<n; j++){
                if(!map.containsKey(i+j)){
                    map.put(i+j, new ArrayList<>());
                }

                map.get(i+j).add(mat[i][j]);
            }
        }
        int k = 0;
        for(int i:map.keySet()){

            List<Integer> list=map.get(i);

            if(i%2==0){ // reversing the list so to follow the pattern given in que
                Collections.reverse(list);
            }
            for (int j : list) {
                ans[k] = j;
                k++;
            }
        }

        return ans;
    }
}
