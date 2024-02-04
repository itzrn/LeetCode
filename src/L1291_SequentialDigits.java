package src;

/**
 * An integer has sequential digits if and only if each digit in the number is one more than the previous digit.
 *
 * Return a sorted list of all the integers in the range [low, high] inclusive that have sequential digits.
 *
 *
 * Example 1:
 *
 * Input: low = 100, high = 300
 * Output: [123,234]
 * Example 2:
 *
 * Input: low = 1000, high = 13000
 * Output: [1234,2345,3456,4567,5678,6789,12345]
 *
 *
 * Constraints:
 *
 * 10 <= low <= high <= 10^9
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class L1291_SequentialDigits {
    public List<Integer> sequentialDigits(int low, int high) {
        List<Integer> list = new ArrayList<>();

        for(int i = 1; i<=9; i++){ // after analysing the question or the cases can generate, you will come to know that the generated numbers can only start with 1 to 9, starting with 9(when '1' digit number is allowed, which is not allowed here according to the constraint)
            int temp = i;

            while(temp <= high && temp%10 != 0){ // this condition bound upper limit of the range
                // this loop max to max will run for 10 iterations
                if(temp >= low){// here conditions bound the lower limit and this is the time when that number is valid
                    list.add(temp);
                }

                temp = ((temp%10)+1) + temp*10; // generating the number
            }
        }

        Collections.sort(list); // result is need to be sorted
        return list;
    }
}
