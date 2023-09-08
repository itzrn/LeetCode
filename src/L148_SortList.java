package src;

/**
 * Given the head of a linked list, return the list after sorting it in ascending order.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: head = [4,2,1,3]
 * Output: [1,2,3,4]
 * Example 2:
 *
 *
 * Input: head = [-1,5,3,4,0]
 * Output: [-1,0,3,4,5]
 * Example 3:
 *
 * Input: head = []
 * Output: []
 *
 *
 * Constraints:
 *
 * The number of nodes in the list is in the range [0, 5 * 104].
 * -105 <= Node.val <= 105
 *
 *
 * Follow up: Can you sort the linked list in O(n logn) time and O(1) memory (i.e. constant space)?
 */

public class L148_SortList {

    // this -> have the time complexity O(n^2)
    public ListNode sortList(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode temp = sortList(head.next);
        head.next = temp; // doing this to connect the already sorted list, earlier which was unsorted

        if(head.val > temp.val){ // when this condition is true, mean to have to move the larger value back of smaller value
            head.next = head.next.next; // this swapping the smaller value before the greater value
            temp.next = afterSort(head); // after moving the larger value back of smaller value putting this value at its right position in already sorted list
            return temp; // as we have to return the smallest value mode so returning it here
        }else{ // this case is -> head.val  <= temp.val, means head.val is already smaller, no need to move any node anywhere, so returning head
            return head;
        }
    }

    // this function can also be written in recursive form
    public ListNode afterSort(ListNode head){ // this putting any larger value node at its right position in the already sorted list
        if(head.next == null || head.val <= head.next.val){
            return head;
        }
        ListNode curr = head;
        while(curr.next != null && head.val > curr.next.val){
            curr = curr.next;
        }
        ListNode temp = head.next;
        head.next = curr.next;
        curr.next = head;
        return temp;
    }


}
