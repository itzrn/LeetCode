package src;

/**
 * Given an integer array nums, return the length of the longest strictly increasing
 * subsequence
 * .
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [10,9,2,5,3,7,101,18]
 * Output: 4
 * Explanation: The longest increasing subsequence is [2,3,7,101], therefore the length is 4.
 * Example 2:
 *
 * Input: nums = [0,1,0,3,2,3]
 * Output: 4
 * Example 3:
 *
 * Input: nums = [7,7,7,7,7,7,7]
 * Output: 1
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 2500
 * -104 <= nums[i] <= 104
 *
 *
 * Follow up: Can you come up with an algorithm that runs in O(n log(n)) time complexity?
 */

import java.util.Arrays;

public class L300_LongestIncreasingSubsequence {

    // this method is iterative dp
    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1); // filling dp with '1', bcz every element is the longest increasing subsequence in itself

        for(int i = nums.length-1; i>=0; i--){ // this takes O(N^2)
            for(int j = i+1; j< nums.length; j++){
                if(nums[i] < nums[j]){
                    dp[i] = Math.max(dp[i], 1 + dp[j]);
                }
            }
        }

        int max = 0;
        for(int i : dp){ // picking out the max of dp
            if(i > max){
                max = i;
            }
        }

        return max;
    }

    // recursive solution, without filling dp array with any specific initial number
    // there is the reason to not fill the dp with any specific value(1)
    // its bcz, when we keep the initial value '1', it will start to repeat some already visited elements, which on further will give TLE
    public int lengthOfLIS2(int[] nums) {
        int n = nums.length;
        recursion(nums, 0, n-1, new int[n]);
        return max;
    }

    int max = 1; // as we know the minimum length possible is '1', so in starting keeping the max length '1'
    public int recursion(int[] arr, int index, int n, int[] dp){
        if(index == n){ // base case, from where the recursion will back track
            dp[index] = 1;
            return index;
        }

        if(dp[index] != 0){ // applying dp
            return index;
        }

        int count = 0;
        for(int i = index+1; i<=n; i++){ // responsible for making the brut force graph
            int temp = recursion(arr, i, n, dp); // keeping the last index visited while back tracking, so to make compare and increase the count on valid compare
            if(arr[index] < arr[temp]){
                count = Math.max(count, dp[temp]);
            }
        }

        dp[index] = count+1; // adding '1' indicates here, adding itself to the count
        max = Math.max(max, dp[index]); // side by side taking the max of the whole dp so in extra need not iterate the dp
        return index; // returning the current index, which will become last index visited while back tracking
    }

}
