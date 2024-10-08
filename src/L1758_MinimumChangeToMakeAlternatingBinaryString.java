package src;

/**
 * You are given a string s consisting only of the characters '0' and '1'.
 * In one operation, you can change any '0' to '1' or vice versa.
 *
 * The string is called alternating if no two adjacent characters are equal. For example, the string "010" is
 * alternating, while the string "0100" is not.
 *
 * Return the minimum number of operations needed to make s alternating.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "0100"
 * Output: 1
 * Explanation: If you change the last character to '1', s will be "0101", which is alternating.
 * Example 2:
 *
 * Input: s = "10"
 * Output: 0
 * Explanation: s is already alternating.
 * Example 3:
 *
 * Input: s = "1111"
 * Output: 2
 * Explanation: You need two operations to reach "0101" or "1010".
 *
 *
 * Constraints:
 *
 * 1 <= s.length <= 104
 * s[i] is either '0' or '1'.
 */

public class L1758_MinimumChangeToMakeAlternatingBinaryString {
    public int minOperations(String s) {
        int start0 = 0; // this is going to count the number to change need to when the string starts with 0
        int start1 = 0; // this is going to count the number to change need to when the string starts with 1

        int n = s.length();
        for(int i = 0; i<n; i++){
            // there are possible bellow 2 condition for each start0 and start1 to count

            if(i%2 == 0){
                if(s.charAt(i) == '1'){
                    start1++;
                }else{
                    start0++;
                }
            }else{ // when 'i' is odd
                if(s.charAt(i) == '1'){
                    start0++;
                }else{
                    start1++;
                }
            }
        }

        return Math.min(start0, start1); // taking the minimum of two counts
    }
}
