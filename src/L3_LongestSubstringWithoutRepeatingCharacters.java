package src;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
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

    LinkedList<Character> list = new LinkedList<>();
    int temp = 0;
    int big = 0;
    boolean check = false;
    public int lengthOfLongestSubstring3(String s) {
        if(temp == s.length()){
            return big;
        }
        for(int j = temp;j<s.length();j++){
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
        temp++;

        return lengthOfLongestSubstring3(s);
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



    // using array and sliding window
    public int lengthOfLongestSubstring4(String s) {
        // in total we have 128 character and symbol in ascii
        // where index vary from 0 to 127
        int[] count = new int[128];
        char[] str = s.toCharArray();
        int n = str.length;
        int max = 0;
        int x = 0;
        int y = 0;
        for(; y<n; y++){
            count[str[y]]++;

            while(count[str[y]]>1){
                count[str[x]]--;
                x++;
            }

            max = Math.max(max, y-x+1);
        }

        return max;
    }
}
