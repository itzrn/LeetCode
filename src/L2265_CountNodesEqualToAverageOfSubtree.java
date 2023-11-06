package src;

/**
 * Given the root of a binary tree, return the number of nodes where the value of the node is equal to the average of the values in its subtree.
 *
 * Note:
 *
 * The average of n elements is the sum of the n elements divided by n and rounded down to the nearest integer.
 * A subtree of root is a tree consisting of root and all of its descendants.
 *
 *
 * Example 1:
 *
 *
 * Input: root = [4,8,5,0,1,null,6]
 * Output: 5
 * Explanation:
 * For the node with value 4: The average of its subtree is (4 + 8 + 5 + 0 + 1 + 6) / 6 = 24 / 6 = 4.
 * For the node with value 5: The average of its subtree is (5 + 6) / 2 = 11 / 2 = 5.
 * For the node with value 0: The average of its subtree is 0 / 1 = 0.
 * For the node with value 1: The average of its subtree is 1 / 1 = 1.
 * For the node with value 6: The average of its subtree is 6 / 1 = 6.
 * Example 2:
 *
 *
 * Input: root = [1]
 * Output: 1
 * Explanation: For the node with value 1: The average of its subtree is 1 / 1 = 1.
 *
 *
 * Constraints:
 *
 * The number of nodes in the tree is in the range [1, 1000].
 * 0 <= Node.val <= 1000
 */

// this class is used as we have to store two things for every Node
class L2265_Info {
    int count;
    int sum;
    L2265_Info(int count, int sum){
        this.count = count;
        this.sum = sum;
    }
}

public class L2265_CountNodesEqualToAverageOfSubtree {
    public int averageOfSubtree(TreeNode root) {
        dfs(root);
        return count;
    }

    int count = 0;
    public L2265_Info dfs(TreeNode root){ // following just normal dfs
        if(root == null){
            return new L2265_Info(0,0);
        }
        if(root.left == null && root.right == null){
            count++;
            return new L2265_Info(1, root.val);
        }

        L2265_Info left = dfs(root.left);
        L2265_Info right = dfs(root.right);
        if((left.sum+right.sum+root.val) /(left.count+right.count+1) == root.val){
            count++;
        }
        return new L2265_Info(left.count+right.count+1, left.sum+right.sum+root.val);
    }
}
