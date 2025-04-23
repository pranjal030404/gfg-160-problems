//Given an array arr[] where no two adjacent elements are same, find the index of a peak element.
// An element is considered to be a peak if it is greater than its adjacent elements (if they exist).
// If there are multiple peak elements, return index of any one of them. The output will be "true" if the index returned by your function is correct; otherwise, it will be "false".

class Solution {
    public int peakElement(int[] arr) {
        int n = arr.length;
        if (n == 1)
            return 0;

        int start = 0, end = n - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            boolean left = (mid == 0 || arr[mid] > arr[mid - 1]);
            boolean right = (mid == n - 1 || arr[mid] > arr[mid + 1]);

            if (left && right) {
                return mid;
            } else if (mid > 0 && arr[mid - 1] > arr[mid]) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        return -1;
    }
}
