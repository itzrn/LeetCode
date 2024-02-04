package src;

/**
 * Given two strings s and t of lengths m and n respectively, return the minimum window
 * substring
 *  of s such that every character in t (including duplicates) is included in the window. If there is no such substring, return the empty string "".
 *
 * The testcases will be generated such that the answer is unique.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "ADOBECODEBANC", t = "ABC"
 * Output: "BANC"
 * Explanation: The minimum window substring "BANC" includes 'A', 'B', and 'C' from string t.
 * Example 2:
 *
 * Input: s = "a", t = "a"
 * Output: "a"
 * Explanation: The entire string s is the minimum window.
 * Example 3:
 *
 * Input: s = "a", t = "aa"
 * Output: ""
 * Explanation: Both 'a's from t must be included in the window.
 * Since the largest window of s only has one 'a', return empty string.
 *
 *
 * Constraints:
 *
 * m == s.length
 * n == t.length
 * 1 <= m, n <= 105
 * s and t consist of uppercase and lowercase English letters.
 *
 *
 * Follow up: Could you find an algorithm that runs in O(m + n) time?
 */

import java.util.HashMap;
import java.util.Map;

public class L76_MinimumWindowSubstring {

    /*
    previously I was trying to implement the bellow approach using 2 map, which was absolutely wrong way of implementing this approach
     */

    public String minWindow(String s, String t) {
        int n = s.length();
        int m = t.length();

        Map<Character, Integer> map = new HashMap<>();
        for(char i: t.toCharArray()){
            map.put(i, map.getOrDefault(i, 0)+1);
        }

        int count = m; // this counter is used to identify that how many characters of 't' is in the current sliding window, the time its get zero means we have covered that substring of 's' which we need as answer
        int min = Integer.MAX_VALUE; // assuming the length of sliding winding initially
        int left = 0; // this is used as left pointer
        int start = 0; // this is used to store the starting index of the minimum length of substring which contains 't'

        char[] arr = s.toCharArray();


        for(int right=0; right<n; right++){ // this loop is used as the right pinter
            if(map.getOrDefault(arr[right], 0)>0){ // trying to catch a valid sliding window
                count--;
            }
            map.put(arr[right], map.getOrDefault(arr[right], 0) -1);

            while(count == 0){ // the time we get a valid sliding window find the min length of it and further go for decreasing the sliding window till the window remains valid
                if(min > right-left+1){ // simultaneously calculating the min length of sliding window
                    min = right-left+1;
                    start = left; // keeping the track of starting index of min length of substring in 's'
                }
                map.put(arr[left], map.get(arr[left])+1);
                if(map.get(arr[left]) > 0){
                    count++;
                }

                left++;
            }

        }

        return min == Integer.MAX_VALUE?"":s.substring(start, start+min); // at last returning the substring which contains all the characters of 't'
    }
}
