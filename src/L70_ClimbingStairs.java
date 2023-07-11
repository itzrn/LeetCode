package src;

/*
You are climbing a staircase. It takes n steps to reach the top.
Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?

Example 1:

Input: n = 2
Output: 2
Explanation: There are two ways to climb to the top.
1. 1 step + 1 step
2. 2 steps


Example 2:

Input: n = 3
Output: 3
Explanation: There are three ways to climb to the top.
1. 1 step + 1 step + 1 step
2. 1 step + 2 steps
3. 2 steps + 1 step



test cases ---> 1, 45, 2, 3
 */

public class L70_ClimbingStairs {
    public int climbStairs(int n) {
        // the commented code is recursion way, but it extends the time alot to calculate
        // if(n == 1){
        //     return 1;
        // }
        // if(n == 2){
        //     return 2;
        // }

        // return climbStairs(n-1) + climbStairs(n - 2);

        int[] array = new int[n];
        array[0] = 1;
        if(n > 1){
            array[1] = 2;
        }

        for(int i = 2; i<n;i++){
            array[i] = array[i-1] + array[i-2];
        }

        return array[n-1];
    }
}
