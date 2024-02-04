package src;

/**
 * Given an integer array arr, partition the array into (contiguous) subarrays of length at most k. After partitioning,
 * each subarray has their values changed to become the maximum value of that subarray.
 *
 * Return the largest sum of the given array after partitioning. Test cases are generated so that the answer fits in a 32-bit integer.
 *
 *
 *
 * Example 1:
 *
 * Input: arr = [1,15,7,9,2,5,10], k = 3
 * Output: 84
 * Explanation: arr becomes [15,15,15,9,10,10,10]
 * Example 2:
 *
 * Input: arr = [1,4,1,5,7,3,6,1,9,9,3], k = 4
 * Output: 83
 * Example 3:
 *
 * Input: arr = [1], k = 1
 * Output: 1
 *
 *
 * Constraints:
 *
 * 1 <= arr.length <= 500
 * 0 <= arr[i] <= 109
 * 1 <= k <= arr.length
 */

public class L1043_PartitionArrayOfMaximumSum {

    public int maxSumAfterPartitioning(int[] arr, int k) {
        return recursion(arr, 0, arr.length, k, new int[arr.length]);
    }


    // this is just simple recursive dfs solution, here the only thing is need to make sure, time of loop should run for a particular index
    public int recursion(int[] arr, int index, int n, int k, int[] dp){
        if(index >= n){ // base case
            return 0;
        }

        if(dp[index] != 0){ // using dp
            return dp[index];
        }

        int max = 0; // this is to calculate max value for a partition at index 'index'
        for(int i = index; i<n && i<index+k; i++){
            max = Math.max(max, arr[i]);
            dp[index] = Math.max(dp[index], max*(i-index+1) + recursion(arr, i+1, n, k, dp)); // i-index+1 identify the number of times the max should get multiply for the partition
        }

        return dp[index]; // this is returning the max of a partition
    }
}
