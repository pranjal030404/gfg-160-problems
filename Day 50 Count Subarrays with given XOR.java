// Given an array of integers arr[] and a number k, count the number of subarrays having XOR of their elements as k

class Solution {
    public long subarrayXor(int arr[], int k) {
        // code here
        HashMap<Integer, Integer> freq = new HashMap<>();
        int xorSum = 0;
        long count = 0;
        for (int i = 0; i < arr.length; i++) {
            xorSum ^= arr[i];
            if (xorSum == k)
                count++;
            int required = xorSum ^ k;
            if (freq.containsKey(required))
                count += freq.get(required);
            freq.put(xorSum, freq.getOrDefault(xorSum, 0) + 1);
        }
        return count;
    }
}