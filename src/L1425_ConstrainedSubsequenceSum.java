package src;

/**
 * Given an integer array nums and an integer k, return the maximum sum of a non-empty subsequence
 * of that array such that for every two consecutive integers in the subsequence, nums[i] and nums[j], where i < j, the condition j - i <= k is satisfied.
 *
 * A subsequence of an array is obtained by deleting some number of elements (can be zero) from the array,
 * leaving the remaining elements in their original order.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [10,2,-10,5,20], k = 2
 * Output: 37
 * Explanation: The subsequence is [10, 2, 5, 20].
 * Example 2:
 *
 * Input: nums = [-1,-2,-3], k = 1
 * Output: -1
 * Explanation: The subsequence must be non-empty, so we choose the largest number.
 * Example 3:
 *
 * Input: nums = [10,-2,-10,-5,20], k = 2
 * Output: 23
 * Explanation: The subsequence is [10, -2, -5, 20].
 *
 *
 * Constraints:
 *
 * 1 <= k <= nums.length <= 105
 * -104 <= nums[i] <= 104
 */

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

public class L1425_ConstrainedSubsequenceSum {
    public int constrainedSubsetSum(int[] nums, int k) {
        int[] dp = new int[nums.length];
        return iteration(nums, dp, k);
    }

    public int iteration(int[] arr, int[] dp, int k){
        dp[arr.length-1] = arr[arr.length-1];
        int res = arr[arr.length-1];
        Queue<int[]> pq = new PriorityQueue<>((a, b) -> (b[0] - a[0])); // this is the way to keep a pair in priority queue or any data structure
        // the above queue is maxheap based on index '0' of every array(pair)
        pq.add(new int[]{dp[arr.length-1], arr.length-1});// adding the first pair


        // this play the role of back tracking of the recursive function
        for(int i = arr.length-2; i >= 0; i--){

            // this is to optimize the solution
            while(!pq.isEmpty() && pq.peek()[1] - i > k){
                pq.remove();
            }

            // using dp to keep the max value from i+1 to j-i <= k
//            assert pq.peek() != null; // this is used to assert the compiler that the queue is not empty
            dp[i] = Math.max(arr[i] + pq.peek()[0], arr[i]);
            pq.add(new int[]{dp[i], i});
            res  = Math.max(res, dp[i]);
        }

        return res;
    }

    public int constrainedSubsetSum3(int[] nums, int k) {
        return iteration3(nums, k);
    }

    // using priority queue as dp
    public int iteration3(int[] arr, int k){
        int res = arr[arr.length-1];
        Queue<int[]> pq = new PriorityQueue<>((a,b) -> (b[0] - a[0]));
        pq.add(new int[]{arr[arr.length-1], arr.length-1});
        for(int i = arr.length-2; i >= 0; i--){
            while(!pq.isEmpty() && pq.peek()[1] - i > k) {
                pq.remove();
            }
            int a = Math.max(arr[i] + pq.peek()[0], arr[i]);
            pq.add(new int[]{a, i});
            res  = Math.max(res, a);
        }
        return res;
    }


    // this solution gives TLE in leetcode
    public int constrainedSubsetSum1(int[] nums, int k) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, Integer.MIN_VALUE);
        int a = recursion(nums, dp, 0, k);
        return res;
    }

    int res;
    public int recursion(int[] arr, int[] dp, int index, int k){
        if(dp[index] != Integer.MIN_VALUE){
            return dp[index];
        }

        if(index == arr.length-1){
            dp[index] = arr[index];
            res  = dp[index];
            return dp[index];
        }

        int max = Integer.MIN_VALUE;
        for(int i = index+1; i< arr.length && i <= index+k; i++){
            max = Math.max(max, recursion(arr, dp, i, k));
        }

        dp[index] = Math.max(arr[index] + max, arr[index]);

        res  = Math.max(res, dp[index]);

        return dp[index];
    }


    // this is also TLE in leetcode, but this is the iterative way, this iterative way is just using backtracking  of recursion method
    public int constrainedSubsetSum2(int[] nums, int k) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, Integer.MIN_VALUE);
        return iteration2(nums, dp, k);
    }
    public int iteration2(int[] arr, int[] dp, int k){
        dp[arr.length-1] = arr[arr.length-1];
        int res = arr[arr.length-1];

        for(int i = arr.length-2; i >= 0; i--){
            int max = Integer.MIN_VALUE;
            for(int j = i+1; j<arr.length && j <= i+k; j++){
                max = Math.max(max, dp[j]);
            }
            dp[i] = Math.max(arr[i] + max, arr[i]);
            res  = Math.max(res, dp[i]);
        }

        return res;
    }
}
