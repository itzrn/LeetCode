package src;

/**
 * The frequency of an element is the number of times it occurs in an array.
 *
 * You are given an integer array nums and an integer k. In one operation, you can choose an index of nums and increment the element at that index by 1.
 *
 * Return the maximum possible frequency of an element after performing at most k operations.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [1,2,4], k = 5
 * Output: 3
 * Explanation: Increment the first element three times and the second element two times to make nums = [4,4,4].
 * 4 has a frequency of 3.
 * Example 2:
 *
 * Input: nums = [1,4,8,13], k = 5
 * Output: 2
 * Explanation: There are multiple optimal solutions:
 * - Increment the first element three times to make nums = [4,4,8,13]. 4 has a frequency of 2.
 * - Increment the second element four times to make nums = [1,8,8,13]. 8 has a frequency of 2.
 * - Increment the third element five times to make nums = [1,4,13,13]. 13 has a frequency of 2.
 * Example 3:
 *
 * Input: nums = [3,9,6], k = 2
 * Output: 1
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 105
 * 1 <= nums[i] <= 105
 * 1 <= k <= 105
 */

import java.util.Arrays;

public class L1838_FrequencyOfTheMostFrequentElement {
    public int maxFrequency(int[] arr, int k) {
        Arrays.sort(arr); // there is the reason behind sorting i.e. we can find all the close number together
        int left = 0;
        int right = 0;
        int max = 0;
        int sum = 0;

        while(right < arr.length){

            // step 1 -> keeping add in the sum.
            sum += arr[right];

            /*
            int temp = arr[right] * (right-left+1) not using this line, bcz if we use temp we won't able to validate the sliding window as sun and left pointer
            changes when we validate the sliding window
             */

            // step 2 -> making the sliding window valid.
            while((arr[right] * (right-left+1))-sum > k){
                sum -= arr[left];
                left++;
            }

            // step 3 -> finding the max between previous max and current length of sliding window.
            max = Math.max(max, right-left+1);

            // step 4 -> increasing the right pointer for upcoming sum.
            right++;
        }

        return max;
    }
}
