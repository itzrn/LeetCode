package src;

/**
 * Given a binary tree, determine if it is
 * height-balanced
 * .
 *
 *
 *
 * Example 1:
 *
 *
 * Input: root = [3,9,20,null,null,15,7]
 * Output: true
 * Example 2:
 *
 *
 * Input: root = [1,2,2,3,3,null,null,4,4]
 * Output: false
 * Example 3:
 *
 * Input: root = []
 * Output: true
 *
 *
 * Constraints:
 *
 * The number of nodes in the tree is in the range [0, 5000].
 * -104 <= Node.val <= 104
 */

public class L110_BalancedBinaryTree {
    public boolean isBalanced(TreeNode root) {
        int temp = recursion(root);
        return res;
    }

    boolean res = true; // assuming that the given tree is Balanced
    public int recursion(TreeNode root){
        if(root == null){ // base case
            return 0;
        }

        if(!res){ // if at any point we found that the tree is not balanced, we will simply stop the recursion, and wherever we are we will return to root
            return 0;
        }

        int left  = recursion(root.left) + 1;
        int right = recursion(root.right) + 1;

        if(Math.abs(left-right) > 1){ // after calculating the height of right and left subtree, checking for the balanced tree condition
            res = false; // if the condition gets true means the tree is not balanced
        }

        return Math.max(left,right);
    }
}
