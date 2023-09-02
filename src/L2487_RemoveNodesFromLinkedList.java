package src;

/**
 * You are given the head of a linked list.
 *
 * Remove every node which has a node with a strictly greater value anywhere to the right side of it.
 *
 * Return the head of the modified linked list.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: head = [5,2,13,3,8]
 * Output: [13,8]
 * Explanation: The nodes that should be removed are 5, 2 and 3.
 * - Node 13 is to the right of node 5.
 * - Node 13 is to the right of node 2.
 * - Node 8 is to the right of node 3.
 * Example 2:
 *
 * Input: head = [1,1,1,1]
 * Output: [1,1,1,1]
 * Explanation: Every node has value 1, so no nodes are removed.
 *
 *
 * Constraints:
 *
 * The number of the nodes in the given list is in the range [1, 105].
 * 1 <= Node.val <= 105
 */

public class L2487_RemoveNodesFromLinkedList {
    public ListNode removeNodes(ListNode head) {
        if(head.next == null){ // doing head.next == null as base case, bcz we know there is no node in flowing,
            // with which you will compare the head.val, by this line we can also conclude that the last node will always present in the final List
            return head;
        }

        ListNode temp = removeNodes(head.next);
        if(head.val< temp.val){ // when this condition is true means we have to skip the particular node, and return the temp
            return temp;
        }else{ // when it comes in else case, it can be the case the next node of this particular node have to be deleted, so doing head.next = temp
            // it can also be the case the next node of the particular node need not delete, still to be in the safe side and not to lose the nodes while backtrack
            // we are doing head.next=temp
            head.next = temp;
            return head;
        }
    }
}
