package src;

/**
 * Given an array of strings strs, group the anagrams together. You can return the answer in any order.
 *
 * An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.
 *
 *
 *
 * Example 1:
 *
 * Input: strs = ["eat","tea","tan","ate","nat","bat"]
 * Output: [["bat"],["nat","tan"],["ate","eat","tea"]]
 * Example 2:
 *
 * Input: strs = [""]
 * Output: [[""]]
 * Example 3:
 *
 * Input: strs = ["a"]
 * Output: [["a"]]
 *
 *
 * Constraints:
 *
 * 1 <= strs.length <= 104
 * 0 <= strs[i].length <= 100
 * strs[i] consists of lowercase English letters.
 */

import java.util.*;

public class L49_GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>> map = new HashMap<>();
        for(String s : strs){
            char[] ch = s.toCharArray(); // creating the array of all character
            Arrays.sort(ch); // sorting character array in alphabetical order
            String update_str = new String(ch); // creating a new string of those characters which is now in alphabetical order

            // after arranging in alphabetical order, similar strings will same update_str
            if(!map.containsKey(update_str)){ // putting all those similar strings all together in a list
                map.put(update_str , new ArrayList<>());
            }
            map.get(update_str).add(s);
        }
        return new ArrayList<>(map.values()); // making list of all those list having similar string(anagram)
    }
}
