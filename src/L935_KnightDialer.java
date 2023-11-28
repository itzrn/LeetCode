package src;

/**
 * The chess knight has a unique movement, it may move two squares vertically and one square horizontally, or two squares
 * horizontally and one square vertically (with both forming the shape of an L). The possible movements of chess knight are shown in this diagaram:
 *
 * A chess knight can move as indicated in the chess diagram below:
 *
 *
 * We have a chess knight and a phone pad as shown below, the knight can only stand on a numeric cell (i.e. blue cell).
 *
 *
 * Given an integer n, return how many distinct phone numbers of length n we can dial.
 *
 * You are allowed to place the knight on any numeric cell initially and then you should perform n - 1
 * jumps to dial a number of length n. All jumps should be valid knight jumps.
 *
 * As the answer may be very large, return the answer modulo 109 + 7.
 *
 *
 *
 * Example 1:
 *
 * Input: n = 1
 * Output: 10
 * Explanation: We need to dial a number of length 1, so placing the knight over any numeric cell of the 10 cells is sufficient.
 * Example 2:
 *
 * Input: n = 2
 * Output: 20
 * Explanation: All the valid number we can dial are [04, 06, 16, 18, 27, 29, 34, 38, 40, 43, 49, 60, 61, 67, 72, 76, 81, 83, 92, 94]
 * Example 3:
 *
 * Input: n = 3131
 * Output: 136006598
 * Explanation: Please take care of the mod.
 *
 *
 * Constraints:
 *
 * 1 <= n <= 5000
 */

public class L935_KnightDialer {
    int MOD = (int) 1e9 + 7;

    public int knightDialer(int n) {
        int[][] dp = new int[n + 1][10];
        int[][] map = {{4, 6}, {6, 8}, {7, 9}, {4, 8}, {3, 9, 0}, {}, {1, 7, 0}, {2, 6}, {1, 3}, {2, 4}};
        // this is the map which indicates the movement fo knight according to the current position of it

        int sum = 0;
        for(int i = 0;i<10; i++){ // we will calculate all those paths starting from 0 to 9
            sum = (sum + recursion(n-1, i, dp, map)) % MOD;
        }

        return sum;
    }

    public int recursion(int left, int curr, int[][] dp, int[][] map) { // this is normal dp
        if (left == 0) { // when there is no step left to move
            return 1;
        }

        if (dp[left][curr] != 0) { // if with same left step and with same current position is repeated there we will use dp
            return dp[left][curr];
        }

        int sum = 0; // this is sum of all paths possible
        for (int i : map[curr]) { // this is responsible for creating the according to its current position
            sum = (sum + recursion(left - 1, i, dp, map)) % MOD;
        }

        return dp[left][curr] = sum;
    }
}
