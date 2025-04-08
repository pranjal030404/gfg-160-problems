Given an array arr[]that contains positive and negative integers(may contain 0 as well).Find the maximum product that we can get in a subarray of arr[].

Note:It is guaranteed that the output fits in a 32-bit integer.

class Solution {
    public int maxProduct(int[] arr) {
        if (arr.length == 0) return 0; // Edge case: empty array

        int maxP = arr[0], minP = arr[0], res = arr[0];

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < 0) {
                int temp = maxP;
                maxP = minP;
                minP = temp; 
            }

            maxP = Math.max(arr[i], maxP * arr[i]);
            minP = Math.min(arr[i], minP * arr[i]);

            res = Math.max(res, maxP);
        }

        return res;
    }

}
