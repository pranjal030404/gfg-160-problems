// You are given an array arr[] of non-negative numbers. Each number tells you
// the maximum number of steps you can jump forward from that position.

// For example:

// If arr[i] = 3, you can jump to index i + 1, i + 2, or i + 3 from position i.
// If arr[i] = 0, you cannot jump forward from that position.
// Your task is to find the minimum number of jumps needed to move from the
// first position in the array to the last position.

// Note:  Return -1 if you can't reach the end of the array.

class Solution {
  static int minJumps(int[] arr) {
    int n = arr.length;
    if (n <= 1)
      return 0;
    if (arr[0] == 0)
      return -1;
    int maxReach = arr[0];
    int steps = arr[0];
    int jumps = 1;
    for (int i = 1; i < n; i++) {
      if (i == n - 1)
        return jumps;
      maxReach = Math.max(maxReach, i + arr[i]);
      steps--;
      if (steps == 0) {
        jumps++;
        if (i >= maxReach)
          return -1;
        steps = maxReach - i;
      }
    }

    return -1;
  }
}