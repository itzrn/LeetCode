package src;

/**
 * Given the root of a binary tree, return the level order traversal of its nodes' values. (i.e., from left to right, level by level).
 *
 *
 *
 * Example 1:
 *
 *
 * Input: root = [3,9,20,null,null,15,7]
 * Output: [[3],[9,20],[15,7]]
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
 * -1000 <= Node.val <= 1000
 */

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class L102_BinaryTreeLevelOrderTraversal {
    public List<List<Integer>> levelOrder(TreeNode root) {
        bfs(root);
        return res;
    }

    List<List<Integer>> res = new ArrayList<>();
    List<Integer> list = new ArrayList<>();
    public void bfs(TreeNode root){ // this is a level order traversal
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        queue.add(null);

        while(queue.peek() != null){ // at the end we will have 2 null in queue, one null will get remove just after the inner while loop but another will remain
            // and this happens only at the end of the traversal, so taking this point as end of outer while loop
            list.clear();
            while(queue.peek() != null){// adding all the nodes fo the next level
                if(queue.peek().left != null){
                    queue.add(queue.peek().left);
                }

                if(queue.peek().right != null){
                    queue.add(queue.peek().right);
                }

                list.add(queue.poll().val);
            }

            queue.poll(); // this is removing the front null value which was used for level change identification
            queue.add(null); // this is used to identify that there is the change in level
            res.add(new ArrayList<>(list));// adding the list of one level node in resultant list
        }
    }
}
