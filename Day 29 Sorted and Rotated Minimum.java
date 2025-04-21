// A sorted array of distinct elements arr[] is rotated at some unknown point, the task is to find the minimum element in it. 




class Solution {
    public int findMin(int[] arr) {
        // complete the function here
        int low = 0, high = arr.length - 1;

        while (low < high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] > arr[high]) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return arr[low];
    }
}
