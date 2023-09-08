package src;

/**
 * Given a string s and a dictionary of strings wordDict, add spaces in s to construct a sentence where
 * each word is a valid dictionary word. Return all such possible sentences in any order.
 *
 * Note that the same word in the dictionary may be reused multiple times in the segmentation.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "catsanddog", wordDict = ["cat","cats","and","sand","dog"]
 * Output: ["cats and dog","cat sand dog"]
 * Example 2:
 *
 * Input: s = "pineapplepenapple", wordDict = ["apple","pen","applepen","pine","pineapple"]
 * Output: ["pine apple pen apple","pineapple pen apple","pine applepen apple"]
 * Explanation: Note that you are allowed to reuse a dictionary word.
 * Example 3:
 *
 * Input: s = "catsandog", wordDict = ["cats","dog","sand","and","cat"]
 * Output: []
 *
 *
 * Constraints:
 *
 * 1 <= s.length <= 20
 * 1 <= wordDict.length <= 1000
 * 1 <= wordDict[i].length <= 10
 * s and wordDict[i] consist of only lowercase English letters.
 * All the strings of wordDict are unique.
 * Input is generated in a way that the length of the answer doesn't exceed 105.
 */

import java.util.ArrayList;
import java.util.List;

// doing brut force
public class L140_WordBreak2 {
    public List<String> wordBreak(String s, List<String> wordDict) {
        recursion(s, 0, wordDict,"");
        return res;
    }

    List<String> res = new ArrayList<>(); // keeping all the combination of string
    public void recursion(String s, int i, List<String> words, String resStr){
        if(i >= s.length()){ // when this condition gets true means our one combination is ready, and it needs to add in the res
            res.add(resStr.trim()); // trimming the string, so it won't have any starting or leading space
            return;
        }

        for(String str : words){ // this is making a graph and going every possibility, like dfs
            // this loop is matching every word of dictionary in the string 's', if it present it go for recursion
            if(i+str.length() <= s.length() && s.startsWith(str, i)){
                // instead of this above condition we can use -> i+str.length() <= s.length() && s.substring(i,i+str.length()).equals(str), which means same
                recursion(s, i+str.length(), words, resStr + s.substring(i,i+str.length()) + " ");
            }
        }
    }
}
