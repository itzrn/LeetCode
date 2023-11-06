package src;

/**
 * You are given an integer array arr. Sort the integers in the array in ascending order by
 * the number of 1's in their binary representation and in case of two or more integers have the same number of 1's you have to sort them in ascending order.
 *
 * Return the array after sorting it.
 *
 *
 *
 * Example 1:
 *
 * Input: arr = [0,1,2,3,4,5,6,7,8]
 * Output: [0,1,2,4,8,3,5,6,7]
 * Explantion: [0] is the only integer with 0 bits.
 * [1,2,4,8] all have 1 bit.
 * [3,5,6] have 2 bits.
 * [7] has 3 bits.
 * The sorted array by bits is [0,1,2,4,8,3,5,6,7]
 * Example 2:
 *
 * Input: arr = [1024,512,256,128,64,32,16,8,4,2,1]
 * Output: [1,2,4,8,16,32,64,128,256,512,1024]
 * Explantion: All integers have 1 bit in the binary representation, you should just sort them in ascending order.
 *
 *
 * Constraints:
 *
 * 1 <= arr.length <= 500
 * 0 <= arr[i] <= 104
 */

import java.util.Arrays;
import java.util.Comparator;

public class L1356_SortIntegerByTheNumberOf1Bits {
    public int[] sortByBits(int[] arr) {
        Integer[] nums = Arrays.stream(arr).boxed().toArray(Integer[]::new); // this is used to convert int[] -> Integer[]
        Comparator<Integer> comparator = new L1356_CustomComparator();
        Arrays.sort(nums, comparator);
        return Arrays.stream(nums).mapToInt(Integer::intValue).toArray(); // this is used to convert Integer[] -> int[]
    }
}

class L1356_CustomComparator implements Comparator<Integer> {
    @Override
    public int compare(Integer a, Integer b) { // Integer.bitCount(a) -> gives number of 1 bits in O(1)
        if (Integer.bitCount(a) == Integer.bitCount(b)) {
            return a - b;
        }

        return Integer.bitCount(a) - Integer.bitCount(b);
    }

    // public int find1Bits(int num){ // can be used to count the 1 bits of a number, which takes log(num) base 2
    //     int count = 0;
    //     while(num != 0){
    //         count += (num & 1);
    //         num >>= 1;
    //     }

    //     return count;
    // }
}
