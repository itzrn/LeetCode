package src;

/**
 * You are given the root of a binary tree with unique values, and an integer start. At minute 0,
 * an infection starts from the node with value start.
 *
 * Each minute, a node becomes infected if:
 *
 * The node is currently uninfected.
 * The node is adjacent to an infected node.
 * Return the number of minutes needed for the entire tree to be infected.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: root = [1,5,3,null,4,10,6,9,2], start = 3
 * Output: 4
 * Explanation: The following nodes are infected during:
 * - Minute 0: Node 3
 * - Minute 1: Nodes 1, 10 and 6
 * - Minute 2: Node 5
 * - Minute 3: Node 4
 * - Minute 4: Nodes 9 and 2
 * It takes 4 minutes for the whole tree to be infected so we return 4.
 * Example 2:
 *
 *
 * Input: root = [1], start = 1
 * Output: 0
 * Explanation: At minute 0, the only node in the tree is infected so we return 0.
 *
 *
 * Constraints:
 *
 * The number of nodes in the tree is in the range [1, 105].
 * 1 <= Node.val <= 105
 * Each node has a unique value.
 * A node with a value of start exists in the tree.
 */

import java.util.*;

public class L2385_AmountOfTimeToBinaryTreeToBeInfected {
    public int amountOfTime(TreeNode root, int start) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        buildGraph(root, map);
        recursion(start, map, new HashSet<>(), 0);
        return count;
    }

    public int buildGraph(TreeNode root, Map<Integer, List<Integer>> map){
        // this is creating undirected graph
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

    int count = 0;
    public void recursion(int start, Map<Integer, List<Integer>> map, Set<Integer> visited, int level){
        // doing dfs, using HashSet bcz its take less time to analyse a node is visited or not
        if(!visited.add(start)){
            return;
        }

        visited.add(start);
        count = Math.max(count, level);
        for(int i: map.get(start)){
            recursion(i, map, visited, level+1);
        }
    }
}
