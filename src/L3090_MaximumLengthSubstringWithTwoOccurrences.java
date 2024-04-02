package src;

/**
 * Given a string s, return the maximum length of a
 * substring
 *  such that it contains at most two occurrences of each character.
 *
 *
 * Example 1:
 *
 * Input: s = "bcbbbcba"
 *
 * Output: 4
 *
 * Explanation:
 *
 * The following substring has a length of 4 and contains at most two occurrences of each character: "bcbbbcba".
 * Example 2:
 *
 * Input: s = "aaaa"
 *
 * Output: 2
 *
 * Explanation:
 *
 * The following substring has a length of 2 and contains at most two occurrences of each character: "aaaa".
 *
 *
 * Constraints:
 *
 * 2 <= s.length <= 100
 * s consists only of lowercase English letters.
 */

public class L3090_MaximumLengthSubstringWithTwoOccurrences {
    public int maximumLengthSubstring(String s) {
        int[] arr = new int[26];
        int i = 0;
        int j = 0;
        int n = s.length();
        int max = 0;
        while(j<n){
            arr[s.charAt(j)-'a']++;
            while(i<n && arr[s.charAt(j)-'a']>2){
                arr[s.charAt(i)-'a']--;
                i++;
            }

            max = Math.max(max, j-i+1);
            j++;
        }

        return max;
    }
}
