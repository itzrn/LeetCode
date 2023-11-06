package src;

/**
 * Given the root of a binary search tree (BST) with duplicates, return all the mode(s) (i.e., the most frequently occurred element) in it.
 *
 * If the tree has more than one mode, return them in any order.
 *
 * Assume a BST is defined as follows:
 *
 * The left subtree of a node contains only nodes with keys less than or equal to the node's key.
 * The right subtree of a node contains only nodes with keys greater than or equal to the node's key.
 * Both the left and right subtrees must also be binary search trees.
 *
 *
 * Example 1:
 *
 *
 * Input: root = [1,null,2,2]
 * Output: [2]
 * Example 2:
 *
 * Input: root = [0]
 * Output: [0]
 *
 *
 * Constraints:
 *
 * The number of nodes in the tree is in the range [1, 104].
 * -105 <= Node.val <= 105
 *
 *
 * Follow up: Could you do that without using any extra space? (Assume that the implicit stack space incurred due to recursion does not count).
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class L501_FindModeInBinarySearchTree {

    // approach 1
    public int[] findMode1(TreeNode root) {
        HashMap<Integer,Integer> map = new HashMap<>();
        dfs1(map , root);
        int maxCount = 0;

        for(int nodeVal : map.keySet()){ // calculating the max count
            maxCount = Math.max(maxCount , map.get(nodeVal));
        }
        List<Integer> list = new ArrayList<>();
        for(int nodeVal : map.keySet()){ // taking out all the numbers whose frequency is equal to max count
            if(map.get(nodeVal) == maxCount){
                list.add(nodeVal);
            }
        }
        int[] res = new int[list.size()];
        for(int i=0;i<res.length;i++){
            res[i] = list.get(i);
        }

        return res;
    }

    public void dfs1(HashMap<Integer,Integer> map , TreeNode root){
        if(root == null){
            return;
        }
        map.put(root.val , map.getOrDefault(root.val , 0)+1);
        dfs1(map , root.left);
        dfs1(map , root.right);
    }


    // approach 2: with optimized space
    public int[] findMode(TreeNode root) {
        recursion(root);
        return res.stream().mapToInt(Integer::intValue).toArray();
    }

    int currNum = 0;
    int currFreq = 0;
    int maxFreq = 0;
    List<Integer> res = new ArrayList<>();

    // doing inorder traversal to get the sorted manner of element of BST
    public void recursion(TreeNode root){
        if(root == null){
            return;
        }

        recursion(root.left);

        // condition 1
        if(root.val == currNum){
            currFreq++;
        }else{
            currNum = root.val;
            currFreq = 1;
        }

        // condition 2
        if(currFreq > maxFreq){
            res.clear();
            maxFreq = currFreq;
        }

        // condition 3
        if(currFreq == maxFreq){
            res.add(root.val);
        }

        recursion(root.right);
    }
}
