package src;

/**
 * Given an m x n matrix, return all elements of the matrix in spiral order.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
 * Output: [1,2,3,6,9,8,7,4,5]
 * Example 2:
 *
 *
 * Input: matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
 * Output: [1,2,3,4,8,12,11,10,9,5,6,7]
 *
 *
 * Constraints:
 *
 * m == matrix.length
 * n == matrix[i].length
 * 1 <= m, n <= 10
 * -100 <= matrix[i][j] <= 100
 */

import java.util.ArrayList;
import java.util.List;

public class L54_SpiralMatrix {
    List<Integer> res = new ArrayList<>();
    int[][] matrix;
    int m;
    int n;

    public void borderFrom(int r, int c) {
        for (int i = c; i <= c + n - 1; i++) {
            res.add(matrix[r][i]);
        }
        for (int i = r + 1; i <= r + m - 2; i++) {
            res.add(matrix[i][c + n - 1]);
        }
        if (m > 1) {
            for (int i = c + n - 1; i >= c; i--) {
                res.add(matrix[r + m - 1][i]);
            }
        }
        if (n > 1) {
            for (int i = r + m - 2; i >= r + 1; i--) {
                res.add(matrix[i][c]);
            }
        }
    }

    public List<Integer> spiralOrder(int[][] matrix) {
        this.matrix = matrix;
        m = matrix.length;
        n = matrix[0].length;
        int p = 0;
        while (n > 0 && m > 0) {
            borderFrom(p, p);
            p++;
            m -= 2;
            n -= 2;
        }
        return res;
    }
}
