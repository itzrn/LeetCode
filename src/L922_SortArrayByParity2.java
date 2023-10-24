package src;

/**
 * Given an array of integers nums, half of the integers in nums are odd, and the other half are even.
 *
 * Sort the array so that whenever nums[i] is odd, i is odd, and whenever nums[i] is even, i is even.
 *
 * Return any answer array that satisfies this condition.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [4,2,5,7]
 * Output: [4,5,2,7]
 * Explanation: [4,7,2,5], [2,5,4,7], [2,7,4,5] would also have been accepted.
 * Example 2:
 *
 * Input: nums = [2,3]
 * Output: [2,3]
 *
 *
 * Constraints:
 *
 * 2 <= nums.length <= 2 * 104
 * nums.length is even.
 * Half of the integers in nums are even.
 * 0 <= nums[i] <= 1000
 *
 *
 * Follow Up: Could you solve it in-place?
 */

import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;

public class L922_SortArrayByParity2 {
    public int[] sortArrayByParityII(int[] nums) {
        recursion(nums, new PriorityQueue<Integer>(), new PriorityQueue<Integer>(), 0);
        return nums;
    }

    // using 2 min heap, one is used to keep all the
    public void recursion(int[] arr, Queue<Integer> queueE, Queue<Integer> queueO, int index){
        if(index == arr.length){
            return;
        }

        boolean a = (arr[index] % 2 == 0)?queueE.add(arr[index]):queueO.add(arr[index]);
        a = (arr[index + 1] % 2 == 0)?queueE.add(arr[index + 1]):queueO.add(arr[index + 1]);

        recursion(arr, queueE, queueO, index+2);

        arr[index] = queueE.remove();
        arr[index+1] = queueO.remove();
    }


    // can be done using two stack
    public int[] sortArrayByParityII1(int[] nums) {
        recursion(nums, new Stack<Integer>(), new Stack<Integer>(), 0);
        return nums;
    }

    // 2 stack used, one for even and one for odd number
    public void recursion(int[] arr, Stack<Integer> stackE, Stack<Integer> stackO, int index){
        if(index == arr.length){
            return;
        }

        int a = (arr[index] % 2 == 0)?stackE.push(arr[index]):stackO.push(arr[index]);
        a = (arr[index + 1] % 2 == 0)?stackE.push(arr[index + 1]):stackO.push(arr[index + 1]);

        recursion(arr, stackE, stackO, index+2);

        arr[index] = stackE.pop();
        arr[index+1] = stackO.pop();
    }
}
