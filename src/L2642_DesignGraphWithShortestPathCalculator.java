package src;

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
