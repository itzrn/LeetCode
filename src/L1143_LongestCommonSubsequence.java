package src;

/**
 * Given two strings text1 and text2, return the length of their longest common subsequence. If there is no common subsequence,
 * return 0.
 *
 * A subsequence of a string is a new string generated from the original string with some characters (can be none) deleted without
 * changing the relative order of the remaining characters.
 *
 * For example, "ace" is a subsequence of "abcde".
 * A common subsequence of two strings is a subsequence that is common to both strings.
 *
 *
 * Example 1:
 *
 * Input: text1 = "abcde", text2 = "ace"
 * Output: 3
 * Explanation: The longest common subsequence is "ace" and its length is 3.
 * Example 2:
 *
 * Input: text1 = "abc", text2 = "abc"
 * Output: 3
 * Explanation: The longest common subsequence is "abc" and its length is 3.
 * Example 3:
 *
 * Input: text1 = "abc", text2 = "def"
 * Output: 0
 * Explanation: There is no such common subsequence, so the result is 0.
 *
 *
 * Constraints:
 *
 * 1 <= text1.length, text2.length <= 1000
 * text1 and text2 consist of only lowercase English characters.
 */

public class L1143_LongestCommonSubsequence {

    // this is a question where you can learn the use of 2D dp
    public int longestCommonSubsequence(String text1, String text2) {
        /*
        here first thing in mind should not come to make the all possible subsequence and check one by one, bcz this is the brut force approach which gives TLE on leetcode

        here the approach is to make tree where parent have one child or two child based on two condition
        parent with one node -> when the characters are same on given two index
        parent have two nodes -> when the characters are different on given two index

        choose 2D dp -> bcz, for every index in string1 there is need to iterate through all indexes of string2,
        when we found same character on one index of string1 and on one index of string2 then we can have the further search for longest subsequence

        at the end of the dat this recursive solution is not optimal to submit the code on leetcode
        bcz, too much time is getting consume in doing recursion and doing backtracking

        most optimal solution will be given by bottom up dp.
         */

        int n = text1.length();
        int m = text2.length();
        return recursion(text1.toCharArray(), n, 0, text2.toCharArray(), m, 0, new int[n][m]);
    }

    public int recursion(char[] str1, int n, int idx1, char[] str2, int m, int idx2, int[][] dp){
        if(idx1 == n || idx2 == m){
            return 0;
        }

        if(dp[idx1][idx2] != 0){
            return dp[idx1][idx2];
        }

        if(str1[idx1] == str2[idx2]){
            return 1 + recursion(str1, n, idx1+1, str2, m, idx2+1, dp);
        }

        int temp1 = recursion(str1, n, idx1+1, str2, m, idx2, dp);
        int temp2 = recursion(str1, n, idx1, str2, m, idx2+1, dp);

        return dp[idx1][idx2] = Math.max(dp[idx1][idx2], Math.max(temp1, temp2));
    }

    /*
    adding small optimization in the above recursive function to get the solution submit on leetcode

    here optimization is like ->
    we can see if there is a character in string1 and its not present in string2 then that character can not get add in the common longest subsequence
    time is getting increase where the string1 or string2 have a character 2 times present in it, and it's not present in the other string then for exploring for same character again and again
    is time-consuming, so this is what getting optimize here.

    so if there is a character which is not present in another string, making marked as -1 not to explore again if in future that character gets repeat.
     */

    public int longestCommonSubsequence2(String text1, String text2) {
        int n = text1.length();
        int m = text2.length();
        int ans = recursion2(text1.toCharArray(), n, 0, text2.toCharArray(), m, 0, new int[n][m]);
        return ans == -1?0: ans;
    }

    public int recursion2(char[] str1, int n, int idx1, char[] str2, int m, int idx2, int[][] dp){
        if(idx1 == n || idx2 == m || dp[idx1][idx2] == -1){
            return 0;
        }

        if(dp[idx1][idx2] != 0){
            return dp[idx1][idx2];
        }

        if(str1[idx1] == str2[idx2]){
            return 1 + recursion(str1, n, idx1+1, str2, m, idx2+1, dp);
        }

        int temp1 = recursion2(str1, n, idx1+1, str2, m, idx2, dp);
        int temp2 = recursion2(str1, n, idx1, str2, m, idx2+1, dp);

        int temp3 = Math.max(dp[idx1][idx2], Math.max(temp1, temp2));
        return dp[idx1][idx2] = temp3 == 0?-1:temp3;
    }


    // this is the bottom-up approach
    public int longestCommonSubsequence3(String text1, String text2) {
        int n = text1.length();
        int m = text2.length();

        int[][] dp = new int[n+1][m+1];
        for(int i = 1; i<=n; i++){
            for(int j = 1; j<=m; j++){
                if(text1.charAt(i-1) == text2.charAt(j-1)){
                    dp[i][j] = 1 + dp[i-1][j-1];
                    continue;
                }

                dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
            }
        }


        return dp[n][m];
    }
}
