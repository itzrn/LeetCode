package src;

/**
 * You are given two positive integers n and k. A factor of an integer n is defined as an integer i where n % i == 0.
 *
 * Consider a list of all factors of n sorted in ascending order, return the kth factor in this list or return -1
 * if n has less than k factors.
 */

public class L1492_TheKthFactorOfNAmazon {

    public int kthFactor(int n, int k) {
        for(int i=1;i<=n/2;i++){  // this loop is going till n/2 bcz number n can not have facter greater than n/2 other than the number(n) itself
            if(n%i==0){
                k--;
                if(k==0){
                    return i;
                }
            }
        }
        k--;
        if(k==0){  // checking, is at kth position n itself come or not
            return n;
        }

        return -1;  // compiler return -1 if and only if k is greater than the number of facter of n
    }
}
