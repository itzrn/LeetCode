package src;

/**
 * Given the root of a binary search tree, return a balanced binary search tree with the same node values.
 * If there is more than one answer, return any of them.
 *
 * A binary search tree is balanced if the depth of the two subtrees of every node never differs by more than 1.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: root = [1,null,2,null,3,null,4,null,null]
 * Output: [2,1,3,null,null,null,4]
 * Explanation: This is not the only correct answer, [3,1,4,null,2] is also correct.
 * Example 2:
 *
 *
 * Input: root = [2,1,3]
 * Output: [2,1,3]
 *
 *
 * Constraints:
 *
 * The number of nodes in the tree is in the range [1, 104].
 * 1 <= Node.val <= 105
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

import java.util.ArrayList;
import java.util.List;

public class L1382_BalanceABinarySearchTree {
    public TreeNode balanceBST(TreeNode root) {
        List<TreeNode> list = new ArrayList<>();
        inOrder(list, root);
        return recursion(list, 0, list.size());
    }

    public void inOrder(List<TreeNode> list, TreeNode root){
        if(root == null){
            return;
        }

        inOrder(list, root.left);
        list.add(root);
        inOrder(list, root.right);
    }

    public TreeNode recursion(List<TreeNode> list, int low, int high){
        if(low == high){
            return null;
        }
        int mid = low + (high-low)/2;
        TreeNode root = list.get(mid);
        root.left = recursion(list, low, mid);
        root.right = recursion(list, mid+1, high);
        return root;
    }
}
