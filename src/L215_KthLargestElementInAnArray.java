package src;

/**
 * Given an integer array nums and an integer k, return the kth largest element in the array.
 *
 * Note that it is the kth largest element in the sorted order, not the kth distinct element.
 *
 * Can you solve it without sorting?
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [3,2,1,5,6,4], k = 2
 * Output: 5
 * Example 2:
 *
 * Input: nums = [3,2,3,1,2,4,5,5,6], k = 4
 * Output: 4
 */

import java.util.PriorityQueue;

public class L215_KthLargestElementInAnArray {

    public int findKthLargestUsingPriorityQueue(int[] nums, int k) { // takes 56ms to pass all the test casess
        // here using max heap
        PriorityQueue<Integer> dp = new PriorityQueue<>();
        for(int  i = 0;i<nums.length;i++){
            dp.add(-nums[i]); // adding element in negative, to perform maxheap
        }

        int res = 0;
        for(int i = 0;i<k;i++){
            res = dp.remove();
        }

        return -res;
    }

    public  int findKthLargestUsingQuickSort(int[] nums, int k){ // takes 96ms to pass all the test cases
        quickSort(nums, 0, nums.length-1);
        return nums[k-1];
    }

     public void quickSort(int[] arr, int low, int high){
         if(low<high){
             int pivot = partition(arr, low, high);
             quickSort(arr, low, pivot-1);
             quickSort(arr, pivot+1, high);
         }
     }

     public int partition(int[] arr, int low, int high){
         int i = high+1;
         for(int j = high;j>low;j--){
             if(arr[low]>arr[j]){
                 i--;
                 int temp = arr[i];
                 arr[i] = arr[j];
                 arr[j] = temp;
             }
         }
         i--;
         int temp = arr[i];
         arr[i] = arr[low];
         arr[low] = temp;
         return i;
     }
}
