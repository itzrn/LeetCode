package src;

/**
 * Given the head of a singly linked list where elements are sorted in ascending order, convert it to a
 * height-balanced
 *  binary search tree.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: head = [-10,-3,0,5,9]
 * Output: [0,-3,9,-10,null,5]
 * Explanation: One possible answer is [0,-3,9,-10,null,5], which represents the shown height balanced BST.
 * Example 2:
 *
 * Input: head = []
 * Output: []
 *
 *
 * Constraints:
 *
 * The number of nodes in head is in the range [0, 2 * 104].
 * -105 <= Node.val <= 105
 */


/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

public class L109_ConvertSortedListToBinarySearchTree {
    public TreeNode sortedListToBST(ListNode head) {
        return recursion(head, null);
    }

    public TreeNode recursion(ListNode start, ListNode end){
        if(start == end){ // base case
            return null;
        }
        ListNode turtle = start;
        ListNode hare = start;
        while(hare != end && hare.next != end){ // this loop is used as binary search, which is helpful to find the root of every subtree
            turtle = turtle.next;
            hare = hare.next.next;
        }

        TreeNode root = new TreeNode(turtle.val); // making the root of every subtree
        root.left = recursion(start, turtle); // constructing the left subtree
        root.right = recursion(turtle.next, end); // constructing the right subtree

        return root; // returning the subtree
    }
}
