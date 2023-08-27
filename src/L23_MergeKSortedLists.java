package src;

/**
 * You are given an array of k linked-lists lists, each linked-list is sorted in ascending order.
 * Merge all the linked-lists into one sorted linked-list and return it.
 *
 * Example 1:
 *
 * Input: lists = [[1,4,5],[1,3,4],[2,6]]
 * Output: [1,1,2,3,4,4,5,6]
 * Explanation: The linked-lists are:
 * [
 *   1->4->5,
 *   1->3->4,
 *   2->6
 * ]
 * merging them into one sorted list:
 * 1->1->2->3->4->4->5->6
 * Example 2:
 *
 * Input: lists = []
 * Output: []
 * Example 3:
 *
 * Input: lists = [[]]
 * Output: []
 */

import java.util.PriorityQueue;

public class L23_MergeKSortedLists {

    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<Integer> dp = new PriorityQueue<>(); // using PriorityQueue as dp
        for(int i = 0;i<lists.length;i++){ // keeping all the element in dp, while iterating through all the elements
            while(lists[i] != null){
                dp.add(lists[i].val);
                lists[i] = lists[i].next;
            }
        }

        ListNode head = null;
        ListNode curr = null;
        while(!dp.isEmpty()){ // removing all the element from the PriorityQueue one by one, and putting in the linked list
            if(head == null){
                head = new ListNode(dp.remove());
                curr = head;
            }else{
                curr.next = new ListNode(dp.remove());
                curr = curr.next;
            }
        }

        return head; // returning the linkedlist
    }
}
