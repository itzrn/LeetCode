package src;

/**
 * Given the root of a Binary Search Tree (BST), return the minimum absolute difference between the values of any two different nodes in the tree.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: root = [4,2,6,1,3]
 * Output: 1
 * Example 2:
 *
 *
 * Input: root = [1,0,48,null,null,12,49]
 * Output: 1
 *
 *
 * Constraints:
 *
 * The number of nodes in the tree is in the range [2, 104].
 * 0 <= Node.val <= 105
 */

public class L530_MinimumAbsoluteDifferenceInBST {
    TreeNode prev = null; // keeping the track of previous node, so to calculate the difference between current node and the previous node
    int minDiff = Integer.MAX_VALUE;

    public int getMinimumDifference(TreeNode root) {
        recursion(root);
        return minDiff;
    }

    public void recursion(TreeNode root) {
        if (root == null) {
            return;
        }

        recursion(root.left);

        if (prev != null) { // condition, to calculate the difference
            minDiff = Math.min(minDiff, root.val - prev.val);
        }

        prev = root;

        recursion(root.right);
    }
}
