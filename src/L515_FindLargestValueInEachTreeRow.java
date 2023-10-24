package src;

/**
 * Given the root of a binary tree, return an array of the largest value in each row of the tree (0-indexed).
 *
 *
 *
 * Example 1:
 *
 *
 * Input: root = [1,3,2,5,3,null,9]
 * Output: [1,3,9]
 * Example 2:
 *
 * Input: root = [1,2,3]
 * Output: [1,3]
 *
 *
 * Constraints:
 *
 * The number of nodes in the tree will be in the range [0, 104].
 * -231 <= Node.val <= 231 - 1
 */

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class L515_FindLargestValueInEachTreeRow {
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if(root == null){
            return res;
        }
        Queue<TreeNode> queue = new LinkedList<>();

        queue.add(root);
        queue.add(null);

        // At last queue will have 2 null value, which implies that it's the end of the traversal
        while(queue.peek() != null){ // this is used to traverse all the level
            int max = Integer.MIN_VALUE;

            while(queue.peek() != null){ // this is used to traverse all the node of level
                max = Math.max(max, queue.peek().val); // this is used to calculate the max of a level
                if(queue.peek().right != null){ // this is used to add the right node of the next level if present
                    queue.add(queue.peek().right);
                }

                if(queue.peek().left != null){ // this is used to add the left node of the next level if present
                    queue.add(queue.peek().left);
                }

                queue.remove(); // removing the node
            }

            res.add(max); // this is used to add max value of each level to res list
            queue.remove(); // this is actually removing the null value present before the start of any level
            queue.add(null); // this is used to identify compiler, that there is the change in row
        }

        return res;
    }
}
