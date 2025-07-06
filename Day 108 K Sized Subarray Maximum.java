// Given an array arr[] of integers and an integer k, your task is to find the
// maximum value for each contiguous subarray of size k. The output should be an
// array of maximum values corresponding to each contiguous subarray.

class Solution {
  static ArrayList<Integer> maxOfSubarrays(int[] arr, int k) {
    ArrayList<Integer> result = new ArrayList<>();
    Deque<Integer> dq = new LinkedList<>();

    for (int i = 0; i < arr.length; i++) {
      while (!dq.isEmpty() && dq.peekFirst() <= i - k) {
        dq.pollFirst();
      }

      while (!dq.isEmpty() && arr[dq.peekLast()] < arr[i]) {
        dq.pollLast();
      }

      dq.offerLast(i);

      if (i >= k - 1) {
        result.add(arr[dq.peekFirst()]);
      }
    }

    return result;
  }
}