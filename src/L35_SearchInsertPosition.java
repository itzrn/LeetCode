package src;

public class L35_SearchInsertPosition {
    public int binarySearch(int[] nums, int start, int end, int target){
        int mid = 0;
        while(start<=end){
            mid = start + (end-start)/2;
            if(nums[mid] == target){
                return mid;
            }
            else if(nums[mid]>target){
                end = mid -1;
            }else{
                start = mid + 1;
            }
        }

        if(nums[mid]>target && mid == 0){
            return 0;
        }
        else if(nums[mid]<target){
            return mid+1;
        }
        return mid;
    }

    public int searchInsert(int[] nums, int target) {
        return binarySearch(nums,0,nums.length-1,target);
    }
}
