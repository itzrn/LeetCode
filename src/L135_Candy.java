package src;

/**
 * There are n children standing in a line. Each child is assigned a rating value given in the integer array ratings.
 *
 * You are giving candies to these children subjected to the following requirements:
 *
 * Each child must have at least one candy.
 * Children with a higher rating get more candies than their neighbors.
 * Return the minimum number of candies you need to have to distribute the candies to the children.
 *
 *
 *
 * Example 1:
 *
 * Input: ratings = [1,0,2]
 * Output: 5
 * Explanation: You can allocate to the first, second and third child with 2, 1, 2 candies respectively.
 * Example 2:
 *
 * Input: ratings = [1,2,2]
 * Output: 4
 * Explanation: You can allocate to the first, second and third child with 1, 2, 1 candies respectively.
 * The third child gets 1 candy because it satisfies the above two conditions.
 *
 *
 * Constraints:
 *
 * n == ratings.length
 * 1 <= n <= 2 * 104
 * 0 <= ratings[i] <= 2 * 104
 */

import java.util.Arrays;

public class L135_Candy {

    // this problem will get done in two pass
    // Pass1 -> from 10 to ratings.length-1
    // Pass2 -> from ratings.length-2 to 0
    public int candy(int[] ratings) {
        if(ratings.length == 1){
            return 1;
        }

        int[] dp = new int[ratings.length];
        Arrays.fill(dp, 1); // filling dp with '1' to fulfill the first condition, that every child must have least 1 candy

        // the bellow pass1 and pass2 will fulfill the condition 2
        for(int i = 1; i<ratings.length; i++){// pass1
            if(ratings[i-1] < ratings[i]){ // while going forward, if this condition is true, means we have to increase the candies for the child which have high rating
                dp[i] = dp[i-1] + 1;
            } // if the above condition is not true, then the number of candies of ratings[i] child can be affect by ratings[i+1] child
              // so, while doing pass2 we will solve it.
        }

        for(int i = ratings.length-2; i>=0; i--){ // pass2
            if(ratings[i]>ratings[i+1] && dp[i] <= dp[i+1]){
                // when this condition is true means, while doing pass1 ratings[i] was getting affect by the ratings[i+1], which is getting solve now
                dp[i] = dp[i+1] + 1;
            }
        }

        int sum = 0;
        for(int i : dp){ // doing sum of all the candies and returning total sum
            sum += i;
        }
        return sum;
    }
}
