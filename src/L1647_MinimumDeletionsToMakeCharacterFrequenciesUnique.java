package src;

public class L1647_MinimumDeletionsToMakeCharacterFrequenciesUnique {
    public int minDeletions(String s) {
        int[] arr = new int[26]; // this array will keep the count of each letter of the word
        for(int i =0;i<s.length();i++){  // 0 index -> a, 1 index -> b, .... similarly for all
            int a = s.charAt(i)-97;
            arr[a] = arr[a] + 1;
        }

        quickSort(arr, 0, arr.length-1); // doing quick sort

        int count = 0;
        for(int i = arr.length-1;i>0;i--){ // after sorting, trying to remove all the duplicate numbers of the array
            if(arr[i] !=0){
                for(int j = i-1;j>=0;j--){
                    if(arr[i] == arr[j]){
                        count ++;
                        arr[j]--;
                    }else{
                        break;
                    }
                }
            }
        }
        return count;
    }

    public void quickSort(int[] arr, int low, int high){
        if(low < high){
            int pivot = partition(arr, low, high);
            quickSort(arr, low, pivot-1);
            quickSort(arr, pivot+1, high);
        }
    }

    public int partition(int[]arr, int low, int high){
        int pivot = arr[high];
        int makePlace = low-1;
        for(int i = low; i<high;i++){
            if(arr[i] < pivot){
                makePlace++;
                int temp = arr[makePlace];
                arr[makePlace] = arr[i];
                arr[i] = temp;
            }
        }
        makePlace++;
        int temp = arr[makePlace];
        arr[makePlace] = arr[high];
        arr[high] = temp;

        return makePlace;
    }
}
