package src;

/*
Write a function that reverses a string. The input string is given as an array of characters s.
You must do this by modifying the input array in-place with O(1) extra memory.

Example 1:
Input: s = ["h","e","l","l","o"]
Output: ["o","l","l","e","h"]


Example 2:
Input: s = ["H","a","n","n","a","h"]
Output: ["h","a","n","n","a","H"]


Constraints:
    1 <= s.length <= 105
    s[i] is a printable ascii character.

 */


public class L344_ReversingAString {

    public String reverse(String s, int i){// (String , -1)
        i++;
        if(i == s.length()){// base condition to terminate
            return "";
        }

        return reverse(s,i) + s.charAt(i);
    }

    public void reverseString(char[] s) {
        String string = "";
        for(int i = 0;i<s.length;i++){
            string = string + s[i];
        }

        string = reverse(string, -1);

        for(int i = 0;i<s.length;i++){
            s[i] = string.charAt(i);
        }
    }
}
