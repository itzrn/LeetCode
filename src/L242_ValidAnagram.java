package src;

/**
 * Given two strings s and t, return true if t is an anagram of s, and false otherwise.
 *
 * An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase,
 * typically using all the original letters exactly once.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "anagram", t = "nagaram"
 * Output: true
 * Example 2:
 *
 * Input: s = "rat", t = "car"
 * Output: false
 *
 *
 * Constraints:
 *
 * 1 <= s.length, t.length <= 5 * 104
 * s and t consist of lowercase English letters.
 *
 *
 * Follow up: What if the inputs contain Unicode characters? How would you adapt your solution to such a case?
 */

public class L242_ValidAnagram {

    // intuition -> as we know there will only be lowercase character in both the string
    // we initialize a 26 sized array, to store the counting of all characters
    // The characters of string s, adding the counting
    // and characters of string t, subtracting the counting
    // if both string have same characters and same number of character, the counting of array will get compensate to '0'
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()){ // if length is not equal, means any character is more in any of the two string
            return false;
        }

        int[] arr = new int[26];

        for(int i = 0;i<s.length() ;i++){
            arr[s.charAt(i) - 97]++; // adding
            arr[t.charAt(i) - 97]--; // subtracting
            // if at the end of the loop, all the index is zero, means the same characters are there in both the string
        }

        for(int i=0;i<26;i++){
            if(arr[i] != 0){
                return false;
            }
        }

        return true;
    }
}
