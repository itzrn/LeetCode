package src;

/**
 * Given the head of a linked list and a value x,
 * partition it such that all nodes less than x come before nodes greater than or equal to x.
 *
 * You should preserve the original relative order of the nodes in each of the two partitions.
 *
 * Example 1:
 *
 * Input: head = [1,4,3,2,5,2], x = 3
 * Output: [1,2,2,4,3,5]
 *
 *
 * Example 2:
 *
 * Input: head = [2,1], x = 2
 * Output: [1,2]
 */

import java.util.LinkedList;
import java.util.Queue;

public class L86_PartitionList {
    // this ques says that if there is any number less than x,
    // then put in the starting keeping the sequence same, and all other greater than or equal to x, put then in the end of the list keeping sequence same
    Queue<Integer> dp = new LinkedList<>();  // using queue as dp, we will store all the bigger element than x,
    // and the add all those elements in the same sequence to the end of the list

    public ListNode partition(ListNode head, int x) {
        ListNode head1 = null;

        ListNode curr = null;
        while(head != null){ // this search all the element less than x, and put in the list
            if(head.val < x){
                if(head1 == null){
                    head1 = new ListNode(head.val);
                    curr = head1;
                }else{
                    curr.next = new ListNode(head.val);
                    curr = curr.next;
                }
            }else{
                dp.add(head.val);
            }
            head = head.next;
        }

        while(!dp.isEmpty()){ // if any element present in the dp, put at the end of the list(these elements are greater than or equal to x)
            if(head1 == null){
                head1 = new ListNode(dp.remove());
                curr = head1;
            }else{
                curr.next = new ListNode(dp.remove());
                curr = curr.next;
            }
        }

        return head1;
    }
}
