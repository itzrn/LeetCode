package src;

/**
 * You are given a string s and an integer k, a k duplicate removal consists of choosing k adjacent and equal letters from s and removing them,
 * causing the left and the right side of the deleted substring to concatenate together.
 *
 * We repeatedly make k duplicate removals on s until we no longer can.
 *
 * Return the final string after all such duplicate removals have been made. It is guaranteed that the answer is unique.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "abcd", k = 2
 * Output: "abcd"
 * Explanation: There's nothing to delete.
 * Example 2:
 *
 * Input: s = "deeedbbcccbdaa", k = 3
 * Output: "aa"
 * Explanation:
 * First delete "eee" and "ccc", get "ddbbbdaa"
 * Then delete "bbb", get "dddaa"
 * Finally delete "ddd", get "aa"
 * Example 3:
 *
 * Input: s = "pbbcggttciiippooaais", k = 2
 * Output: "ps"
 *
 *
 * Constraints:
 *
 * 1 <= s.length <= 105
 * 2 <= k <= 104
 * s only contains lowercase English letters.
 */

import java.util.Stack;

class L1209_Pair {
    char key;
    int count = 1;

    L1209_Pair(){}
    L1209_Pair(char key){
        this.key = key;
    }
}

public class L1209_RemoveAllAdjacentDuplicatesInString2 {
    public String removeDuplicates(String s, int k) { // keeping character count pair in stack, easy level question
        Stack<L1209_Pair> stack = new Stack<>();
        char[] arr = s.toCharArray();

        int n = s.length();
        for(int i = 0; i<n; i++){
            L1209_Pair temp = stack.isEmpty()?null:stack.peek();

            if(temp == null || temp.key != arr[i]){
                stack.push(new L1209_Pair(arr[i]));
                continue;
            }

            temp.count++;

            if(k == temp.count){
                stack.pop();
            }
        }

        StringBuilder res = new StringBuilder();
        for(L1209_Pair p:stack){
            res.append(String.valueOf(p.key).repeat(p.count));
        }
        return res.toString();
    }
}
