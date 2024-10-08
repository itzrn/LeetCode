package src;

/**
 * You are given the head of a non-empty linked list representing a non-negative integer without leading zeroes.
 *
 * Return the head of the linked list after doubling it.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: head = [1,8,9]
 * Output: [3,7,8]
 * Explanation: The figure above corresponds to the given linked list which represents the number 189. Hence, the returned linked list represents the number 189 * 2 = 378.
 * Example 2:
 *
 *
 * Input: head = [9,9,9]
 * Output: [1,9,9,8]
 * Explanation: The figure above corresponds to the given linked list which represents the number 999. Hence, the returned linked list reprersents the number 999 * 2 = 1998.
 *
 *
 * Constraints:
 *
 * The number of nodes in the list is in the range [1, 104]
 * 0 <= Node.val <= 9
 * The input is generated such that the list represents a number that does not have leading zeros, except the number 0 itself.
 */

public class L2816_DoubleANumberRepresentedAsALinkedList {
    public ListNode doubleIt(ListNode head) {
        if(recursion(head) == 1){
            ListNode temp = new ListNode(1);
            temp.next = head;
            head = temp;
        }

        return head;
    }

    public int recursion(ListNode head){
        if(head == null){
            return 0;
        }

        int temp = head.val*2 + recursion(head.next);
        head.val = temp>9?temp-10:temp;

        return temp>9?1:0;
    }

}
