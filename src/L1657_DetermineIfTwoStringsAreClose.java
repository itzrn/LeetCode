package src;

/**
 * Two strings are considered close if you can attain one from the other using the following operations:
 *
 * Operation 1: Swap any two existing characters.
 * For example, abcde -> aecdb
 * Operation 2: Transform every occurrence of one existing character into another existing character, and do the same with the other character.
 * For example, aacabb -> bbcbaa (all a's turn into b's, and all b's turn into a's)
 * You can use the operations on either string as many times as necessary.
 *
 * Given two strings, word1 and word2, return true if word1 and word2 are close, and false otherwise.
 *
 *
 *
 * Example 1:
 *
 * Input: word1 = "abc", word2 = "bca"
 * Output: true
 * Explanation: You can attain word2 from word1 in 2 operations.
 * Apply Operation 1: "abc" -> "acb"
 * Apply Operation 1: "acb" -> "bca"
 * Example 2:
 *
 * Input: word1 = "a", word2 = "aa"
 * Output: false
 * Explanation: It is impossible to attain word2 from word1, or vice versa, in any number of operations.
 * Example 3:
 *
 * Input: word1 = "cabbba", word2 = "abbccc"
 * Output: true
 * Explanation: You can attain word2 from word1 in 3 operations.
 * Apply Operation 1: "cabbba" -> "caabbb"
 * Apply Operation 2: "caabbb" -> "baaccc"
 * Apply Operation 2: "baaccc" -> "abbccc"
 *
 *
 * Constraints:
 *
 * 1 <= word1.length, word2.length <= 105
 * word1 and word2 contain only lowercase English letters.
 */

import java.util.Arrays;

public class L1657_DetermineIfTwoStringsAreClose {
    public boolean closeStrings(String word1, String word2) {
        int[] wordCount1 = new int[26];
        int[] wordCount2 = new int[26];
        for(char ch1 : word1.toCharArray()){ // calculating the frequency of word1
            wordCount1[ch1-'a']++;
        }
        for(char ch2 : word2.toCharArray()){ // calculating the frequency of word2
            wordCount2[ch2-'a']++;
        }

        // this particular loop is handling the operation rule 1 of the question
        for(int i=0;i<26;i++){
            if((wordCount1[i] == 0 && wordCount2[i] != 0) || (wordCount1[i]!=0 && wordCount2[i]==0)){ // condition where to return false
                return false;
            }
        }

        // this sorting is handling the operation rule 2 fo the question
        Arrays.sort(wordCount1);
        Arrays.sort(wordCount2);

        for(int i=0;i<26;i++){
            if(wordCount1[i] != wordCount2[i]){ // condition where to return false
                return false;
            }
        }
        return true;
    }
}
