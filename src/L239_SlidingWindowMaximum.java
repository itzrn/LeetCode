package src;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.PriorityQueue;

public class L239_SlidingWindowMaximum {

    public int[] maxSlidingWindow(int[] nums, int k){
        if(k == 1){
            return nums;
        }
        int[] res = new int[nums.length-k+1];
        Deque<Integer> dp = new ArrayDeque<>();  // in dequeue we are keeping indexes

        for(int i = 0;i< nums.length;i++){
            while(!dp.isEmpty() && nums[dp.peekFirst()] < nums[i]){ // removing all the smaller element present at the first of dequeue, as compare to the incoming element
                dp.removeFirst();
            }
            dp.addFirst(i); // pushing the incoming element at the first of dequeue

            if(dp.peekLast() == i-k){ // removing element which get exceeded than the window-slide
                dp.removeLast();
            }

            if(i>=k-1) {  // this condition indicates that the first window size we have covered, so now we can keep the max value of tht particular window in the array
                res[i - k + 1] = nums[dp.peekLast()];  // keeping the max value of each slide
            }
        }

        return res;
    }

    //this giving TLE in Leet-Code
    public int[] maxSlidingWindow1(int[] nums, int k) {
        int[] res = new int[nums.length-k+1]; // making nums.length-k+1 length array to keep the result
        PriorityQueue<Integer> dp = new PriorityQueue<>();  // when PriorityQueue gives the min element, its search lon(n) time and gives the ans
        // therefore, this approach takes nlog(n) time to solve this problem, but we need to solve in n time, to pass all the test cases in leet-code
        for(int i=0;i<k;i++){ //iterating first k elements
            dp.add(-nums[i]); // adding first k element
        }
        res[0] = -dp.peek(); // putting the largest number of first window slide
        for(int i = k;i<nums.length;i++){ // now iterating remaining elements to find the largest element of the remaining slide windows
            dp.remove(-nums[i-k]);
            dp.add(-nums[i]);
            res[i-k+1] = -dp.peek();
        }
        return res;
    }
    /*
    in min-heap to search min value is in O(1), but inserting  element is logN and searching any element is O(N)
    in max-heap to search max value is in O(1), but inserting  element is logN and searching any element is O(N)
     */
}
