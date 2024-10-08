package src;

/**
 * Given the root of a binary tree, construct a string consisting of parenthesis and integers from a binary tree with the preorder traversal way, and return it.
 *
 * Omit all the empty parenthesis pairs that do not affect the one-to-one mapping relationship between the string and the original binary tree.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: root = [1,2,3,4]
 * Output: "1(2(4))(3)"
 * Explanation: Originally, it needs to be "1(2(4)())(3()())", but you need to omit all the unnecessary empty parenthesis pairs. And it will be "1(2(4))(3)"
 * Example 2:
 *
 *
 * Input: root = [1,2,3,null,4]
 * Output: "1(2()(4))(3)"
 * Explanation: Almost the same as the first example, except we cannot omit the first parenthesis pair to break the one-to-one mapping
 * relationship between the input and the output.
 *
 *
 * Constraints:
 *
 * The number of nodes in the tree is in the range [1, 104].
 * -1000 <= Node.val <= 1000
 */

public class L606_ConstructStringFromBinaryTree {
    public String tree2str(TreeNode root) {
        recursion(root);
        return ans.toString();
    }

    StringBuilder ans = new StringBuilder();
    public void recursion(TreeNode root){
        if(root == null){ // base case 1
            return;
        }

        if(root.left == null && root.right == null){ // base case 2
            ans.append(root.val);
            return;
        }

        // doing preorder traversal
        ans.append(root.val);
        ans.append("(");
        recursion(root.left);
        ans.append(")");
        if(root.right != null){// doing right tree traversal only when it is available and left tree need to show with extra bracket
            ans.append("(");
            recursion(root.right);
            ans.append(")");
        }
    }
}
