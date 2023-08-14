package src;

/*
Given an array nums containing n distinct numbers in the range [0, n], return the only number in the range that is missing from the array.
 */
public class L268_MissingNumber {
    public int missingNumber(int[] nums) {
        /*
        as we know we have to calculate the missing number between 0 to n.
        we can use the approach -> taking sum of sll the element of the array and subtract it from sum of  first n natural numbers.
         */
        int totalSum = nums.length*(nums.length+1)/2;
        int sum = 0;
        for(int i = 0;i<nums.length;i++){
            sum = sum + nums[i];
        }

        return totalSum - sum;
    }
}
