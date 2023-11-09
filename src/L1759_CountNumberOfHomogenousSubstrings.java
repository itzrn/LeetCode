package src;

/**
 * Given a string s, return the number of homogenous substrings of s. Since the answer may be too large, return it modulo 109 + 7.
 *
 * A string is homogenous if all the characters of the string are the same.
 *
 * A substring is a contiguous sequence of characters within a string.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "abbcccaa"
 * Output: 13
 * Explanation: The homogenous substrings are listed as below:
 * "a"   appears 3 times.
 * "aa"  appears 1 time.
 * "b"   appears 2 times.
 * "bb"  appears 1 time.
 * "c"   appears 3 times.
 * "cc"  appears 2 times.
 * "ccc" appears 1 time.
 * 3 + 1 + 2 + 1 + 3 + 2 + 1 = 13.
 * Example 2:
 *
 * Input: s = "xy"
 * Output: 2
 * Explanation: The homogenous substrings are "x" and "y".
 * Example 3:
 *
 * Input: s = "zzzzz"
 * Output: 15
 *
 *
 * Constraints:
 *
 * 1 <= s.length <= 105
 * s consists of lowercase letters.
 */

public class L1759_CountNumberOfHomogenousSubstrings {

    /*
    if count -> n
    then possible substring = (n*n+1)/2 -> sum from 1 to n
     */
    public int countHomogenous(String s) {
        s = s+" ";
        int count = 1;
        long res = 0;
        for(int i = 1; i<s.length(); i++){
            if(s.charAt(i) != s.charAt(i-1)){ // this identifies, that there is the change in the character, and we need to reset the count
                count = 1;
            }else{
                count++;
            }
            res += count; // this is basically performing sum from 1 to n, for evey count
        }
        return (int)(res % (Math.pow(10,9)+7));
    }
}
