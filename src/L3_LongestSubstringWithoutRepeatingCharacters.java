package src;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Given a string s, find the length of the longest
 * substring
 *  without repeating characters.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "abcabcbb"
 * Output: 3
 * Explanation: The answer is "abc", with the length of 3.
 * Example 2:
 *
 * Input: s = "bbbbb"
 * Output: 1
 * Explanation: The answer is "b", with the length of 1.
 * Example 3:
 *
 * Input: s = "pwwkew"
 * Output: 3
 * Explanation: The answer is "wke", with the length of 3.
 * Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.
 *
 *
 * Constraints:
 *
 * 0 <= s.length <= 5 * 104
 * s consists of English letters, digits, symbols and spaces.
 */

public class L3_LongestSubstringWithoutRepeatingCharacters {
    Queue<Character> dp = new LinkedList<>();
    int i = 0; // this is used for the indexing of the String
    int max = 0; // this is used to calculate the max length
    public int lengthOfLongestSubstring(String s) {
        if(i == s.length()){ // base case, when the 'i' moves IndexOutOfBound, means String got over
            return max;
        }

        if(!dp.contains(s.charAt(i))){ //In this condition, we are checking if the dp have the particular character or not, if not then add to do and find the new max
            dp.add(s.charAt(i));
            max = Math.max(max,dp.size());
        }else{ // if dp already contains, ith character, then remove all the characters including it which are before the ith character
            dp.add(s.charAt(i));
            while(dp.remove() != s.charAt(i));
        }
        i++;
        return lengthOfLongestSubstring(s);
    }
}
