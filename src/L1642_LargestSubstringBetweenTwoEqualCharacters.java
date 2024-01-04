package src;

/**
 * Given a string s, return the length of the longest substring between two equal characters, excluding the two characters.
 * If there is no such substring return -1.
 *
 * A substring is a contiguous sequence of characters within a string.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "aa"
 * Output: 0
 * Explanation: The optimal substring here is an empty substring between the two 'a's.
 * Example 2:
 *
 * Input: s = "abca"
 * Output: 2
 * Explanation: The optimal substring here is "bc".
 * Example 3:
 *
 * Input: s = "cbzxy"
 * Output: -1
 * Explanation: There are no characters that appear twice in s.
 *
 *
 * Constraints:
 *
 * 1 <= s.length <= 300
 * s contains only lowercase English letters.
 */

import java.util.HashMap;
import java.util.Map;

public class L1642_LargestSubstringBetweenTwoEqualCharacters {
    public int maxLengthBetweenEqualCharacters(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int n = s.length();
        char[] arr = s.toCharArray();
        int max = -1;
        for(int i = 0; i<n; i++){

            if(!map.containsKey(arr[i])){
                map.put(arr[i], i);
                continue;
            }


            max = Math.max(max, i-map.get(arr[i])-1);
        }

        return max;
    }
}
