// Given an array arr[] denoting heights of N towers and a positive integer K.

// For each tower, you must perform exactly one of the following operations
// exactly once.

// Increase the height of the tower by K
// Decrease the height of the tower by K
// Find out the minimum possible difference between the height of the shortest
// and tallest towers after you have modified each tower.

// You can find a slight modification of the problem here.
// Note: It is compulsory to increase or decrease the height by K for each
// tower. After the operation, the resultant array should not contain any
// negative integers.

class Solution {
    int getMinDiff(int[] arr, int k) {
        // code here
        Arrays.sort(arr);
        int n = arr.length;
        int r = arr[n - 1] - arr[0];

        for (int i = 1; i < n; i++) {
            if (arr[i] >= k) {
                int maxVal = Math.max(arr[i - 1] + k, arr[n - 1] - k);
                int minVal = Math.min(arr[i] - k, arr[0] + k);
                r = Math.min(r, maxVal - minVal);
            }
        }
        return r;
    }
}
