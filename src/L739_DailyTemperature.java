package src;

/**
 * Given an array of integers temperatures represents the daily temperatures, return an array answer such that answer[i]
 * is the number of days you have to wait after the ith day to get a warmer temperature. If there is no future day for which this is possible,
 * keep answer[i] == 0 instead.
 *
 *
 *
 * Example 1:
 *
 * Input: temperatures = [73,74,75,71,69,72,76,73]
 * Output: [1,1,4,2,1,1,0,0]
 * Example 2:
 *
 * Input: temperatures = [30,40,50,60]
 * Output: [1,1,1,0]
 * Example 3:
 *
 * Input: temperatures = [30,60,90]
 * Output: [1,1,0]
 *
 *
 * Constraints:
 *
 * 1 <= temperatures.length <= 105
 * 30 <= temperatures[i] <= 100
 */

import java.util.Stack;

public class L739_DailyTemperature {
    public int[] dailyTemperatures(int[] temp) { // basic stack concept
        Stack<int[]> stack = new Stack<>();
        int n = temp.length;

        int[] ans = new int[n];
        ans[n-1] = 0;
        stack.push(new int[]{temp[n-1], n-1});

        for(int i = n-2; i>=0; i--){
            while(!stack.isEmpty() && stack.peek()[0]<=temp[i]){
                stack.pop();
            }

            if(stack.isEmpty()){
                ans[i] = 0;
            }else{
                ans[i] = stack.peek()[1]-i;
            }

            stack.push(new int[]{temp[i], i});
        }
        return ans;
    }


    // reducing space complexity by adding just index in stack, not pair
    public int[] dailyTemperatures2(int[] temperatures) { // same approach as above
        int n = temperatures.length;
        int[] res = new int[n];
        Stack<Integer> stack = new Stack<>();
        for(int i=0;i<n;i++){
            while(!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]){
                int j = stack.pop();
                res[j] = i - j;
            }
            stack.push(i);
        }
        return res;
    }
}
