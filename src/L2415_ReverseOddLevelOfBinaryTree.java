package src;

/**
 * Given the root of a perfect binary tree, reverse the node values at each odd level of the tree.
 *
 * For example, suppose the node values at level 3 are [2,1,3,4,7,11,29,18], then it should become [18,29,11,7,4,3,1,2].
 * Return the root of the reversed tree.
 *
 * A binary tree is perfect if all parent nodes have two children and all leaves are on the same level.
 *
 * The level of a node is the number of edges along the path between it and the root node.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: root = [2,3,5,8,13,21,34]
 * Output: [2,5,3,8,13,21,34]
 * Explanation:
 * The tree has only one odd level.
 * The nodes at level 1 are 3, 5 respectively, which are reversed and become 5, 3.
 * Example 2:
 *
 *
 * Input: root = [7,13,11]
 * Output: [7,11,13]
 * Explanation:
 * The nodes at level 1 are 13, 11, which are reversed and become 11, 13.
 * Example 3:
 *
 * Input: root = [0,1,2,0,0,0,0,1,1,1,1,2,2,2,2]
 * Output: [0,2,1,0,0,0,0,2,2,2,2,1,1,1,1]
 * Explanation:
 * The odd levels have non-zero values.
 * The nodes at level 1 were 1, 2, and are 2, 1 after the reversal.
 * The nodes at level 3 were 1, 1, 1, 1, 2, 2, 2, 2, and are 2, 2, 2, 2, 1, 1, 1, 1 after the reversal.
 *
 *
 * Constraints:
 *
 * The number of nodes in the tree is in the range [1, 214].
 * 0 <= Node.val <= 105
 * root is a perfect binary tree.
 */

public class L2415_ReverseOddLevelOfBinaryTree {
    public TreeNode reverseOddLevels(TreeNode root) {
        // as we know root is at level 0 and at 0 level there is only one node, so there is no need to reverse teh order
        // trying to reverse the level of subtree
        recursion(root.left, root.right, 1);
        return root;
    }

    public void recursion(TreeNode root1, TreeNode root2, int level){
        if(root1 == null || root2 == null){ // base case
            return;
        }

        if(level%2 == 1){ // condition the level which is need to reverse
            int temp = root1.val;
            root1.val = root2.val;
            root2.val = temp;
        }

        // as we know the given tree is going to be perfect tree
        // so the depth we go in left, we will go the same depth in right and where ever we find the level is odd, need to reverse the order
        // here at the same time travelling both the subtree

        // this particular recursion is used to cover the outer node of each subtree
        recursion(root1.left, root2.right, level+1);

        // this particular recursion is used to cover the inner node each subtree
        recursion(root1.right, root2.left, level+1);
    }
}
