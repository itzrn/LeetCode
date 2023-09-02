package src;

/**
 * Given a square matrix mat, return the sum of the matrix diagonals.
 *
 * Only include the sum of all the elements on the primary diagonal
 * and all the elements on the secondary diagonal that are not part of the primary diagonal.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: mat = [[1,2,3],
 *               [4,5,6],
 *               [7,8,9]]
 * Output: 25
 * Explanation: Diagonals sum: 1 + 5 + 9 + 3 + 7 = 25
 * Notice that element mat[1][1] = 5 is counted only once.
 * Example 2:
 *
 * Input: mat = [[1,1,1,1],
 *               [1,1,1,1],
 *               [1,1,1,1],
 *               [1,1,1,1]]
 * Output: 8
 * Example 3:
 *
 * Input: mat = [[5]]
 * Output: 5
 *
 *
 * Constraints:
 *
 * n == mat.length == mat[i].length
 * 1 <= n <= 100
 * 1 <= mat[i][j] <= 100
 */

public class L1572_MatrixDiagonalSum {
    public int diagonalSum(int[][] mat) { // here we have to keep in mind, while calculating the sum of both the diagonal,
        // if the matrix is of odd order then the middle element can get add two time in the sum
        int sum = 0;
        for(int i = 0;i<mat.length;i++){ // diagonal means -> (1,1), (2,2) and so on
            if(i == mat.length-(i+1)){ // this condition is to avoid the two time addition of the middle element when the order of the matrix is odd
                sum += mat[i][i];
            }else{
                sum += mat[i][i] + mat[i][mat.length-(i+1)];
            }
        }
        return sum;
    }
}
