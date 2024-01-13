package src;

/**
 * Given the root of a binary tree, return the sum of values of nodes with an even-valued grandparent.
 * If there are no nodes with an even-valued grandparent, return 0.
 *
 * A grandparent of a node is the parent of its parent if it exists.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: root = [6,7,8,2,7,1,3,9,null,1,4,null,null,null,5]
 * Output: 18
 * Explanation: The red nodes are the nodes with even-value grandparent while the blue nodes are the even-value grandparents.
 * Example 2:
 *
 *
 * Input: root = [1]
 * Output: 0
 *
 *
 * Constraints:
 *
 * The number of nodes in the tree is in the range [1, 104].
 * 1 <= Node.val <= 100
 */

public class L1315_SomeOfNodesWithEvenValuedGrandparent {
    public int sumEvenGrandparent(TreeNode root) {
        recursion(root);
        return sum;
    }

    // breaking the approach in two recursive parts
    public void recursion(TreeNode root){ // this recursion is finding all the nodes having even value
        if(root == null){
            return;
        }

        if(root.val % 2 == 0){
            grandChildSum(root, 0);
        }

        recursion(root.left);
        recursion(root.right);
    }

    int sum = 0;
    public void grandChildSum(TreeNode root, int level){ // this recursion is calculating the sum fo grand child of the node with even value
        if(level > 2 || root == null){
            return;
        }

        if(level == 2){
            sum += root.val;
        }

        grandChildSum(root.left, level+1);
        grandChildSum(root.right, level+1);
    }
}
