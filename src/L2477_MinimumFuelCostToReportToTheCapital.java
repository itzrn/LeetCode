package src;

/**
 * There is a tree (i.e., a connected, undirected graph with no cycles) structure country network consisting of n
 * cities numbered from 0 to n - 1 and exactly n - 1 roads. The capital city is city 0. You are given a 2D integer
 * array roads where roads[i] = [ai, bi] denotes that there exists a bidirectional road connecting cities ai and bi.
 *
 * There is a meeting for the representatives of each city. The meeting is in the capital city.
 *
 * There is a car in each city. You are given an integer seats that indicates the number of seats in each car.
 *
 * A representative can use the car in their city to travel or change the car and ride with another representative.
 * The cost of traveling between two cities is one liter of fuel.
 *
 * Return the minimum number of liters of fuel to reach the capital city.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: roads = [[0,1],[0,2],[0,3]], seats = 5
 * Output: 3
 * Explanation:
 * - Representative1 goes directly to the capital with 1 liter of fuel.
 * - Representative2 goes directly to the capital with 1 liter of fuel.
 * - Representative3 goes directly to the capital with 1 liter of fuel.
 * It costs 3 liters of fuel at minimum.
 * It can be proven that 3 is the minimum number of liters of fuel needed.
 * Example 2:
 *
 *
 * Input: roads = [[3,1],[3,2],[1,0],[0,4],[0,5],[4,6]], seats = 2
 * Output: 7
 * Explanation:
 * - Representative2 goes directly to city 3 with 1 liter of fuel.
 * - Representative2 and representative3 go together to city 1 with 1 liter of fuel.
 * - Representative2 and representative3 go together to the capital with 1 liter of fuel.
 * - Representative1 goes directly to the capital with 1 liter of fuel.
 * - Representative5 goes directly to the capital with 1 liter of fuel.
 * - Representative6 goes directly to city 4 with 1 liter of fuel.
 * - Representative4 and representative6 go together to the capital with 1 liter of fuel.
 * It costs 7 liters of fuel at minimum.
 * It can be proven that 7 is the minimum number of liters of fuel needed.
 * Example 3:
 *
 *
 * Input: roads = [], seats = 1
 * Output: 0
 * Explanation: No representatives need to travel to the capital city.
 *
 *
 * Constraints:
 *
 * 1 <= n <= 105
 * roads.length == n - 1
 * roads[i].length == 2
 * 0 <= ai, bi < n
 * ai != bi
 * roads represents a valid tree.
 * 1 <= seats <= 105
 */

import java.util.ArrayList;

public class L2477_MinimumFuelCostToReportToTheCapital {
    public long minimumFuelCost(int[][] roads, int seats) {
        if(roads.length == 0){
            return 0L;
        }
        int n = roads.length;
        // n+1 is the number of node

        // creating the graph
        ArrayList<Integer>[] graph = new ArrayList[n+1];
        for(int[] i : roads){
            if(graph[i[0]] == null){
                graph[i[0]] = new ArrayList<>();
            }

            if(graph[i[1]] == null){
                graph[i[1]] = new ArrayList<>();
            }

            graph[i[0]].add(i[1]);
            graph[i[1]].add(i[0]);
        }


        boolean[] visited = new boolean[n+1];
        recursion(0, graph, seats, visited);
        return fuel;
    }

    long fuel = 0L;
    public long recursion(int city, ArrayList<Integer>[] graph, int seats, boolean[] visited){ // doing proper dfs, this dfs function is returning number of nodes
        if(visited[city]){ // base case
            return 0;
        }

        visited[city] = true;
        int count = 0;
        for(int i:graph[city]){// here count is calculating the number of nodes at present while backtracking
            count+=recursion(i, graph, seats, visited);
        }
        count++; // this is calculating the present node
        if(city != 0){ // this is the way to calculate the number of fuels till the present node while backtracking
            fuel += count%seats == 0?count/seats:(count/seats)+1;
        }

        return count;
    }
}
