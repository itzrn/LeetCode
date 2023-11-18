package src;

/**
 * Given an array of strings nums containing n unique binary strings each of length n, return a binary string of length n
 * that does not appear in nums. If there are multiple answers, you may return any of them.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = ["01","10"]
 * Output: "11"
 * Explanation: "11" does not appear in nums. "00" would also be correct.
 * Example 2:
 *
 * Input: nums = ["00","01"]
 * Output: "11"
 * Explanation: "11" does not appear in nums. "10" would also be correct.
 * Example 3:
 *
 * Input: nums = ["111","011","001"]
 * Output: "101"
 * Explanation: "101" does not appear in nums. "000", "010", "100", and "110" would also be correct.
 *
 *
 * Constraints:
 *
 * n == nums.length
 * 1 <= n <= 16
 * nums[i].length == n
 * nums[i] is either '0' or '1'.
 * All the strings of nums are unique.
 */

public class L1980_FindUniqueBinaryString {

    // this is called heuristic approach
    public String findDifferentBinaryString(String[] nums) {
        StringBuilder str = new StringBuilder();
        for(int i=0;i<nums.length;i++){ // in this loop we are generating a string which have the opposite binary of nums[i].charAt(i), doing this
            // generating a string which is going to be different from all the string present in the array
            str.append((nums[i].charAt(i) == '1')?'0':'1');
        }
        return str.toString();
    }
}
