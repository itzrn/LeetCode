package src;

import java.util.Arrays;

public class L213_HouseRobber2 {
    public int rob(int[] nums) {
        if(nums.length == 1){ // base case
            return nums[0];
        }

        if(nums.length == 2){ // base case
            return Math.max(nums[0], nums[1]);
        }

        int[] dp = new int[nums.length];
        Arrays.fill(dp, -1);
        int a = recursion(nums, dp, 0, nums.length-2);
        Arrays.fill(dp, -1);
        int b = recursion(nums, dp, 1, nums.length-1);
        int c = 0;
        if(nums[2] > nums[1]){ // this case is special when all the elements of the array is in increasing order
            // which means at this case, the starting large element which is at 2 index, which this index is not getting add
            Arrays.fill(dp, -1);
            c = recursion(nums,dp,2,nums.length-1);
        }
        return Math.max(Math.max(a,b), c);
    }

    public int recursion(int[] arr, int[] dp, int start, int last){
        if(dp[start] != -1){
            return dp[start];
        }

        int max = 0;
        for(int i = start+2;i<=last;i++){
            max = Math.max(max, recursion(arr, dp, i, last));
        }

        dp[start] = arr[start] + max;
        return dp[start];
    }
}
