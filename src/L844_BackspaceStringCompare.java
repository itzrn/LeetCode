package src;

import java.util.Stack;

/**
 * Given two strings s and t, return true if they are equal when both are typed into empty text editors. '#' means a backspace character.
 *
 * Note that after backspacing an empty text, the text will continue empty.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "ab#c", t = "ad#c"
 * Output: true
 * Explanation: Both s and t become "ac".
 * Example 2:
 *
 * Input: s = "ab##", t = "c#d#"
 * Output: true
 * Explanation: Both s and t become "".
 * Example 3:
 *
 * Input: s = "a#c", t = "b"
 * Output: false
 * Explanation: s becomes "c" while t becomes "b".
 *
 *
 * Constraints:
 *
 * 1 <= s.length, t.length <= 200
 * s and t only contain lowercase letters and '#' characters.
 *
 *
 * Follow up: Can you solve it in O(n) time and O(1) space?
 */

public class L844_BackspaceStringCompare {
    public boolean backspaceCompare(String s, String t) {
        Stack<Character> stacks = helper(s);
        Stack<Character> stackt = helper(t);

        if(stacks.size() != stackt.size()){
            return false;
        }
        while(!stacks.isEmpty()){
            if(stacks.pop() != stackt.pop()){
                return false;
            }
        }

        return true;
    }

    public Stack<Character> helper(String str){
        Stack<Character> stack = new Stack<>();

        int i = 0;
        while(i<str.length()){
            if(str.charAt(i) == '#' && !stack.isEmpty()){
                stack.pop();
            }else if(str.charAt(i) != '#'){
                stack.push(str.charAt(i));
            }
            i++;
        }
        System.out.println(stack);
        return stack;
    }
}
