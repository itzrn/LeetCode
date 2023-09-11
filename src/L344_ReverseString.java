package src;

/**
 * Write a function that reverses a string. The input string is given as an array of characters s.
 *
 * You must do this by modifying the input array in-place with O(1) extra memory.
 *
 *
 *
 * Example 1:
 *
 * Input: s = ["h","e","l","l","o"]
 * Output: ["o","l","l","e","h"]
 * Example 2:
 *
 * Input: s = ["H","a","n","n","a","h"]
 * Output: ["h","a","n","n","a","H"]
 *
 *
 * Constraints:
 *
 * 1 <= s.length <= 105
 * s[i] is a printable ascii character.
 */

public class L344_ReverseString {

    public void reverseString(char[] s) { // using two pinter method
        int a = 0;
        int b = s.length-1;
        while(a < b){ // not used <=, bcz when a==b mean both pointer is at same index, and swapping same index doesn't mean anything
            char temp = s[a];
            s[a]=s[b];
            s[b] = temp;
            a++;
            b--;
        }
    }
}
