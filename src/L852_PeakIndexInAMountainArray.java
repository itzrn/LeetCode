package src;

/**
 * An array arr a mountain if the following properties hold:
 *     arr.length >= 3
 *     There exists some i with 0 < i < arr.length - 1 such that:
 *         arr[0] < arr[1] < ... < arr[i - 1] < arr[i]
 *         arr[i] > arr[i + 1] > ... > arr[arr.length - 1]
 * Given a mountain array arr, return the index i such that arr[0] < arr[1] < ... < arr[i - 1] < arr[i] > arr[i + 1] > ... > arr[arr.length - 1].
 *
 * You must solve it in O(log(arr.length)) time complexity.
 */
public class L852_PeakIndexInAMountainArray {
    public int peakIndexInMountainArray(int[] arr) {
        for(int i = 1;i<arr.length;i++){
            if(arr[i-1]>arr[i]){
                return i-1;
            }
        }
        return 1;
    }

    public int usingBinarySearch(int[] arr){
        int l = 0, r = arr.length - 1, mid;
        while (l < r) {
            mid = (l + r) / 2;
            if (arr[mid] < arr[mid + 1])
                l = mid + 1;
            else
                r = mid;
        }
        return l;
    }
}
