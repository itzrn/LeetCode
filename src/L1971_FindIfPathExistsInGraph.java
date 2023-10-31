package src;

/**
 * There is a bi-directional graph with n vertices, where each vertex is labeled from 0 to n - 1 (inclusive).
 * The edges in the graph are represented as a 2D integer array edges, where each edges[i] = [ui, vi] denotes a
 * bi-directional edge between vertex ui and vertex vi. Every vertex pair is connected by at most one edge, and no vertex has an edge to itself.
 *
 * You want to determine if there is a valid path that exists from vertex source to vertex destination.
 *
 * Given edges and the integers n, source, and destination, return true if there is a valid path from source to destination, or false otherwise.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: n = 3, edges = [[0,1],[1,2],[2,0]], source = 0, destination = 2
 * Output: true
 * Explanation: There are two paths from vertex 0 to vertex 2:
 * - 0 → 1 → 2
 * - 0 → 2
 * Example 2:
 *
 *
 * Input: n = 6, edges = [[0,1],[0,2],[3,5],[5,4],[4,3]], source = 0, destination = 5
 * Output: false
 * Explanation: There is no path from vertex 0 to vertex 5.
 *
 *
 * Constraints:
 *
 * 1 <= n <= 2 * 105
 * 0 <= edges.length <= 2 * 105
 * edges[i].length == 2
 * 0 <= ui, vi <= n - 1
 * ui != vi
 * 0 <= source, destination <= n - 1
 * There are no duplicate edges.
 * There are no self edges.
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class L1971_FindIfPathExistsInGraph {
    Map<Integer, List<Integer>> graph;
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        graph = new HashMap<>();
        buildGraph(edges);
        boolean[] visited = new boolean[n];
        return dfs(source, destination, visited);
    }

    public void buildGraph(int[][] edges){ // used to build the graph
        for(int[] i: edges){
            addEdge(i[0], i[1]);
        }
    }

    public void addEdge(int src, int dest){ // used to add the edge
        if(!graph.containsKey(src)){
            graph.put(src, new ArrayList<>());
        }

        if(!graph.containsKey(dest)){
            graph.put(dest, new ArrayList<>());
        }

        graph.get(src).add(dest);
        graph.get(dest).add(src);
    }

    public boolean dfs(int src, int dest, boolean[] visited){ // this is the dfs traversal
        if(src == dest){
            return true;
        }

        if(visited[src]){
            return false;
        }

        visited[src] = true;
        for(int i:graph.get(src)){
            if(dfs(i, dest, visited)){
                return true;
            }
        }

        return false;
    }
}
