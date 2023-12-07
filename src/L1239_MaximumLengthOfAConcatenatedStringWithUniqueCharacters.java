package src;

/**
 * You are given an array of strings arr. A string s is formed by the concatenation of a subsequence of arr that has unique characters.
 *
 * Return the maximum possible length of s.
 *
 * A subsequence is an array that can be derived from another array by deleting some or no elements without changing the order of the remaining elements.
 *
 *
 *
 * Example 1:
 *
 * Input: arr = ["un","iq","ue"]
 * Output: 4
 * Explanation: All the valid concatenations are:
 * - ""
 * - "un"
 * - "iq"
 * - "ue"
 * - "uniq" ("un" + "iq")
 * - "ique" ("iq" + "ue")
 * Maximum length is 4.
 * Example 2:
 *
 * Input: arr = ["cha","r","act","ers"]
 * Output: 6
 * Explanation: Possible longest valid concatenations are "chaers" ("cha" + "ers") and "acters" ("act" + "ers").
 * Example 3:
 *
 * Input: arr = ["abcdefghijklmnopqrstuvwxyz"]
 * Output: 26
 * Explanation: The only string in arr has all 26 characters.
 *
 *
 * Constraints:
 *
 * 1 <= arr.length <= 16
 * 1 <= arr[i].length <= 26
 * arr[i] contains only lowercase English letters.
 */

import java.util.List;

public class L1239_MaximumLengthOfAConcatenatedStringWithUniqueCharacters {
    public int maxLength(List<String> arr) {
        return recursion(arr, "", 0, arr.size());
    }

    // here we are making tree of exclude and include
    public int recursion(List<String> arr, String temp, int idx, int n){
        if(idx == n){
            return temp.length();
        }
        int include = 0;
        int exclude = 0;

        if(isDuplicate(arr.get(idx) , temp)){ // when there exists duplicates means we need to exclude
            exclude = recursion(arr , temp , idx+1 , n);
        }else{ // when there is no duplicates' means we can have two resuts when we exclude nad include
            exclude = recursion(arr , temp , idx+1 , n);
            temp += arr.get(idx);
            include = recursion(arr , temp , idx+1 , n);
        }

        return Math.max(exclude , include);
    }

    public boolean isDuplicate(String s1 , String s2){ // this is just to compare strings have duplicate characters or not
        int[] arr = new int[26];
        for(char ch:s1.toCharArray()){
            if(arr[ch - 'a'] > 0){
                return true;
            }
            arr[ch - 'a']++;
        }
        for(char ch : s2.toCharArray()){
            if(arr[ch - 'a'] > 0){
                return true;
            }
        }
        return false;
    }
}
