package src;

/**
 * You are given two non-empty linked lists representing two non-negative integers.
 * The digits are stored in reverse order, and each of their nodes contains a single digit.
 * Add the two numbers and return the sum as a linked list.

 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.


 * Input: l1 = [2,4,3], l2 = [5,6,4]
 * Output: [7,0,8]
 * Explanation: 342 + 465 = 807.
 */
public class L2_AddTwoNumbers {
    ListNode resultHead;

    public void add(int val){//adding node at the end of the LinkedList
        if(resultHead == null){
            resultHead = new ListNode(val);
            return;
        }

        ListNode currentNode = resultHead;
        while(currentNode.next != null){
            currentNode = currentNode.next;
        }
        currentNode.next = new ListNode(val);
    }

    int carry = 0;//to take carry at every sum
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int sum;
        if(l1 == null && l2 == null){//if reach to the null node of both the LinkedList, then terminate
            if(carry > 0){
                add(carry);
            }
            return resultHead;
        }
        if(l1 == null){// if l1 is getting null, but l2 won't, then the left digit of the l2 is need to be added
            sum = l2.val + carry;
            if(sum >= 10){
                carry = 1;
                sum = sum - 10;
            }else if((sum - 10) <= -1){
                carry = 0;
            }
            add(sum);
            return addTwoNumbers(null,l2.next);
        }
        if(l2 == null){// if l2 is getting null, but l1 won't, then the left digit of the l1 is need to be added
            sum = l1.val + carry;
            if(sum >= 10){
                carry = 1;
                sum = sum - 10;
            }else if((sum - 10) <= -1){
                carry = 0;
            }
            add(sum);
            return addTwoNumbers(l1.next,null);
        }
        sum = l1.val + l2.val + carry;
        if((sum-10)>=0){
            carry = 1;
            sum = sum - 10;
        }else if((sum-10) <= -1){
            carry = 0;
        }
        add(sum);
        return addTwoNumbers(l1.next,l2.next);
    }

    public ListNode addTwoNumbersUsingRecursion(ListNode l1, ListNode l2) {  // this is the recursive way to solve the problem
        return recursionSum(l1,l2,null,0);
    }

    public ListNode recursionSum(ListNode l1, ListNode l2, ListNode res, int carry){ // here three cases can arise
        if(l1 == null && l2 == null){  // case 1
            if(carry == 1){
                return new ListNode(carry);
            }
            return res;
        }else if(l1 == null){ // case 2
            if(l2.val + carry >9){// if the sum is greater than 9,
                // then on every recursion we have to add carry 1, or we have to add carry 1 to every recursion till at a particular recursion sum won't get <=9
                res = new ListNode(l2.val+carry-10);
                carry = 1;
                res.next = recursionSum(l1,l2.next,res.next,carry);
                return res;
            }else{ // this says that if the sum is not greater than 9, then add the remaining nodes of l2 to res
                l2.val = l2.val+carry;
                return l2;
            }

        }else if(l2 == null){ // case 3
            if(l1.val + carry > 9){ // if the sum is greater than 9,
                // then on every recursion we have to add carry 1, or we have to add carry 1 to every recursion till at a particular recursion sum won't get <=9
                res = new ListNode(l1.val+carry-10);
                carry = 1;
                res.next = recursionSum(l1.next, l2,res.next,carry);
                return res;
            }else{ // this says that if the sum is not greater than 9, then add the remaining nodes of l1 to res
                l1.val = l1.val+carry;
                return l1;
            }
        }else{ // case 4 -> this case says, when both l1 and l2 have value
            if(l1.val+l2.val+carry>9){
                res = new ListNode(l1.val+l2.val+carry-10);
                carry = 1;
            }else{
                res = new ListNode(l1.val + l2.val + carry);
                carry = 0;
            }
            res.next = recursionSum(l1.next,l2.next,res.next,carry);
            return res;
        }
    }
}
