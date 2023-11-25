package src;

/**
 * There is a directed weighted graph that consists of n nodes numbered from 0 to n - 1.
 * The edges of the graph are initially represented by the given array edges where edges[i] = [fromi, toi, edgeCosti] meaning
 * that there is an edge from fromi to toi with the cost edgeCosti.
 *
 * Implement the Graph class:
 *
 * Graph(int n, int[][] edges) initializes the object with n nodes and the given edges.
 * addEdge(int[] edge) adds an edge to the list of edges where edge = [from, to, edgeCost]. It is guaranteed that there is no edge between
 * the two nodes before adding this one.
 * int shortestPath(int node1, int node2) returns the minimum cost of a path from node1 to node2. If no path exists, return -1. The cost of
 * a path is the sum of the costs of the edges in the path.
 *
 *
 * Example 1:
 *
 *
 * Input
 * ["Graph", "shortestPath", "shortestPath", "addEdge", "shortestPath"]
 * [[4, [[0, 2, 5], [0, 1, 2], [1, 2, 1], [3, 0, 3]]], [3, 2], [0, 3], [[1, 3, 4]], [0, 3]]
 * Output
 * [null, 6, -1, null, 6]
 *
 * Explanation
 * Graph g = new Graph(4, [[0, 2, 5], [0, 1, 2], [1, 2, 1], [3, 0, 3]]);
 * g.shortestPath(3, 2); // return 6. The shortest path from 3 to 2 in the first diagram above is 3 -> 0 -> 1 -> 2 with a total cost of 3 + 2 + 1 = 6.
 * g.shortestPath(0, 3); // return -1. There is no path from 0 to 3.
 * g.addEdge([1, 3, 4]); // We add an edge from node 1 to node 3, and we get the second diagram above.
 * g.shortestPath(0, 3); // return 6. The shortest path from 0 to 3 now is 0 -> 1 -> 3 with a total cost of 2 + 4 = 6.
 *
 *
 * Constraints:
 *
 * 1 <= n <= 100
 * 0 <= edges.length <= n * (n - 1)
 * edges[i].length == edge.length == 3
 * 0 <= fromi, toi, from, to, node1, node2 <= n - 1
 * 1 <= edgeCosti, edgeCost <= 106
 * There are no repeated edges and no self-loops in the graph at any point.
 * At most 100 calls will be made for addEdge.
 * At most 100 calls will be made for shortestPath.
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class L2642_DesignGraphWithShortestPathCalculator {
    List<int[]>[] graph;
    PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1]-b[1]);
    int n;

    public L2642_DesignGraphWithShortestPathCalculator(int n, int[][] edges) {
        this.n = n;
        graph = new ArrayList[n];
        for(int i = 0;i<n;i++){
            graph[i] = new ArrayList<>();
        }
        for(int[] i: edges){
            graph[i[0]].add(new int[]{i[1], i[2]});
        }
    }

    public void addEdge(int[] edge) {
        graph[edge[0]].add(new int[]{edge[1], edge[2]});
    }

    public int shortestPath(int node1, int node2) { // this is dijkstra's algo using Priority Queue
        int[] result = new int[this.n];
        Arrays.fill(result, Integer.MAX_VALUE);

        result[node1] = 0;
        pq.offer(new int[]{node1, 0});

        while(!pq.isEmpty()){
            int[] temp = pq.poll();
            for(int[] i:graph[temp[0]]){
                if(temp[1] + i[1] < result[i[0]]){
                    result[i[0]] = temp[1] + i[1];
                    pq.offer(new int[]{i[0], temp[1]+i[1]});
                }
            }
        }

        return result[node2] == Integer.MAX_VALUE?-1:result[node2];
    }
}
