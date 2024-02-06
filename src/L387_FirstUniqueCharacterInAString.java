package src;

/**
 * Given a string s, find the first non-repeating character in it and return its index. If it does not exist, return -1.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "leetcode"
 * Output: 0
 * Example 2:
 *
 * Input: s = "loveleetcode"
 * Output: 2
 * Example 3:
 *
 * Input: s = "aabb"
 * Output: -1
 *
 *
 * Constraints:
 *
 * 1 <= s.length <= 105
 * s consists of only lowercase English letters.
 */

public class L387_FirstUniqueCharacterInAString {
    public int firstUniqChar(String s) {
        for (int i = 0; i < s.length(); i++) {
            int c = s.charAt(i);
            // s.lastIndexOf(c) -> give the index of the last occurrence of character
            // s.indexOf(c) -> give the first occurrence of character
            if (i == s.lastIndexOf(c) && i == s.indexOf(c)){
                return i;
            }
        }

        return -1;
    }

    public int firstUniqChar2(String s) { // new approach iteratin the string two times
        int n = s.length();
        int[] arr = new int[26];
        char[] str = s.toCharArray();

        for(char i:str){
            arr[i-'a']++;
        }

        for(int i = 0; i<n; i++){
            if(arr[str[i]-'a'] == 1){
                return i;
            }
        }

        return -1;
    }
}
