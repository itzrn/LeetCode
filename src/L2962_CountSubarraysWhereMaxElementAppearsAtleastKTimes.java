package src;

public class L2962_CountSubarraysWhereMaxElementAppearsAtleastKTimes {
    public long countSubarrays(int[] arr, int k) {
        int max = 0;
        for(int i:arr){ // find the max of the array
            max= Math.max(max, i);
        }

        long count = 0; // used to count the number of sub-array possible
        int left = 0;
        for(int i = 0; i<arr.length; i++){
            if(arr[i] == max){
                k--;
            }
            /*
            approach -
            looking at present index counting all the sub-array if possible till now on the basis of past traversed index
             */
            while(k == 0){
                if(arr[left] == max){
                    k++;
                }
                left++;
            }

            count += left;
        }

        return count;
    }
}
