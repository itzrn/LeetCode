package src;

/**
 * You are given two non-empty linked lists representing two non-negative integers.
 * The digits are stored in reverse order, and each of their nodes contains a single digit.
 * Add the two numbers and return the sum as a linked list.

 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.


 * Input: l1 = [2,4,3], l2 = [5,6,4]
 * Output: [7,0,8]
 * Explanation: 342 + 465 = 807.
 */
public class L2_AddTwoNumbers {
    static class ListNode{
        int val;
        ListNode next;
        ListNode(int val){
            this.val = val;
            next = null;
        }
    }
    ListNode resultHead;

    public void add(int val){//adding node at the end of the LinkedList
        if(resultHead == null){
            resultHead = new ListNode(val);
            return;
        }

        ListNode currentNode = resultHead;
        while(currentNode.next != null){
            currentNode = currentNode.next;
        }
        currentNode.next = new ListNode(val);
    }

    int carry = 0;//to take carry at every sum
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int sum;
        if(l1 == null && l2 == null){//if reach to the null node of both the LinkedList, then terminate
            if(carry > 0){
                add(carry);
            }
            return resultHead;
        }
        if(l1 == null){// if l1 is getting null, but l2 won't, then the left digit of the l2 is need to be added
            sum = l2.val + carry;
            if(sum >= 10){
                carry = 1;
                sum = sum - 10;
            }else if((sum - 10) <= -1){
                carry = 0;
            }
            add(sum);
            return addTwoNumbers(null,l2.next);
        }
        if(l2 == null){// if l2 is getting null, but l1 won't, then the left digit of the l1 is need to be added
            sum = l1.val + carry;
            if(sum >= 10){
                carry = 1;
                sum = sum - 10;
            }else if((sum - 10) <= -1){
                carry = 0;
            }
            add(sum);
            return addTwoNumbers(l1.next,null);
        }
        sum = l1.val + l2.val + carry;
        if((sum-10)>=0){
            carry = 1;
            sum = sum - 10;
        }else if((sum-10) <= -1){
            carry = 0;
        }
        add(sum);
        return addTwoNumbers(l1.next,l2.next);
    }
}
