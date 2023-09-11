package src;

/**
 * You are given the head of a singly linked-list. The list can be represented as:
 *
 * L0 → L1 → … → Ln - 1 → Ln
 * Reorder the list to be on the following form:
 *
 * L0 → Ln → L1 → Ln - 1 → L2 → Ln - 2 → …
 * You may not modify the values in the list's nodes. Only nodes themselves may be changed.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: head = [1,2,3,4]
 * Output: [1,4,2,3]
 * Example 2:
 *
 *
 * Input: head = [1,2,3,4,5]
 * Output: [1,5,2,4,3]
 *
 *
 * Constraints:
 *
 * The number of nodes in the list is in the range [1, 5 * 104].
 * 1 <= Node.val <= 1000
 */

public class L143_ReorderList {
    public void reorderList(ListNode head) {
        recursion(head, head); // at the end this will return null, so not using another variable to store
    }

    public ListNode recursion(ListNode slow, ListNode fast){ // using hair(fast) and turtle(slow) method, using this will come to know the middle node of the List
        if(fast.next == null){ // this case is when there is odd number of nodes
            ListNode curr = slow.next;
            slow.next = null;
            return curr;
        }
        if(fast.next.next == null){ // this case is when there is odd number of nodes
            ListNode curr = slow.next.next;
            slow.next.next = null;
            return curr;
        }

        ListNode temp1 = recursion(slow.next, fast.next.next); // this function returns that node which should have to get connect with slow node
        ListNode temp2 = temp1.next; // storing, so we won't lose the following nodes

        // keeping a node between two nodes
        temp1.next = slow.next;
        slow.next = temp1;

        return temp2;
    }
}