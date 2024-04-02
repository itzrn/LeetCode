package src;

/**
 * Given the root of a binary tree, return the zigzag level order traversal of its nodes' values.
 * (i.e., from left to right, then right to left for the next level and alternate between).
 *
 *
 *
 * Example 1:
 *
 *
 * Input: root = [3,9,20,null,null,15,7]
 * Output: [[3],[20,9],[15,7]]
 * Example 2:
 *
 * Input: root = [1]
 * Output: [[1]]
 * Example 3:
 *
 * Input: root = []
 * Output: []
 *
 *
 * Constraints:
 *
 * The number of nodes in the tree is in the range [0, 2000].
 * -100 <= Node.val <= 100
 */

import java.util.ArrayList;
import java.util.List;

public class L103_BinaryTreeZigZagLevelOrderTraversal {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        recursion(root, 0);
        return ans;
    }

    List<List<Integer>> ans = new ArrayList<>();
    int size=-1;
    public void recursion(TreeNode root, int level){
        if(root == null){
            return;
        }

        if(size<level){
            ans.add(new ArrayList<>());
            size++;
        }

        if(level%2 == 0){
            ans.get(level).add(root.val);
        }else{
            ans.get(level).add(0, root.val);
        }

        recursion(root.left, level+1);
        recursion(root.right, level+1);
    }
}
