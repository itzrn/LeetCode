package src;

/**
 * Given an m x n integer matrix matrix, if an element is 0, set its entire row and column to 0's.
 *
 * You must do it in place.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: matrix = [[1,1,1],[1,0,1],[1,1,1]]
 * Output: [[1,0,1],[0,0,0],[1,0,1]]
 * Example 2:
 *
 *
 * Input: matrix = [[0,1,2,0],[3,4,5,2],[1,3,1,5]]
 * Output: [[0,0,0,0],[0,4,5,0],[0,3,1,0]]
 *
 *
 * Constraints:
 *
 * m == matrix.length
 * n == matrix[0].length
 * 1 <= m, n <= 200
 * -231 <= matrix[i][j] <= 231 - 1
 *
 *
 * Follow up:
 *
 * A straightforward solution using O(mn) space is probably a bad idea.
 * A simple improvement uses O(m + n) space, but still not the best solution.
 * Could you devise a constant space solution?
 */

public class L73_SetMatrixZeros {

//    this is the better solution
    // try to optimize the solution without using extra space
    public void setZeroes1(int[][] matrix) { // TC -> O(2 * M * N)  SC -> O(N + M)
        int[] column = new int[matrix.length];
        int[] row = new int[matrix[0].length];

        // firstly trying to mark all the rows and column which is need to be marked zero at the end of the day
        for(int i = 0;i<matrix.length;i++){
            for(int j = 0 ;j<matrix[i].length; j++){
                if(matrix[i][j] == 0){
                    column[i] = 1;
                    row[j] = 1;
                }
            }
        }

        // at the end of the day, marking a grid  zero whose row or column is marked
        for(int i = 0;i<matrix.length;i++){
            for(int j = 0;j<matrix[i].length;j++){
                if(column[i] == 1 || row[j] == 1){
                    matrix[i][j] = 0;
                }
            }
        }
    }
}
