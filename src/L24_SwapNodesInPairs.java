package src;

/**
 * Given a linked list, swap every two adjacent nodes and return its head. You must solve the problem without
 * modifying the values in the list's nodes (i.e., only nodes themselves may be changed.)
 *
 *
 *
 * Example 1:
 *
 *
 * Input: head = [1,2,3,4]
 * Output: [2,1,4,3]
 * Example 2:
 *
 * Input: head = []
 * Output: []
 * Example 3:
 *
 * Input: head = [1]
 * Output: [1]
 *
 *
 * Constraints:
 *
 * The number of nodes in the list is in the range [0, 100].
 * 0 <= Node.val <= 100
 */



public class L24_SwapNodesInPairs {
    public ListNode swapPairs(ListNode head) {
        return swapPairs(head, 0);
    }
    /*
    Intuition ->
    hera we are traversing till the end of the LinkedList, while back tracking we will reverse the pair of node and returning head of every
    reverse pair
     */


    // parameter 'a' is specially used to check the total number of nodes is odd or even, and also helping in reversing the pairs and identifying
    // the head of the pairs before and after the reverse of the pair

    public ListNode swapPairs(ListNode head, int a){ // taking 'a' to identify the compiler, the node have a=1 means we have to reverse the node with its following node
        // and returning head of reverse pair,
        // when a == 2 means, connect the next pointer of the head node to the head of reversed head(temp1) so not to lose the following node
        if(a == 2){ // this condition is used to re-start the counting, so to give a=1 and a=2 to every node for identification
            a = 0;
        }
        if(head == null || head.next == null){ // there is a reason to keep head == null before head.next == null,
            // let if in case head == null and head.next == null is before head == null, then it will check head.next == null first,
            // which will give NullPointerException, so to avoid this keeping head == null first. Like -> if head == null becomes true,
            // and we have || operator then it will not check the head.next condition, and it will return the head
            return head;
        }
        a++;
        ListNode temp1 = swapPairs(head.next, a); // recursive call
        if(a == 1){ // at this condition, reversing the pair and returning the head of the reversed pair
            ListNode temp2 =  temp1.next;
            temp1.next = head;
            head.next = temp2;
            return temp1;
        }else{ // at this condition we are connecting the head with the head of the reversed pair, to not lose the following pairs, and returning the head
            head.next = temp1;
            return head;
        }
    }
}
