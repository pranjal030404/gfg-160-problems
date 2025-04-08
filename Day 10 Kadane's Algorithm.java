// Given an integer array arr[]. You need to find the maximum sum of a subarray.

class Solution {
    public int maxSubarraySum(int[] nums) { // Renamed method to match GFG expectation
        int currSum = 0, maxSum = Integer.MIN_VALUE;
        for (int val : nums) {
            currSum += val;
            maxSum = Math.max(currSum, maxSum);
            if (currSum < 0) {
                currSum = 0;
            }
        }
        return maxSum;
    }
}
