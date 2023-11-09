package src;

/**
 * There are n cities. Some of them are connected, while some are not. If city a is connected directly with city b, and city b is connected directly with city c, then city a is connected indirectly with city c.
 *
 * A province is a group of directly or indirectly connected cities and no other cities outside of the group.
 *
 * You are given an n x n matrix isConnected where isConnected[i][j] = 1 if the ith city and the jth city are directly connected, and isConnected[i][j] = 0 otherwise.
 *
 * Return the total number of provinces.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: isConnected = [[1,1,0],[1,1,0],[0,0,1]]
 * Output: 2
 * Example 2:
 *
 *
 * Input: isConnected = [[1,0,0],[0,1,0],[0,0,1]]
 * Output: 3
 *
 *
 * Constraints:
 *
 * 1 <= n <= 200
 * n == isConnected.length
 * n == isConnected[i].length
 * isConnected[i][j] is 1 or 0.
 * isConnected[i][i] == 1
 * isConnected[i][j] == isConnected[j][i]
 */

public class L547_NumberOfProvinces {
    public int findCircleNum(int[][] isConnected) {
        int count = 0;
        boolean[] visited = new boolean[isConnected.length];
        for(int i =0;i<isConnected.length;i++){
            if(!visited[i]){ // after a dfs traversal if there exist any node unvisited, means we have more provinces to count
                dfs(i, isConnected, visited); // this is responsible to mark all the city of a province true, so we can go for other unmarked provinces
                count++;
            }
        }

        return count;
    }

    public void dfs(int start, int[][] arr, boolean[] visited){ // doing normal dfs
        visited[start] = true;

        for(int i=0;i<arr.length;i++){
            if(!visited[i] && arr[start][i] == 1){
                dfs(i, arr, visited);
            }
        }
    }
}
