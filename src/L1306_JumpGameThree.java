package src;

/**
 * Given an array of non-negative integers arr, you are initially positioned at start index of the array.
 * When you are at index i, you can jump to i + arr[i] or i - arr[i], check if you can reach any index with value 0.
 *
 * Notice that you can not jump outside of the array at any time.
 *
 * Example 1:
 *
 * Input: arr = [4,2,3,0,3,1,2], start = 5
 * Output: true
 * Explanation:
 * All possible ways to reach at index 3 with value 0 are:
 * index 5 -> index 4 -> index 1 -> index 3
 * index 5 -> index 6 -> index 4 -> index 1 -> index 3
 *
 *
 * Example 2:
 *
 * Input: arr = [4,2,3,0,3,1,2], start = 0
 * Output: true
 * Explanation:
 * One possible way to reach at index 3 with value 0 is:
 * index 0 -> index 4 -> index 1 -> index 3
 */


import java.util.LinkedList;

public class L1306_JumpGameThree {
    // using, linked-list just to tally that do we have visited that particular index or not, if we have visited
    // once then we will not check for that index anymore bcz it won't contain zero at that index

    // index(start) selection can make go in infinite loop, therefore using linked-list, to not visit again if we have already visited to that index
    LinkedList<Integer> list = new LinkedList<>();

    public boolean canReach(int[] arr, int start) {
        if(arr[0] ==0 || arr[arr.length-1] == 0){ // it can be possible 0 is at 0 index or at arr,length-1 index,
            // so keeping that also as a case to find ans, instead of going through the long way
            return true;
        }
        if(start<0 || start>=arr.length || list.contains(start)){
            return false;
        }
        if(arr[start] == 0){
            return true;
        }
        list.add(start);  // adding the visited index in the list

        // this is doing dfs
        boolean left = canReach(arr, start-arr[start]);  // calculating that 0 is present in the left subtree or not
        boolean right = canReach(arr, start+arr[start]);  // calculating that 0 is present in the right subtree or not

        return left || right;
    }
}
