package src;

/**
 * Given the head of a sorted linked list, delete all duplicates such that each element appears only once. Return the linked list sorted as well.
 *
 * Example 1:
 *
 *
 * Input: head = [1,1,2]
 * Output: [1,2]
 * Example 2:
 *
 *
 * Input: head = [1,1,2,3,3]
 * Output: [1,2,3]
 * Constraints:
 *
 * The number of nodes in the list is in the range [0, 300].
 * -100 <= Node.val <= 100
 * The list is guaranteed to be sorted in ascending order.
 */

public class L83_RemoveDuplicatesFromSortedList {

    public ListNode deleteDuplicates(ListNode head) {
        if(head == null){
            return null;
        }
        ListNode curr = head;  // taking head node in curr variable, so not to lost head node

        while(curr.next != null){
            if(curr.val == curr.next.val){ // removing the next node until the value of next node is equal to current node
                curr.next = curr.next.next;
            }else{ // if the value of next node is not equal to current node then moving to next node comparison
                curr = curr.next;
            }
        }

        return head; // returning the head of the list
    }
}
