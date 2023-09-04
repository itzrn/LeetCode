package src;

/**
 * Given head, the head of a linked list, determine if the linked list has a cycle in it.
 *
 * There is a cycle in a linked list if there is some node in the list that can be reached again by continuously
 * following the next pointer. Internally, pos is used to denote the index of the node that tail's next pointer is connected to. Note that pos is not passed as a parameter.
 *
 * Return true if there is a cycle in the linked list. Otherwise, return false.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: head = [3,2,0,-4], pos = 1
 * Output: true
 * Explanation: There is a cycle in the linked list, where the tail connects to the 1st node (0-indexed).
 * Example 2:
 *
 *
 * Input: head = [1,2], pos = 0
 * Output: true
 * Explanation: There is a cycle in the linked list, where the tail connects to the 0th node.
 * Example 3:
 *
 *
 * Input: head = [1], pos = -1
 * Output: false
 * Explanation: There is no cycle in the linked list.
 *
 *
 * Constraints:
 *
 * The number of the nodes in the list is in the range [0, 104].
 * -105 <= Node.val <= 105
 * pos is -1 or a valid index in the linked-list.
 *
 *
 * Follow up: Can you solve it using O(1) (i.e. constant) memory?
 */

public class L141_LinkedListCycle {
    public boolean hasCycle(ListNode head) {
        if(head == null || head.next == null){ // base case
            return false;
        }

        ListNode turtle = head; // this will step forward by one node
        ListNode rabbit =  head; // this will step forward by 2 nodes

        do{ // if in the case list contains any loop, then there will come any time when turtle==rabbit, else turtle can't reach to rabbit any time
            turtle = turtle.next;
            rabbit = rabbit.next.next;
            if(turtle == rabbit){ // when this condition gets true for any list, means there is a cycle
                return true;
            }
        }while(rabbit != null && rabbit.next != null);

        // using do-while loop bcz, in starting turtle == rabbit == head, so in while loop it always true
        // do while first move both of them turtle and rabbit forward and then start checking the condition

        return false;

    }
}
