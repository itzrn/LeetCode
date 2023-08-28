package src;

public class L82_RemoveDuplicatesFromSortedList { // here we have to delete the ELEMENT which is getting repeat

    public ListNode deleteDuplicates(ListNode head) {
        if(head == null){
            return null;
        }
        head = recursiveDelete(head);
        if(check){ // if at the end check remains true means the head element is duplicated,
            // and all the duplicate of this element is deleted, now the compiler have to delete that particular element also
            return head.next;
        }
        return head;
    }

    boolean check = false;
    /*
    why check?
    the bellow recursive function will delete all the duplicate element, but it will not delete the ELEMENT itself
     -> like if the linked-list is -> 1,1,2,3,3,4,4,5
     then without check the ans will be -> 1,2,3,4,5
     so, we can see its just deleting the repeated element
     */
    public ListNode recursiveDelete(ListNode head){
        if(head.next == null){
            return head;
        }

        ListNode temp = recursiveDelete(head.next);
        // I put here if-else-if condition, that's a reason
        // whenever the head.val == temp.val it will go in that condition only it will not go in else-if

        if(head.val == temp.val){ // this condition is deleting all the duplicate element
            check = true;
            head.next = temp.next;
        }else if(check){ // when the compiler enters this condition, means all the duplicate elements of that particular element
            // is deleted, now the compiler have to delete that particular element too
            check = false;
            head.next = temp.next;
        }
        return head;
    }
}
