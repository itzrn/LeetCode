package src;

import java.util.LinkedList;

/*
Given a string s, find the length of the longest substring without repeating characters.

Example 1:

Input: s = "abcabcbb"
Output: 3
Explanation: The answer is "abc", with the length of 3.


Example 2:

Input: s = "bbbbb"
Output: 1
Explanation: The answer is "b", with the length of 1.


Example 3:

Input: s = "pwwkew"
Output: 3
Explanation: The answer is "wke", with the length of 3.
Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.


testCases --->" ", "aeiou", "a", "dvdf", "aa", "aeabcd"
 */
public class L3_LongestSubStringWithoutRepeatingCharacter {
    LinkedList<Character> list = new LinkedList<>();
    int i = 0;
    int big = 0;
    boolean check = false;
    public int lengthOfLongestSubstring(String s) {
        if(i == s.length()){
            return big;
        }
        for(int j = i;j<s.length();j++){
            if(list.contains(s.charAt(j))){
                if(big < list.size()){
                    big = list.size();
                }
                list.clear();
                break;
            }else{
                list.add(s.charAt(j));
                if(big < list.size()){
                    big = list.size();
                }
            }
        }
        i++;

        return lengthOfLongestSubstring(s);
    }
}
