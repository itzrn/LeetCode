package src;

/**
 * Given an integer n, your task is to count how many strings of length n can be formed under the following rules:
 *
 * Each character is a lower case vowel ('a', 'e', 'i', 'o', 'u')
 * Each vowel 'a' may only be followed by an 'e'.
 * Each vowel 'e' may only be followed by an 'a' or an 'i'.
 * Each vowel 'i' may not be followed by another 'i'.
 * Each vowel 'o' may only be followed by an 'i' or a 'u'.
 * Each vowel 'u' may only be followed by an 'a'.
 * Since the answer may be too large, return it modulo 10^9 + 7.
 *
 *
 *
 * Example 1:
 *
 * Input: n = 1
 * Output: 5
 * Explanation: All possible strings are: "a", "e", "i" , "o" and "u".
 * Example 2:
 *
 * Input: n = 2
 * Output: 10
 * Explanation: All possible strings are: "ae", "ea", "ei", "ia", "ie", "io", "iu", "oi", "ou" and "ua".
 * Example 3:
 *
 * Input: n = 5
 * Output: 68
 */

public class L1220_CountVowelPermutation {
    long[][] dp;
    int MOD = (int)1e9+7;
    public int countVowelPermutation(int n) {
        dp = new long[n+1][26]; // we can make the size of (n+1, 5)

        // applying dfs for a, e, i, o, u
        return (int)((recursion(n-1,'a') + recursion(n-1,'e') + recursion(n-1,'i') + recursion(n-1,'o') + recursion(n-1,'u')) % MOD);
    }

    // this is just a dfs with many conditions
    public long recursion(int n, char previousChar){
        if(n == 0){
            return 1;
        }

        if(dp[n][previousChar -'a']  != 0){
            return dp[n][previousChar -'a'] ;
        }

        long count = 0;
        if(previousChar == 'a'){
            count = recursion(n-1,'e');
        }
        else if(previousChar == 'e'){
            count = (recursion(n-1,'a') + recursion(n-1,'i'));
        }
        else if(previousChar == 'i'){
            count = recursion(n-1,'a') + recursion(n-1,'e') + recursion(n-1,'o') + recursion(n-1,'u');
        }
        else if(previousChar == 'o'){
            count = recursion(n-1,'i') + recursion(n-1,'u');
        }
        else if(previousChar == 'u'){
            count = recursion(n-1,'a');
        }
        return dp[n][previousChar -'a'] = (count % MOD);
    }
}
