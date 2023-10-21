package src;

/**
 * Given string num representing a non-negative integer num, and an integer k, return the smallest possible integer after removing k digits from num.
 *
 *
 *
 * Example 1:
 *
 * Input: num = "1432219", k = 3
 * Output: "1219"
 * Explanation: Remove the three digits 4, 3, and 2 to form the new number 1219 which is the smallest.
 * Example 2:
 *
 * Input: num = "10200", k = 1
 * Output: "200"
 * Explanation: Remove the leading 1 and the number is 200. Note that the output must not contain leading zeroes.
 * Example 3:
 *
 * Input: num = "10", k = 2
 * Output: "0"
 * Explanation: Remove all the digits from the number and it is left with nothing which is 0.
 *
 *
 * Constraints:
 *
 * 1 <= k <= num.length <= 105
 * num consists of only digits.
 * num does not have any leading zeros except for the zero itself.
 */

import java.util.Stack;

public class L402_RemoveKDigits {

    // using the concept of minimum stack
    public String removeKdigits(String num, int k) {
        Stack<Character> stack = new Stack<>();

        for(int i = 0; i<num.length(); i++){
            while(k>0 && !stack.isEmpty() && stack.peek() > num.charAt(i)){ // this loop is used to remove the first k digits, so to make the overall number be smaller
                k -= 1;
                stack.pop();
            }
            stack.push(num.charAt(i));
        }
        while(k>0){ // if in case k>0, mean we still need to remove some element and make overall number smaller
            stack.pop();
            k-=1;
        }
        StringBuilder res = new StringBuilder();
        while(!stack.isEmpty()){// poping all the element, and making a string which consist number
            res.insert(0, stack.pop());
        }

        int i = 0;
        while(i<res.length()){ // this is used to remove all leading zeros if present
            if(res.charAt(i) != '0'){
                break;
            }
            i++;
        }

        res = new StringBuilder(res.substring(i)); // after removing all the leading zeros, updating the res
        return (res.length() == 0)? "0": res.toString(); // if still res = "", then return "0" else res
    }
}
