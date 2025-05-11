// Given an unsorted array of integers, find the number of subarrays having sum exactly equal to a given number k.

class Solution {
    public int countSubarrays(int arr[], int k) {
        // code here
        HashMap<Integer, Integer> prefixSumCount = new HashMap<>();
        int count = 0;
        int currentSum = 0;
        prefixSumCount.put(0, 1);
        for (int num : arr) {
            currentSum += num;
            if (prefixSumCount.containsKey(currentSum - k)) {
                count += prefixSumCount.get(currentSum - k);
            }
            prefixSumCount.put(currentSum, prefixSumCount.getOrDefault(currentSum, 0) + 1);
        }

        return count;
    }
}