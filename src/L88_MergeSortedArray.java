package src;

/**
 * You are given two integer arrays nums1 and nums2, sorted in non-decreasing order, and two integers m and n,
 * representing the number of elements in nums1 and nums2 respectively.
 *
 * Merge nums1 and nums2 into a single array sorted in non-decreasing order.
 *
 * The final sorted array should not be returned by the function, but instead be stored inside the array nums1.
 * To accommodate this, nums1 has a length of m + n, where the first m elements denote the elements that should be
 * merged, and the last n elements are set to 0 and should be ignored. nums2 has a length of n.
 */

public class L88_MergeSortedArray {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int idx1 = 0; //tracking the index of first array
        int idx2 = 0; // tracking the index of second array
        int x = 0; // tracking the index of nums

        int[] nums = new int[nums1.length];

        while(idx1<=m-1 && idx2<=n-1){  // after getting wrong to this condition, 3 condition can arise
            // 1->all the element got sorted, no need to go in any of the while loop bellow
            // 2->if some sorted element left in the nums1 array, means the left elements are sorted and greater than all the element kept till now in the nums array and just need to be copied in the nums array which will get copied in 1st upcoming while loop
            // 3->if some sorted element left in the nums2 array, means the left elements are sorted and greater than all the element kept till now in the nums array and just need to be copied in the nums array which will get copied in 2nd upcoming while loop
            if(nums1[idx1]<nums2[idx2]){  // comparing and putting the smallest value to the nums array
                nums[x] = nums1[idx1];
                x++;
                idx1++;
            }else{
                nums[x] = nums2[idx2];
                x++;
                idx2++;
            }
        }

        while(idx1<=m-1){  // this loop is for, let first array is still left with some element
            nums[x] = nums1[idx1];
            x++;
            idx1++;
        }

        while(idx2<=n-1){ // this loop is for, let second array is still left with some element
            nums[x] = nums2[idx2];
            x++;
            idx2++;
        }

        for(int i=0;i<nums.length;i++){  //copying the nums element in our nums1 array
            nums1[i] = nums[i];
        }
    }
}
