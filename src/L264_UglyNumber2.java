package src;

/**
 * An ugly number is a positive integer whose prime factors are limited to 2, 3, and 5.
 *
 * Given an integer n, return the nth ugly number.
 *
 *
 *
 * Example 1:
 *
 * Input: n = 10
 * Output: 12
 * Explanation: [1, 2, 3, 4, 5, 6, 8, 9, 10, 12] is the sequence of the first 10 ugly numbers.
 * Example 2:
 *
 * Input: n = 1
 * Output: 1
 * Explanation: 1 has no prime factors, therefore all of its prime factors are limited to 2, 3, and 5.
 *
 *
 * Constraints:
 *
 * 1 <= n <= 1690
 */

public class L264_UglyNumber2 {
    public int nthUglyNumber(int n) {
        int[] dp = new int[n]; // creating a dp array of size n, which keeps the i^th ugly number, where i is the index
        dp[0] = 1; // keeping 1 at 0, bcz 1 is the first ugly number, as given in the statement
        int count2 = 0; // keeping the index count of 2
        int count3 = 0; // keeping the index count of 3
        int count5 = 0; // keeping the index count of 5

        for(int i = 1;i<n;i++){ // iterating from 1 to n-1 to keep the i^th ugly number

            // we know the ugly number will be the only multiple of 2,3 or 5
            // so, we are using the concept, 2,3 0r 5 multiple of previously generated ugly number
            dp[i] = Math.min(dp[count2]*2, Math.min(dp[count3]*3, dp[count5]*5));
            // taking the min of three ugly number generated, so to keep the ugly number generated in accenting order

            // after getting every ugly number, increasing the count of particular 2,3 or 5
            // in some case we will get the multiple of any two or three of 2,3 or 5 same at that time we have to increase the count of those 2,3 or 5
            if(dp[i] == dp[count2]*2){
                count2++;
            }
            if(dp[i] == dp[count3]*3){
                count3++;
            }
            if(dp[i] == dp[count5]*5){
                count5++;
            }
        }

        // returning the nth ugly number
        return dp[n-1];
    }
}
