package src;

/**
 * No-Zero integer is a positive integer that does not contain any 0 in its decimal representation.
 *
 * Given an integer n, return a list of two integers [a, b] where:
 *
 * a and b are No-Zero integers.
 * a + b = n
 * The test cases are generated so that there is at least one valid solution. If there are many valid solutions, you can return any of them.
 *
 *
 *
 * Example 1:
 *
 * Input: n = 2
 * Output: [1,1]
 * Explanation: Let a = 1 and b = 1.
 * Both a and b are no-zero integers, and a + b = 2 = n.
 * Example 2:
 *
 * Input: n = 11
 * Output: [2,9]
 * Explanation: Let a = 2 and b = 9.
 * Both a and b are no-zero integers, and a + b = 9 = n.
 * Note that there are other valid answers as [8, 3] that can be accepted.
 *
 *
 * Constraints:
 *
 * 2 <= n <= 104
 */

public class L1317_ConvertIntegerToTheSumOfTwoNoZeroIntegers {
    public int[] getNoZeroIntegers(int n) {
        for (int i = 1; i < n; i++) {
            if (check(n-i) && check(i)) { // checking if the partitioned two element have zero in it or not, if both won't have then return those two number in array
                return new int[]{n-i, i};
            }
        }
        return null;
    }

    public boolean check(int m) {
        while (m > 0) {
            if (m % 10 == 0) {
                return false;
            }
            m /= 10;
        }
        return true;
    }
}
