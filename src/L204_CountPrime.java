package src;

public class L204_CountPrime {

    public int countPrimes(int n) {
        // this is simple sieve algo to count the number of prime number from 2 to <n

        if(n == 0 || n == 1){ // base case
            return 0;
        }
        int[] arr = new int[n]; // making the array of size n, sometimes it can say to find the prime number between 0 to <=n, then we need to make the array of size n+!
        for(int i = 2;i<=n/2;i++){ // iterating till n/2 bcz multiplying ((n/2) + 1) by 2 will get out of n
            if(arr[i] == 0){
                for(int j = 2*i;j<n;j+=i){
                    arr[j] = 1;
                }
            }
        }

        int count=0;
        for(int i = 2;i<n;i++){
            if(arr[i] == 0)
                count++;
        }

        return count;
    }
}
/*
0 0 0 0 0 0 -> 0 1 2 3 4 5(indexing)
0 0 0 0 1 0  when i=2
0 0 0 0 1 0  when i=3
0 0 0 0 1 0  when i=4
0 0 0 0 1 1  when i=5
*/
