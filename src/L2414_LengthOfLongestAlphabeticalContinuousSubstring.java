package src;

/**
 * An alphabetical continuous string is a string consisting of consecutive letters in the alphabet.
 * In other words, it is any substring of the string "abcdefghijklmnopqrstuvwxyz".
 *
 * For example, "abc" is an alphabetical continuous string, while "acb" and "za" are not.
 * Given a string s consisting of lowercase letters only, return the length of the longest alphabetical continuous substring.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "abacaba"
 * Output: 2
 * Explanation: There are 4 distinct continuous substrings: "a", "b", "c" and "ab".
 * "ab" is the longest continuous substring.
 * Example 2:
 *
 * Input: s = "abcde"
 * Output: 5
 * Explanation: "abcde" is the longest continuous substring.
 *
 *
 * Constraints:
 *
 * 1 <= s.length <= 105
 * s consists of only English lowercase letters.
 */

import java.util.Stack;

public class L2414_LengthOfLongestAlphabeticalContinuousSubstring {
    public int longestContinuousSubstring(String s) {
        Stack<Character> stack = new Stack<>();
        stack.push(s.charAt(0));
        int max = 1;
        for(int i=1; i<s.length(); i++){
            if(s.charAt(i) - stack.peek() != 1){ // condition when the string are continuous
                max = Math.max(max, stack.size());
                stack.clear();
            }

            stack.push(s.charAt(i));
        }

        max = Math.max(max, stack.size()); // this is for the last continuous substring if formed
        return max;
    }
}
