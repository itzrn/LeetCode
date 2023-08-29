package src;

/**
 * You are given the head of a linked list, and an integer k.
 *
 * Return the head of the linked list after swapping the values of the kth node from the beginning and the kth node from the end (the list is 1-indexed).
 *
 *
 *
 * Example 1:
 *
 *
 * Input: head = [1,2,3,4,5], k = 2
 * Output: [1,4,3,2,5]
 * Example 2:
 *
 * Input: head = [7,9,6,6,7,8,3,0,9,5], k = 5
 * Output: [7,9,6,6,8,7,3,0,9,5]
 *
 *
 * Constraints:
 *
 * The number of nodes in the list is n.
 * 1 <= k <= n <= 105
 * 0 <= Node.val <= 100
 */

public class L1721_SwappingNodeInALinkedList {

    public ListNode swapNodes(ListNode head, int k) {
        if(head == null){
            return null;
        }

        int size = 0;
        ListNode curr = head;
        while(curr != null){
            size++;
            curr = curr.next;
        }

        int kL = size - k + 1;

        curr = head;
        while(k>1){
            curr = curr.next;
            k--;
        }

        ListNode cur = head;
        while(kL>1){
            cur = cur.next;
            kL--;
        }

        int temp = curr.val;
        curr.val = cur.val;
        cur.val = temp;

        return head;
    }
}
