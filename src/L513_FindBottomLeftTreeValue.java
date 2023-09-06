package src;

/**
 * Given the root of a binary tree, return the leftmost value in the last row of the tree.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: root = [2,1,3]
 * Output: 1
 * Example 2:
 *
 *
 * Input: root = [1,2,3,4,null,5,6,null,null,7]
 * Output: 7
 *
 *
 * Constraints:
 *
 * The number of nodes in the tree is in the range [1, 104].
 * -231 <= Node.val <= 231 - 1
 */

public class L513_FindBottomLeftTreeValue {
    public int findBottomLeftValue(TreeNode root) {
        recursion(root,1);
        return leftMost;
    }

    int leftMost = 0; // this is used to calculate the left most node value
    int levelDone = 0; // this is used to keep the track till which level we have covered the left most node, if in case we are in the right subtree, with
    // already covered level then we have not to make that node as leftmost node
    public void recursion(TreeNode root, int level){
        if(root == null){
            return;
        }

        if(level > levelDone){ // if this condition is true means the particular node is bottom leftmost
            levelDone++;
            leftMost = root.val;
        }

        recursion(root.left,level+1); // firstly going in left, covering all left most node
        recursion(root.right, level+1); // then going in right subtree, may it have any left most node
    }
}
