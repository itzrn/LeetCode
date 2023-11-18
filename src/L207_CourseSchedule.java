package src;

/**
 * There are a total of numCourses courses you have to take, labeled from 0 to numCourses - 1. You are given an array prerequisites
 * where prerequisites[i] = [ai, bi] indicates that you must take course bi first if you want to take course ai.
 *
 * For example, the pair [0, 1], indicates that to take course 0 you have to first take course 1.
 * Return true if you can finish all courses. Otherwise, return false.
 *
 *
 *
 * Example 1:
 *
 * Input: numCourses = 2, prerequisites = [[1,0]]
 * Output: true
 * Explanation: There are a total of 2 courses to take.
 * To take course 1 you should have finished course 0. So it is possible.
 * Example 2:
 *
 * Input: numCourses = 2, prerequisites = [[1,0],[0,1]]
 * Output: false
 * Explanation: There are a total of 2 courses to take.
 * To take course 1 you should have finished course 0, and to take course 0 you should also have finished course 1. So it is impossible.
 *
 *
 * Constraints:
 *
 * 1 <= numCourses <= 2000
 * 0 <= prerequisites.length <= 5000
 * prerequisites[i].length == 2
 * 0 <= ai, bi < numCourses
 * All the pairs prerequisites[i] are unique.
 */

import java.util.*;

public class L207_CourseSchedule {
    public boolean canFinish(int courses, int[][] arrPre) {
        if(arrPre.length == 0){
            return true;
        }

        Map<Integer, List<Integer>> graph = new HashMap<>(); // building the directed graph of n nodes according the question
        boolean[] visited = new boolean[courses];
        boolean[] inCurrDfs = new boolean[courses];

        for(int[] i : arrPre){
            if(!graph.containsKey(i[1])){
                graph.put(i[1], new ArrayList<>());
            }

            if(!graph.containsKey(i[0])){
                graph.put(i[0], new ArrayList<>());
            }

            graph.get(i[1]).add(i[0]);
        }

        for(int i : graph.keySet()){
            if(!visited[i] && dfs(i, graph, visited, inCurrDfs)){ // if cycle present in the graph, then the particular graph is not compatible for course scheduling
                return false;
            }
        }

        return true;
    }


    public boolean dfs(int start, Map<Integer, List<Integer>> graph, boolean[] visited, boolean[] inCurrDfs){ // normal dfs, finding a cycle in whole graph
        visited[start] = true;
        inCurrDfs[start] = true;

        for(int i:graph.get(start)){
            if((!visited[i] && dfs(i, graph, visited, inCurrDfs)) || inCurrDfs[i]){
                return true;
            }
        }

        inCurrDfs[start] = false;
        return false;
    }

    // another approach using khan's Algo
    public boolean canFinish2(int numCourses, int[][] prerequisites) {
        List<Integer>[] graph = new ArrayList[numCourses];
        int[] inDegree = new int[numCourses];


        // building graph
        for(int[] i : prerequisites){
            if(graph[i[1]] == null){
                graph[i[1]] = new ArrayList<>();
            }

            graph[i[1]].add(i[0]);
            inDegree[i[0]]++;
        }

        return khansAlgo(graph, inDegree, numCourses);
    }


    public boolean khansAlgo(List<Integer>[] graph, int[] inDegree, int n){ // used Khan's Algo bcz, This algo give works when graph contains no cycle
        //topological sort
        Queue<Integer> queue = new LinkedList<>();
        int count = 0;
        for(int i=0;i< n;i++){
            if(inDegree[i] == 0){
                queue.offer(i);
                count++;
            }
        }

        while(!queue.isEmpty()){
            int temp = queue.poll();
            for(int i = 0; graph[temp]!=null && i<graph[temp].size();i++){
                inDegree[graph[temp].get(i)]--;
                if(inDegree[graph[temp].get(i)] == 0){
                    queue.offer(graph[temp].get(i));
                    count++;
                }
            }
        }

        return count == n;
    }
}
