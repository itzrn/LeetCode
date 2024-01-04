package src;

/**
 * Given the root of a binary search tree, rearrange the tree in in-order so that the leftmost node in the tree is now the root of the tree,
 * and every node has no left child and only one right child.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: root = [5,3,6,2,4,null,8,1,null,null,null,7,9]
 * Output: [1,null,2,null,3,null,4,null,5,null,6,null,7,null,8,null,9]
 * Example 2:
 *
 *
 * Input: root = [5,1,7]
 * Output: [1,null,5,null,7]
 *
 *
 * Constraints:
 *
 * The number of nodes in the given tree will be in the range [1, 100].
 * 0 <= Node.val <= 1000
 */

public class L897_IncreasingOrderSearchTree {
    public TreeNode increasingBST(TreeNode root) {
        if(root == null){
            return null;
        }

        if(root.left == null && root.right == null){
            return root;
        }

        // doing dfs inorder traversal, but in opposite way means going firstly end of the right subtree
        // the reason of doing such kind of traversal is bcz at the end we have to make the right subtree at the end of the list and left subtree in the starting and root in the middle
        // so, while backtrack we push all the right subtree at the end of the list
        TreeNode right = increasingBST(root.right);
        TreeNode left = increasingBST(root.left);

        if(left == null){ // if this condition gets true means, we have to only connect the root with right subtree
            root.right = right;
            return root;
        }

        // we will iterate to the end of the left subtree and connect to the root
        TreeNode temp = left;
        while(temp.right != null){
            temp = temp.right;
        }


        temp.right = root;
        root.right = right;
        root.left = null; // this is used to make all the left pointer of node null
        return left; // returning the left subtree bcz we need the left subtree as head of the generated list
    }
}
