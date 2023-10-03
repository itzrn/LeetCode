package src;

import java.util.Stack;

/**
 * Given a string containing just the characters '(' and ')', return the length of the longest valid (well-formed) parentheses
 * substring
 * .
 *
 *
 *
 * Example 1:
 *
 * Input: s = "(()"
 * Output: 2
 * Explanation: The longest valid parentheses substring is "()".
 * Example 2:
 *
 * Input: s = ")()())"
 * Output: 4
 * Explanation: The longest valid parentheses substring is "()()".
 * Example 3:
 *
 * Input: s = ""
 * Output: 0
 *
 *
 * Constraints:
 *
 * 0 <= s.length <= 3 * 104
 * s[i] is '(', or ')'
 */

public class L32_LongestValidParentheses {
    public int longestValidParentheses(String s) {
        Stack<Character> stack = new Stack<>();
        Stack<Integer> indexStack = new Stack<>(); // indexStack is working as dp
        indexStack.add(-1); // adding '-1' to take the reference that stack is empty and at indexStack.peek() index continuity of string got break
        int max = 0;
        for(int i = 0;i<s.length();i++){
            if(s.charAt(i) == '('){ // for opening bracket
                stack.push('(');
                indexStack.push(i);
            }else{// for closing bracket
                if(!stack.isEmpty()){
                    stack.pop();
                    indexStack.pop();
                    max = Math.max(max, i - indexStack.peek());
                }else{
                    indexStack.push(i);
                }
            }
        }

        return max;
    }
}
