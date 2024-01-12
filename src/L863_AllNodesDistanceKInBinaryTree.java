package src;

/**
 * Given the root of a binary tree, the value of a target node target, and an integer k,
 * return an array of the values of all nodes that have a distance k from the target node.
 *
 * You can return the answer in any order.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: root = [3,5,1,6,2,0,8,null,null,7,4], target = 5, k = 2
 * Output: [7,4,1]
 * Explanation: The nodes that are a distance 2 from the target node (with value 5) have values 7, 4, and 1.
 * Example 2:
 *
 * Input: root = [1], target = 1, k = 3
 * Output: []
 *
 *
 * Constraints:
 *
 * The number of nodes in the tree is in the range [1, 500].
 * 0 <= Node.val <= 500
 * All the values Node.val are unique.
 * target is the value of one of the nodes in the tree.
 * 0 <= k <= 1000
 */

import java.util.*;

public class L863_AllNodesDistanceKInBinaryTree {
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        buildGraph(root, map);
        recursion(target.val, map, new HashSet<>(), k);
        return list;
    }

    public int buildGraph(TreeNode root, Map<Integer, List<Integer>> map){ // building undirected graph using map
        if(root == null){
            return 0;
        }

        int left = buildGraph(root.left, map);
        int right = buildGraph(root.right, map);

        if(!map.containsKey(root.val)){
            map.put(root.val, new ArrayList<>());
        }

        if(left != 0){
            if(!map.containsKey(left)){
                map.put(left, new ArrayList<>());
            }
            map.get(left).add(root.val);
            map.get(root.val).add(left);
        }

        if(right != 0){
            if(!map.containsKey(right)){
                map.put(right, new ArrayList<>());
            }
            map.get(right).add(root.val);
            map.get(root.val).add(right);
        }

        return root.val;
    }

    List<Integer> list = new ArrayList<>();
    public void recursion(int start, Map<Integer, List<Integer>> map, Set<Integer> visited, int level){ // making dfs call
        if(!visited.add(start)){
            return;
        }

        if(level == 0){
            list.add(start);
        }

        for(int i:map.get(start)){
            recursion(i, map, visited, level-1);
        }
    }
}
