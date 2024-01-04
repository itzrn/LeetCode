package src;

/**
 * Given the root of a binary tree with unique values and the values of two different nodes of the tree x and y,
 * return true if the nodes corresponding to the values x and y in the tree are cousins, or false otherwise.
 *
 * Two nodes of a binary tree are cousins if they have the same depth with different parents.
 *
 * Note that in a binary tree, the root node is at the depth 0, and children of each depth k node are at the depth k + 1.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: root = [1,2,3,4], x = 4, y = 3
 * Output: false
 * Example 2:
 *
 *
 * Input: root = [1,2,3,null,4,null,5], x = 5, y = 4
 * Output: true
 * Example 3:
 *
 *
 * Input: root = [1,2,3,null,4], x = 2, y = 3
 * Output: false
 *
 *
 * Constraints:
 *
 * The number of nodes in the tree is in the range [2, 100].
 * 1 <= Node.val <= 100
 * Each node has a unique value.
 * x != y
 * x and y are exist in the tree.
 */

public class L993_CousinsInBinaryTree {
    public boolean isCousins(TreeNode root, int x, int y) {
        recursion(root, x, y, 0);
        return ans == 0 && a != b;
    }

    int ans = 0; // this is used to identify the depth, mean if we add and subtract the same level depth then 'ans' will remain 0
    int a = 0, b=0; // this is used to collect parent node of x nad y
    public boolean recursion(TreeNode root, int x, int y, int level){
        if(root == null){
            return false;
        }
        if(root.val == x){
            ans += level;
            return true;
        }
        if(root.val == y){
            ans -= level;
            return true;
        }

        // doing dfs
        boolean left = recursion(root.left, x, y, level+1);
        boolean right = recursion(root.right, x, y, level+1);
        if(left && a == 0){
            a = root.val;
        }

        if(right && b == 0){
            b = root.val;
        }
        return left || right;
    }
}
