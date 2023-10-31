package src;

/**
 *
 Given the root of a binary tree, return the bottom-up level order traversal of its nodes' values. (i.e., from left to right, level by level from leaf to root).



 Example 1:


 Input: root = [3,9,20,null,null,15,7]
 Output: [[15,7],[9,20],[3]]
 Example 2:

 Input: root = [1]
 Output: [[1]]
 Example 3:

 Input: root = []
 Output: []


 Constraints:

 The number of nodes in the tree is in the range [0, 2000].
 -1000 <= Node.val <= 1000
 */

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class L107_BinaryTreeLevelOrderTraversal2 {
    Queue<TreeNode> queue;
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        queue = new LinkedList<>();
        queue.add(root);
        queue.add(null);

        recursion();
        return res;
    }

    List<List<Integer>> res = new ArrayList<>();
    public void recursion(){
        if(queue.peek() == null){
            return;
        }

        List<Integer> list = new ArrayList<>();
        while(queue.peek() != null){
            if(queue.peek().left != null){
                queue.add(queue.peek().left);
            }

            if(queue.peek().right != null){
                queue.add(queue.peek().right);
            }

            list.add(queue.poll().val);
        }
        queue.poll();
        queue.add(null);

        recursion();
        res.add(list);
    }
}
