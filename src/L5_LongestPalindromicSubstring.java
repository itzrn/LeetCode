package src;

/**
 * Given a string s, return the longest
 * palindromic
 *
 * substring
 *  in s.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "babad"
 * Output: "bab"
 * Explanation: "aba" is also a valid answer.
 * Example 2:
 *
 * Input: s = "cbbd"
 * Output: "bb"
 *
 *
 * Constraints:
 *
 * 1 <= s.length <= 1000
 * s consist of only digits and English letters.
 */

public class L5_LongestPalindromicSubstring {
    int[][] dp = new int[1001][1001];
    public String longestPalindrome(String s) {
        int maxLen = 0;
        int startInd = -1;

        // this is just a basic approach, int O(n^2)
        for(int i = 0;i<s.length(); i++){
            for(int j = i;j<s.length();j++){
                if(palindromeCheck(s, i, j) == 1 && maxLen < j-i+1){ // checking each and every substring and taking the biggest one out
                    maxLen = j-i+1;
                    startInd = i;
                }
            }
        }

        return s.substring(startInd, startInd+maxLen);
    }

    // this is just to check a substring is palindrome or not
    public int palindromeCheck(String str, int i, int j){ // 1->true, -1 -> false
        if(i >= j){
            return 1;
        }
        if(dp[i][j] != 0){
            return dp[i][j];
        }

        if(str.charAt(i) == str.charAt(j)){
            return dp[i][j] = palindromeCheck(str, i+1, j-1);
        }

        return dp[i][j] = -1;
    }
}
