package src;

/**
 * Given the head of a singly linked list, group all the nodes with odd indices together followed by the nodes with even indices, and return the reordered list.
 *
 * The first node is considered odd, and the second node is even, and so on.
 *
 * Note that the relative order inside both the even and odd groups should remain as it was in the input.
 *
 * You must solve the problem in O(1) extra space complexity and O(n) time complexity.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: head = [1,2,3,4,5]
 * Output: [1,3,5,2,4]
 * Example 2:
 *
 *
 * Input: head = [2,1,3,5,6,4,7]
 * Output: [2,3,6,7,1,5,4]
 *
 *
 * Constraints:
 *
 * The number of nodes in the linked list is in the range [0, 104].
 * -106 <= Node.val <= 106
 */

import java.util.LinkedList;
import java.util.Queue;

public class L328_OddEvenLinkedList {
    public ListNode oddEvenList(ListNode head) {
        return recursion(head, new LinkedList<>());
    }

    public ListNode recursion(ListNode head, Queue<ListNode> queue){
        if(head == null || head.next == null){
            if(head == null){
                return allEven(queue);
            }

            head.next = allEven(queue);
            return head;
        }

        queue.offer(head.next);
        head.next = recursion(head.next.next, queue);

        return head;
    }

    public ListNode allEven(Queue<ListNode> queue){
        if(queue.isEmpty()){
            return null;
        }

        ListNode head = queue.poll();
        ListNode curr = head;

        while(!queue.isEmpty()){
            curr.next = queue.poll();
            curr = curr.next;
        }
        curr.next = null;

        return head;
    }
}
