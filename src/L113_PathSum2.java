package src;

/**
 * Given the root of a binary tree and an integer targetSum, return all root-to-leaf paths where
 * the sum of the node values in the path equals targetSum. Each path should be returned as a list of the node values, not node references.
 *
 * A root-to-leaf path is a path starting from the root and ending at any leaf node. A leaf is a node with no children.
 *
 *
 * Example 1:
 *
 *
 * Input: root = [5,4,8,11,null,13,4,7,2,null,null,5,1], targetSum = 22
 * Output: [[5,4,11,2],[5,8,4,5]]
 * Explanation: There are two paths whose sum equals targetSum:
 * 5 + 4 + 11 + 2 = 22
 * 5 + 8 + 4 + 5 = 22
 * Example 2:
 *
 *
 * Input: root = [1,2,3], targetSum = 5
 * Output: []
 * Example 3:
 *
 * Input: root = [1,2], targetSum = 0
 * Output: []
 *
 *
 * Constraints:
 *
 * The number of nodes in the tree is in the range [0, 5000].
 * -1000 <= Node.val <= 1000
 * -1000 <= targetSum <= 1000
 */

import java.util.ArrayList;
import java.util.List;

public class L113_PathSum2 {
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        recursion(root, targetSum, new ArrayList<>());
        return res;
    }

    List<List<Integer>> res = new ArrayList<>(); // keeping the resultant list, which contains all combination list to targetSum
    public void recursion(TreeNode root, int target, List<Integer> list){
        if(root == null){ // base case
            return;
        }

        // here we are travelling till root node, no matter in between if the sum gets more than target sum, it can be possible the node have -ve number and
        // when we reach to leaf node till then the sum becomes equal to target sum
        if(root.left == null && root.right == null){
            if(target - root.val == 0){ // in every recursion we are subtracting roo value to make target sum '0', which implies that we reach to our target combination
                list.add(root.val);
                res.add(new ArrayList<>(list));
                list.remove(list.size() - 1);
            }
            return;
        }

        // doing dfs till all leaf
        list.add(root.val);
        recursion(root.left, target-root.val, list);
        recursion(root.right, target-root.val, list);
        list.remove(list.size() - 1);
    }
}
