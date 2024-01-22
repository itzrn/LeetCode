package src;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class L2583_KthLargestSumInABinaryTree {
    public long kthLargestLevelSum(TreeNode root, int k) {
        recursion(root, 0);
        Collections.sort(list);
        int n = list.size();
        if(k > n){
            return -1;
        }
        return list.get(n - k);
    }

    int size = -1;
    List<Long> list = new ArrayList<>();
    public void recursion(TreeNode root, int level){ // doing dfs
        if(root == null){
            return;
        }

        // updating the sum at its level
        if(size == level-1){
            list.add((long)root.val);
        }else{
            list.add(level, list.remove(level) + root.val);
        }

        // updating the size
        size = Math.max(size, level);

        recursion(root.left, level+1);
        recursion(root.right, level+1);
    }
}
