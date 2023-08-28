package src;

public class L646_MaximumLengthOfPairChain {
    public int findLongestChain(int[][] pairs) {
        quickSort(pairs, 0, pairs.length-1);  // using quickSort, sorting is done on index->[i][0]
        int count = 0;

        int[] dp = new int[pairs.length]; // creating a dp array, to keep the length of max chain when the index i is the starting point.

        for(int i = 0;i<pairs.length;i++){ // calculating the max chain for each i, and picking up the max chain count at any instant if possible
            count = Math.max(count, longestPairChainForParticularIndex(i, dp, pairs));
        }

        return count;
    }

    public int longestPairChainForParticularIndex(int i, int[] dp, int[][] pairs){
        if(dp[i] != 0){ // base case, means if dp[i] is not 0, then we have already calculated the length of max chain using that 'i' as the first element of the chain
            return dp[i]; // this letting us not to go in the already wet recursion
        }
        dp[i] = 1; // this identifies, taking the tbe index 'i' as starting of the chain
        for(int j = i+1;j<pairs.length;j++){  //searching all the possible element for the chain
            if(pairs[i][1] < pairs[j][0]){ // if at any point this condition gets fails, then that particular element should not be in that chain, and we are skipping that element using for loop
                dp[i] = Math.max(dp[i], 1 + longestPairChainForParticularIndex(j, dp, pairs));
            }
        }

        return dp[i];
    }

    public void quickSort(int[][] arr, int low, int high){ // doing sorting, this type of sorting is called bucket sort
        if(low < high){
            int pivot = partition(arr, low, high);
            quickSort(arr, low, pivot-1);
            quickSort(arr, pivot+1, high);
        }
    }

    public int partition(int[][] arr, int low, int high){
        int i = low-1;

        for(int j = low;j<high;j++){
            if(arr[j][0] < arr[high][0]){
                i++;
                int[] temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        i++;
        int[] temp = arr[i];
        arr[i] = arr[high];
        arr[high] = temp;
        return i;
    }
}
