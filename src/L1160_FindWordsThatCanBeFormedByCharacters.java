package src;

/**
 * You are given an array of strings words and a string chars.
 *
 * A string is good if it can be formed by characters from chars (each character can only be used once).
 *
 * Return the sum of lengths of all good strings in words.
 *
 *
 *
 * Example 1:
 *
 * Input: words = ["cat","bt","hat","tree"], chars = "atach"
 * Output: 6
 * Explanation: The strings that can be formed are "cat" and "hat" so the answer is 3 + 3 = 6.
 * Example 2:
 *
 * Input: words = ["hello","world","leetcode"], chars = "welldonehoneyr"
 * Output: 10
 * Explanation: The strings that can be formed are "hello" and "world" so the answer is 5 + 5 = 10.
 *
 *
 * Constraints:
 *
 * 1 <= words.length <= 1000
 * 1 <= words[i].length, chars.length <= 100
 * words[i] and chars consist of lowercase English letters.
 */

public class L1160_FindWordsThatCanBeFormedByCharacters {
    public int countCharacters(String[] words, String chars) {
        int[] charCount = new int[26];
        for(char ch:chars.toCharArray()){
            charCount[ch - 'a']++;
        }
        int res = 0;
        for(String word:words){
            int[] countWord = new int[26];
            for(char ch : word.toCharArray()){
                countWord[ch - 'a']++;
            }
            boolean goodStrings = true;
            for(int i=0;i<26;i++){
                if(countWord[i] > charCount[i]){
                    goodStrings = false;
                    break;
                }

            }
            if(goodStrings){
                res += word.length();
            }
        }
        return res;
    }
}
