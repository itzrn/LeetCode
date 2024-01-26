package src;

/**
 * You are given the root of a binary tree with n nodes where each node in the tree has node.val coins.
 * There are n coins in total throughout the whole tree.
 *
 * In one move, we may choose two adjacent nodes and move one coin from one node to another.
 * A move may be from parent to child, or from child to parent.
 *
 * Return the minimum number of moves required to make every node have exactly one coin.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: root = [3,0,0]
 * Output: 2
 * Explanation: From the root of the tree, we move one coin to its left child, and one coin to its right child.
 * Example 2:
 *
 *
 * Input: root = [0,3,0]
 * Output: 3
 * Explanation: From the left child of the root, we move two coins to the root [taking two moves].
 * Then, we move one coin from the root of the tree to the right child.
 *
 *
 * Constraints:
 *
 * The number of nodes in the tree is n.
 * 1 <= n <= 100
 * 0 <= Node.val <= n
 * The sum of all Node.val is n.
 */

public class L979_DistributeCoinsInBinaryTree {
    public int distributeCoins(TreeNode root) {
        recursion(root);
        return count;

    }

    int count = 0;

    // doing normal dfs
    // here the approach is like first to collect the number of coins needed by left and right subtree of the node
    // if the coins needed by the subtree(left or right) is negative means that subtree is in the deficiency of that particular number of coins and this amount of coins is need to be added in the count as we need the movement of that particular number of coins to fulfil the deficiency
    // and if the coins needed by the subtree(left or right) is positive means that particular number of coins is additional which is need to shift to other subtree and this amount of coins is need to be added in the count as we need the movement of that particular number of coins

    // -n means the subtree have n fewer coins
    // +n means the subtree have n more coins
    public int recursion(TreeNode root){
        if(root == null){
            return 0;
        }

        int left = recursion(root.left);
        int right = recursion(root.right);

        root.val += left+right;

        /*
        when left or right < 0
        then its need to multiply with -1 and then add to count for the movement count
         */

        count += left >= 0?left:-1*left;
        count += right >= 0?right:-1*right;

        return root.val-1;
    }
}
