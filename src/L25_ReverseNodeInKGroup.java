package src;

/**
 * Given the head of a linked list, reverse the nodes of the list k at a time, and return the modified list.
 *
 * k is a positive integer and is less than or equal to the length of the linked list.
 * If the number of nodes is not a multiple of k then left-out nodes, in the end, should remain as it is.
 *
 * You may not alter the values in the list's nodes, only nodes themselves may be changed.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: head = [1,2,3,4,5], k = 2
 * Output: [2,1,4,3,5]
 * Example 2:
 *
 *
 * Input: head = [1,2,3,4,5], k = 3
 * Output: [3,2,1,4,5]
 *
 *
 * Constraints:
 *
 * The number of nodes in the list is n.
 * 1 <= k <= n <= 5000
 * 0 <= Node.val <= 1000
 */

public class L25_ReverseNodeInKGroup {
    public ListNode reverseKGroup(ListNode head, int k) {
        if(k == 1 || head == null){ // keeping the base case, if k=1 no need of any reverse, bcz reversing of length k=1 node doesn't mean anything
            return head;
        }

        ListNode curr = head; // keeping the head in curr variable, bcz to reverse I have to give the starting node and end node, and here this head node will get lost in future
        int a=k; // taking 'a', to retrieve the value of k
        while(a>1){ // this loop is to find the end node, mean the kth node to reverse the list from 1 to k
            if(head.next == null && k>1){
                return curr;
            }
            head = head.next;
            a--;
        }
        ListNode temp = head.next; // keeping the head.next in temp, bcz for next k node I need, start and end node to reverse
        ListNode curr1 = reverse(curr, head); // reversing some part of the list
        ListNode curr2 = reverseKGroup(temp,k); // this doing recursion, which returns the head of the reversed list to the previously reversed list emd node
        curr.next = curr2; // as we know this curr node on reverse will come at the end, and this node has to get connect with the starting node of the future k reversed node
        return curr1; // returning the head of the reversed list
    }

    public ListNode reverse(ListNode head, ListNode end){ // this doing some(from node head to node end) node Of LinkedList reverse, with end.next = null
        if(head == end){
            return head;
        }

        ListNode temp = reverse(head.next, end); // firstly moving till the end node
        head.next.next = head; // now connect one step forward node to itself
        head.next = null; // and making node.next = null

        return temp; // returning the last node which will become head after reversing.
    }
}
