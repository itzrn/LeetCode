package src;

/**
 * Given an array nums with n objects colored red, white, or blue, sort them in-place so that objects of
 * the same color are adjacent, with the colors in the order red, white, and blue.
 *
 * We will use the integers 0, 1, and 2 to represent the color red, white, and blue, respectively.
 *
 * You must solve this problem without using the library's sort function.
 */

public class L75_SortColors {
    public void sortColors(int[] nums) {  // doing quick sort
        quickSort(nums, 0, nums.length-1);
    }

    public void quickSort(int[] arr, int low, int high){
        if(low<high){
            int pivot = partition(arr, low, high);

            quickSort(arr,low,pivot-1);
            quickSort(arr,pivot+1,high);
        }
    }

    public int partition(int[] arr, int low, int high){
        int pivot = arr[high];
        int j=low-1;
        for(int i=low;i<high;i++){
            if(arr[i] < pivot){
                j++;

                int temp = arr[j];
                arr[j] = arr[i];
                arr[i] = temp;
            }
        }
        j++;
        int temp = arr[j];
        arr[j] = pivot;
        arr[high] = temp;

        return j;
    }
}
