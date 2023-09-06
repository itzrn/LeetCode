package src;

public class L725_SplitsLinkedListInParts {
    public ListNode[] splitListToParts(ListNode head, int k) {
        ListNode curr = head;
        int size = 0;
        while(curr != null){ // finding size of the linked-list
            size++;
            curr = curr.next;
        }

        int partSize = size/k; // number of nodes each partition will contain, which out adding any extra node if there
        int extra = size%k; // extra nodes.
        if(size<k){ // if size is less than k, means all the index of arr will contain only one node
            partSize = 1;
            extra = 0;
        }
        ListNode[] arr = new ListNode[k];
        int i = 0; // indexing for arr
        while(head!=null && i<k){
            int eachPartSize = partSize;
            if(extra > 0){ // adding one extra node if there, to evey index linked-list, as every indexed linked list should have size almost same
                eachPartSize++;
                extra--;
            }
            arr[i] = head;
            while(eachPartSize > 1){
                head = head.next;
                eachPartSize--;
            }

            ListNode temp = head;
            head = head.next;
            temp.next = null; // making null, else it will contain all the nodes
            i++;
        }
        return arr;
    }
}
