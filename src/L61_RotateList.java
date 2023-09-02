package src;

/**
 * Given the head of a linked list, rotate the list to the right by k places.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: head = [1,2,3,4,5], k = 2
 * Output: [4,5,1,2,3]
 * Example 2:
 *
 *
 * Input: head = [0,1,2], k = 4
 * Output: [2,0,1]
 *
 *
 * Constraints:
 *
 * The number of nodes in the list is in the range [0, 500].
 * -100 <= Node.val <= 100
 * 0 <= k <= 2 * 109
 */

/*
Intuition ->
rotating k times a list means putting the last k nodes in the front
so what we are doing here is ->
firstly traversing till last node and while back tracking counting the k nodes, and then putting those in the front
 */

public class L61_RotateList {
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null){ // base case
            return null;
        }
        int size = 0;
        ListNode curr = head;
        while(curr!=null){
            size++;
            curr = curr.next;
        }

        if(size==k){
            return head;
        }else if(size<k){ // making size feasible
            while(size<k){
                k -= size;
            }
        }

        return rotate(head,k);
    }

    int a = 0;
    ListNode last; // this is used to keep the last node the list, which will get connect to head of the original list head
    public ListNode rotate(ListNode head, int k){ // this rotates the list k times while back tracking
        if(head == null || k == 0){ // base case for the recursion
            return head;
        }

        if(head.next == null){
            last = head;
            return head;
        }

        ListNode temp = rotate(head.next, k);
        ++a; // for counting
        if(a >= k){  // if this condition gets true, we have to return the temp
            if(a == k){ // this condition makes the next pointer of the end node of final list
                head.next = null;
            }
            last.next = head; // this is to make connect the last node with the head of the original list
            return temp;
        }

        return head;
    }
}
