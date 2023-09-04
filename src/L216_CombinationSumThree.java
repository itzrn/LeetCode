package src;

/**
 * Find all valid combinations of k numbers that sum up to n such that the following conditions are true:
 *
 * Only numbers 1 through 9 are used.
 * Each number is used at most once.
 * Return a list of all possible valid combinations. The list must not contain the same combination twice, and the
 * combinations may be returned in any order.
 *
 *
 *
 * Example 1:
 *
 * Input: k = 3, n = 7
 * Output: [[1,2,4]]
 * Explanation:
 * 1 + 2 + 4 = 7
 * There are no other valid combinations.
 * Example 2:
 *
 * Input: k = 3, n = 9
 * Output: [[1,2,6],[1,3,5],[2,3,4]]
 * Explanation:
 * 1 + 2 + 6 = 9
 * 1 + 3 + 5 = 9
 * 2 + 3 + 4 = 9
 * There are no other valid combinations.
 * Example 3:
 *
 * Input: k = 4, n = 1
 * Output: []
 * Explanation: There are no valid combinations.
 * Using 4 different numbers in the range [1,9], the smallest sum we can get is 1+2+3+4 = 10 and since 10 > 1, there are no valid combination.
 *
 *
 * Constraints:
 *
 * 2 <= k <= 9
 * 1 <= n <= 60
 **/

import java.util.ArrayList;
import java.util.List;

public class L216_CombinationSumThree {
    public List<List<Integer>> combinationSum3(int k, int n) {
        recursive(k,n,1); // this is storing all the combination in res.
        return res;
    }

    /*
    Intuition ->
        firstly, making a list which will get add the combination, then empty itself and add another combination in it.
        secondly, as one combination get prepare we add the copy of that combination to the result(list of list).
     */

    List<List<Integer>> res = new ArrayList<>(); // this is to store all  the combination list.
    List<Integer> list = new ArrayList<>(); // this is used to store every combination
    public void recursive(int k, int n, int start){ // this is the recursive function which is calculating all the combination
        if(k == 0 && n == 0){

            res.add(new ArrayList<>(list)); // this line is adding the copy of every combination, let if you are adding directly list to the res, not the copy,
            // then at the end added all list in res will get empty, bcz the address for all the stored list in re is same as of the list.

            return;
        }

        for(int  i = start;i<=9;i++){ // this loop is creating a graph
            list.add(i); // adding the element while recursive
            recursive(k-1, n - i, i+1); // this recursive call is to add the different combination.
            list.remove(list.size()-1); // removing the last element while backtracking, and going for another combination to try
        }
    }
}
