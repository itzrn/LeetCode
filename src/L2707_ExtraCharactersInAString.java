package src;

/**
 * You are given a 0-indexed string s and a dictionary of words dictionary. You have to break s into one or more non-overlapping
 * substrings such that each substring is present in dictionary. There may be some extra characters in s which are not present in any of the substrings.
 *
 * Return the minimum number of extra characters left over if you break up s optimally.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "leetscode", dictionary = ["leet","code","leetcode"]
 * Output: 1
 * Explanation: We can break s in two substrings: "leet" from index 0 to 3 and "code" from index 5 to 8.
 * There is only 1 unused character (at index 4), so we return 1.
 *
 * Example 2:
 *
 * Input: s = "sayhelloworld", dictionary = ["hello","world"]
 * Output: 3
 * Explanation: We can break s in two substrings: "hello" from index 3 to 7 and "world" from index 8 to 12. The characters at indices 0, 1, 2
 * are not used in any substring and thus are considered as extra characters. Hence, we return 3.
 *
 *
 * Constraints:
 *
 * 1 <= s.length <= 50
 * 1 <= dictionary.length <= 50
 * 1 <= dictionary[i].length <= 50
 * dictionary[i] and s consists of only lowercase English letters
 * dictionary contains distinct words
 */

public class L2707_ExtraCharactersInAString {
    public int minExtraChar(String s, String[] dictionary) {
        // using Integer array bcz it won't need to fill it with -1 else we can use initial value as null which saves the time in filling array with -1
        return recursion(s, 0, s.length(), dictionary, new Integer[s.length()]);
    }

    // doing dfs based on two condition with multiple choice
    // for each two condition there will be separate recursion means n condition n recursion
    public int recursion(String str, int index, int n, String[] dict, Integer[] dp){
        if(index == n){
            return 0;
        }

        if(dp[index] != null){
            return dp[index];
        }

        int min = Integer.MAX_VALUE;

        // below recursion is of condition one
        // which is responsible to create the graph
        for(String i: dict){
            int len = i.length();
            if(index+len <= n && str.substring(index, index+len).equals(i)){
                min = Math.min(min, recursion(str, index+len, n, dict, dp));
            }
        }

        // earlier I was using this, here it's not searching for those extra characters when the character at index 'index' is not involve
        // here not involve means -> we are considering that character as extra
        // if(min == Integer.MAX_VALUE){
        //     min = 1 + recursion(str, index+1, n, dict);
        // }

        // here recursion is based on condition 2
        // which is required when a character is need to skip, so first we will check that dictionary contains the word starting with character at index 'index'
        // if it contains then make the graph for that and also check if we won't involve that particular character then how many extra character we will left with
        min = Math.min(min, 1+recursion(str, index+1, n, dict, dp));

        return dp[index] = min;
    }
}
