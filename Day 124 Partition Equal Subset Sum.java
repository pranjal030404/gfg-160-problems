
// Given an array arr[], determine if it can be partitioned into two subsets
// such that the sum of elements in both parts is the same.

// Note: Each element must be in exactly one subset.

class Solution {
  static boolean equalPartition(int arr[]) {
    int n = arr.length;
    int total = 0;

    for (int num : arr) {
      total += num;
    }
    if (total % 2 != 0)
      return false;
    int sum = total / 2;
    boolean[][] dp = new boolean[n + 1][sum + 1];
    for (int i = 0; i <= n; i++) {
      dp[i][0] = true;
    }
    for (int i = 1; i <= n; i++) {
      for (int j = 1; j <= sum; j++) {
        if (arr[i - 1] <= j) {
          dp[i][j] = dp[i - 1][j] || dp[i - 1][j - arr[i - 1]];
        } else {
          dp[i][j] = dp[i - 1][j];
        }
      }
    }
    return dp[n][sum];
  }
}