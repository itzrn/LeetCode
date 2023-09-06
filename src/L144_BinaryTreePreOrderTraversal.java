package src;

/**
 *Given the root of a binary tree, return the preorder traversal of its nodes' values.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: root = [1,null,2,3]
 * Output: [1,2,3]
 * Example 2:
 *
 * Input: root = []
 * Output: []
 * Example 3:
 *
 * Input: root = [1]
 * Output: [1]
 *
 *
 * Constraints:
 *
 * The number of nodes in the tree is in the range [0, 100].
 * -100 <= Node.val <= 100
 *
 * Follow up: Recursive solution is trivial, could you do it iteratively?
 */

import java.util.ArrayList;
import java.util.List;

public class L144_BinaryTreePreOrderTraversal {
    public List<Integer> preorderTraversal(TreeNode root) {
        traversal(root);
        return list;
    }

    List<Integer> list = new ArrayList<>();
    public void traversal(TreeNode root){ // root, left, right
        if(root == null){
            return;
        }

        list.add(root.val);
        traversal(root.left);
        traversal(root.right);
    }
}
