package src;

/**
 * Given the root of a binary tree, check whether it is a mirror of itself (i.e., symmetric around its center).
 *
 *
 *
 * Example 1:
 *
 *
 * Input: root = [1,2,2,3,4,4,3]
 * Output: true
 * Example 2:
 *
 *
 * Input: root = [1,2,2,null,3,null,3]
 * Output: false
 *
 *
 * Constraints:
 *
 * The number of nodes in the tree is in the range [1, 1000].
 * -100 <= Node.val <= 100
 *
 *
 * Follow up: Could you solve it both recursively and iteratively?
 */

public class L101_SymmetricTree {
    public boolean isSymmetric(TreeNode root) {
        return comparison(root.left, root.right);
    }

    public boolean comparison(TreeNode left, TreeNode right){
        if(left == null && right == null){
            return true;
        }

        if(left == null || right == null || left.val != right.val){
            return false;
        }

        return comparison(left.left, right.right) && comparison(left.right, right.left); // this line is to be mind here
        // here we are comparing the right node with the left of the right subtree with left subtree
    }
}
