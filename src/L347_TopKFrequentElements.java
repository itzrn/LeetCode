package src;

/**
 * Given an integer array nums and an integer k, return the k most frequent elements. You may return the answer in any order.
 *
 * Example 1:
 *
 * Input: nums = [1,1,1,2,2,3], k = 2
 * Output: [1,2]
 * Example 2:
 *
 * Input: nums = [1], k = 1
 * Output: [1]
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 105
 * -104 <= nums[i] <= 104
 * k is in the range [1, the number of unique elements in the array].
 * It is guaranteed that the answer is unique.
 *
 *
 * Follow up: Your algorithm's time complexity must be better than O(n log n), where n is the array's size.
 */

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class L347_TopKFrequentElements {
    public int[] topKFrequent(int[] nums, int k) {
        if(k == nums.length){ // this base case says, that if the nums.length is equal to k,
            // means there are nums.length number of unique number, means all the number in the nums is unique
            return nums;
        }
        HashMap<Integer,Integer> dp = new HashMap<>();
        for(int i = 0;i<nums.length;i++){ // this is a way to count the number of repeatead elements in a array
            dp.put(nums[i],dp.getOrDefault(nums[i],0)+1);
        }

        int[][] arr= new int[dp.size()][2]; // creating a 2D array to keep the key value pair in it, and to make sorting feasible on the basis of value
        int j = 0;
        for(int i:dp.keySet()){ // keeping all the key value pairs in 2D array
            arr[j][0] = i;
            arr[j][1] = dp.get(i);
            j++;
        }
        quickSort(arr,0,arr.length-1); // sorting the 2D array on the basis of [i][1] -> which contains the count of each unique number present

        int[] res = new int[k]; // creating 1D array to keep the top k frequent number

        for(int i = 0;i<k;i++){ // keeping all the top k frequent number in the result array
            res[i] = arr[i][0];
        }
        return res;
    }

    public void quickSort(int[][] arr, int low, int high){ // doing quick sort of 2D array on the basis of [i][1] index
        if(low < high){
            int pivot = partition(arr, low, high);
            quickSort(arr,low,pivot-1);
            quickSort(arr, pivot+1,high);
        }
    }

    public int partition(int[][] arr, int low, int high){
        int i = low-1;
        for(int j = low;j<high;j++){
            if(arr[j][1] > arr[high][1]){
                i++;
                int[] temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        i++;
        int[] temp = arr[i];
        arr[i] = arr[high];
        arr[high] = temp;
        return i;
    }



    // using priorityQueue
    public int[] topKFrequent1(int[] nums, int k) {
        Map<Integer, int[]> map = new HashMap<>();

        for(int i:nums){
            if(!map.containsKey(i)){
                map.put(i, new int[]{i, 0});
            }
            map.get(i)[1]++;
        }

        Queue<int[]> pq = new PriorityQueue<>((a, b)->b[1]-a[1]);
        pq.addAll(map.values());

        int[] ans = new int[k];
        int i = 0;
        while(i<k){
            assert !pq.isEmpty();
            ans[i] = pq.poll()[0];
            i++;
        }

        return ans;
    }
}
