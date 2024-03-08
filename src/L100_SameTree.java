package src;

/**
 * Given the roots of two binary trees p and q, write a function to check if they are the same or not.
 *
 * Two binary trees are considered the same if they are structurally identical, and the nodes have the same value.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: p = [1,2,3], q = [1,2,3]
 * Output: true
 * Example 2:
 *
 *
 * Input: p = [1,2], q = [1,null,2]
 * Output: false
 * Example 3:
 *
 *
 * Input: p = [1,2,1], q = [1,1,2]
 * Output: false
 *
 *
 * Constraints:
 *
 * The number of nodes in both trees is in the range [0, 100].
 * -104 <= Node.val <= 104
 */

public class L100_SameTree {
    // here the node should have the same value also
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == null && q == null){ // base case
            return true;
        }
        if(p == null || q == null || p.val != q.val){ // if any of these condition is true means the given two tress are not same
            return false;
        }

        return isSameTree(p.left,q.left) && isSameTree(p.right, q.right); // checking right and the left subtree
    }

    public boolean isSameTree1(TreeNode p, TreeNode q) {
        if(p == null && q != null || p != null && q == null){
            return false;
        }

        if(p == null && q == null){
            return true;
        }

        if(p.val != q.val){
            return false;
        }

        return isSameTree1(p.left, q.left) && isSameTree1(p.right, q.right);
    }
}
