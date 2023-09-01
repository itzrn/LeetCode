package src;

public class L338_CountingBitsDP {
    /**
     * Approach -> (n -> in binary)
     * (on dividing a number ny 2, its binary for shift right by 1 bit)
     *
     *  if a number(n) is even, LSB(Last Set Bit) is always 0, and on dividing it by 2 LSB will get lost, means the number of 1's in n/2 is equal to number of 1's in n
     *  if a number(n) is odd, LSB is always 1, and on dividing it by 2 LSB will get lost, means the number of 1's in n/2 is 1 less than the number of 1's in n
     *
     *  as we know binary of 0 ->is 0, on the basis of this we will calculate the number of 1's in any number
     */
    public int[] countBits(int n) {
        int[] arr = new int[n+1];
        arr[0] = 0;
        int index=1;
        while(index<=n){
            if(index%2 == 0){
                arr[index] = arr[index/2];
            }else{
                arr[index] = arr[index/2] + 1;
            }
            index++;
        }
        return arr;
    }


//    use link -> https://www.youtube.com/watch?v=RyBM56RIWrM
    public int[] countBits2(int n) { // using DP
        int[] dp = new int[n+1];
        dp[0] = 0;
        int offset = 1;
        for(int i = 1;i<=n;i++){
            if(offset*2 == i){
                offset = offset*2;
            }
            dp[i] = 1 + dp[i-offset];
        }
        return dp;
    }

    public int[] countBits3(int n) { // using DP
        int[] dp = new int[n+1];
        dp[0] = 0;
        for(int i = 1;i<=n;i++){
            if(i%2 == 0){ // on observation, we can find that if 'i' is even then the number of '1' in its binary
                // form will be equal to the number of '1' in the binary form of 'i/2'
                dp[i] = dp[i/2];
            }else{ // if 'i' is odd then, then the number of'1' in its binary form will be equal to the number of '1' in the binary form of 'i/2' + 1
                dp[i] = dp[i/2] + 1;
            }
        }
        return dp;
    }
}
