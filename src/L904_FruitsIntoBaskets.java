package src;

/**
 * You are visiting a farm that has a single row of fruit trees arranged from left to right. The trees are represented
 * by an integer array fruits where fruits[i] is the type of fruit the ith tree produces.
 *
 * You want to collect as much fruit as possible. However, the owner has some strict rules that you must follow:
 *
 * You only have two baskets, and each basket can only hold a single type of fruit. There is no limit on the amount of fruit each basket can hold.
 * Starting from any tree of your choice, you must pick exactly one fruit from every tree (including the start tree) while moving to the right.
 * The picked fruits must fit in one of your baskets.
 * Once you reach a tree with fruit that cannot fit in your baskets, you must stop.
 * Given the integer array fruits, return the maximum number of fruits you can pick.
 *
 *
 *
 * Example 1:
 *
 * Input: fruits = [1,2,1]
 * Output: 3
 * Explanation: We can pick from all 3 trees.
 * Example 2:
 *
 * Input: fruits = [0,1,2,2]
 * Output: 3
 * Explanation: We can pick from trees [1,2,2].
 * If we had started at the first tree, we would only pick from trees [0,1].
 * Example 3:
 *
 * Input: fruits = [1,2,3,2,2]
 * Output: 4
 * Explanation: We can pick from trees [2,3,2,2].
 * If we had started at the first tree, we would only pick from trees [1,2].
 *
 *
 * Constraints:
 *
 * 1 <= fruits.length <= 105
 * 0 <= fruits[i] < fruits.length
 */

import java.util.HashMap;

public class L904_FruitsIntoBaskets {
    public int totalFruit(int[] fruits) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int left = 0; // left pointer
        int right = 0; // right pointer
        int max = 0; // this os used to calculate the max length
        int total = 0; // this is used to keep the track of length of sliding window

        while(right<fruits.length){ // iterating through whole array
            map.put(fruits[right], map.getOrDefault(fruits[right], 0) + 1); // keeping the track of the count of the element(fruit)
            total += 1;//updating the length of sliding window

            while(map.size() > 2){ // when the sliding window is violating the rules, then - remove the left pointer element until the sliding window won't get valid
                if(map.getOrDefault(fruits[left], -1) > 1){ //in the process of validating the sliding window, update the map
                    map.put(fruits[left], map.get(fruits[left]) - 1);
                }else if(map.getOrDefault(fruits[left], -1) == 1){
                    map.remove(fruits[left]);
                }
                total -= 1; // updating the length of sliding window
                left++; // updating the left pointer
            }

            max = Math.max(max, total); // updating the max value, after we have a valid sliding window
            right++;
        }

        return max;
    }
}
