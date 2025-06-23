// Given an array arr[] of positive integers and an integer k,
//     Your task is to return k largest elements in decreasing order.

class Solution {
  public ArrayList<Integer> kLargest(int[] arr, int k) {
    PriorityQueue<Integer> minHeap = new PriorityQueue<>();

    for (int num : arr) {
      minHeap.add(num);
      if (minHeap.size() > k)
        minHeap.poll();
    }

    ArrayList<Integer> res = new ArrayList<>(minHeap);
    res.sort(Collections.reverseOrder());
    return res;
  }
}
