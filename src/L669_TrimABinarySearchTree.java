package src;

/**
 * Given the root of a binary search tree and the lowest and highest boundaries as low and high,
 * trim the tree so that all its elements lies in [low, high]. Trimming the tree should not change the relative
 * structure of the elements that will remain in the tree (i.e., any node's descendant should remain a descendant).
 * It can be proven that there is a unique answer.
 *
 * Return the root of the trimmed binary search tree. Note that the root may change depending on the given bounds.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: root = [1,0,2], low = 1, high = 2
 * Output: [1,null,2]
 * Example 2:
 *
 *
 * Input: root = [3,0,4,null,2,null,null,1], low = 1, high = 3
 * Output: [3,2,null,1]
 *
 *
 * Constraints:
 *
 * The number of nodes in the tree is in the range [1, 104].
 * 0 <= Node.val <= 104
 * The value of each node in the tree is unique.
 * root is guaranteed to be a valid binary search tree.
 * 0 <= low <= high <= 104
 */

public class L669_TrimABinarySearchTree {
    public TreeNode trimBST(TreeNode root, int low, int high) {
        if(root == null){
            return null;
        }

        // doing dfs
        root.left = trimBST(root.left, low, high);
        root.right = trimBST(root.right, low, high);

        // while backtracking, checking bellow two condition

        if(root.val < low){// if this condition gets true, means all the element of the left subtree will be smaller than 'low'
            root.left = null; // so making the left node of the root null
            return root.right; // and returning the right subtree which will having elements greater than low
        }
        if(root.val > high){// if this condition gets true, means all the element of the right subtree will be greater than 'high'
            root.right = null;// so making the right node of the root null
            return root.left;// and returning the left subtree which will having elements smaller than 'high'
        }

        // if root value is in between low and high then returning the root, bcz that node we want in the tree
        return root;
    }
}
