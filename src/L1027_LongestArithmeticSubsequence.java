package src;

import java.util.HashMap;

/**
 * Given an array nums of integers, return the length of the longest arithmetic subsequence in nums.
 *
 * Note that:
 *
 * A subsequence is an array that can be derived from another array by deleting some or no elements without changing
 * the order of the remaining elements.
 * A sequence seq is arithmetic if seq[i + 1] - seq[i] are all the same value (for 0 <= i < seq.length - 1).
 *
 *
 * Example 1:
 *
 * Input: nums = [3,6,9,12]
 * Output: 4
 * Explanation:  The whole array is an arithmetic sequence with steps of length = 3.
 */

public class L1027_LongestArithmeticSubsequence {
    public int longestArithSeqLength(int[] nums){
        if(nums.length<=2){  // this is the empty array check
            /*
            why <=2 ?
            bcz a difference can be between 2 element, and if the array contains 2 element means that is in AP(2 integer in the world is always AP)
            and if the number of element is 1, means that number is already in sequence
             */
            return nums.length;
        }

        HashMap<Integer, Integer>[] dp = new HashMap[nums.length];  // creating an array of HashMap for every element of the array
        // this HashMap stores the number of time a particular different occurred with the elements which is bellow its index

        int maxDiffOccur = 1;  //bcz this is the minimum number of time that any difference will get seen.

        for(int  i=0;i< nums.length;i++){ // in n^2 time complexity we are completing the process
            dp[i] = new HashMap<>(); // initializing the HashMap for every element of the array

            for(int j=0;j<i;j++){
                int diff = nums[i] - nums[j];
                int updateCountDiff = dp[j].getOrDefault(diff, 0) + 1; // calculating the number of time that particular difference for this time
                dp[i].put(diff,updateCountDiff); // updating the difference, in the hashmap of particular element
                maxDiffOccur = Math.max(maxDiffOccur,dp[i].get(diff)); // now taking the max of the occurred calculated difference
            }
        }

        return maxDiffOccur+1; // result +1 bcz. difference is between 2 numbers and here we have to return number of
        // element not the number of difference.(like if maxDiffOccur is 4, means 4 time that particular difference appeared which can arise between 5 elements)
    }

    public static void main(String[] args) {
        L1027_LongestArithmeticSubsequence test = new L1027_LongestArithmeticSubsequence();
        int[] arr = {9,4,7,2,10};
        System.out.println(test.longestArithSeqLength(arr));
    }
}
