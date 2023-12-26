package src;

/**
 * A message containing letters from A-Z can be encoded into numbers using the following mapping:
 *
 * 'A' -> "1"
 * 'B' -> "2"
 * ...
 * 'Z' -> "26"
 * To decode an encoded message, all the digits must be grouped then mapped back into letters using the reverse of the
 * mapping above (there may be multiple ways). For example, "11106" can be mapped into:
 *
 * "AAJF" with the grouping (1 1 10 6)
 * "KJF" with the grouping (11 10 6)
 * Note that the grouping (1 11 06) is invalid because "06" cannot be mapped into 'F' since "6" is different from "06".
 *
 * Given a string s containing only digits, return the number of ways to decode it.
 *
 * The test cases are generated so that the answer fits in a 32-bit integer.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "12"
 * Output: 2
 * Explanation: "12" could be decoded as "AB" (1 2) or "L" (12).
 * Example 2:
 *
 * Input: s = "226"
 * Output: 3
 * Explanation: "226" could be decoded as "BZ" (2 26), "VF" (22 6), or "BBF" (2 2 6).
 * Example 3:
 *
 * Input: s = "06"
 * Output: 0
 * Explanation: "06" cannot be mapped to "F" because of the leading zero ("6" is different from "06").
 *
 *
 * Constraints:
 *
 * 1 <= s.length <= 100
 * s contains only digits and may contain leading zero(s).
 */

import java.util.Arrays;

public class L91_DecodeWays {
    public int numDecodings(String s) {
        int[] dp = new int[s.length()];
        Arrays.fill(dp, -1); // filling dp with -1, which indicates we haven't explore this index

        return recursion(0, s, s.length(), dp);
    }

    public int recursion(int index, String str, int n, int[] dp){
        if(index == n){ // base case to identify that we have one solution
            return 1;
        }

        if(str.charAt(index) == '0'){ // case where the partition can be invalid
            return 0;
        }

        if(dp[index] != -1){ // if the value og index != -1, means that particular index is already explored
            return dp[index];
        }

        // simple tree creation
        int ith_char = recursion(index+1, str, n, dp); // this is the left child creation of tree
        int iPlus1_char = 0;

        if(index+1 < n && (str.charAt(index) == '1' || str.charAt(index) == '2' && str.charAt(index+1)<='6')){
            // this is the right child creation of tree which some conditions
            iPlus1_char += recursion(index+2, str, n, dp);
        }

        return dp[index] = ith_char + iPlus1_char; // updating the index of dp
    }
}
