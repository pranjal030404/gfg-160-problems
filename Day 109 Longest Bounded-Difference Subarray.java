// Given an array of positive integers arr[] and a non-negative integer x, the task is to find the longest sub-array where the absolute difference between any two elements is not greater than x.
// If multiple such subarrays exist, return the one that starts at the smallest index.

class Solution {
  public ArrayList<Integer> longestSubarray(int[] arr, int x) {
    TreeMap<Integer, Integer> map = new TreeMap<>();
    int start = 0, maxLen = 0, left = 0;

    for (int end = 0; end < arr.length; end++) {
      map.put(arr[end], map.getOrDefault(arr[end], 0) + 1);

      while (map.lastKey() - map.firstKey() > x) {
        map.put(arr[start], map.get(arr[start]) - 1);
        if (map.get(arr[start]) == 0)
          map.remove(arr[start]);
        start++;
      }

      if (end - start + 1 > maxLen) {
        maxLen = end - start + 1;
        left = start;
      }
    }

    ArrayList<Integer> result = new ArrayList<>();
    for (int i = left; i < left + maxLen; i++) {
      result.add(arr[i]);
    }

    return result;
  }
}