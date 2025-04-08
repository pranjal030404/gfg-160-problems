// Given an array of integers arr[] in a circular fashion. Find the maximum subarray sum that we can get if we assume the array to be circular.

class Solution {
    // Function to find maximum circular subarray sum
    public int circularSubarraySum(int[] arr) {
        int n = arr.length;
        int mn = Integer.MAX_VALUE, mx = Integer.MIN_VALUE;
        int sum1 = 0, sum2 = 0, total = 0;

        for (int i = 0; i < n; i++) {
            total += arr[i];
            sum2 = Math.min(arr[i], sum2 + arr[i]);
            mn = Math.min(mn, sum2);
            sum1 = Math.max(arr[i], sum1 + arr[i]);
            mx = Math.max(mx, sum1);
        }

        if (mx < 0)
            return mx;

        return Math.max(mx, total - mn);
    }
}