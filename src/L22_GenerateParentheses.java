package src;

/**
 * Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
 *
 *
 *
 * Example 1:
 *
 * Input: n = 3
 * Output: ["((()))","(()())","(())()","()(())","()()()"]
 * Example 2:
 *
 * Input: n = 1
 * Output: ["()"]
 *
 *
 * Constraints:
 *
 * 1 <= n <= 8
 */

import java.util.ArrayList;
import java.util.List;

public class L22_GenerateParentheses {
    public List<String> generateParenthesis(int n) {
        recursion("",  n, n, n);
        return res;
    }

    List<String> res = new ArrayList<>();
    public void recursion(String str, int open, int close, int n){
        if(str.length() == 2*n){
            res.add(str.substring(0, str.length()));
            // adding the copy of the string, if we add the string directly, it will pass reference, so at the end all the generated string will not be there
            return;
        }

        if(open>0){ // condition when to add open bracket
            recursion(str+"(", open-1, close, n);
        }

        if(close>0 && open<close){ // condition when to add close bracket
            recursion(str+")", open, close-1, n);
        }
    }
}
