// Given an integer array arr[] and a number k. Find the count of distinct elements in every window of size k in the array.

class Solution {
    ArrayList<Integer> countDistinct(int arr[], int k) {
        // code here
        ArrayList<Integer> result = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
            if (i >= k - 1) {
                result.add(map.size());
                int elementOut = arr[i - k + 1];
                map.put(elementOut, map.get(elementOut) - 1);
                if (map.get(elementOut) == 0) {
                    map.remove(elementOut);
                }
            }
        }
        return result;
    }
}