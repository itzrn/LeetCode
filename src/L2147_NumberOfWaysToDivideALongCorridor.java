package src;

/**
 * Along a long library corridor, there is a line of seats and decorative plants. You are given a 0-indexed string corridor
 * of length n consisting of letters 'S' and 'P' where each 'S' represents a seat and each 'P' represents a plant.
 *
 * One room divider has already been installed to the left of index 0, and another to the right of index n - 1. Additional
 * room dividers can be installed. For each position between indices i - 1 and i (1 <= i <= n - 1), at most one divider can be installed.
 *
 * Divide the corridor into non-overlapping sections, where each section has exactly two seats with any number of plants.
 * There may be multiple ways to perform the division. Two ways are different if there is a position with a room divider
 * installed in the first way but not in the second way.
 *
 * Return the number of ways to divide the corridor. Since the answer may be very large, return it modulo 109 + 7. If there is no way, return 0.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: corridor = "SSPPSPS"
 * Output: 3
 * Explanation: There are 3 different ways to divide the corridor.
 * The black bars in the above image indicate the two room dividers already installed.
 * Note that in each of the ways, each section has exactly two seats.
 * Example 2:
 *
 *
 * Input: corridor = "PPSPSP"
 * Output: 1
 * Explanation: There is only 1 way to divide the corridor, by not installing any additional dividers.
 * Installing any would create some section that does not have exactly two seats.
 * Example 3:
 *
 *
 * Input: corridor = "S"
 * Output: 0
 * Explanation: There is no way to divide the corridor because there will always be a section that does not have exactly two seats.
 *
 *
 * Constraints:
 *
 * n == corridor.length
 * 1 <= n <= 105
 * corridor[i] is either 'S' or 'P'.
 */

public class L2147_NumberOfWaysToDivideALongCorridor {
    /*
    this is just like a que
    like A to B have 2 roots and B to C have 3 roots
    then how many roots are possible from A to C?

    ans -> 2*3 = 6
     */

    public int numberOfWays(String corridor) {
        long dp = 1; // so here the dp is a variable
        char[] arr = corridor.toCharArray();
        int mod = 1000000007;
        int n = arr.length;
        int i = 0;
        while(i<n){
            int countSeat = 0;
            // this is used to calculate 2 number of sets in a section (like in above given example this point is just like the connection between A and C i.e. B)
            while(i<n && countSeat < 2){
                if(arr[i] == 'S'){
                    countSeat++;
                }
                i++;
            }


            if(countSeat < 2){ // if this condition gets true means there is a section where there is not exactly 2 seats
                return 0;
            }

            long divInd = 1;
            while(i<n && arr[i] != 'S'){ // this is used to calculate where a divider can be placed
                divInd++;
                i++;
            }

            if(i<n){
                dp =(dp*divInd)%mod; // calculating ans
            }
        }

        return (int)(dp%mod);
    }
}
