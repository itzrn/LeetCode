package src;

/**
 * Given the root of a binary search tree and an integer k, return true if there exist two elements in the BST
 * such that their sum is equal to k, or false otherwise.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: root = [5,3,6,2,4,null,7], k = 9
 * Output: true
 * Example 2:
 *
 *
 * Input: root = [5,3,6,2,4,null,7], k = 28
 * Output: false
 *
 *
 * Constraints:
 *
 * The number of nodes in the tree is in the range [1, 104].
 * -104 <= Node.val <= 104
 * root is guaranteed to be a valid binary search tree.
 * -105 <= k <= 105
 */

import java.util.ArrayList;
import java.util.List;

public class L653_TwoSum2InputIsABST {
    public boolean findTarget(TreeNode root, int k) {
        List<Integer> list = new ArrayList<>();
        inorder(root , list);
        int i = 0;
        int j = list.size()-1;
        while(i<j){
            if(list.get(i) + list.get(j) == k){
                return true;
            }else if(list.get(i) + list.get(j) > k){
                j--;
            }else{
                i++;
            }
        }
        return false;
    }
    public void inorder(TreeNode root , List<Integer> list){
        if(root == null){
            return;
        }
        inorder(root.left,list);
        list.add(root.val);
        inorder(root.right,list);
    }
}
