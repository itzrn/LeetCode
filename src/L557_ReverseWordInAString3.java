package src;

/**
 * Given a string s, reverse the order of characters in each word within a sentence while still preserving whitespace and initial word order.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "Let's take LeetCode contest"
 * Output: "s'teL ekat edoCteeL tsetnoc"
 * Example 2:
 *
 * Input: s = "God Ding"
 * Output: "doG gniD"
 *
 *
 * Constraints:
 *
 * 1 <= s.length <= 5 * 104
 * s contains printable ASCII characters.
 * s does not contain any leading or trailing spaces.
 * There is at least one word in s.
 * All the words in s are separated by a single space.
 */

public class L557_ReverseWordInAString3 {
    public String reverseWords(String s) {
        s = s.trim();
        recursion(s, 0);
        res = temp + res; // at the end of the recursion, keeping the reversed starting word to res
        return res;
    }

    String temp = "";
    String res = "";
    public void recursion(String str, int index){
        if(index == str.length()){
            return;
        }

        recursion(str, index+1);
        if(str.charAt(index) == ' '){ // while back tracking putting reversed word in the res String
            res = " " + temp + res;
            temp = "";
        }else{
            temp = temp + str.charAt(index); // using to reverse each word
        }
    }
}
