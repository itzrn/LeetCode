package src;

/**
 * Given the head of a singly linked list and two integers left and right where left <= right,
 * reverse the nodes of the list from position left to position right, and return the reversed list.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: head = [1,2,3,4,5], left = 2, right = 4
 * Output: [1,4,3,2,5]
 * Example 2:
 *
 * Input: head = [5], left = 1, right = 1
 * Output: [5]
 *
 *
 * Constraints:
 *
 * The number of nodes in the list is n.
 * 1 <= n <= 500
 * -500 <= Node.val <= 500
 * 1 <= left <= right <= n
 */

public class L92_ReverseLinkedListTwo {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if(head.next == null || left == right){
            return head;
        }

        ListNode curr1 = head; // curr1 is used to keep the node which is at (Position index)i=left of the LinkedList
        ListNode leftPrev = null;
        int a = left;
        while(a>1){ // making curr1 to reach at i=left position of the LinkedList
            if(a == 2){
                leftPrev = curr1; // keeping the previous Node to i=left node, so in future we connect to the head of the reversed portion
            }
            curr1 = curr1.next;
            a--;
        }
        ListNode tempCurr1 = curr1;

        ListNode curr2 = curr1; // curr2 is used to keep the node which is at i=right position of the LinkedList
        right = right-left+1;
        while(right>1){ // making curr2 to reach at i=right position of the LinkedList
            curr2 = curr2.next;
            right--;
        }
        ListNode rightAfter = curr2.next; // keeping the node just after the node at position i=right, so to connect the end node of the reversed portion to it
        ListNode temp = reverse(curr1, curr2); // doing the reverse of the LinkedList Portion
        tempCurr1.next = rightAfter; // after getting reverse, the first node will come at the last, and this node is now connecting with the rightAfter, to maintain the LinkedList

        if(left == 1){ // if left == 1, means the head after reversing the portion of the LinkedList, will be the head of the reversed portion
            return temp;
        }
        assert leftPrev != null;
        leftPrev.next = temp; // if left != 1, means there will be leftPrev, and this is need to connect with the head of the reversed portion

        return head;
    }

    public ListNode reverse(ListNode start, ListNode end){
        if(start == end){
            return start;
        }

        ListNode temp = reverse(start.next, end);
        start.next.next = start;
        start.next = null;
        return temp;
    }
}
