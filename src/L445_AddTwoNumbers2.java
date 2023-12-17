package src;

/**
 * You are given two non-empty linked lists representing two non-negative integers.
 * The most significant digit comes first and each of their nodes contains a single digit. Add the two numbers and return the sum as a linked list.
 *
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: l1 = [7,2,4,3], l2 = [5,6,4]
 * Output: [7,8,0,7]
 * Example 2:
 *
 * Input: l1 = [2,4,3], l2 = [5,6,4]
 * Output: [8,0,7]
 * Example 3:
 *
 * Input: l1 = [0], l2 = [0]
 * Output: [0]
 *
 *
 * Constraints:
 *
 * The number of nodes in each linked list is in the range [1, 100].
 * 0 <= Node.val <= 9
 * It is guaranteed that the list represents a number that does not have leading zeros.
 *
 *
 * Follow up: Could you solve it without reversing the input lists?
 */

import java.util.Stack;

public class L445_AddTwoNumbers2 {
    ListNode res;
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<ListNode> stack1 = new Stack<>();
        while(l1 != null){
            stack1.push(l1);
            l1 = l1.next;
        }

        Stack<ListNode> stack2 = new Stack<>();
        while(l2 != null){
            stack2.push(l2);
            l2 = l2.next;
        }

        int carry = 0;
        while(!stack1.isEmpty() && !stack2.isEmpty()){
            carry = add(stack1.pop().val, stack2.pop().val, carry);
        }

        while(!stack1.isEmpty()){
            carry = add(stack1.pop().val, 0, carry);
        }

        while(!stack2.isEmpty()){
            carry = add(stack2.pop().val, 0, carry);
        }

        if(carry != 0){
            carry = add(0,0,carry);
        }

        return res;
    }

    public int add(int a, int b, int carry){
        if(res == null){
            res = new ListNode((carry+a+b)%10);
        }else{
            ListNode temp = new ListNode((carry+a+b)%10);
            temp.next = res;
            res = temp;
        }

        return (carry+a+b)/10;
    }
}
