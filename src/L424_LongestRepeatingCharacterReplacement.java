package src;

/**
 * You are given a string s and an integer k. You can choose any character of the string and change it to
 * any other uppercase English character. You can perform this operation at most k times.
 *
 * Return the length of the longest substring containing the same letter you can get after performing the above operations.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "ABAB", k = 2
 * Output: 4
 * Explanation: Replace the two 'A's with two 'B's or vice versa.
 * Example 2:
 *
 * Input: s = "AABABBA", k = 1
 * Output: 4
 * Explanation: Replace the one 'A' in the middle with 'B' and form "AABBBBA".
 * The substring "BBBB" has the longest repeating letters, which is 4.
 * There may exists other ways to achieve this answer too.
 *
 *
 * Constraints:
 *
 * 1 <= s.length <= 105
 * s consists of only uppercase English letters.
 * 0 <= k <= s.length
 */

public class L424_LongestRepeatingCharacterReplacement {

    // three steps need to solve the sliding window problem
    public int characterReplacement(String s, int k) {
        int max = 0; // use to track the max size of valid sliding
        int right = 0; // using to increase the size of sliding window
        int left = 0; // using to decrease the sliding window
        int[] arr = new int[26]; // use to track the frequency of each character in sliding window
        while(right < s.length()){
            // step 1:
            arr[s.charAt(right) - 65]++; // increase the sliding window and calculate the result at every iteration until the sliding window is in valid state

            // step 2: make sliding window valid
            if(((right - left + 1) - maxFreq(arr)) > k){ // checking the validity of sliding window, at every iteration
                // or we can use while loop to make the invalid character to valid character at once
                arr[s.charAt(left) - 65]--;
                left++;
            }

            // step 3: calculate the result
            max = Math.max(max, right-left+1); // calculating the max value at every iteration;
            right++;
        }
        return max;
    }

    public int maxFreq(int[] arr){ // this is used to calculate the max frequency among the character
        int max = 0;
        for (int j : arr) {
            max = Math.max(max, j);
        }
        return max;
    }
}
