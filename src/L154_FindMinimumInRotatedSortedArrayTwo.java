package src;

public class L154_FindMinimumInRotatedSortedArrayTwo {
    public int findMin(int[] nums) {
        return nums[findMinRecursion(nums,0,nums.length-1)];
    }

    public int findMinRecursion(int[] arr, int start, int end){
        if(end == start){
            return start;
        }

        int mid = start + (end-start)/2;

        if(arr[mid] >= arr[start] && arr[mid] > arr[end]){
            return findMinRecursion(arr, mid+1,end);
        }else if(arr[mid] == arr[start] && arr[mid] < arr[end]){
            return findMinRecursion(arr,start,mid);
        }else if(arr[mid] == arr[start] && arr[mid] == arr[end]){ // here this condition get add, at this condition we don't know where the smallest value lies
            // so doing 'start+1' or we can do 'end-1' to check where the smallest value lies
            return findMinRecursion(arr,start+1,end);
        }else{
            return findMinRecursion(arr,start,mid);
        }
    }
}
