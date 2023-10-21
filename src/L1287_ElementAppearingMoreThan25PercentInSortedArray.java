package src;

/**
 * Given an integer array sorted in non-decreasing order,
 * there is exactly one integer in the array that occurs more than 25% of the time, return that integer.
 *
 *
 *
 * Example 1:
 *
 * Input: arr = [1,2,2,6,6,6,6,7,10]
 * Output: 6
 * Example 2:
 *
 * Input: arr = [1,1]
 * Output: 1
 *
 *
 * Constraints:
 *
 * 1 <= arr.length <= 104
 * 0 <= arr[i] <= 105
 */

public class L1287_ElementAppearingMoreThan25PercentInSortedArray {
    public int findSpecialInteger(int[] arr) {
        int count = 1;
        int ans = 0;
        for(int i = 1;i<arr.length;i++){
            if(arr[i] != arr[i-1]){
                if((double)count/arr.length > 0.25){
                    ans = i-1;
                }
                count = 1;
                continue;
            }

            count++;
        }

        if((double)count/arr.length > 0.25){
            return arr[arr.length-1];
        }

        return arr[ans];
    }
}
