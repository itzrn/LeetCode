package src;

/**
 * Given two integer arrays nums1 and nums2, sorted in non-decreasing order, return the minimum integer common to both arrays.
 * If there is no common integer amongst nums1 and nums2, return -1.
 *
 * Note that an integer is said to be common to nums1 and nums2 if both arrays have at least one occurrence of that integer.
 *
 *
 *
 * Example 1:
 *
 * Input: nums1 = [1,2,3], nums2 = [2,4]
 * Output: 2
 * Explanation: The smallest element common to both arrays is 2, so we return 2.
 * Example 2:
 *
 * Input: nums1 = [1,2,3,6], nums2 = [2,3,4,5]
 * Output: 2
 * Explanation: There are two common elements in the array 2 and 3 out of which 2 is the smallest, so 2 is returned.
 *
 *
 * Constraints:
 *
 * 1 <= nums1.length, nums2.length <= 105
 * 1 <= nums1[i], nums2[j] <= 109
 * Both nums1 and nums2 are sorted in non-decreasing order.
 */

import java.util.PriorityQueue;
import java.util.Queue;

public class L2540_MinimumCommonValue {
    public int getCommon(int[] nums1, int[] nums2) {
        Queue<Integer> pq1 = new PriorityQueue<>();
        for(int i:nums1){
            pq1.offer(i);
        }

        Queue<Integer> pq2 = new PriorityQueue<>();
        for(int i:nums2){
            pq2.add(i);
        }

        while(!pq1.isEmpty() && !pq2.isEmpty()){
            int a = pq1.peek();
            int b = pq2.peek();

            if(a == b){
                return a;
            }
            if(a<b){
                pq1.poll();
            }
            if(a>b){
                pq2.poll();
            }
        }

        return -1;
    }


    public int getCommon2(int[] nums1, int[] nums2) {// same concept as above but likhne ka tarika thoda alag ha
        Queue<Integer> pq1 = new PriorityQueue<>();
        for(int i:nums1){
            pq1.offer(i);
        }

        Queue<Integer> pq2 = new PriorityQueue<>();
        for(int i:nums2){
            pq2.add(i);
        }

        while(!pq1.isEmpty() && !pq2.isEmpty()){
            if(pq1.peek().compareTo(pq2.peek()) == 0){
                return pq1.poll();
            }

            if(pq1.peek()<pq2.peek()){
                pq1.poll();
            }

            if(!pq1.isEmpty() && !pq2.isEmpty() && pq1.peek()>pq2.peek()){
                pq2.poll();
            }
        }

        return -1;
    }

    public int getCommon3(int[] nums1, int[] nums2) {
        int i= 0;
        int j = 0;
        while(i <nums1.length && j < nums2.length){
            if(nums1[i] < nums2[j]){
                i++;
            }
            else if(nums1[i] > nums2[j]){
                j++;
            }
            else{
                return nums1[i];
            }
        }
        return -1;
    }
}
