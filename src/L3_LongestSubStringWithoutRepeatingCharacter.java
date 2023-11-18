package src;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

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

    // this is using sliding window
    public int lengthOfLongestSubstring2(String s) {
        int n = s.length();
        Map<Character, Integer> map = new HashMap<>();
        int left = 0;
        int max = 0;
        int right = 0;
        while(right < n){
            char temp = s.charAt(right);
            map.put(temp, map.getOrDefault(temp, 0)+1);

            while(map.get(temp) > 1){
                max = Math.max(max, right-left);
                char t = s.charAt(left);
                map.put(t, map.get(t)-1);
                left++;
            }
            right++;
        }
        max = Math.max(max, right-left);

        return max;
    }
}
