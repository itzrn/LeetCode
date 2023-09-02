package src;

/**
 * You are given an m x n integer matrix matrix with the following two properties:
 *
 * Each row is sorted in non-decreasing order.
 * The first integer of each row is greater than the last integer of the previous row.
 * Given an integer target, return true if target is in matrix or false otherwise.
 *
 * You must write a solution in O(log(m * n)) time complexity.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 3
 * Output: true
 * Example 2:
 *
 *
 * Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 13
 * Output: false
 *
 *
 * Constraints:
 *
 * m == matrix.length
 * n == matrix[i].length
 * 1 <= m, n <= 100
 * -104 <= matrix[i][j], target <= 104
 */

public class L74_L240_SearchA2DMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        for(int i = 0;i<matrix.length;i++){ // iterating to ever matrix
            if(binarySearch(matrix[i],0,matrix[i].length-1,target)){ // searching target value in every matrix
                return true;
            }
        }
        return false;
    }

    public boolean binarySearch(int[] arr, int low, int high, int target){ // time complexity -> log(n)
        if(low>high){
            return false;
        }
        int mid = low + (high-low)/2;
        if(arr[mid] == target){
            return true;
        }

        return binarySearch(arr,low,mid-1,target) || binarySearch(arr,mid+1,high,target);
    }
}
