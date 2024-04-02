package src;

/**
 * Given two strings s and t, determine if they are isomorphic.
 *
 * Two strings s and t are isomorphic if the characters in s can be replaced to get t.
 *
 * All occurrences of a character must be replaced with another character while preserving the order of characters.
 * No two characters may map to the same character, but a character may map to itself.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "egg", t = "add"
 * Output: true
 * Example 2:
 *
 * Input: s = "foo", t = "bar"
 * Output: false
 * Example 3:
 *
 * Input: s = "paper", t = "title"
 * Output: true
 *
 *
 * Constraints:
 *
 * 1 <= s.length <= 5 * 104
 * t.length == s.length
 * s and t consist of any valid ascii character.
 */

import java.util.HashMap;

public class L205_IsomorphicStrings {
    public boolean isIsomorphic(String s, String t) {

        HashMap<Character, Character> mapST = new HashMap<>(); // used to keep the mapping from s to t
        HashMap<Character, Character> mapTS = new HashMap<>(); // used to keep the mapping from t to s

        for(int i = 0;i<s.length();i++){

            // if mapST already contains the character then mapTS also contain the same mapping
            //  using mapTS.getOrDefault(t.charAt(i), '0') to check t to s, bcz it can be possible that t.charAt(i) won't available in mapTS so returning default value '0'
            if(mapST.containsKey(s.charAt(i)) && mapTS.getOrDefault(t.charAt(i), '0') != s.charAt(i)){
                return false;
            }

            // if mapTS already contains the character then mapST also contain the same mapping
            //  using mapST.getOrDefault(t.charAt(i), '0') to check t to s, bcz it can be possible that s.charAt(i) won't available in mapST so returning default value '0'
            if(mapTS.containsKey(t.charAt(i)) && mapST.getOrDefault(s.charAt(i), '0') != t.charAt(i)){
                return false;
            }


            mapST.put(s.charAt(i), t.charAt(i)); // doing s to t mapping
            mapTS.put(t.charAt(i), s.charAt(i)); // doing t to s mapping
        }

        return true;
    }

    public boolean isIsomorphic2(String s, String t) {
        int n = s.length();
        char[] arr1 = new char[128];
        char[] arr2 = new char[128];

        for(int i = 0;i<n; i++){
            char a = s.charAt(i);
            char b = t.charAt(i);
            if(arr1[a] != '\u0000' && arr1[a] != b){
                return false;
            }

            if(arr2[b] != '\u0000' && arr2[b] != a){
                return false;
            }

            arr1[a] = b;
            arr2[b] = a;

        }

        return true;
    }
}
