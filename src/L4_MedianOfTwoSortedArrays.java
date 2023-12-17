package src;

/**
 * Given two sorted arrays nums1 and nums2 of size m and n respectively, return the median of the two sorted arrays.
 *
 * The overall run time complexity should be O(log (m+n)).
 *
 *
 *
 * Example 1:
 *
 * Input: nums1 = [1,3], nums2 = [2]
 * Output: 2.00000
 * Explanation: merged array = [1,2,3] and median is 2.
 * Example 2:
 *
 * Input: nums1 = [1,2], nums2 = [3,4]
 * Output: 2.50000
 * Explanation: merged array = [1,2,3,4] and median is (2 + 3) / 2 = 2.5.
 *
 *
 * Constraints:
 *
 * nums1.length == m
 * nums2.length == n
 * 0 <= m <= 1000
 * 0 <= n <= 1000
 * 1 <= m + n <= 2000
 * -106 <= nums1[i], nums2[i] <= 106
 */

public class L4_MedianOfTwoSortedArrays {
    public int[] mergeTwoSortedArray(int[] array1, int[] array2){
        int[] mergedArray = new int[array1.length + array2.length];
        int i = 0;
        int j = 0;
        int k = 0;

        while (i < array1.length && j < array2.length){
            if(array1[i] < array2[j]){
                mergedArray[k] = array1[i];
                i++;
            }else{
                mergedArray[k] = array2[j];
                j++;
            }
            k++;
        }

        while(i < array1.length){
            mergedArray[k] = array1[i];
            k++;
            i++;
        }

        while(j < array2.length){
            mergedArray[k] = array2[j];
            k++;
            j++;
        }
        return mergedArray;
    }


    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] array = mergeTwoSortedArray(nums1, nums2);
        if((array.length % 2) == 0 ){
            return (double) (array[(array.length/2)-1] + array[array.length/2])/2;
        }else{
            return array[array.length/2];
        }
    }
}
