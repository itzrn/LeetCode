package src;

/**
 * Given a binary tree, find the lowest common ancestor (LCA) of two given nodes in the tree.
 *
 * According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined between two nodes p and q as
 * the lowest node in T that has both p and q as descendants (where we allow a node to be a descendant of itself).”
 *
 *
 *
 * Example 1:
 *
 *
 * Input: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
 * Output: 3
 * Explanation: The LCA of nodes 5 and 1 is 3.
 * Example 2:
 *
 *
 * Input: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
 * Output: 5
 * Explanation: The LCA of nodes 5 and 4 is 5, since a node can be a descendant of itself according to the LCA definition.
 * Example 3:
 *
 * Input: root = [1,2], p = 1, q = 2
 * Output: 1
 *
 *
 * Constraints:
 *
 * The number of nodes in the tree is in the range [2, 105].
 * -109 <= Node.val <= 109
 * All Node.val are unique.
 * p != q
 * p and q will exist in the tree.
 */

public class L236_LowestCommonAncestorOfABinaryTree {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        recursion(root, p, q);
        return ans;
    }

    // my first approach
    TreeNode ans = null;
    public boolean recursion(TreeNode root, TreeNode p, TreeNode q){
        if(root == null){
            return false;
        }

        boolean[] check = new boolean[3]; // this is used to identify the node getting from left subtree or itself is the node or from right subtree
        if(root == p || root == q){
            check[1] = true;
        }

        // doing dfs
        check[0] = recursion(root.left, p, q);
        check[2] = recursion(root.right, p, q);

        if(check[0] && check[1] || check[1] && check[2] || check[0] && check[2]){ // basic condition that a node is the lowest common ancestor
            ans = root;
        }

        return check[0] || check[1] || check[2];
    }



    // another approach
    public TreeNode lowestCommonAncestor1(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return null;

        if (root == p) return p;

        if (root == q ) return q;

        TreeNode lef = lowestCommonAncestor1(root.left,p,q);
        TreeNode rig = lowestCommonAncestor1(root.right,p,q);

        if (lef == null)
            return rig;
        if (rig == null)
            return lef;

        return root;
    }

    public TreeNode lowestCommonAncestor3(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null){
            return null;
        }
        if(root == p || root == q){
            return root;
        }

        TreeNode left = lowestCommonAncestor3(root.left, p, q);
        TreeNode  right = lowestCommonAncestor3(root.right, p, q);
        return left != null && right != null?root:left==null?right:left;
    }
}
