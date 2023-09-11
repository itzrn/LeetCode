package src;

/**
 * Given a string s, reverse the string according to the following rules:
 *
 * All the characters that are not English letters remain in the same position.
 * All the English letters (lowercase or uppercase) should be reversed.
 * Return s after reversing it.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "ab-cd"
 * Output: "dc-ba"
 * Example 2:
 *
 * Input: s = "a-bC-dEf-ghIj"
 * Output: "j-Ih-gfE-dCba"
 * Example 3:
 *
 * Input: s = "Test1ng-Leet=code-Q!"
 * Output: "Qedo1ct-eeLg=ntse-T!"
 *
 *
 * Constraints:
 *
 * 1 <= s.length <= 100
 * s consists of characters with ASCII values in the range [33, 122].
 * s does not contain '\"' or '\\'.
 */

import java.util.LinkedList;
import java.util.Queue;

public class L917_ReverseOnlyLetters {

    public String reverseOnlyLetters(String s) {
        return recursion(s, 0, new LinkedList<>());
    }

    public String recursion(String s, int index, Queue<Character> queue){
        if(index == s.length()){
            return "";
        }

        char a ='\u0000'; // this is the way to initialise the character variable;
        if((s.charAt(index)>= 65 && s.charAt(index)<=90) || (s.charAt(index)>=97 && s.charAt(index)<=122)){
            queue.add(s.charAt(index)); // while recursion, keeping all the characters in the queue
        }else{
            a = s.charAt(index);
        }

        String temp = recursion(s, index+1, queue); // temp variable is storing all the reversed character of the string
        if(a != '\u0000'){ // when this condition is true, means a contains special character
            return a + temp;
        }
        return queue.remove() + temp; // while back tracking, removing character from the queue, where there is no special character
    }
}
