package src;

/**
 * We are playing the Guess Game. The game is as follows:
 *
 * I pick a number from 1 to n. You have to guess which number I picked.
 *
 * Every time you guess wrong, I will tell you whether the number I picked is higher or lower than your guess.
 *
 * You call a pre-defined API int guess(int num), which returns three possible results:
 *
 * -1: Your guess is higher than the number I picked (i.e. num > pick).
 * 1: Your guess is lower than the number I picked (i.e. num < pick).
 * 0: your guess is equal to the number I picked (i.e. num == pick).
 * Return the number that I picked.
 *
 *
 *
 * Example 1:
 *
 * Input: n = 10, pick = 6
 * Output: 6
 * Example 2:
 *
 * Input: n = 1, pick = 1
 * Output: 1
 * Example 3:
 *
 * Input: n = 2, pick = 1
 * Output: 1
 *
 *
 * Constraints:
 *
 * 1 <= n <= 231 - 1
 * 1 <= pick <= n
 */

class GuessGame{ // this class is defined just to make the code error less
    public int guess(int n){
        return n;
    }
}

public class L374_GuessNumberHigherOrLower extends GuessGame {
    public int guessNumber(int n) {
        return binarySearch(0, n);
    }

    public int binarySearch(int start, int end){
        if(start>end){
            return -1;
        }
        int mid = start + (end-start)/2;

        if(guess(mid) == 0){
            return mid;
        }else if(guess(mid) == 1){
            return binarySearch(mid+1, end);
        }

        return binarySearch(start, mid-1);
    }
}
