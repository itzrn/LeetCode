package src;

/**
 * Given a positive integer n, find the pivot integer x such that:
 *
 * The sum of all elements between 1 and x inclusively equals the sum of all elements between x and n inclusively.
 * Return the pivot integer x. If no such integer exists, return -1. It is guaranteed that there will be at most one pivot index for the given input.
 *
 *
 *
 * Example 1:
 *
 * Input: n = 8
 * Output: 6
 * Explanation: 6 is the pivot integer since: 1 + 2 + 3 + 4 + 5 + 6 = 6 + 7 + 8 = 21.
 * Example 2:
 *
 * Input: n = 1
 * Output: 1
 * Explanation: 1 is the pivot integer since: 1 = 1.
 * Example 3:
 *
 * Input: n = 4
 * Output: -1
 * Explanation: It can be proved that no such integer exist.
 *
 *
 * Constraints:
 *
 * 1 <= n <= 1000
 */

public class L2485_FindThePivotInteger {
    public int pivotInteger(int n) { // used two pointer approach
        int i = 1;
        int j = n;
        int sumi = 0;
        int sumj = 0;

        while(i<=j){
            if(sumi<sumj){
                sumi+=i;
                i++;

            }else if(sumi>sumj){
                sumj+=j;
                j--;
            }else{
                sumi+=i;
                sumj+=j;
                i++;
                j--;
            }
        }

        // Math.abs(i-j) == 2 is used which determine that there is a common pivot, as pivot will get add both in sumi and sumj
        return (sumi == sumj && Math.abs(i-j) == 2)?i-1:-1;
    }

    public int pivotInteger2(int n) {
        int sum = (n*(n+1))/2;
        int pivot = (int)Math.sqrt(sum);
        if(pivot*pivot==sum)
            return pivot;
        return -1;
    }

    public int pivotInteger3(int n) { // this is a binary search approach
        int i = 1;
        int j = n;
        while(i<=j){
            int mid = (j+i)/2;
            //         sum till n    sum till n*2 where n = mid
            int diff = (n*(n+1)/2) - mid*(mid+1) + mid; // mid is getting add in both the sum so it could be a pivot
            if(diff == 0){
                return mid;
            }

            if(diff > 0){ // means we get that pivot where left sum is less than right sum
                i = mid+1;
            }else{ // means we took that pivot where the right sum is less than left sum
                j = mid-1;
            }
        }

        return -1;
    }
}
