package src;

/**
 * (This problem is an interactive problem.)
 *
 * You may recall that an array arr is a mountain array if and only if:
 *
 * arr.length >= 3
 * There exists some i with 0 < i < arr.length - 1 such that:
 * arr[0] < arr[1] < ... < arr[i - 1] < arr[i]
 * arr[i] > arr[i + 1] > ... > arr[arr.length - 1]
 * Given a mountain array mountainArr, return the minimum index such that mountainArr.get(index) == target. If such an index does not exist, return -1.
 *
 * You cannot access the mountain array directly. You may only access the array using a MountainArray interface:
 *
 * MountainArray.get(k) returns the element of the array at index k (0-indexed).
 * MountainArray.length() returns the length of the array.
 * Submissions making more than 100 calls to MountainArray.get will be judged Wrong Answer. Also, any solutions that attempt to circumvent the judge will result in disqualification.
 *
 *
 *
 * Example 1:
 *
 * Input: array = [1,2,3,4,5,3,1], target = 3
 * Output: 2
 * Explanation: 3 exists in the array, at index=2 and index=5. Return the minimum index, which is 2.
 * Example 2:
 *
 * Input: array = [0,1,2,4,2,1], target = 3
 * Output: -1
 * Explanation: 3 does not exist in the array, so we return -1.
 *
 *
 * Constraints:
 *
 * 3 <= mountain_arr.length() <= 104
 * 0 <= target <= 109
 * 0 <= mountain_arr.get(index) <= 109
 */

// in interface, we can define the method, and also we can make the abstract
 interface MountainArray {
     int get(int index);
     int length();
 }

public class L1095_FindInMountainArray {
    public int findInMountainArray(int target, MountainArray mountainArr) {
        int peakInd = binarySearchPeakElement(mountainArr, 0, mountainArr.length()-1);
        int a = binarySearchAscending(mountainArr,target, 0, peakInd);
        return (a != -1)?a:binarySearchDescending(mountainArr, target, peakInd, mountainArr.length()-1);
    }

    public int binarySearchPeakElement(MountainArray arr, int low, int high){
        if(low>high){
            return -1;
        }

        int mid = low + (high - low)/2;
        int a = arr.get(mid);
        int c = arr.get(mid+1);

        if((mid == 0 || a > arr.get(mid-1)) && (mid == arr.length()-1 || a > c)){
            return mid;
        }

        if((mid == 0 || a>arr.get(mid-1)) && a<c){
            return binarySearchPeakElement(arr, mid+1, high);
        }

        return binarySearchPeakElement(arr, low, mid-1);
    }

    public int binarySearchAscending(MountainArray arr, int target, int low, int high){
        if(low>high){
            return -1;
        }

        int mid = low + (high - low)/2;
        int a = arr.get(mid);
        if(a == target){
            return mid;
        }

        if(a > target){
            return binarySearchAscending(arr, target, low, mid-1);
        }

        return binarySearchAscending(arr, target, mid+1, high);
    }

    public int binarySearchDescending(MountainArray arr, int target, int low, int high){
        if(low>high){
            return -1;
        }

        int mid = low + (high - low)/2;
        int a = arr.get(mid);
        if(a == target){
            return mid;
        }

        if(a < target){
            return binarySearchDescending(arr, target, low, mid-1);
        }

        return binarySearchDescending(arr, target, mid+1, high);
    }
}
