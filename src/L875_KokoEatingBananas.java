package src;

/**
 * Koko loves to eat bananas. There are n piles of bananas, the ith pile has piles[i] bananas.
 * The guards have gone and will come back in h hours.
 *
 * Koko can decide her bananas-per-hour eating speed of k. Each hour, she chooses some pile of bananas and eats k
 * bananas from that pile. If the pile has less than k bananas, she eats all of them instead and will not eat any more bananas during this hour.
 *
 * Koko likes to eat slowly but still wants to finish eating all the bananas before the guards return.
 *
 * Return the minimum integer k such that she can eat all the bananas within h hours.
 *
 *
 *
 * Example 1:
 *
 * Input: piles = [3,6,7,11], h = 8
 * Output: 4
 * Example 2:
 *
 * Input: piles = [30,11,23,4,20], h = 5
 * Output: 30
 * Example 3:
 *
 * Input: piles = [30,11,23,4,20], h = 6
 * Output: 23
 *
 *
 * Constraints:
 *
 * 1 <= piles.length <= 104
 * piles.length <= h <= 109
 * 1 <= piles[i] <= 109
 */

public class L875_KokoEatingBananas {
    public int minEatingSpeed(int[] piles, int h) {
        int max = 0;
        for(int i: piles){ // first finding the at-most possible value of k, i.e. the max of piles
            max = Math.max(max, i);
        }

        // as we need to find the number of bananas needed, we will apply binary search on numbers ranging 1 to max
        // which makes the time complexity O(log(max) * piles.length)
        int left = 1;
        int right = max;

        int res = max; // putting result as max, bcz this is the at-most value which is possible for res

        // applying binary search, using left and right pointer
        while(left <= right){
            int mid = left + (right-left)/2; // here mid is denoting value of 'k' means number of bananas

            int hours = 0;
            for(int i:piles){ // calculating number of hours needed to complete the whole pile, when mid per hour is the speed of koko to eat
                hours += Math.ceil((double)i/mid); // for correct answer typecasting to double is necessary
            }


            if(hours <= h){// on this condition, we need to decrease the speed of koko eating
                res = Math.min(res, mid);
                right = mid-1;
            }else { // this condition is hours>h, means we need to increase the speed of koko eating
                // so doing left = mid+1, moving to right part to search
                left = mid+1;
            }
        }

        return res;
    }
}
