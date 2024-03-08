package src;

/**
 * Given the head of a linked list, remove the nth node from the end of the list and return its head.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: head = [1,2,3,4,5], n = 2
 * Output: [1,2,3,5]
 * Example 2:
 *
 * Input: head = [1], n = 1
 * Output: []
 * Example 3:
 *
 * Input: head = [1,2], n = 1
 * Output: [1]
 *
 *
 * Constraints:
 *
 * The number of nodes in the list is sz.
 * 1 <= sz <= 30
 * 0 <= Node.val <= 100
 * 1 <= n <= sz
 */

public class L19_RemoveNthNodeFromEndOfList {
    int a = 0; // keeping 'a' to count the node from end, while backtracking
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head == null){
            return head;
        }
        ListNode temp = removeNthFromEnd(head.next,n);
        a++;
        if(a == n){ // this case is used when a==n, means the node at 'a' from end we won't need, so doing head=head.next
            head=head.next;
        }else if(a == n+1){ // this case is when we reached to Node which is at a=n+1 from end,
            // meas the next pointer of the node at a=n+1 should connect the returned node i.e. temp
            head.next = temp;
        }

        return head;
    }


    public ListNode removeNthFromEnd2(ListNode head, int n) {
        if(n == 1 && head.next == null){
            return null;
        }

        ListNode curr = head;
        int count = 0;
        while(curr!=null){
            count++;
            curr = curr.next;
        }
        if(n == count){
            return head.next;
        }

        n = count-n;
        curr = head;
        while(n>1){
            n--;
            curr = curr.next;
        }

        curr.next = curr.next.next;
        return head;
    }
}
