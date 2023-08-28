package src;

/**
 * Given the head of a linked list and an integer val, remove all the nodes of the linked list that has Node.val == val, and return the new head.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: head = [1,2,6,3,4,5,6], val = 6
 * Output: [1,2,3,4,5]
 * Example 2:
 *
 * Input: head = [], val = 1
 * Output: []
 * Example 3:
 *
 * Input: head = [7,7,7,7], val = 7
 * Output: []
 *
 *
 * Constraints:
 *
 * The number of nodes in the list is in the range [0, 104].
 * 1 <= Node.val <= 50
 * 0 <= val <= 50
 */

public class L203_RemoveLinkedListElement {

    public ListNode removeElements(ListNode head, int val) {
        if(head == null){ // base case
            return null;
        }

        while(head != null && head.val == val){ // removing head node if the head value is equal to val
            head = head.next;
        }

        ListNode curr = head;
        while(curr!=null && curr.next != null){ // now deleting the node whose value is equal to val, if any
            if(curr.next.val == val){
                curr.next = curr.next.next;
            }else{
                curr = curr.next;
            }
        }

        return head;
    }
}
