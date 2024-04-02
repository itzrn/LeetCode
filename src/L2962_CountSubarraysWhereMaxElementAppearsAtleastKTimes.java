package src;

/**
 * You are given an integer array nums and a positive integer k.
 *
 * Return the number of subarrays where the maximum element of nums appears at least k times in that subarray.
 *
 * A subarray is a contiguous sequence of elements within an array.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [1,3,2,3,3], k = 2
 * Output: 6
 * Explanation: The subarrays that contain the element 3 at least 2 times are: [1,3,2,3], [1,3,2,3,3], [3,2,3], [3,2,3,3], [2,3,3] and [3,3].
 * Example 2:
 *
 * Input: nums = [1,4,2,1], k = 3
 * Output: 0
 * Explanation: No subarray contains the element 4 at least 3 times.
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 105
 * 1 <= nums[i] <= 106
 * 1 <= k <= 105
 */

public class L2962_CountSubarraysWhereMaxElementAppearsAtleastKTimes {
    public long countSubarrays(int[] arr, int k) {
        int max = 0;
        for(int i:arr){ // find the max of the array
            max= Math.max(max, i);
        }

        long count = 0; // used to count the number of sub-array possible
        int left = 0;
        for(int i = 0; i<arr.length; i++){
            if(arr[i] == max){
                k--;
            }
            /*
            approach -
            looking at present index counting all the sub-array if possible till now on the basis of past traversed index
             */
            while(k == 0){
                if(arr[left] == max){
                    k++;
                }
                left++;
            }

            count += left;
        }

        return count;
    }
}
