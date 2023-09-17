package src;

/**
 * Given the root of a binary tree, return its maximum depth.
 *
 * A binary tree's maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: root = [3,9,20,null,null,15,7]
 * Output: 3
 * Example 2:
 *
 * Input: root = [1,null,2]
 * Output: 2
 *
 *
 * Constraints:
 *
 * The number of nodes in the tree is in the range [0, 104].
 * -100 <= Node.val <= 100
 */

public class L104_MaximumDepthOfBinaryTree {
    public int maxDepth(TreeNode root) {
        recursion(root, 1);
        return max;
    }

    int max = 0;
    public void recursion(TreeNode root, int depth){
        if(root == null){
            max = Math.max(max, depth-1); // doing depth-1, so to remove the count of null
            return;
        }

        // going depth of every sub tree
        recursion(root.left, depth+1);
        recursion(root.right, depth+1);
    }
}
