package src;

/**
 * You are given the heads of two sorted linked lists list1 and list2.
 *
 * Merge the two lists into one sorted list. The list should be made by splicing together the nodes of the first two lists.
 *
 * Return the head of the merged linked list.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: list1 = [1,2,4], list2 = [1,3,4]
 * Output: [1,1,2,3,4,4]
 * Example 2:
 *
 * Input: list1 = [], list2 = []
 * Output: []
 * Example 3:
 *
 * Input: list1 = [], list2 = [0]
 * Output: [0]
 */

import java.util.PriorityQueue;

public class L21_MergeTwoSortedList {

    // used a data structure
    public ListNode mergeTwoLists1(ListNode list1, ListNode list2) {
        PriorityQueue<Integer> dp = new PriorityQueue<>(); // PriorityQueue as dp

        while(list1 != null){  // putting list1 element in the dp
            dp.add(list1.val);
            list1 = list1.next;
        }

        while(list2 != null){  // putting list2 element in the dp
            dp.add(list2.val);
            list2 = list2.next;
        }

        ListNode head = null;
        ListNode curr = null;

        while(!dp.isEmpty()){ // removing element one by one and putting it to the linked-list, thus sorting int the ascending order
            if(head == null){
                head = new ListNode(dp.remove());
                curr = head;
            }else{
                curr.next = new ListNode(dp.remove());
                curr = curr.next;
            }
        }

        return head;
    }
}
