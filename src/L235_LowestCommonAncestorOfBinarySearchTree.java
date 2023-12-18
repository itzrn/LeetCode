package src;

public class L235_LowestCommonAncestorOfBinarySearchTree {
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

    public TreeNode lowestCommonAncestor1(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null || root == p || root == q){
            return root;
        }
        TreeNode left = lowestCommonAncestor1(root.left, p, q);
        TreeNode right = lowestCommonAncestor1(root.right, p, q);

        if(left == null){
            return right;
        }else if(right == null){
            return left;
        }
        return root;
    }
}
