package src;

/**
 * Given the head of a singly linked list, return true if it is a
 * palindrome
 *  or false otherwise.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: head = [1,2,2,1]
 * Output: true
 * Example 2:
 *
 *
 * Input: head = [1,2]
 * Output: false
 *
 *
 * Constraints:
 *
 * The number of nodes in the list is in the range [1, 105].
 * 0 <= Node.val <= 9
 *
 *
 * Follow up: Could you do it in O(n) time and O(1) space?
 */

public class L234_PalindromeLinkedList {
    /*
    Intuition here is to fnd the middle node of the list using hare and turtle method as we get the
    middle node we will start comparing the values while backtracking
     */

    public boolean isPalindrome(ListNode head) {
        head = recursion(head, head); // using head itself to keep the returned node, which we have no use, as the fun will return something it's necessary to keep the return value
        return res;
    }

    boolean res = true; // assuming the given list is palindrome
    public ListNode recursion(ListNode head1, ListNode head2){
        if(head2.next == null){ // this condition gets true means there are odd number of nodes
            return head1.next;
        }

        if(head2.next.next == null){ // if this condition gets true means there are even number of nodes
            if(head1.val != head1.next.val){ // this is the needed condition to check when there is even number of nodes, may be at the starting only nodes value is not equal
                res = false;
            }
            return head1.next.next;
        }

        // using turtle and hare method to solve this problem
        // head1 is working as turtle and head2 is working as hare
        ListNode temp = recursion(head1.next, head2.next.next);
        if(head1.val != temp.val){ // if at any condition the node value is not same, then the list cannot be palindrome, then doing res as false
            res = false;
        }

        return temp.next;
    }
}
