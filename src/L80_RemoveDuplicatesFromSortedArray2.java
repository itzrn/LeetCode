package src;

/**
 * Given an integer array nums sorted in non-decreasing order, remove some duplicates in-place such that each unique element appears at most twice. The relative order of the elements should be kept the same.
 *
 * Since it is impossible to change the length of the array in some languages, you must instead have the result be placed in the first part of the array nums. More formally, if there are k elements after removing the duplicates, then the first k elements of nums should hold the final result. It does not matter what you leave beyond the first k elements.
 *
 * Return k after placing the final result in the first k slots of nums.
 *
 * Do not allocate extra space for another array. You must do this by modifying the input array in-place with O(1) extra memory.
 *
 * Custom Judge:
 *
 * The judge will test your solution with the following code:
 *
 * int[] nums = [...]; // Input array
 * int[] expectedNums = [...]; // The expected answer with correct length
 *
 * int k = removeDuplicates(nums); // Calls your implementation
 *
 * assert k == expectedNums.length;
 * for (int i = 0; i < k; i++) {
 *     assert nums[i] == expectedNums[i];
 * }
 * If all assertions pass, then your solution will be accepted.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [1,1,1,2,2,3]
 * Output: 5, nums = [1,1,2,2,3,_]
 * Explanation: Your function should return k = 5, with the first five elements of nums being 1, 1, 2, 2 and 3 respectively.
 * It does not matter what you leave beyond the returned k (hence they are underscores).
 * Example 2:
 *
 * Input: nums = [0,0,1,1,1,1,2,3,3]
 * Output: 7, nums = [0,0,1,1,2,3,3,_,_]
 * Explanation: Your function should return k = 7, with the first seven elements of nums being 0, 0, 1, 1, 2, 3 and 3 respectively.
 * It does not matter what you leave beyond the returned k (hence they are underscores).
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 3 * 104
 * -104 <= nums[i] <= 104
 * nums is sorted in non-decreasing order.
 */

/*
Approach ->
    * as we have to keep the count of each element as 1 or 2 or atmost 2, so keeping count variable to count element
    if there are more than 2 count of an element then selecting out the 2 count of that element and after passing the remaining duplicates, when nums[left] != num[right],
    gets true then starting the same process for upcoming new element
 */
public class L80_RemoveDuplicatesFromSortedArray2 {
    public int removeDuplicates(int[] nums) {
        int left = 0;
        int right = 1;
        int count = 1;// taking count as 1 initial, bcz if an element is present means, its initial count is 1
        while (right<nums.length){ // iterating through whole array
            if(count < 2 && nums[left] == nums[right]){
                count++;

                // here ++left -> making the space for the upcoming element and adding second occurrence of element
                nums[++left] = nums[right];
            }
            if(nums[left] != nums[right]){

                // / here ++left -> making the space for the upcoming element and adding first occurrence of new element
                nums[++left] = nums[right];
                count = 1; // re-starting the count
            }

            right++;
        }
        return left+1;
    }


    // another approach
    public int removeDuplicates2(int[] nums) {
        int j = 2;
        for(int i=j;i<nums.length;i++){
            if(nums[i] != nums[j-2]){
                nums[j++] = nums[i];
            }
        }
        return j;
    }
}
