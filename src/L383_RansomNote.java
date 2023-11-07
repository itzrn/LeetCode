package src;

/**
 * Given two strings ransomNote and magazine, return true if ransomNote can be constructed by using the letters from magazine and false otherwise.
 *
 * Each letter in magazine can only be used once in ransomNote.
 *
 *
 *
 * Example 1:
 *
 * Input: ransomNote = "a", magazine = "b"
 * Output: false
 * Example 2:
 *
 * Input: ransomNote = "aa", magazine = "ab"
 * Output: false
 * Example 3:
 *
 * Input: ransomNote = "aa", magazine = "aab"
 * Output: true
 *
 *
 * Constraints:
 *
 * 1 <= ransomNote.length, magazine.length <= 105
 * ransomNote and magazine consist of lowercase English letters.
 */

import java.util.HashMap;
import java.util.Map;

public class L383_RansomNote {
    public boolean canConstruct(String ran, String mag) {
        Map<Character, Integer> map = new HashMap<>();
        for(int i = 0;i< ran.length(); i++){
            map.put(ran.charAt(i), map.getOrDefault(ran.charAt(i), 0)+1);
        }

        for(int i = 0;i<mag.length(); i++){
            if(map.containsKey(mag.charAt(i))){
                if(map.get(mag.charAt(i)) == 1){
                    map.remove(mag.charAt(i));
                }else{
                    map.put(mag.charAt(i), map.get(mag.charAt(i))-1);
                }
            }
        }


        return map.isEmpty();
    }
}
