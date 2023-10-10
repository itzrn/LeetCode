package src;

/**
 * Given the root of a binary tree, return all root-to-leaf paths in any order.
 *
 * A leaf is a node with no children.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: root = [1,2,3,null,5]
 * Output: ["1->2->5","1->3"]
 * Example 2:
 *
 * Input: root = [1]
 * Output: ["1"]
 *
 *
 * Constraints:
 *
 * The number of nodes in the tree is in the range [1, 100].
 * -100 <= Node.val <= 100
 */

import java.util.ArrayList;
import java.util.List;

public class L257_BinaryTreePath {
    public List<String> binaryTreePaths(TreeNode root) {
        recursion(root, "");
        return list;
    }

    List<String> list = new ArrayList<>();
    public void recursion(TreeNode root, String res){
        if(root == null){
            return;
        }
        if(root.left == null && root.right == null){
            res = res + root.val;
            list.add(res);
            return;
        }

        res = res + root.val + "->";
        recursion(root.left, res);
        recursion(root.right, res);
    }
}
