package src.NameAlgorithum;
// this algo is used to calculate the number of prime number between 2 to n
public class SimpleSieve {
    // 0 and 1 is not a prime number
    public void sieve(int n){
        int[] dp = new int[n+1]; // making dp array of size n+1 bcz we have to show n is prime or not

        for(int i = 2;i<=n/2;i++){
            // iterating till n/2 bcz, let n = 10, we will go till 5, bcz 6*2 is getting increase than n=10, means i=2 to i=5 they will cover all the number til 10
            // so there is no need to iterate more than i=n/2
            if(dp[i] == 0){
                for(int j = i*2;j<=n;j+=i){
                    dp[j] = 1;
                }
            }
        }

        for(int i = 2;i<=n;i++){ // printing all the prime number from 2 to n(included)
            if(dp[i] == 0){
                System.out.println(i);
            }
        }
    }

    public static void main(String[] args) {
        SimpleSieve s = new SimpleSieve();
        s.sieve(23);
    }
}
