package src;

/**
 * There are a total of numCourses courses you have to take, labeled from 0 to numCourses - 1.
 * You are given an array prerequisites where prerequisites[i] = [ai, bi] indicates that you must take course bi first if you want to take course ai.
 *
 * For example, the pair [0, 1], indicates that to take course 0 you have to first take course 1.
 * Return the ordering of courses you should take to finish all courses. If there are many valid answers,
 * return any of them. If it is impossible to finish all courses, return an empty array.
 *
 *
 *
 * Example 1:
 *
 * Input: numCourses = 2, prerequisites = [[1,0]]
 * Output: [0,1]
 * Explanation: There are a total of 2 courses to take. To take course 1 you should have finished course 0. So the correct course order is [0,1].
 * Example 2:
 *
 * Input: numCourses = 4, prerequisites = [[1,0],[2,0],[3,1],[3,2]]
 * Output: [0,2,1,3]
 * Explanation: There are a total of 4 courses to take. To take course 3 you should have finished both courses 1
 * and 2. Both courses 1 and 2 should be taken after you finished course 0.
 * So one correct course order is [0,1,2,3]. Another correct ordering is [0,2,1,3].
 * Example 3:
 *
 * Input: numCourses = 1, prerequisites = []
 * Output: [0]
 *
 *
 * Constraints:
 *
 * 1 <= numCourses <= 2000
 * 0 <= prerequisites.length <= numCourses * (numCourses - 1)
 * prerequisites[i].length == 2
 * 0 <= ai, bi < numCourses
 * ai != bi
 * All the pairs [ai, bi] are distinct.
 */

import java.util.ArrayList;
import java.util.Stack;

public class L210_CourseSchedule2 {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        ArrayList<Integer>[] graph = new ArrayList[numCourses];
        for(int[] i: prerequisites){
            if(graph[i[1]] == null){
                graph[i[1]] = new ArrayList<>();
            }

            graph[i[1]].add(i[0]);
        }

        Stack<Integer> stack = new Stack<>(); // this is used to store the element in the topological sorting order, so its get easy to put the element in the array
        boolean[]visited = new boolean[numCourses];
        for(int i=0; i<numCourses; i++){ // this is for all graph if there is any unconnected graph
            if(!visited[i] && recursion(i, graph, stack, visited, new boolean[numCourses])){
                return new int[]{}; // returning empty array if there is any cycle detected
            }
        }

        // putting all the element in the answer array through popping all the elements form the stack
        int[] ans = new int[numCourses];
        int i=0;
        while(!stack.isEmpty()){
            ans[i] = stack.pop();
            i++;
        }

        return ans;
    }

    // here used dfs + topological sorting + cycle detection in directed graph
    public boolean recursion(int start, ArrayList<Integer>[] graph, Stack<Integer> stack, boolean[] visited, boolean[] inRecursion) {
        // this function is returning boolean value which tells, do any cycle is there in already visited graph
        visited[start] = true;
        inRecursion[start] = true;

        if (graph[start] != null) {
            for (int i : graph[start]) {
                if ((!visited[i] && recursion(i, graph, stack, visited, inRecursion)) || inRecursion[i]) {
                    return true;
                }
            }
        }

        stack.push(start);
        inRecursion[start] = false;
        return false;
    }
}
