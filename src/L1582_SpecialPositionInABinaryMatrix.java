package src;

/**
 * Given an m x n binary matrix mat, return the number of special positions in mat.
 *
 * A position (i, j) is called special if mat[i][j] == 1 and all other elements in row i and column j are 0 (rows and columns are 0-indexed).
 *
 *
 *
 * Example 1:
 *
 *
 * Input: mat = [[1,0,0],[0,0,1],[1,0,0]]
 * Output: 1
 * Explanation: (1, 2) is a special position because mat[1][2] == 1 and all other elements in row 1 and column 2 are 0.
 * Example 2:
 *
 *
 * Input: mat = [[1,0,0],[0,1,0],[0,0,1]]
 * Output: 3
 * Explanation: (0, 0), (1, 1) and (2, 2) are special positions.
 *
 *
 * Constraints:
 *
 * m == mat.length
 * n == mat[i].length
 * 1 <= m, n <= 100
 * mat[i][j] is either 0 or 1.
 */

public class L1582_SpecialPositionInABinaryMatrix {
    public int numSpecial(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;

        int[] row = new int[n]; // this is used to store the number of 1 present in a row
        int[] column = new int[m]; // this is used to store the number of 1 present in a column

        for(int i = 0; i<n; i++){ // calculating the number of 1 in each row and each column
            for(int j =0; j<m;j++){
                if(mat[i][j] == 1){
                    row[i]++;
                    column[j]++;
                }
            }
        }

        int count = 0;
        for(int i = 0; i<n; i++){
            for(int j = 0; j<m; j++){
                if(mat[i][j] == 1 && row[i] == 1 && column[j] == 1){ // condition for a grid to be special
                    count++;
                }
            }
        }

        return count;
    }
}
