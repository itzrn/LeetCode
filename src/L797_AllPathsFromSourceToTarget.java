package src;

/**
 * Given a directed acyclic graph (DAG) of n nodes labeled from 0 to n - 1, find all possible paths from node 0 to node n - 1 and return them in any order.
 *
 * The graph is given as follows: graph[i] is a list of all nodes you can visit from node i (i.e., there is a directed edge from node i to node graph[i][j]).
 *
 *
 *
 * Example 1:
 *
 *
 * Input: graph = [[1,2],[3],[3],[]]
 * Output: [[0,1,3],[0,2,3]]
 * Explanation: There are two paths: 0 -> 1 -> 3 and 0 -> 2 -> 3.
 * Example 2:
 *
 *
 * Input: graph = [[4,3,1],[3,2,4],[3],[4],[]]
 * Output: [[0,4],[0,3,4],[0,1,3,4],[0,1,2,3,4],[0,1,4]]
 *
 *
 * Constraints:
 *
 * n == graph.length
 * 2 <= n <= 15
 * 0 <= graph[i][j] < n
 * graph[i][j] != i (i.e., there will be no self-loops).
 * All the elements of graph[i] are unique.
 * The input graph is guaranteed to be a DAG.
 */

import java.util.ArrayList;
import java.util.List;

public class L797_AllPathsFromSourceToTarget {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        list.add(0);
        dfs(graph, 0, new boolean[graph.length], graph.length-1);
        return res;
    }

    List<List<Integer>> res = new ArrayList<>();
    List<Integer> list = new ArrayList<>();
    public void dfs(int[][] graph, int start, boolean[] visited, int target){
        if(visited[start]){
            return;
        }

        if(start == target){
            res.add(new ArrayList<>(list));
            return;
        }

        visited[start] = true;
        for(int i:graph[start]){
            list.add(i);
            dfs(graph, i, visited, target);
            list.remove(list.size()-1);
        }
        visited[start] = false;
    }

    // without using visited array
    public List<List<Integer>> allPathsSourceTarget2(int[][] graph) {
        list.add(0);
        dfs(graph, 0, graph.length-1);
        return res;
    }

//    List<List<Integer>> res = new ArrayList<>();
//    List<Integer> list = new ArrayList<>();
    public void dfs(int[][] graph, int start, int target){

        if(start == target){
            res.add(new ArrayList<>(list));
            return;
        }

        for(int i:graph[start]){
            list.add(i);
            dfs(graph, i, target);
            list.remove(list.size()-1);
        }
    }
}
