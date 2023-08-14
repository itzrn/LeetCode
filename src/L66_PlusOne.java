package src;

/**
 * You are given a large integer represented as an integer array digits, where each digits[i] is the ith digit of the
 * integer. The digits are ordered from most significant to least significant in left-to-right order.
 * The large integer does not contain any leading 0's.
 *
 * Increment the large integer by one and return the resulting array of digits.
 */

public class L66_PlusOne {
    public int[] plusOne(int[] digits) {
        int n = digits.length;

        for(int i=digits.length-1;i>=0;i--){
            if(digits[i]<9){
                digits[i]++;
                return digits;
            }

            digits[i] = 0;
        }

        int[] newNum = new int[digits.length+1];
        newNum[0]=1;
        return newNum;
    }

    public int[] plusOne1(int[] A) {
        int count=0;
        for(int i=0;i<A.length;i++){ // let if in the starting indexes, there are 0's then we have to remove those o's for valid integer
            if(A[i] == 0){
                count++;
            }else{
                break;
            }
        }
        if(count>0){  // if we have any number of 0's in starting, then we will make a new array, and put those valid element in the array
            int[] arr = new int[A.length-count];
            for(int i = 0;i<arr.length;i++){
                arr[i] = A[count];
                count++;
            }
            A = arr;
        }
        for(int i = A.length-1;i>=0;i--){
            if(A[i] <=8){
                A[i] = A[i] + 1;
                return A;
            }else{
                A[i] = 0;
            }
        }
        int[] arr = new int[A.length+1];
        arr[0] = 1;
        return arr;
    }
}
