package src;

/**
 * Given a string s, return the number of unique palindromes of length three that are a subsequence of s.
 *
 * Note that even if there are multiple ways to obtain the same subsequence, it is still only counted once.
 *
 * A palindrome is a string that reads the same forwards and backwards.
 *
 * A subsequence of a string is a new string generated from the original string with some characters (can be none)
 * deleted without changing the relative order of the remaining characters.
 *
 * For example, "ace" is a subsequence of "abcde".
 *
 *
 * Example 1:
 *
 * Input: s = "aabca"
 * Output: 3
 * Explanation: The 3 palindromic subsequences of length 3 are:
 * - "aba" (subsequence of "aabca")
 * - "aaa" (subsequence of "aabca")
 * - "aca" (subsequence of "aabca")
 * Example 2:
 *
 * Input: s = "adc"
 * Output: 0
 * Explanation: There are no palindromic subsequences of length 3 in "adc".
 * Example 3:
 *
 * Input: s = "bbcbaba"
 * Output: 4
 * Explanation: The 4 palindromic subsequences of length 3 are:
 * - "bbb" (subsequence of "bbcbaba")
 * - "bcb" (subsequence of "bbcbaba")
 * - "bab" (subsequence of "bbcbaba")
 * - "aba" (subsequence of "bbcbaba")
 *
 *
 * Constraints:
 *
 * 3 <= s.length <= 105
 * s consists of only lowercase English letters.
 */

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/*
approach:
here we need to find subsequence of length 3
and this is possible when first character and third character is same.
using this approach, created a data structure -> array of sets
where index of array represent the first and the last character and the set at that particular index store the number of unique characters which can possible to form
palindrome string of length 3
 */

public class L1930_UniqueLength3PalindromicSubsequences {
    public int countPalindromicSubsequence(String s) {
        Set<Character>[] set = new HashSet[26]; //
        Map<Character, Integer> map = new HashMap<>(); // this is used to store character index pair
        int[] arr = new int[26]; // this is used, to count the frequency of each character
        // if any character is greater or equal to 3 then that is going add one to count

        for(int i = 0; i<s.length(); i++){ // using as a sliding window
            char a = s.charAt(i);
            arr[a-97]++;
            if(map.containsKey(a)){
                for(int j = map.get(a)+1;j<i;j++){
                    if(set[a-97] == null){
                        set[a-97] = new HashSet<>();
                    }
                    set[a-97].add(s.charAt(j));
                }
            }
            map.put(a, i);
        }

        int count = 0;
        for(int i = 0; i<26; i++){
            if(set[i] != null){
                count += set[i].size();
            }
            if(arr[i] >= 3){
                count+=1;
            }
        }

        return count;
    }


    public int countPalindromicSubsequence2(String s) {
        Set<Character> set = new HashSet<>();
        for(char c: s.toCharArray()){
            set.add(c);
        }
        int res = 0;
        for(char ch : set){
            int start = -1;
            int end = -1;

            for(int i = 0;i<s.length();i++){
                if(s.charAt(i) == ch){
                    if(start == -1){
                        start = i;
                    }
                    end = i;
                }
            }

            Set<Character> countPalin = new HashSet<>();
            for(int j = start+1;j<=end-1;j++){
                countPalin.add(s.charAt(j));
            }
            res += countPalin.size();
        }
        return res;
    }
}
