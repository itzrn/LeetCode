package src;

/**
 * You are given an array of strings words (0-indexed).
 *
 * In one operation, pick two distinct indices i and j, where words[i] is a non-empty string, and move any character from words[i] to any position in words[j].
 *
 * Return true if you can make every string in words equal using any number of operations, and false otherwise.
 *
 *
 *
 * Example 1:
 *
 * Input: words = ["abc","aabc","bc"]
 * Output: true
 * Explanation: Move the first 'a' in words[1] to the front of words[2],
 * to make words[1] = "abc" and words[2] = "abc".
 * All the strings are now equal to "abc", so return true.
 * Example 2:
 *
 * Input: words = ["ab","a"]
 * Output: false
 * Explanation: It is impossible to make all the strings equal using the operation.
 *
 *
 * Constraints:
 *
 * 1 <= words.length <= 100
 * 1 <= words[i].length <= 100
 * words[i] consists of lowercase English letters.
 */

public class L1897_RedistributeCharactersToMakeAllStringsEqual {

    /*
    Characters are independent—only the frequency of characters matters.
    It is possible to distribute characters if all characters can be divided equally among all strings.
     */
    public boolean makeEqual(String[] words) {
        int[] arr = new int[26]; // storing the count all characters

        for(String s: words){ // counting all characters
            for(char c: s.toCharArray()){
                arr[c-'a']++;
            }
        }

        int n = words.length;
        for(int i: arr){
            if(i%n != 0){ // if any character couldn't able to get distribute through whole word array, then returning false
                return false;
            }
        }

        return true; // returning true, as al the characters can be distributed properly.
    }
}
