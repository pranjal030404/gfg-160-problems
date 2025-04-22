//Given a sorted and rotated array arr[] of distinct elements, the task is to find the index of a target key. Return -1
// if the key is not found.

class Solution {
    public int search(int[] arr, int key) {
        int n = arr.length;
        int st = 0, end = n - 1;

        while (st <= end) {
            int mid = st + (end - st) / 2;

            if (arr[mid] == key) {
                return mid;
            }

            // Check if the left half is sorted
            if (arr[st] <= arr[mid]) {
                if (arr[st] <= key && key <= arr[mid]) {
                    end = mid - 1;
                } else {
                    st = mid + 1;
                }
            }
            // Right half is sorted
            else {
                if (arr[mid] <= key && key <= arr[end]) {
                    st = mid + 1;
                } else {
                    end = mid - 1;
                }
            }
        }

        return -1;
    }
}