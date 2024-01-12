package src;

/**
 * Given the root of a binary tree, find the maximum value v for which there exist different nodes a and b where v = |a.val - b.val| and a is an ancestor of b.
 *
 * A node a is an ancestor of b if either: any child of a is equal to b or any child of a is an ancestor of b.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: root = [8,3,10,1,6,null,14,null,null,4,7,13]
 * Output: 7
 * Explanation: We have various ancestor-node differences, some of which are given below :
 * |8 - 3| = 5
 * |3 - 7| = 4
 * |8 - 1| = 7
 * |10 - 13| = 3
 * Among all possible differences, the maximum value of 7 is obtained by |8 - 1| = 7.
 * Example 2:
 *
 *
 * Input: root = [1,null,2,null,0,3]
 * Output: 3
 *
 *
 * Constraints:
 *
 * The number of nodes in the tree is in the range [2, 5000].
 * 0 <= Node.val <= 105
 */

public class L1026_MaximumDifferenceBetweenNodeAndAncestor {
    public int maxAncestorDiff(TreeNode root) {
        int[] arr = recursion(root);
        return max;
    }
    int max = 0;
    public int[] recursion(TreeNode root){ // taking out minimum and maximum value from each right and left subtree of node and find the max difference possible
        if(root == null){
            return new int[]{Integer.MAX_VALUE, Integer.MIN_VALUE};
        }

        int[] left = recursion(root.left);
        int[] right = recursion(root.right);

        // checking these conditions before the comparison for max, bcz difference between root value and integer max or min value will get high, which we don't want
        if(left[0] != Integer.MAX_VALUE){
            max = Math.max(max, Math.abs(left[0]-root.val));
        }

        if(left[1] != Integer.MIN_VALUE){
            max = Math.max(max, Math.abs(left[1]-root.val));
        }

        if(right[0] != Integer.MAX_VALUE){
            max = Math.max(max, Math.abs(right[0]-root.val));
        }

        if(right[1] != Integer.MIN_VALUE){
            max = Math.max(max, Math.abs(right[1]-root.val));
        }

        // returning the left minimum value and right maximum value
        return new int[]{Math.min(left[0], Math.min(right[0], root.val)), Math.max(left[1], Math.max(right[1], root.val))};
    }
}
