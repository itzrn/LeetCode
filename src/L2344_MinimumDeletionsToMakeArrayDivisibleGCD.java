package src;

/**
 * You are given two positive integer arrays nums and numsDivide. You can delete any number of elements from nums.
 *
 * Return the minimum number of deletions such that the smallest element in nums divides all the elements of numsDivide. If this is not possible, return -1.
 *
 * Note that an integer x divides y if y % x == 0.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [2,3,2,4,3], numsDivide = [9,6,9,3,15]
 * Output: 2
 * Explanation:
 * The smallest element in [2,3,2,4,3] is 2, which does not divide all the elements of numsDivide.
 * We use 2 deletions to delete the elements in nums that are equal to 2 which makes nums = [3,4,3].
 * The smallest element in [3,4,3] is 3, which divides all the elements of numsDivide.
 * It can be shown that 2 is the minimum number of deletions needed.
 * Example 2:
 *
 * Input: nums = [4,3,6], numsDivide = [8,2,6,10]
 * Output: -1
 * Explanation:
 * We want the smallest element in nums to divide all the elements of numsDivide.
 * There is no way to delete elements from nums to allow this.
 *
 *
 * Constraints:
 *
 * 1 <= nums.length, numsDivide.length <= 105
 * 1 <= nums[i], numsDivide[i] <= 109
 */

import java.util.Arrays;
public class L2344_MinimumDeletionsToMakeArrayDivisibleGCD { // here is the concept of GCD, as in the question it talks about the divisibility
    public int minOperations(int[] nums, int[] numsDivide) {
        int t = numsDivide[0];
        int n = numsDivide.length;
        for(int i=1; i<n; i++){
            t = gcd(t, numsDivide[i]);
        }

        // t gives the GCD of every number in numsDivide array, means t is the greatest number which divides the whole array

        Arrays.sort(nums);
        n = nums.length;
        for(int i=0; i<n; i++){
            if(t%nums[i] == 0){ // t get divide any of the element of the nums array
                return i; // then we can return i, denoting the number of operation need to remove we the smallest element of the array divides the t
            }
        }

        return -1; // when there is no element which can divide the array(numsDivide)
    }

    // this is the Euclidean algorithm an efficient way to calculate gcd
    public int gcd(int a, int b){ // where a smaller than b
        if(a == 0){
            return b;
        }
        return gcd(b%a, a);
    }
}


/*

When doing competitive programming, understanding the properties of the Greatest Common Divisor (GCD) can be crucial for
solving problems efficiently. Here are some key properties of the GCD that can be particularly useful:

1. Definition: The GCD of two numbers is the largest positive integer that divides both of them without leaving a remainder.

2. GCD of Two Numbers is the Same as the GCD of Their Difference:
gcd(a, b) = gcd(b, a - b) where a > b. This property is the basis of the Euclidean algorithm for finding GCDs.


3. Euclidean Algorithm:
The GCD of two numbers can be efficiently calculated using the Euclidean algorithm: gcd(a, b) = gcd(b, a % b),
with the base case being gcd(a, 0) = a. This algorithm significantly reduces the complexity of finding a GCD.

4. GCD and LCM Relationship:
The product of two numbers is equal to the product of their GCD and LCM (Least Common Multiple): a * b = gcd(a, b) * lcm(a, b).

5. GCD is Distributive Over LCM and Vice Versa:
gcd(a, lcm(b, c)) = lcm(gcd(a, b), gcd(a, c))
lcm(a, gcd(b, c)) = gcd(lcm(a, b), lcm(a, c))

6. Associativity:
The GCD operation is associative, which means that gcd(a, gcd(b, c)) = gcd(gcd(a, b), c).

7. GCD of Any Number and 1:
gcd(a, 1) = 1 for any integer a. This implies that any two numbers that are co-prime (their GCD is 1) are relatively prime to each other.
GCD of a Set of Numbers:

8. The GCD of a set of numbers can be computed iteratively using the property that gcd(a, b, c) = gcd(a, gcd(b, c)).

9. Multiplicative Property:
While GCD itself is not multiplicative (meaning gcd(a, b) * gcd(c, d) is not necessarily equal to gcd(ac, bd)), the GCD of any number with itself times another is the number itself: gcd(a, na) = a for any integer n.

10. GCD of Consecutive Integers:
The GCD of two consecutive integers is always 1 since consecutive numbers have no common divisors other than 1.

11. Linear Combination (Bézout's Identity):
For any non-negative integers a and b, there exist integer coefficients x and y (which can be positive, negative, or zero) such that ax + by = gcd(a, b).
This property is crucial in problems involving linear diophantine equations.
Understanding these properties can help in devising efficient algorithms for problems involving divisibility, number theory, and modular arithmetic
in competitive coding contests.
 */
